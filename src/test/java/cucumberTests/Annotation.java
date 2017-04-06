package cucumberTests; 

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 


public class Annotation { 
   WebDriver driver = null; 
	
   @Given("^I have open the browser$") 
   public void openBrowser() { 
      driver = new FirefoxDriver(); 
   } 
	
   @When("^I open the ParticipationSystem website$") 
   public void goToParticipation() { 
      driver.navigate().to("https://localhost:8080"); 
   } 
	
   @Then("^login form should exist$") 
   public void loginForm() { 
      if(driver.findElement(By.id("j_idt4")).isEnabled()) { 
         System.out.println("Login functionality exists"); 
      } else { 
         System.out.println("Login functionality doesn't exist"); 
      } 
      driver.close(); 
   } 
}