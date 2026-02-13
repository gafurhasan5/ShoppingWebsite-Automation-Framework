package com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BroswerUtility {

	private WebDriver driver;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver;
	}

	public BroswerUtility(WebDriver driver) {
		super();
		this.driver = driver; // create instance of driver variable
	}

	public BroswerUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {

			driver = new ChromeDriver();
		} else if (browserName == Browser.EDGE) {

			driver = new EdgeDriver();
		} else if (browserName == Browser.FIREFOX) {

			driver = new FirefoxDriver();
		} else {
			logger.error("Invalid Browser Name....Please select correct Browser");
			System.err.print("Invalid Browser Name....Please select correct Browser");
		}
	}

	public void goToWebSite(String URL) {
		logger.info("Visiting the website" + URL);
		driver.get(URL);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the Browser window");
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Elements with locator" + locator);
		WebElement element = driver.findElement(locator);
		logger.info("Elements Found and Now Performing click");
		element.click();
	}

	public void enterText(By locator, String email) {
		logger.info("Finding Elements with locator" + locator);
		WebElement element = driver.findElement(locator);
		logger.info("Elements Found and Now Enter Text");
		element.sendKeys(email);
	}

	public String getVisibilityText(By locator) {
		logger.info("Finding Elements with locator" + locator);
		WebElement element = driver.findElement(locator);
		logger.info("Elements Found and Now returning the visible" + element.getText());
		return element.getText();

	}

}
