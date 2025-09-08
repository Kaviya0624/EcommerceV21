package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	
	@Test(groups={"Sanity", "Master"})
	public void verify_Login()
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
		//Assert.assertEquals(targetpage, true , "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***finsihed login started******");
	}
}
