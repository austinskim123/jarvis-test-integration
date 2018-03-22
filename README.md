# jarvis-test-integration
This project contains automated tests implemented with Selenium and Cucumber for Liferay Global Service's internal portal - Jarvis.

## Setup
### Prerequisites
The setup instructions assume that you have a copy of lfrgs-liferay-jarvis on your local machine already, as it is an automated testing framework for that project.

### Installing
Depending on your OS (Windows, Mac, Linux) and the browser you want to test for, you need to download the appropriate web driver. 

Navigate to the following link:
```
https://www.seleniumhq.org/download/
```

Under the section labeled **Third Party Browser Drivers NOT DEVELOPED by seleniumhq**, find the browser you want to run the automated tests for. Place the web driver you downloaded into the /external-libraries/browser-drivers/ directory.

Do a global search in your IDE for `/external-libraries/browser-driver` and replace the path with the path to your web driver. Note that you will also have to change the class of the WebDriver based on which web driver you use (i.e. ChromeDriver for Google Chrome, FirefoxDriver for Mozilla Firefox, etc.).