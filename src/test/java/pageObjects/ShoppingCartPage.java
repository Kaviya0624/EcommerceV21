package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

	
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(css = ".btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
	WebElement dropdownCart;
	
	@FindBy(xpath="//button[@title='Remove']")
	WebElement Close;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement Additem;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement SCart;
	
	@FindBy(css ="input[value='1']")
	WebElement qty;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateqty;
	
	@FindBy(xpath="//a[normalize-space()='Use Coupon Code']")
	WebElement coupon;
	
	@FindBy(xpath="//input[@id='input-coupon']")
	WebElement txtcoupun;
	
	@FindBy(xpath="//input[@id='button-coupon']")
	WebElement applycoupon;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmsg;
	
	@FindBy(xpath="//a[normalize-space()='Estimate Shipping & Taxes']")
	WebElement shippingdd;
	
	@FindBy(xpath="//select[@id='input-country']")
	WebElement countryDropdown;
	
	@FindBy(xpath="//select[@id='input-zone']")
	WebElement stateDropdown;
	
	@FindBy(xpath="//input[@id='input-postcode']")
	WebElement txtpostcode;
	
	@FindBy(xpath="//button[@id='button-quote']")
	WebElement getquotes;
	
	@FindBy(xpath="//input[@name='shipping_method']")
	WebElement flatshipping;
	
	@FindBy(xpath="//input[@id='button-shipping']")
	WebElement applyshipping;
	
	@FindBy(xpath="//a[normalize-space()='Use Gift Certificate']")
	WebElement gift;
	
	@FindBy(xpath="//input[@id='input-voucher']")
	WebElement txtgift;

	@FindBy(xpath="//input[@id='button-voucher']")
	WebElement applygift;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement checkout;
	
	
    public void openCartDropdown() 
    {
        dropdownCart.click();
    }
    
    public void removeItemFromCart() 
    {
       Close.click();
    }

  
    public void addItemToCart() 
    {
    	Additem.click();
    }

   
    public void goToShoppingCart() 
    {
       SCart.click();
    }

 
    public void updateQuantity(String quantity)
    {
    	
       qty.clear();
       qty.sendKeys(quantity);
       updateqty.click();
    }

   
    public void applyCoupon(String couponCode) {
        coupon.click();
        txtcoupun.clear();
        txtcoupun.sendKeys(couponCode);
        applycoupon.click();
       
    }

   
    public String getAlertMessage()
    {
    	
    	 String message = alertmsg.getText();
    	 txtcoupun.clear();
    	 return message;
    }

   

    public void selectCountryAndState(String countryName, String stateName)
    {
       
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(countryName);

        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText(stateName);
    }
    
 
    public void estimateShipping(String country, String state, String postcode)
    {
    	
       shippingdd.click(); 
       selectCountryAndState(country, state); 
       txtpostcode.clear();
       txtpostcode.sendKeys(postcode);
       getquotes.click();
       flatshipping.click();
       applyshipping.click();
      
    }


    public void applyGiftCertificate(String giftCode) 
    {
        gift.click();
        txtgift.sendKeys(giftCode);
        applygift.click();
    }
    
    public String getAlertMessage2()
    {
    	
    	 String message = alertmsg.getText();
    	 txtgift.clear();
    	 return message;
    }

    
    public void proceedToCheckout()
    {
        checkout.click();
    }
	
}

