package stepImplementations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageFactory;

public class BDDLoginTest {

	private WebDriver driver;

	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("User is on the login page...");
		System.setProperty("webdriver.chrome.driver", "/home/austinskim/liferay/external-libraries/browser-drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("jarvis.com:8080");
	}

	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_password() {
		System.out.println("User entering username and password...");
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login("test","test");
	}

	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("User successfully logged in!");
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		Assert.assertTrue(loginPageFactory.getPageHeaderTitle().equals("j.a.r.v.i.s"));
		driver.quit();
	}

}
