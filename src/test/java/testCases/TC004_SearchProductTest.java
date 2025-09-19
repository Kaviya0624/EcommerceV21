package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test(priority=1,groups = {"Sanity"})
	public void searchproduct() throws InterruptedException
	{
		try
		{
			
		logger.info("search case started......");
		SearchPage sp = new SearchPage(driver);
		sp.EnterName(p.getProperty("searchProductName1"));
		Thread.sleep(2000);
		sp.clicksearch();
		Thread.sleep(2000);
		sp.isProductExist("iPhone");
		
		Assert.assertEquals(sp.isProductExist("iPhone"),true);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scrolling up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));	
		
		
		sp.EnterName("Mac");
		Thread.sleep(2000);
		sp.clicksearch();
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));	//3rd scroll page till end of the page
		
		logger.info("search case ended......");
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
	}

	@Test(priority=2,groups = {"Negative"})
	public void searchProductNotExist() throws InterruptedException {
	    try {
	    	
	        logger.info("Negative test: Search non-existing product started");

	        SearchPage sp = new SearchPage(driver);
	        sp.EnterName("RandomProduct123");
	        sp.clicksearch();
	        Thread.sleep(2000);

	      
	        String noProductMsg = sp.getNoProductMessage(); 
	        Assert.assertTrue(noProductMsg.contains("There is no product that matches the search criteria."));

	        logger.info("Negative test: Search non-existing product finished");
	    }
	    catch(Exception e) {
	        logger.error("Exception during negative search test: " + e.getMessage());
	        Assert.fail();
	    }
	}

	@Test(priority=3,groups = {"Negative"})
	public void searchProductWithEmptyInput() throws InterruptedException {
	    try {
	        logger.info("Negative test: Search with empty input started");

	        SearchPage sp = new SearchPage(driver);
	        sp.EnterName("");
	        sp.clicksearch();
	        Thread.sleep(2000);

	        String noProductMsg = sp.getNoProductMessage();
	        Assert.assertTrue(noProductMsg.contains("There is no product that matches the search criteria."));


	        logger.info("Negative test: Search with empty input finished");
	    }
	    catch(Exception e) 
	    {
	        logger.error("Exception during negative search test: " + e.getMessage());
	        Assert.fail();
	    }
	}

	@Test(priority=4,groups = {"Negative"})
	public void searchProductWithSpecialChars() throws InterruptedException {
	    try {
	        logger.info("Negative test: Search with special characters started");

	        SearchPage sp = new SearchPage(driver);
	        sp.EnterName("@#$%^&*!");
	        sp.clicksearch();
	        Thread.sleep(2000);

	        String noProductMsg = sp.getNoProductMessage();
	        Assert.assertTrue(noProductMsg.contains("There is no product that matches the search criteria."));


	        logger.info("Negative test: Search with special characters finished");
	    } 
	    catch(Exception e) 
	    {
	        logger.error("Exception during negative search test: " + e.getMessage());
	        Assert.fail();
	    }
	}


}
