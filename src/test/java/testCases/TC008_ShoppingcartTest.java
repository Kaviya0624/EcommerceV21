package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddtocartPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC008_ShoppingcartTest extends BaseClass {
	
	
	@Test(priority=1,groups= {"Sanity"})
	public void verfiyShoppingcartTest() throws InterruptedException
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
		at.enterquantity("1");
		at.clickaddtocart();
		
		Assert.assertTrue(at.isSuccessMessageDisplayed(), "Product was not added to cart successfully!");
		
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		 
		Thread.sleep(2000);
		sc.openCartDropdown();
		Thread.sleep(2000);
		sc.removeItemFromCart();
		Thread.sleep(2000);
		sc.addItemToCart();
		Thread.sleep(2000);
		sc.goToShoppingCart();
		sc.updateQuantity("2");
		Thread.sleep(2000);
		
		sc.applyCoupon("COUPON10");
		Thread.sleep(2000);
		String alertText = sc.getErrorMessage();
		
		Assert.assertTrue(alertText.contains("Warning"), "Alert should contain 'Warning'");

		sc.estimateShipping("India", "Tamil Nadu", "4353453");
		Thread.sleep(2000);
		
		sc.applyGiftCertificate("Gift1");
		Thread.sleep(2000);
		
		String alertText2 = sc.getErrorMessage();
		Assert.assertTrue(alertText2.contains("Warning"), "Alert should contain 'Warning'");
		Thread.sleep(2000);
		
		sc.proceedToCheckout();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}
	
	
	
	@Test(priority=2, groups={"Negative"})
	public void estimateShippingWithInvalidDetails() {
	    try 
	    {
	        logger.info("Negative test: Estimate shipping with invalid details started");

	        ShoppingCartPage sc = new ShoppingCartPage(driver);
	        sc.goToShoppingCart();
	       // sc.clearShippingForm();
	        Thread.sleep(2000);
	        sc.estimateShipping2("India", "--- Please Select ---", "ABCDE");
	        Thread.sleep(2000);
	        String alertText3 = sc.getErrorZone();
	        Assert.assertTrue(alertText3.contains("Please select a region / state!"), "Expected warning message for invalid shipping details");
	        Thread.sleep(2000);
	        logger.info("Negative test: Estimate shipping with invalid details finished");
	    } 
	    catch(Exception e)
	    {
	        logger.error("Exception in estimateShippingWithInvalidDetails: " + e.getMessage());
	        Assert.fail();
	    }
	}

	
	
}
