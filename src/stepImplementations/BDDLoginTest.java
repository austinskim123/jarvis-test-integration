package stepImplementations;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BDDLoginTest {

	WebDriver driver;

	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("User is on the login page...");
		System.setProperty("webdriver.chrome.driver", "C:\\liferay\\external-libraries\\browser-drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("jarvis.com:8080");
	}

	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_password() {
		System.out.println("User entering username and password...");
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).sendKeys("test");
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password")).sendKeys("test");
		driver.findElement(By.cssSelector("button[class='btn btn-lg btn-primary btn-default'][type='submit']")).click();
	}

	@Then("user gets confirmation")
	public void user_gets_confirmation() {
		System.out.println("User successfully logged in!");
		Assert.assertTrue(driver.findElement(By.className("header-page-title")).getText().equals("j.a.r.v.i.s"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
