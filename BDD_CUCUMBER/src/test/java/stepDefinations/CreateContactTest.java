package stepDefinations;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateContactTest {
	WebDriver driver;
	String contactName="pavan_"+new Random().nextInt(1000);

	@Given("Browser should be open and url is navigated")
	public void browser_should_be_open_and_url_is_navigated() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
	}

	@Given("Login page is displayed")
	public void login_page_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='vtiger']")).isDisplayed());
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("submitButton")).click();
	}

	@When("homepage is displayed")
	public void homepage_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed());

	}

	@When("user click on contact link")
	public void user_click_on_contact_link() {
	   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	}

	@When("contacts page is displayed")
	public void contacts_page_is_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Contacts' and @class='hdrLink']")).isDisplayed());
	}

	@When("user click on create contact link")
	public void user_click_on_create_contact_link() {
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	}

	@When("create contact page is displayed")
	public void create_contact_page_is_displayed() {
	     Assert.assertTrue( driver.findElement(By.xpath("//span[text()='Creating New Contact']")).isDisplayed());
  
	}

	@When("user enters contact name")
	public void user_enters_contact_name() {
	     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactName);
  
	}

	@When("user click on save")
	public void user_click_on_save() {
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	}

	@Then("contact should be successfully saved")
	public void contact_should_be_successfully_saved() {
		Assert.assertTrue( driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText().contains(contactName));
	}

}
