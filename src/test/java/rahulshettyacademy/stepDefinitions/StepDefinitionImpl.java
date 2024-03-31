package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.CartPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.CheckOutPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.ConfirmationPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.LandingPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;



public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productcatalogue;
	public ConfirmationPage confirmationPage;

	
	
	@Given("I landed to Ecommerce Page")
	public void i_landed_to_Ecommerce_Page() throws IOException {
		
		landingPage	=launchApplication();
	}
	
	
	
	 @Given("^Logged in with username (.+) and password (.+)$")
	 public void Logged_in_with_username_and_password (String username,String password) {
		 
	 productcatalogue=landingPage.loginApplication(username,password); 
	 }
	 
	 @When("I add product {string}  to cart")
	  public void I_add_product_to_cart(String productName) throws InterruptedException{
		  
		  List<WebElement> products =productcatalogue.getProductList();
		    productcatalogue.addProductToCart(productName);  
	  }
	  
	  @When("Checkout {string} and submit the order")
	  public void Checkout_submit_order(String productName) throws InterruptedException {
		  
		  CartPage cartPage = productcatalogue.goToCartPage();
		  Boolean match  =cartPage.verifyProductDisplay(productName);
		  Assert.assertTrue(match);
		  CheckOutPage checkOutPage= cartPage.goToCheckout();
		  checkOutPage.selectCountry("india");
		  confirmationPage=checkOutPage.submitOrder();
	  }
		  
	 @Then("{string} message is displayed on ConfirmationPage")
	  public void message_displayed_confirmationPage(String message){
		 
		  String ConfirmMessage  = confirmationPage.getConfirmationMessage();
		   Assert.assertTrue(ConfirmMessage.equalsIgnoreCase(message));
		   driver.close();
	 } 
		   
     @Then("{string} message is Displayed")
		 public void message_is_Displayed(String strArg1) {
			  
    	  Assert.assertEquals(strArg1, landingPage.getErrorMessage()); 
    	    driver.close();
    	 
		   }
     
     
	 }
		
	
	  


