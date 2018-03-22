package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver open(String browserType) {

		String OS = System.getProperty("os.name").toLowerCase();

		if (browserType.equals(PropKeys.CHROME_BROWSER)) {

			if (OS.startsWith(Constants.LINUX)) {
				System.setProperty(Constants.CHROME_DRIVER_SYSTEM_PROPERTY,
						Constants.BROWSER_DRIVER_DIRECTORY + Constants.CHROME_DRIVER_LINUX64);
			}
			else if (OS.startsWith(Constants.WINDOWS)) {
				System.setProperty(Constants.CHROME_DRIVER_SYSTEM_PROPERTY,
						Constants.BROWSER_DRIVER_DIRECTORY + Constants.CHROME_DRIVER_WIN32);
			}
			else {
				System.setProperty(Constants.CHROME_DRIVER_SYSTEM_PROPERTY,
						Constants.BROWSER_DRIVER_DIRECTORY + Constants.CHROME_DRIVER_MAC64);
			}
			return new ChromeDriver();
		}
		else {
			if (OS.startsWith(Constants.LINUX)) {
				System.setProperty(Constants.FIREFOX_DRIVER_SYSTEM_PROPERTY,
						Constants.BROWSER_DRIVER_DIRECTORY + Constants.FIREFOX_DRIVER_LINUX32);
			}
			else if (OS.startsWith(Constants.WINDOWS)) {
				System.setProperty(Constants.FIREFOX_DRIVER_SYSTEM_PROPERTY,
						Constants.BROWSER_DRIVER_DIRECTORY + Constants.FIREFOX_DRIVER_WIN32);
			}
			else {
				System.setProperty(Constants.FIREFOX_DRIVER_SYSTEM_PROPERTY,
						Constants.BROWSER_DRIVER_DIRECTORY + Constants.FIREFOX_DRIVER_MAC32);
			}
			return new FirefoxDriver();
		}
	}
}

