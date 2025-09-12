package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test
	public void searchproduct() throws InterruptedException
	{
		
		
		SearchPage sp = new SearchPage(driver);
		sp.EnterName(p.getProperty("searchProductName"));
		Thread.sleep(2000);
		sp.clicksearch();
		Thread.sleep(2000);
		sp.isProductExist("iPhone");
		
		Assert.assertEquals(sp.isProductExist("iPhone"),true);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scrolling up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));	
		
		Thread.sleep(2000);
		sp.EnterName("Mac");
		Thread.sleep(2000);
		sp.clicksearch();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));	  //3rd scroll page till end of the page
		
		
		
		
	}

	

}
