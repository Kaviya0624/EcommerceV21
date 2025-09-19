package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishlistPage extends BasePage {
	
	public AddToWishlistPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Cameras']")
	WebElement Camera;
	
	@FindBy(css ="div[id='content'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(2) button:nth-child(2) i:nth-child(1)")
	WebElement AddtoWish;
	
	@FindBy(xpath="//a[normalize-space()='Nikon D300']")
	WebElement NikonCamera;
	
	@FindBy(xpath="//div[@id='product-product']//div[@class='btn-group']//button[1]")
	WebElement AddtoWish2;
	
	@FindBy(xpath="//a[normalize-space()='Tablets (1)']")
	WebElement Tablets;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement AddtoWish3;
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	WebElement Wishlistmenu;
	
	@FindBy(xpath="//h2[normalize-space()='My Wish List']")
	WebElement txtConfirm;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert2;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement contin;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Wish List']")
	WebElement AccoWL;
	
	
	
	 public String getErrorMessage() {
	        return alert2.getText();
	    }
	
	public void clickCamera()
	{
		Camera.click();
	}
	
	public void clickAddtoWish()
	{
		AddtoWish.click();
	}
	
	public void clickNikonCamera()
	{
		NikonCamera.click();
	}
	
	public void clickAddtoWish2()
	{
		AddtoWish2.click();
	}
	
	public void clickTablets()
	{
		Tablets.click();
	}
	
	public void clickAddtoWish3()
	{
		AddtoWish3.click();
	}
	
	public void clickWishlistmenu()
	{
		Wishlistmenu.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return(txtConfirm.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public boolean isSuccessMessageDisplayed() {
	    try {
	        return alert.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public void clickcontin()
	{
		contin.click();
	}
	
	
	public void clickAccoWL()
	{
		AccoWL.click();
	}
}
