package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;

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

	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Home')]")).isDisplayed());
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
