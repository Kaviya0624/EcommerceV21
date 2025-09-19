package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public  LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;
	
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
    WebElement loginErrorMsg;
	
	public void Username(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void Passwrod(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		Login.click();
	}
	
	public String getLoginErrorMessage() 
	{
	    return loginErrorMsg.getText();
	}
}
