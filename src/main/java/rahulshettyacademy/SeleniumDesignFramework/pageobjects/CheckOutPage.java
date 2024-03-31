package rahulshettyacademy.SeleniumDesignFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;


public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.driver=driver;
		//here,this refer to the current class driver means Webdriver driver;
		//driver as an arguments
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="[placeholder='Select Country']")
	private WebElement country ;
	
	private By results=By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class, 'ta-item')])[2]")
     WebElement selectCountry ;

	
	@FindBy(css=".action__submit")
	private WebElement submit ;
	
	
	
	public void selectCountry(String countryname) {
		Actions a=new Actions(driver);
		a.sendKeys(country,countryname).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
		
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException
	{
		//waitForWebElementToAppear(submit);
		submit.click();
		return new ConfirmationPage(driver);

		
	}
	 
	
	
}

