package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	// Define web elements at class level

	private WebDriver driver;

	@FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_login")
	private WebElement usernameBox;

	@FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_password")
	private WebElement passwordBox;

	@FindBy(css = "button[class='btn btn-lg btn-primary btn-default'][type='submit']")
	private WebElement loginButton;

	@FindBy(className = "header-page-title")
	private WebElement pageHeaderTitle;

	//Steps

	public void clickLogin() {
		loginButton.click();
	}

	public String getPageHeaderTitle() {

		return pageHeaderTitle.getText();
	}

	public void setUsername(String username) {

		usernameBox.sendKeys(username);
	}

	public void setPassword(String password) {

		passwordBox.sendKeys(password);
	}

	// Actions

	public void login(String username, String password) {

		usernameBox.clear();
		setUsername(username+"@liferay.com");
		setPassword(password);
		clickLogin();
	}

	// Constructor initializes the state of the driver

	public LoginPageFactory(WebDriver driver) {

		this.driver = driver;

		// Initialize web elements
		PageFactory.initElements(driver, this);
	}

}
