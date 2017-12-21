package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	WebDriver driver;

	@FindBy(linkText="Directories")
	WebElement directoriesLink;

	@FindBy(linkText="Advanced Search")
	WebElement advancedSearchLink;

	@FindBy(linkText="Document Central")
	WebElement documentCentralLink;

	@FindBy(xpath = "//*[@id=\"banner\"]/a")
	WebElement homeLink;

	@FindBy(id="_SearchPortlet_keywords")
	WebElement searchBox;

	public void clickAdvancedSearch() {

		advancedSearchLink.click();
	}

	public void clickDirectories() {

		directoriesLink.click();
	}

	public void clickDocumentCentral() {

		documentCentralLink.click();
	}

	public void clickHome() {

		homeLink.click();
	}

	public void setSearchBox(String searchTerm) {

		searchBox.sendKeys(searchTerm);
	}

	public HomePageFactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
