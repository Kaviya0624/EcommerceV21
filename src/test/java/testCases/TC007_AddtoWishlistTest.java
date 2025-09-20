package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToWishlistPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC007_AddtoWishlistTest extends BaseClass {
	
	@Test(priority=1, groups={"Sanity"})
	public void verifyWishlist()
	{
		try
		{
			logger.info("Wishlist test started........");
			AddToWishlistPage wp = new AddToWishlistPage(driver);
			wp.clickCamera();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			System.out.println(js.executeScript("return window.pageYOffset;"));
			
			wp.clickAddtoWish();
			
			wp.clickNikonCamera();
			wp.clickAddtoWish2();
			
			driver.navigate().back();
			
			wp.clickTablets();
			wp.clickAddtoWish3();
			Thread.sleep(2000);
			
			Assert.assertTrue(wp.isSuccessMessageDisplayed(), "Success message not displayed!");
			
			wp.clickWishlistmenu();
			Thread.sleep(2000);
			LoginPage lp = new LoginPage(driver);
			lp.Username(p.getProperty("email"));
			lp.Passwrod(p.getProperty("password"));
			lp.clickLogin();
			
			
//			String confmsg = wp.getConfirmationMsg();
//			if(confmsg.equals("My Wish List"))
//			{
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				logger.error("test failed........");
//				logger.debug("debug logss....");
//				Assert.assertTrue(false);
//			}
			
			String confmsg = wp.getConfirmationMsg();

			
			Assert.assertNotNull(confmsg, "Confirmation message is null — Wishlist page may not have loaded!");

			
			Assert.assertEquals(confmsg, "My Wish List", "Wishlist page not displayed after login");

			wp.clickcontin();
			
			wp.clickAccoWL();
			
			 logger.info("Wishlist test ended........");
			 
			 MyAccountPage mp = new MyAccountPage(driver);
			 HomePage hp = new HomePage(driver);
			 hp.clickMyAccount();
			 mp.clickLogout();
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
	@Test(priority=2, groups={"Negative"})
	public void addToWishlistWithoutLogin() {
	    try
	    {
	        logger.info("Negative test: Add to wishlist without login started");

	        AddToWishlistPage wp = new AddToWishlistPage(driver);
	        wp.clickCamera();
	        wp.clickAddtoWish(); 

	        String msg = wp.getErrorMessage(); 
	        Assert.assertTrue(msg.contains("You must login or create an account to save"), "Expected login warning when adding without login");

	        logger.info("Negative test: Add to wishlist without login finished");

	    } 
	    catch(Exception e)
	    {
	        logger.error("Exception during negative wishlist test: " + e.getMessage());
	        Assert.fail();
	    }
	}
	
	

}
