package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddtocartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC009_E2ECheckoutflowTest extends BaseClass {
	
	@Test
	public void verifyE2Echekout() throws InterruptedException
	{
		
		try
		{
			
		logger.info("endtoened test started........");
	
		SoftAssert myassert = new SoftAssert();
		
		//Account Registration
		System.out.println("Account Registration................");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		
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
		
		
		MyAccountPage mc=new MyAccountPage(driver);
		hp.clickMyAccount();
		mc.clickLogout();
		
		Thread.sleep(3000);
		
		//Login
		System.out.println("Login to application...............");
		
		hp.clickMyAccount();
		hp.clickMyLogin();
		LoginPage lp = new LoginPage(driver);
		lp.Username(p.getProperty("email"));
		lp.Passwrod(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExixts();
		
		Assert.assertTrue(targetpage);
		
		//search and add to cartproduct
		System.out.println("search & add product to cart...............");
		SearchPage sp = new SearchPage(driver);
		
		
		sp.EnterName(p.getProperty("searchProductName"));
		sp.clicksearch();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(2000);
		AddtocartPage at =  new AddtocartPage(driver);
		at.clickImac();
		Thread.sleep(2000);
		at.enterquantity("2");
		Thread.sleep(2000);
		at.clickaddtocart();
		Thread.sleep(2000);
		System.out.println("Added product to cart ? "+ at.isSuccessMessageDisplayed());
		Assert.assertTrue(at.isSuccessMessageDisplayed(), "Product was not added to cart successfully!");
		
		//Shoppingcart
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.goToShoppingCart();
		Thread.sleep(3000);
		String totprice = sc.getTotalPrice();
		System.out.println("total price is shopping cart: "+ totprice);
		myassert.assertEquals(totprice, "$200.00");   //validation
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
		sc.proceedToCheckout(); //navigate to checkout page
		Thread.sleep(3000);
		
		//checkout
		System.out.println("Checkout Product...............");
		CheckOutPage cm = new CheckOutPage(driver);
		
		cm.clicknewadd();
		Thread.sleep(1000);
		cm.EnterFirstname(randomString().toUpperCase());
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,100)", "");
		cm.Enterlastname(randomString().toUpperCase());
		Thread.sleep(1000);
		cm.Entercompany("SKM");
		Thread.sleep(1000);
		cm.Enteradd("address1");
		Thread.sleep(1000);
		cm.Enteradd2("address2");
		Thread.sleep(1000);
		cm.Entercity("Chennai");
		Thread.sleep(1000);
		cm.Enterpostcode("234567");
		Thread.sleep(1000);
		cm.setCountry("India");
		Thread.sleep(1000);
		cm.setState("Tamil Nadu");
		Thread.sleep(1000);
		cm.clckContinue();
		Thread.sleep(1000);
		cm.clckContinueafteradd();
		Thread.sleep(1000);
		cm.Entercomment("need fast delivery");
		Thread.sleep(1000);
		cm.clckContinueafterdelivery();
		Thread.sleep(1000);
		cm.clckagree();
		Thread.sleep(1000);
		cm.clckContinueafterpayment();
		Thread.sleep(1000);
		
		String total_price_inOrderPage = cm.getTotalPriceBeforeConfOrder();
		System.out.println("total price in confirmed order page:"+ total_price_inOrderPage);
		myassert.assertEquals(total_price_inOrderPage, "$205.00");
		Thread.sleep(1000);
		
//		cm.clckbtnConfOrder();
//		Thread.sleep(3000);
//			
//		boolean orderconf=cm.isOrderPlaced();
//		System.out.println("Is Order Placed? "+orderconf);
//		myassert.assertEquals(cm.isOrderPlaced(),true);
			
		myassert.assertAll();
		logger.info("endtoened test finished........");
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
