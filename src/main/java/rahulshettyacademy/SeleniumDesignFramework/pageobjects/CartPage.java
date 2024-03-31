package rahulshettyacademy.SeleniumDesignFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	

	WebDriver driver;
	public CartPage(WebDriver driver)
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
		
		@FindBy(css=".cartSection h3")
		private List<WebElement> cartproducts;

		@FindBy(css=".totalRow button")
		WebElement checkOutEle;
		
		public Boolean verifyProductDisplay(String productname) {
			
			Boolean match=cartproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
			return match;
		}
		
		public CheckOutPage goToCheckout()
		{
			checkOutEle.click();
			//CheckOutPage checkOutPage= new CheckOutPage(driver);
			return new CheckOutPage(driver);
			
		}

}
