package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyaccount;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath= " //ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement Logout;
	
	
	public boolean isMyAccountPageExixts()
	{
		try
		{
			return (txtMyaccount.isDisplayed()) ;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickMyAccount()
	{
		MyAccount.click();
		
	}
	
	
	public void clickLogout()
	{
		Logout.click();
		
	}

}
