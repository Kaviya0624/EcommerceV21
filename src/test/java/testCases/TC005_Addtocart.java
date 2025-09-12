package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddtocartPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_Addtocart extends BaseClass {
	
	
	@Test
	public void verifyaddtocart() throws InterruptedException
	{
		try
		{
			
			logger.info("addtocart test started........");
		SearchPage sp = new SearchPage(driver);
		sp.EnterName(p.getProperty("searchProductName"));
		sp.clicksearch();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		AddtocartPage at =  new AddtocartPage(driver);
		at.clickIphone();
		Thread.sleep(2000);
		at.clickImage();
		Thread.sleep(2000);
		
		for (int i = 0; i < 4; i++) {
		    at.clickArrow();
		    Thread.sleep(2000);
		}
		
		at.clickclose();
		 Thread.sleep(2000);
		 at.clickcmpareproduct();
		 Thread.sleep(2000);
		 
		 Assert.assertTrue(at.isSuccessMessageDisplayed(), "Success message not displayed!");

			
//		WebElement add = driver.findElement(By.xpath("//a[normalize-space()='Reviews (0)']"));
//		js.executeScript("arguments[0].scrollIntoView();", add);
//		System.out.println(js.executeScript("return window.pageYOffset;"));
			
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
			
		at.clickreviews();
		 Thread.sleep(2000);
		 
		
		 at.enterquantity("2");
		 Thread.sleep(2000);
		 at.clickaddtocart();
		 Thread.sleep(2000);
		 
		 Assert.assertTrue(at.isSuccessMessageDisplayed(), "Product was not added to cart successfully!");
		 
		 logger.info("addtocart test ended........");
		 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}

}
