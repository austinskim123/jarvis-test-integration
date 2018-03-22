package stepImplementations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ClientPageFactory;
import pages.DirectoriesPageFactory;
import pages.LoginPageFactory;
import util.PropValues;

import java.util.concurrent.TimeUnit;

public class BDDAddSubclientTest {

	private WebDriver driver;
	private DirectoriesPageFactory directoriesPageFactory;
	private ClientPageFactory clientPageFactory;

	@Given("^user is logged into client page of Test Client$")
	public void user_is_logged_into_client_page_of_test_client() {

		// Open web driver and go to login page
		System.out.println("User is logged in and on the Directories page...");
		driver = util.DriverFactory.open(PropValues.WEB_BROWSER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropValues.BASE_URL + "/directories");
		directoriesPageFactory = new DirectoriesPageFactory(driver);
		clientPageFactory = new ClientPageFactory(driver);

		// Login action
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login("test", "test");

		// Click on the add button
		directoriesPageFactory.openAddClientForm();

		// Change windows and fill out the form and click submit
		directoriesPageFactory.createTestClient("Test Client");

		// Exit out of pop up window
		directoriesPageFactory.exitClientForm();

		// Refresh the page
		directoriesPageFactory.refresh();

		System.out.println("User added client...");
		directoriesPageFactory.clickFirstRowClient();
	}

	@When("^user clicks on Add Subclient$")
	public void user_clicks_on_add_subclient() {

		clientPageFactory.openSubclientForm();
	}

	@And("^user submits subclient form with required fields filled out$")
	public void user_submits_subclient_form_with_required_fields_filled_out() {

		clientPageFactory.setSubclientName("Test Subclient");
		clientPageFactory.exitClientForm();
	}

	@Then("^user gets confirmation that the subclient was added successfully$")
	public void user_gets_confirmation_that_the_subclient_was_added_successfully() {

		System.out.println("User successfully added subclient!");

		clientPageFactory.clickDirectoriesButton();
		directoriesPageFactory.refresh();

		String clientName = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(clientName.equals("Test Subclient"));

		directoriesPageFactory.deleteFirstRowClient();
		directoriesPageFactory.refresh();
		clientName = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(clientName.equals("Test Client"));

		directoriesPageFactory.deleteFirstRowClient();
		directoriesPageFactory.refresh();
		clientName = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(!(clientName.equals("Test Client") || clientName.equals("Test Subclient")));

		driver.quit();
	}
}
