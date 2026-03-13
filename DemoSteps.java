package demoSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoSteps {

   // private boolean onLoginPage = false;
   // private boolean loggedIn = false;

    WebDriver driver;
	  
	  @Before
	  public void setup() {
		  driver = new ChromeDriver(); 
	  }
    
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
         driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
    	  driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
    	  driver.findElement(By.id("password")).sendKeys(password); 
    }

    @When("clicks the Login button")
    public void clicks_the_Login_button() {
    	 driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should be redirected to Products page")
    public void the_user_should_be_redirected_to_products_page() {
    	String currentUrl = driver.getCurrentUrl();
  	   Assert.assertEquals(currentUrl,"https://www.saucedemo.com/inventory.html" );
    }
    
    @Then("an error message {string} should be displayed")
    public void the_user_should_see_an_error_message(String expectedMessage) {
    	String actualMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
    }
    
    @After
    public void tearDown() {
    		  driver.close();
    }
}
