package rahulshettyacademy.SeleniumDesignFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.driver=driver;
		//here,this refer to the current class driver means Webdriver driver;
		//driver as an arguments
		PageFactory.initElements(driver, this);
	}

	 
	  
	  
	  @FindBy(css=".hero-primary")
		WebElement ConfirmationMessage ;
	   
	  public String getConfirmationMessage()
	  {
		  CheckOutPage cp=new CheckOutPage(driver);
		  return ConfirmationMessage.getText();
	  }
	
	
}

