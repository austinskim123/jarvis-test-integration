package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoriesPageFactory {

	// Define web elements
	private WebDriver driver;

	@FindBy(css = "button[aria-expanded='false'][type='button'][data-qa-id='addButton']")
	private WebElement plusButton;

	@FindBy(linkText = "Add Client")
	private WebElement addClientButton;

	@FindBy(xpath = "//*[@id=\"senna_surface1\"]/div[2]/div[2]/div[2]/iframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id=\"_com_liferay_jarvis_client_portlet_EditClientPortlet_name\"]")
	private WebElement clientNameBox;

	@FindBy(css = "button[type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"senna_surface1\"]/div[2]/div[2]/div[1]/div/button")
	private WebElement exitClientFormButton;

	@FindBy(css = "td[class='table-cell first']")
	private WebElement firstRowClient;

	@FindBy(css = "a[class='dropdown-toggle direction-left max-display-items-15 btn btn-default'][title='Actions']")
	private WebElement actionButton;

	@FindBy(linkText = "Delete")
	private WebElement deleteButton;

	// Steps

	public void clickPlusButton() {

		plusButton.click();
	}

	public void clickAddClientButton() {

		addClientButton.click();
	}

	public void switchIFrameToClientForm() {

		driver.switchTo().frame(iframe);
	}

	public void clickClientNameBox() {

		clientNameBox.click();
	}

	public void setClientNameBox(String clientName) {

		clientNameBox.sendKeys(clientName);
	}

	public void clickSubmit() {

		submitButton.click();
	}

	public String getFirstRowClientName() {

		return firstRowClient.getText();
	}

	public void refresh() {

		driver.get("jarvis.com:8080/directories");
		driver.navigate().refresh();
	}

	// Actions

	public void openAddClientForm() {

		clickPlusButton();
		clickAddClientButton();
	}

	public void createTestClient(String clientName) {

		switchIFrameToClientForm();
		clickClientNameBox();
		setClientNameBox(clientName);
		clickSubmit();
	}

	public void exitClientForm() {

		driver.switchTo().defaultContent();
		exitClientFormButton.click();
	}

	public void deleteTestClient() {

		actionButton.click();
		deleteButton.click();
		driver.switchTo().alert().accept();
	}

	// Constructor initializes the state of the driver

	public DirectoriesPageFactory(WebDriver driver) {

		this.driver = driver;

		// Initialize web elements
		PageFactory.initElements(driver, this);
	}

}
