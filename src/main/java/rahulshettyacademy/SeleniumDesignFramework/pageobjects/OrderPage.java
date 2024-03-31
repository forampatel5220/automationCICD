package rahulshettyacademy.SeleniumDesignFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		//here,this refer to the current class driver means Webdriver driver;
		//driver as an arguments
		PageFactory.initElements(driver, this);
	}
	//pagefactory same as webelement

		// WebElement useremail= driver.findElement(By.id("userEmail"));
		 //PageFactory
		
		@FindBy(css="tr td:nth-child(3)")
		private List<WebElement> productNames;

		@FindBy(css=".totalRow button")
		WebElement checkOutEle;
		
		public Boolean verifyOrderDisplay(String productname) {
			
			Boolean match=productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
			return match;
		}
		
		

		
		
	
	
}
