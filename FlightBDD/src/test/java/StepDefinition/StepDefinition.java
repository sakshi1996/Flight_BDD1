package StepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	WebDriver driver;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
    String h = (formatter.format(date)).substring(12,14);
    String m = (formatter.format(date)).substring(15,17);  
    String t="kiran"+h+m+"@gmail.com";
	
	@Given("^Registration page should be available$")
	public void registration_page_should_be_available() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "E:\\Gecko\\geckodriver.exe");
		  driver= new FirefoxDriver();
		  Thread.sleep(5000);
		  driver.get("http://localhost:8090/Demo-0.0.1-SNAPSHOT/homepage");
		  Thread.sleep(5000);
	}

	@When("^Validate registration page$")
	public void validate_registration_page() throws InterruptedException {
		driver.findElement(By.linkText("Register")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.name("title")).sendKeys("Mr");
		  Thread.sleep(3000);
		  driver.findElement(By.name("firstName")).sendKeys("Sai");
		  Thread.sleep(3000);
		  driver.findElement(By.name("middleName")).sendKeys("Karan");
		  Thread.sleep(3000);
		  driver.findElement(By.name("lastName")).sendKeys("Dandumudi");
		  Thread.sleep(3000);
		  driver.findElement(By.name("gender")).sendKeys("F");
		  Thread.sleep(3000);
		  driver.findElement(By.name("emailAddress")).sendKeys(t);
		  Thread.sleep(3000);
		  driver.findElement(By.name("password")).sendKeys("kiran1");
		  Thread.sleep(3000);
		  driver.findElement(By.name("password_confirm")).sendKeys("kiran1");
		  Thread.sleep(3000);
		  driver.findElement(By.name("mobileNumber")).sendKeys("9100599067");
		  Thread.sleep(3000);
		  driver.findElement(By.name("dateOfBirth")).sendKeys("2018-09-02");
		  Thread.sleep(3000);
		  driver.findElement(By.name("passportNumber")).sendKeys("SHDJ2639");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	@Then("^Registration should be successful$")
	public void registration_should_be_successful(){
		String register_successful=driver.findElement(By.tagName("h3")).getText();
		  Assert.assertEquals(register_successful, "Registered successfully");
		  driver.findElement(By.linkText("Logout")).click();
	    driver.close();
	}

	@Given("^Login page should be available$")
	public void login_page_should_be_available() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "E:\\Gecko\\geckodriver.exe");
		  driver= new FirefoxDriver();
		  Thread.sleep(5000);
		  driver.get("http://localhost:8090/Demo-0.0.1-SNAPSHOT/homepage");
		  Thread.sleep(5000);
	}

	@When("^Validate login page$")
	public void validate_login_page() throws InterruptedException{
		driver.findElement(By.linkText("Login")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.name("email")).sendKeys(t);
		  Thread.sleep(3000);
		  driver.findElement(By.name("password")).sendKeys("kiran1");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@type='submit']")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.linkText("Logout")).click();
		  System.out.println("Sucessful");

	}

	String breakpoint;
	@Then("^Login should be successful$")
	public void login_should_be_successful(){
	    driver.close();
	}

}
