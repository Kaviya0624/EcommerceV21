package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@value='new']")
	WebElement newaddress;
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-payment-company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement add1;
	
	@FindBy(xpath="//input[@id='input-payment-address-2']")
	WebElement add2;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement postcode;
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	WebElement selectZone;
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	WebElement lblContinue;
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement lblcontin2;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	WebElement lblcontin3;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement lblcontin4;
	
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement comment;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement btnConfOrder;
	
	@FindBy(xpath="//*[@id='content']/h1")
	WebElement lblOrderConMsg;
	
	@FindBy(xpath="//strong[text()='Total:']//following::td")
	WebElement lblTotalPrice;
	
	
	public void clicknewadd()
	{
		newaddress.click();
	}
	public void EnterFirstname(String fname)
	{
		Firstname.sendKeys(fname);
	}
	
	public void Enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void Entercompany(String com)
	{
		company.sendKeys(com);
	}
	
	public void Enteradd(String add)
	{
		add1.sendKeys(add);
	}
	
	public void Enteradd2(String add2r)
	{
		add2.sendKeys(add2r);
	}
	
	public void Entercity(String cname)
	{
		city.sendKeys(cname);
	}
	
	public void Enterpostcode(String zip)
	{
		postcode.sendKeys(zip);
	}
	
	public void setCountry(String Country)
	{
		new Select(selectCountry).selectByVisibleText(Country);
	}

	public void setState(String State) 
	{
		new Select(selectZone).selectByVisibleText(State);
	}
	
	public void clckContinue()
	{
		lblContinue.click();
	}
	
	public void clckContinueafteradd()
	{
		lblcontin2.click();
	}
	
	public void clckContinueafterdelivery()
	{
		lblcontin3.click();
	}
	
	public void clckContinueafterpayment()
	{
		lblcontin4.click();
	}
	
	public void Entercomment(String comm)
	{
		comment.sendKeys(comm);
	}
	
	public void clckagree()
	{
		agree.click();
	}
	
	public void clckbtnConfOrder()
	{
		btnConfOrder.click();
	}
	
	public String  getTotalPriceBeforeConfOrder()
	{
		return lblTotalPrice.getText(); 
		
	}
	
	public boolean isOrderPlaced() throws InterruptedException
	{
		try
		{
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		btnConfOrder.click();
		Thread.sleep(3000);
		if(lblOrderConMsg.getText().equals("Your order has been placed!"))
			return true;
		else
			return false;
		}catch(Exception e)
		{
			return false;
		}
		
	}
}
