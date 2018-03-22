package stepImplementations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DirectoriesPageFactory;
import pages.LoginPageFactory;
import util.PropValues;

import java.util.concurrent.TimeUnit;

public class BDDAddDeleteClientTest {

	private WebDriver driver;
	private DirectoriesPageFactory directoriesPageFactory;

	@Given("^user is logged in and on the directories page$")
	public void user_is_logged_in_and_on_the_directories_page() {

		// Open web driver and go to login page
		System.out.println("User is on the login page...");
		driver = util.DriverFactory.open(PropValues.WEB_BROWSER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropValues.BASE_URL + "/directories");
		directoriesPageFactory = new DirectoriesPageFactory(driver);

		// Login action
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login("test", "test");
	}

	@When("^user clicks on Add Client$")
	public void user_clicks_on_add_client() {

		// Click on the add button
		System.out.println("User is logged in and on the Directories page...");
		directoriesPageFactory.openAddClientForm();
	}

	@And("^user submits form with the required fields filled out$")
	public void user_submits_form_with_the_required_fields_filled_out() {

		// Change windows and fill out the form and click submit
		directoriesPageFactory.createTestClient("Test Client");

		// Exit out of pop up window
		directoriesPageFactory.exitClientForm();
	}

	@And("^user gets confirmation that the client was added successfully$")
	public void user_gets_confirmation_that_the_client_was_added_successfully() {

		System.out.println("User successfully added client!");

		// Refresh page and confirm that test client was added
		directoriesPageFactory.refresh();
		String testClient = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(testClient.equals("Test Client"));
	}

	@And("^user deletes most recently added client$")
	public void user_deletes_most_recently_added_client() {

		// Delete Test Client to restore DB as it was
		directoriesPageFactory.deleteFirstRowClient();
		directoriesPageFactory.refresh();
	}

	@Then("^user gets confirmation that the client was deleted successfully$")
	public void user_gets_confirmation_that_the_client_was_deleted_successfully() {

		System.out.println("User successfully deleted client!");

		String notTestClient = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(!notTestClient.equals("Test Client"));

		// Close browser
		driver.quit();
	}

}
