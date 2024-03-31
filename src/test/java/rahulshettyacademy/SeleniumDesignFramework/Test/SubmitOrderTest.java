package rahulshettyacademy.SeleniumDesignFramework.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.CartPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.CheckOutPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.ConfirmationPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.OrderPage;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productname= "ZARA COAT 3";
	
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

    ProductCatalogue productcatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
    //ProductCatalogue productcatalogue =new ProductCatalogue(driver);
    List<WebElement> products =productcatalogue.getProductList();
    productcatalogue.addProductToCart(input.get("product"));
    
    CartPage cartPage = productcatalogue.goToCartPage();
   //CartPage cartpage=new CartPage(driver);
    Boolean match  =cartPage.verifyProductDisplay(input.get("product"));
    Assert.assertTrue(match);
    
    CheckOutPage checkOutPage= cartPage.goToCheckout();
    checkOutPage.selectCountry("india");
    ConfirmationPage confirmationPage=checkOutPage.submitOrder();
  
    String ConfirmMessage  = confirmationPage.getConfirmationMessage();
    Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest() {
		
		 ProductCatalogue productcatalogue=landingPage.loginApplication("forampatel133@gmail.com","Foram.5220");
		 OrderPage orderspage=productcatalogue.goToOrdersPage();
		 Assert.assertTrue(orderspage.verifyOrderDisplay(productname)); 		
	}
	
	
	
	
	//Extent Reports

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data= getJasonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
}

/*@DataProvider
public Object[][] getData()
{
	return new Object[][] {{"forampatel133@gmail.com","Foram.5220","ZARA COAT 3"},{"dipal123@gmail.com","Dipal@123","ADIDAS ORIGINAL"}};
}
/*@DataProvider
public Object[][] getData()
{
	HashMap<String,String> map=new HashMap<String,String>();
	map.put("email","forampatel133@gmail.com" );
	map.put("password","Foram.5220");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String,String> map1=new HashMap<String,String>();
	map1.put("email","dipal123@gmail.com" );
	map1.put("password","Dipal@123");
	map1.put("product", "ADIDAS ORIGINAL");
	return new Object[][] {{map},{map1}};
	
}*/
	


