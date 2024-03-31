package rahulshettyacademy.SeleniumDesignFramework.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.SeleniumDesignFramework.pageobjects.CartPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	
	@Test(groups= {"ErrorHandling"},retryAnalyzer= Retry.class)
	public void LoginErrorOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

	//String productname= "ZARA COAT 3";	
    landingPage.loginApplication("forampatel133@gmail.com","Foram@5220");
    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage()); 
    
	}
	
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
	

	String productname= "ZARA COAT 3";	
    ProductCatalogue productcatalogue=landingPage.loginApplication("dipal123@gmail.com","Dipal@123");
    List<WebElement> products =productcatalogue.getProductList();
    productcatalogue.addProductToCart(productname);
    CartPage cartPage = productcatalogue.goToCartPage();
    Boolean match  =cartPage.verifyProductDisplay("ZARA COAT 33");
    Assert.assertFalse(match);
    driver.quit();
   
 
	}
	

}
