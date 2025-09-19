package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtocartPage extends BasePage {
	
	public AddtocartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='iPhone']")
	WebElement lnkIphone;
	
	@FindBy(css ="div[class='caption'] h4 a")
	WebElement iMac;
	
	@FindBy(css = "li:nth-child(2) a:nth-child(1) img:nth-child(1)")
	WebElement fistImage;
	
	@FindBy(xpath="//button[@title='Next (Right arrow key)']")
	WebElement arrowkey;
	
	@FindBy(xpath="//button[normalize-space()='×']")
	WebElement close;
	
	@FindBy(xpath="//a[normalize-space()='Reviews (0)']")
	WebElement reviews;
	
	@FindBy(xpath="//button[@class='btn btn-default']//i[@class='fa fa-exchange']")
	WebElement compareproduct;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtsuccess;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement qty;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addtocart;
		
	public void clickIphone()
	{
		lnkIphone.click();
	}
	
	public void clickImac()
	{
		iMac.click();
	}
	
	
	public void clickImage()
	{
		fistImage.click();
	}
	
	public void clickArrow()
	{
		arrowkey.click();
	}
	
	public void clickclose()
	{
		close.click();
	}
	
	public void clickreviews()
	{
		reviews.click();
	}
	
	public void clickcmpareproduct()
	{
		compareproduct.click();
	}
	
	public boolean isSuccessMessageDisplayed() {
	    try {
	        return txtsuccess.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}


	public void enterquantity(String num)
	{
		qty.clear();
		qty.sendKeys(num);
	}
	
	public void clickaddtocart()
	{
		addtocart.click();
	}
}
