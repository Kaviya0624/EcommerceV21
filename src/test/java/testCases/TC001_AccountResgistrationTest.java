package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC001_AccountResgistrationTest extends BaseClass 
{

	@Test(priority=1,groups={"Regression" , "Master"})
	public void verfy_AccountRegistration()
	{
		try
		{
			
		logger.info("****Starting testcase a *****");
		
		HomePage hp = new HomePage(driver);
	
		hp.clickMyAccount();
		logger.info("****clicked myaccount *****");
		
		hp.clickRegister();
		logger.info("****clicked register *****");

		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
	
		logger.info("****customer details *****");
		
		ap.Enterfirst(randomString().toUpperCase());
		ap.Entersecond(randomString().toUpperCase());
		ap.Enteremail(randomString()+"@gmail.com");
		ap.Entermobile(randomNum());
		
		String password = randomAlphaNumeric();
		ap.EnterPass(password);
		ap.EnterPass2(password);
		
		ap.clickSubscribe();
		ap.clickPolicy();
		ap.clickContinue();
		
		logger.info("****validating expected message *****");
		
		ap.getConfirmationMsg();
		String confmsg = ap.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed........");
			logger.debug("debug logss....");
			Assert.assertTrue(false);
		}
		
		MyAccountPage mp = new MyAccountPage(driver);
		hp.clickMyAccount();
		mp.clickLogout();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("****test executed*****");
		
		}
	
	
	@Test(priority=2,groups={"Negative"})
	public void verify_RegistrationWithEmptyFirstName() {
	    try 
	    {
	        logger.info("***Negative test: Empty first name started***");

	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickRegister();

	        AccountRegistrationPage ap = new AccountRegistrationPage(driver);
	        ap.Enterfirst(""); // empty first name
	        ap.Entersecond(randomString().toUpperCase());
	        ap.Enteremail(randomString()+"@gmail.com");
	        ap.Entermobile(randomNum());

	        String password = randomAlphaNumeric();
	        ap.EnterPass(password);
	        ap.EnterPass2(password);

	        ap.clickSubscribe();
	        ap.clickPolicy();
	        ap.clickContinue();

	        String confmsg = ap.getConfirmationMsg();
	        Assert.assertFalse(confmsg.equals("Your Account Has Been Created!"), "Registration should fail with empty first name");

	    } 
	    catch(Exception e)
	    {
	        logger.error("Exception during negative test: " + e.getMessage());
	        Assert.fail();
	    }

	    logger.info("***Negative test: Empty first name finished***");
	}

	@Test(priority=3,groups={"Negative"})
	public void verify_RegistrationWithInvalidEmail() {
	    try {
	        logger.info("***Negative test: Invalid email started***");

	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickRegister();

	        AccountRegistrationPage ap = new AccountRegistrationPage(driver);
	        ap.Enterfirst(randomString().toUpperCase());
	        ap.Entersecond(randomString().toUpperCase());
	        ap.Enteremail("invalidEmail"); // invalid format
	        ap.Entermobile(randomNum());

	        String password = randomAlphaNumeric();
	        ap.EnterPass(password);
	        ap.EnterPass2(password);

	        ap.clickSubscribe();
	        ap.clickPolicy();
	        ap.clickContinue();

	        String confmsg = ap.getConfirmationMsg();
	        Assert.assertFalse(confmsg.equals("Your Account Has Been Created!"), "Registration should fail with invalid email");

	    } catch(Exception e) {
	        logger.error("Exception during negative test: " + e.getMessage());
	        Assert.fail();
	    }

	    logger.info("***Negative test: Invalid email finished***");
	}

	@Test(priority=4,groups={"Negative"})
	public void verify_RegistrationWithPasswordMismatch() {
	    try {
	        logger.info("***Negative test: Password mismatch started***");

	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickRegister();

	        AccountRegistrationPage ap = new AccountRegistrationPage(driver);
	        ap.Enterfirst(randomString().toUpperCase());
	        ap.Entersecond(randomString().toUpperCase());
	        ap.Enteremail(randomString()+"@gmail.com");
	        ap.Entermobile(randomNum());

	        ap.EnterPass(randomAlphaNumeric()); // first password
	        ap.EnterPass2(randomAlphaNumeric()); // different confirm password

	        ap.clickSubscribe();
	        ap.clickPolicy();
	        ap.clickContinue();

	        String confmsg = ap.getConfirmationMsg();
	        Assert.assertFalse(confmsg.equals("Your Account Has Been Created!"), "Registration should fail with password mismatch");

	    } catch(Exception e) {
	        logger.error("Exception during negative test: " + e.getMessage());
	        Assert.fail();
	    }

	    logger.info("***Negative test: Password mismatch finished***");
	}

}
