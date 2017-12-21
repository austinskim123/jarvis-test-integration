package stepImplementations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BDDAddClientTest {

	WebDriver driver;

	@Given("^user is logged in and on the directories page$")
	public void user_is_logged_in_and_on_the_directories_page() {
		// Open web driver and go to login page
		System.out.println("User is on the login page...");
		System.setProperty("webdriver.chrome.driver", "C:\\liferay\\external-libraries\\browser-drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("jarvis.com:8080/directories");

		// Login action
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).sendKeys("test");
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password")).sendKeys("test");
		driver.findElement(By.cssSelector("button[class='btn btn-lg btn-primary btn-default'][type='submit']")).click();
	}

	@When("^user clicks on Add Client and fills out the required fields$")
	public void user_clicks_on_add_client_and_fills_out_the_required_fields() {
		// Click on the add button
		System.out.println("User is logged in and on the Directories page...");
		driver.findElement(By.cssSelector("button[aria-expanded='false'][type='button'][data-qa-id='addButton']")).click();
		driver.findElement(By.linkText("Add Client")).click();

		// Change windows and fill out the form and click submit
		By locIFrame = By.xpath("//*[@id=\"senna_surface1\"]/div[2]/div[2]/div[2]/iframe");
		driver.switchTo().frame(driver.findElement(locIFrame));
		driver.findElement(By.xpath("//*[@id=\"_com_liferay_jarvis_client_portlet_EditClientPortlet_name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"_com_liferay_jarvis_client_portlet_EditClientPortlet_name\"]")).sendKeys("Test Client");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Exit out of pop up window
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"senna_surface1\"]/div[2]/div[2]/div[1]/div/button")).click();
	}

	@Then("^user gets confirmation that the client was added successfully$")
	public void user_gets_confirmation_that_the_client_was_added_successfully() {
		System.out.println("User successfully added client!");

		// Refresh page and confirm that test client was added
		driver.navigate().refresh();
		String testClient = driver.findElement(By.cssSelector("td[class='table-cell first']")).getText();
		Assert.assertTrue(testClient.equals("Test Client"));

		// Delete Test Client to restore DB as it was
		driver.findElement(By.cssSelector("a[class='dropdown-toggle direction-left max-display-items-15 btn btn-default'][title='Actions']")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.switchTo().alert().accept();
		driver.get("jarvis.com:8080/directories");
		driver.navigate().refresh();
		String notTestClient = driver.findElement(By.cssSelector("td[class='table-cell first']")).getText();
		Assert.assertTrue(!notTestClient.equals("Test Client"));

		// Close browser
		driver.quit();
	}

}
