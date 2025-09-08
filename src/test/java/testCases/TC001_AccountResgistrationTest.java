package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountResgistrationTest extends BaseClass 
{

	@Test(groups={"Regression" , "Master"})
	public void verfy_account_registration()
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
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("****test executed*****");
		
		}
	
	

}
