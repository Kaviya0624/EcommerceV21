package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement clckSearch;
	
	@FindBy(xpath="//*[@id='content']/div[3]//img")
	List<WebElement> searchProducts;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]") // update selector according to your app
	 WebElement noProductMsg;
	
	 @FindBy(xpath = "//div[@class='product-thumb']")
	 List<WebElement> searchResults;
	 
	 @FindBy(xpath = "//ul[@class='pagination']//li[@class='next']")
	  WebElement nextPageButton;

	public String getNoProductMessage() 
	{
	    return noProductMsg.getText();
	}

	
	public void EnterName(String name)
	{
		txtSearch.clear();
		txtSearch.sendKeys(name);
		
	}
	
	public void clicksearch()
	{
		clckSearch.click();
	}
	
	public boolean isProductExist(String productName)
	{
		boolean flag=false;
		for(WebElement product:searchProducts)
		{				
			if(product.getAttribute("title").equals(productName))
			{
			flag=true;
			break;
			}
		}
		
		return flag;
	
	}
	
	public void selectProduct(String productName)
	{
		for(WebElement product:searchProducts)
		{				
			if(product.getAttribute("title").equals(productName))
			{
				product.click();
			}
		}
	
	}
	
	public int getSearchResultCount()
	{
        return searchResults.size();
    }
	 

}
