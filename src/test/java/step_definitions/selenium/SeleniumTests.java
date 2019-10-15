package step_definitions.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTests {
	static WebDriver driver;
	
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given("I login to my GitHub account")
	public void i_login_to_my_GitHub_account() {
	    driver.get("https://github.com/");
	    driver.findElement(By.cssSelector("a[href='/login']")).click();
	    driver.findElement(By.id("login_field")).sendKeys("" + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);
	}

	@Given("I create a new repository")
	public void i_create_a_new_repository() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I pass in repository name {string}")
	public void i_pass_in_repository_name(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I click Create Repository")
	public void i_click_Create_Repository() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the title of the page should containt {string}")
	public void the_title_of_the_page_should_containt(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
}
