package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtFirstname ;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname ;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail ;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtMobilenum ;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPass ;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPass ;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement Subscribe ;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement Policy ;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continue ;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void Enterfirst(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void Entersecond(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void Enteremail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void Entermobile(String phone)
	{
		txtMobilenum.sendKeys(phone);
	}
	
	public void EnterPass(String Pass)
	{
		txtPass.sendKeys(Pass);
	}
	
	public void EnterPass2(String Pass)
	{
		txtConfirmPass.sendKeys(Pass);
	}
	
	public void clickSubscribe()
	{
		Subscribe.click();
	}
	
	public void clickPolicy()
	{
		Policy.click();
	}
	
	public void clickContinue()
	{
		Continue.click();
	}
	
	
	//validations
	
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
