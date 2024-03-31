package rahulshettyacademy.SeleniumDesignFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
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

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner ;
	
	By productsBy=By.cssSelector(".mb-3");
	//By addToCart=By.cssSelector(".card-body button[class='btn w-10 rounded']");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	   
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException 
	{
		
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitforElementToDisappear(spinner);
	
	}
	
}
