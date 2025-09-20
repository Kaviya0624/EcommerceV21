package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddtocartPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddtocartTest extends BaseClass {
	
	
	@Test(priority = 1 ,groups= {"Sanity"})
	public void verifyaddtocart() throws InterruptedException
	{
		try
		{
			
		logger.info("addtocart test started........");
		SearchPage sp = new SearchPage(driver);
		sp.EnterName(p.getProperty("searchProductName1"));
		sp.clicksearch();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		AddtocartPage at =  new AddtocartPage(driver);
		at.clickIphone();
	
		at.clickImage();
	
		
		for (int i = 0; i < 4; i++) {
		    at.clickArrow();
		    
		}
		
		at.clickclose();
		at.clickcmpareproduct();
		Thread.sleep(1000);
		 
		Assert.assertTrue(at.isSuccessMessageDisplayed(), "Success message not displayed!");
		Thread.sleep(1000);
			
//		WebElement add = driver.findElement(By.xpath("//a[normalize-space()='Reviews (0)']"));
//		js.executeScript("arguments[0].scrollIntoView();", add);
//		System.out.println(js.executeScript("return window.pageYOffset;"));
			
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
			
		at.clickreviews();
		
		at.enterquantity("2");
		
		at.clickaddtocart();
		Thread.sleep(1000);
		Assert.assertTrue(at.isSuccessMessageDisplayed(), "Product was not added to cart successfully!");
		Thread.sleep(1000);
		logger.info("addtocart test ended........");
		 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}
	


}
