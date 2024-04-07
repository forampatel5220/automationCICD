package rahulshettyacademy.SeleniumDesignFramework.Test;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumDesignFramework.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                //new comments are added
                //for testing
	String productname= "ZARA COAT 3";	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.get("https://rahulshettyacademy.com/client");
   driver.findElement(By.id("userEmail")).sendKeys("foram123@gmail.com");
   driver.findElement(By.id("userPassword")).sendKeys("Foram.5220");
   driver.findElement(By.id("login")).click();
    
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    
    
    List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    
    WebElement prod=products.stream().filter(product->
    product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
   prod.findElement(By.cssSelector(".card-body button[class='btn w-10 rounded']")).click();
    
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
   
   
  
   driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
 List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
 
   
Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));

   Assert.assertTrue(match);
   
   driver.findElement(By.cssSelector(".totalRow button")).click();   
   
   
   Actions a=new Actions(driver);
  a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
   
 //  WebElement staticDropdown=driver.findElement(By.cssSelector("[placeholder='Select Country']"));
  // Select dropdown=new Select(staticDropdown);
  // dropdown.selectByValue("india");
   //System.out.println(dropdown.getFirstSelectedOption().getText());
  
   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
  driver.findElement(By.cssSelector(".action__submit")).click();
   
  String ConfirmMsg  =  driver.findElement(By.cssSelector(".hero-primary")).getText();
  Assert.assertTrue(ConfirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
 // driver.close();
   
   
	
    
    
    
    
    
    
    
    
     
    
    
      
	
	
	
	
	
		
	}

}
