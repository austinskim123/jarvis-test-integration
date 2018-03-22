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

public class BDDEditClientTest {

	private WebDriver driver;

	private DirectoriesPageFactory directoriesPageFactory;

	private ClientPageFactory clientPageFactory;

	@Given("^user is logged in and client has been added$")
	public void user_is_logged_in_and_client_has_been_added() {

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
	}

	@When("^user navigates to the client page$")
	public void user_navigates_to_the_client_page() {

		System.out.println("User added client...");
		directoriesPageFactory.clickFirstRowClient();
	}

	@And("^user clicks on Edit Client$")
	public void user_clicks_on_edit_client() {

		clientPageFactory.clickEditClientButton();
	}

	@And("^user edits information for the client$")
	public void user_edits_information_for_the_client() {

		clientPageFactory.editClientName("Edited Test Client");
		clientPageFactory.exitClientForm();
	}

	@Then("^user gets confirmation that the client was edited successfully$")
	public void user_gets_confirmation_that_the_client_was_edited_successfully() {

		System.out.println("User successfully edited client!");

		clientPageFactory.clickDirectoriesButton();
		directoriesPageFactory.refresh();

		String clientName = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(clientName.equals("Edited Test Client"));

		// Delete Test Client to restore DB as it was
		directoriesPageFactory.deleteFirstRowClient();
		directoriesPageFactory.refresh();

		String notTestClient = directoriesPageFactory.getFirstRowClientName();
		Assert.assertTrue(!notTestClient.equals("Edited Test Client"));

		// Close browser
		driver.quit();
	}

}
