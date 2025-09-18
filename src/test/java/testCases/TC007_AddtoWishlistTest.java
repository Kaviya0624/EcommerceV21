package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToWishlistPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC007_AddtoWishlistTest extends BaseClass {
	
	@Test
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
			
			
			Assert.assertTrue(wp.isSuccessMessageDisplayed(), "Success message not displayed!");
			
			wp.clickWishlistmenu();
			
			LoginPage lp = new LoginPage(driver);
			lp.Username(p.getProperty("email"));
			
			lp.Passwrod(p.getProperty("password"));
			
			lp.clickLogin();
			
			
			String confmsg = wp.getConfirmationMsg();
			if(confmsg.equals("My Wish List"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("test failed........");
				logger.debug("debug logss....");
				Assert.assertTrue(false);
			}
			
			wp.clickcontin();
			
			wp.clickAccoWL();
			
			 logger.info("Wishlist test ended........");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
	

}
