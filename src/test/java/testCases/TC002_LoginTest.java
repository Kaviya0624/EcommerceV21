package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	
	@Test(priority=1,groups={"Sanity", "Master"})
	public void verify_LoginWithValidCredentials()
	{
		try
		{
		logger.info("***login started******");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickMyLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.Username(p.getProperty("email"));
		lp.Passwrod(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExixts();
		
		Assert.assertTrue(targetpage);
		
		
		hp.clickMyAccount();
		mp.clickLogout();
		//Assert.assertEquals(targetpage, true , "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***finsihed login started******");
	}
	
	@Test(priority= 2)
	public void verify_LoginWithInvalidCredentials() {
	    try {
	        logger.info("***Negative login test: Invalid credentials started***");

	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickMyLogin();

	        LoginPage lp = new LoginPage(driver);
	        lp.Username("invalid@example.com");
	        lp.Passwrod("wrongpassword");
	        lp.clickLogin();

	        String errorMsg = lp.getLoginErrorMessage(); // Make sure this method exists in LoginPage
	        Assert.assertTrue(errorMsg.contains("Warning"), "Expected warning message not displayed");

	    } catch(Exception e)
	    {
	        Assert.fail("Exception during invalid credentials test: " + e.getMessage());
	    }

	    logger.info("***Negative login test: Invalid credentials finished***");
	}

	@Test(priority=3)
	public void verify_LoginWithEmptyUsername()
	{
	    try 
	    
	    {
	        logger.info("***Negative login test: Empty username started***");

	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickMyLogin();

	        LoginPage lp = new LoginPage(driver);
	        lp.Username("");
	        lp.Passwrod(p.getProperty("password"));
	        lp.clickLogin();

	        String errorMsg = lp.getLoginErrorMessage();
	        Assert.assertTrue(errorMsg.contains("Warning"), "Expected warning message for empty username not displayed");

	    }
	    catch(Exception e)
	    {
	        Assert.fail("Exception during empty username test: " + e.getMessage());
	    }

	    logger.info("***Negative login test: Empty username finished***");
	}

	@Test(priority=4)
	public void verify_LoginWithEmptyPassword() {
	    try {
	        logger.info("***Negative login test: Empty password started***");

	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickMyLogin();

	        LoginPage lp = new LoginPage(driver);
	        lp.Username(p.getProperty("email"));
	        lp.Passwrod("");
	        lp.clickLogin();

	        String errorMsg = lp.getLoginErrorMessage();
	        Assert.assertTrue(errorMsg.contains("Warning"), "Expected warning message for empty password not displayed");

	    } catch(Exception e) 
	    {
	        Assert.fail("Exception during empty password test: " + e.getMessage());
	    }

	    logger.info("***Negative login test: Empty password finished***");
	}

}
