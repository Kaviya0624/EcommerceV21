package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CompareProduct extends BasePage {
	
	public CompareProduct(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	WebElement Desktop;
	
	@FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
	WebElement ShowAllDesktop;

	@FindBy(xpath = "//a[normalize-space()='MacBook']")
	WebElement Macbook;
	
	@FindBy(xpath = "//b[normalize-space()='Intel Core 2 Duo processor']")
	WebElement txtVisible;
	
	@FindBy(css = "li:nth-child(2) a:nth-child(1) img:nth-child(1)")
	WebElement firstImage;
	
	@FindBy(xpath = "//button[@title='Next (Right arrow key)']")
	WebElement RightArrow;
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	WebElement close;
	
	@FindBy(xpath = "//i[@class='fa fa-exchange']")
	WebElement AddTocompare;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement txtConfirm;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[contains(text(),'Desktops')]")
	WebElement Desktopmenu;
	
	@FindBy(xpath = "//a[normalize-space()='MacBook Air']")
	WebElement MacBookair;
	
	@FindBy(css = "li:nth-child(2) a:nth-child(1) img:nth-child(1)")
	WebElement mfirst;
	
	@FindBy(xpath = "//a[@id='compare-total']")
	WebElement ProduchCompare;
	
	@FindBy(xpath = "//h1[normalize-space()='Product Comparison']")
	WebElement txtConfirm2;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/table[1]/tbody[4]/tr[1]/td[2]/input[1]")
	WebElement Addtocart;
	
	@FindBy(css = "a[href='https://awesomeqa.com/ui/index.php?route=product/compare&remove=44']")
	WebElement Remove;
	
	public void clickDesktop()
	{
		Desktop.click();
	}
	
	public void clickShowAllDesktop()
	{
		ShowAllDesktop.click();
	}
	
	
	public void clickMacbook()
	{
		Macbook.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return(txtVisible.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
	public void clickfirstImage()
	{
		firstImage.click();
	}
	
	
	public void clickRightArrow()
	{
		RightArrow.click();
	}
	
	public void clickclose()
	{
		close.click();
	}
	
	public void clickAddTocompare()
	{
		AddTocompare.click();
	}
	
	public boolean isSuccessMessageDisplayed() {
	    try {
	        return txtConfirm.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public void clickDesktopmenu()
	{
		Desktopmenu.click();
	}
	
	public void clickMacBookair()
	{
		MacBookair.click();
	}
	
	public void clickmfirst()
	{
		mfirst.click();
	}
	
	public void clickProduchCompare()
	{
		ProduchCompare.click();
	}
	
	public void clickAddtocart()
	{
		Addtocart.click();
	}
	
	public void clickRemove()
	{
		Remove.click();
	}
	
	public String getConfirmationMsg2()
	{
		try {
			return(txtConfirm2.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}

}
