package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BroswerUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BroswerUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		// create instance of driver variable
	}

	public BroswerUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				 options.addArguments("--headless=new");
		            options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {

			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");// headless
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				;
			} else {
				driver.set(new EdgeDriver());
			}

		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");// headless
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}

		} else {
			logger.error("Invalid Browser Name....Please select correct Browser");
			System.err.print("Invalid Browser Name....Please select correct Browser");
		}
	}

	public void goToWebSite(String URL) {
		logger.info("Visiting the website" + URL);
		driver.get().get(URL);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the Browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Elements with locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Elements Found and Now Performing click");
		element.click();
	}

	public void enterText(By locator, String email) {
		logger.info("Finding Elements with locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Elements Found and Now Enter Text");
		element.sendKeys(email);
	}

	public String getVisibilityText(By locator) {
		logger.info("Finding Elements with locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Elements Found and Now returning the visible" + element.getText());
		return element.getText();

	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File scData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = formate.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + "-" + timeStamp + ".png";
		File scFileDest = new File(path);
		try {
			FileUtils.copyFile(scData, scFileDest);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
    
}
