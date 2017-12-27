package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {

	// Define web elements
	private WebDriver driver;

	@FindBy(id = "_com_liferay_jarvis_client_portlet_EditClientPortlet_name")
	private WebElement clientNameBox;

	@FindBy(xpath = "//*[@id=\"portlet_com_liferay_jarvis_client_portlet_ClientPortlet\"]/div/div[2]/div/div[1]/div[2]/a")
	private WebElement editClientButton;

	@FindBy(xpath = "//*[@id=\"senna_surface1\"]/div[2]/div[2]/div[2]/iframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id=\"senna_surface1\"]/div[2]/div[2]/div[1]/div/button")
	private WebElement exitClientFormButton;

	@FindBy(css = "button[type='submit']")
	private WebElement submitButton;

	@FindBy(linkText = "Directories")
	private WebElement directoriesButton;

	// Steps
	public void clickEditClientButton() {

		editClientButton.click();
	}

	public void clearClientNameBox() {

		clientNameBox.clear();
	}

	public void clickClientNameBox() {

		clientNameBox.click();
	}

	public void setClientNameBox(String name) {

		clientNameBox.sendKeys(name);
	}

	public void clickSubmitButton() {

		submitButton.click();
	}

	public void clickDirectoriesButton() {

		directoriesButton.click();
	}

	public void switchIFrameToClientForm() {

		driver.switchTo().frame(iframe);
	}

/*	public void refresh() {

		driver.navigate().refresh();
		driver.navigate().refresh();
	}*/

	// Actions
	public void editClientName(String name) {

		switchIFrameToClientForm();
		clearClientNameBox();
		clickClientNameBox();
		setClientNameBox(name);
		clickSubmitButton();
	}

	public void exitClientForm() {

		driver.switchTo().defaultContent();
		exitClientFormButton.click();
	}

	// Constructor
	public ClientPageFactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
