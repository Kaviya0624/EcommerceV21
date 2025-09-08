package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
	login failed - test fail

Data is invalid - login success - test fail  - logout
	login failed - test pass
*/

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData" , dataProviderClass = DataProviders.class,groups ="Datadriven")
	public void verify_Loginddt(String email, String pwd, String exp)
	{
		
	try
			
	{
		logger.info("***login started******");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickMyLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.Username(email);
		lp.Passwrod(pwd);
		lp.clickLogin();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExixts();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(true);
				mp.clickMyAccount();
				mp.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mp.clickMyAccount();
				mp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
			}
			
			catch(Exception e)
			{
				Assert.fail();
			}
		
	}

}
