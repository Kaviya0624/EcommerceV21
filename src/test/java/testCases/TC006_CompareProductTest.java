package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CompareProduct;
import testBase.BaseClass;

public class TC006_CompareProductTest extends BaseClass {
	
	@Test(priority=1, groups={"Sanity"})
	public void VerifyCompareproduct() throws InterruptedException
	{
		try
		{
			
			logger.info("CompareProduct test started........");
			CompareProduct cp = new CompareProduct(driver);
		
			cp.clickDesktop();
		
			cp.clickShowAllDesktop();
		
		 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='MacBook']"));
			js.executeScript("arguments[0].scrollIntoView();", ele);
			System.out.println(js.executeScript("return window.pageYOffset;"));
			
			cp.clickMacbook();

			String confmsg = cp.getConfirmationMsg();
			if(confmsg.equals("Intel Core 2 Duo processor"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("test failed........");
				logger.debug("debug logss....");
				Assert.assertTrue(false);
			}
			
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");	
			System.out.println(js.executeScript("return window.pageYOffset;"));	
			
			cp.clickfirstImage();
		
		 
			for (int i = 0; i < 4; i++) {
		    cp.clickRightArrow();;
			}
		
			cp.clickclose();
			cp.clickAddTocompare();
		 
		 
			Assert.assertTrue(cp.isSuccessMessageDisplayed(), "Success message not displayed!");
		 
			driver.navigate().back();
		
		 
			WebElement elem = driver.findElement(By.xpath("//a[normalize-space()='MacBook']"));
			js.executeScript("arguments[0].scrollIntoView();", elem);
			System.out.println(js.executeScript("return window.pageYOffset;"));	
			
			cp.clickMacBookair();
			cp.clickmfirst();
		 
		 
			for (int i = 0; i < 3; i++) {
		    cp.clickRightArrow();
			}
		
			cp.clickclose();
		
		 
			cp.clickAddTocompare();
	 
			driver.navigate().back();
		
		 
			WebElement eleme = driver.findElement(By.xpath("//a[@id='compare-total']"));
			js.executeScript("arguments[0].scrollIntoView();", eleme);
			System.out.println(js.executeScript("return window.pageYOffset;"));	
		 
			cp.clickProduchCompare();
		
		 
			String confmsg2 = cp.getConfirmationMsg2();
		 
			if(confmsg2.equals("Product Comparison"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("test failed........");
				logger.debug("debug logss....");
				Assert.assertTrue(false);
			}
			
			cp.clickAddtocart();
		 
			WebElement elemen = driver.findElement(By.xpath("//h5[normalize-space()='My Account']"));
			js.executeScript("arguments[0].scrollIntoView();", elemen);
			System.out.println(js.executeScript("return window.pageYOffset;"));	
			Thread.sleep(1000);
			cp.clickRemove();
			Thread.sleep(1000);
			cp.clickRemove2();
			Thread.sleep(1000);
			logger.info("CompareProduct test ended........");
		 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		 
	}
	
	
	@Test(priority=2, groups={"Negative"})
	public void addToCompareWithoutSelectingProduct() {
	    try 
	    {
	        logger.info("Negative Test: Add to compare without selecting product started...");

	        CompareProduct cp = new CompareProduct(driver);
	        
	        cp.clickDesktop();
			cp.clickShowAllDesktop();
	        cp.clickProduchCompare();

	        String msg = cp.getErrorMessage(); 
	        Assert.assertTrue(msg.contains("You have not chosen any products to compare.") 
	                          || msg.contains("empty"), 
	                          "Expected error for empty comparison list");

	        logger.info("Negative Test: Add to compare without selecting product ended.");
	    } 
	    catch (Exception e) 
	    {
	        logger.error("Exception in addToCompareWithoutSelectingProduct: " + e.getMessage());
	        Assert.fail();
	    }
	}
	
	
}
