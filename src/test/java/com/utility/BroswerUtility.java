package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BroswerUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BroswerUtility(WebDriver driver) {
		super();
		this.driver.set(driver);// create instance of driver variable
	}

	public BroswerUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());

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
		WebElement element =driver.get().findElement(locator);
		logger.info("Elements Found and Now Enter Text");
		element.sendKeys(email);
	}
	public void clearText(By clearTextlocator) {
		logger.info("Finding Elements with locator" +  clearTextlocator);
		WebElement element =driver.get().findElement( clearTextlocator);
		logger.info("clear the Text field");
		element.clear();
		
	}
	public String getVisibilityText1(By locator) {
		logger.info("Finding Elements with locator:" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Elements Found and Now returning the visible:" +locator);
		return element.getText();

	}
	public String getVisibilityText(WebElement element) {
		logger.info("Finding Elements with locator:" + element);
		//logger.info("Elements Found and Now returning the visible:" + element.getText());
		return element.getText();

	}
	public List<String> getAllVisibilityText(By locator) {
		logger.info("Finding Elements with locator:" + locator);  
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and Now printed the List:");
		List<String>listName=new ArrayList<String>();
		int numberOfDress=1;
		for(WebElement element:elementList)
		{
			System.out.println("Name of Product is: "+numberOfDress+": "+getVisibilityText(element));
			listName.add(getVisibilityText(element));
			numberOfDress++;
		}
		return listName;

	}
//	public void selectDropDown(By locator) {
//		logger.info("Finding Elements with locator" + locator);
//		WebElement countryDropdown = driver.get().findElement(locator);
//		logger.info("Elements Found and Now Performing click");
//		countryDropdown.click();
//	}
	public void selectFromDropDown(By dropdownlocator) {
		   //WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		   //WebElement dropdown = wait.until(
		          // ExpectedConditions.visibilityOfElementLocated(dropdownlocator));
		logger.info("Finding Elements with locator" + dropdownlocator);
		WebElement element=driver.get().findElement(dropdownlocator);
		  Select select=new Select( element);
		  logger.info("Selecting the Option: "); 
		  select.selectByIndex(4);
		}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File scData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		SimpleDateFormat formate=new SimpleDateFormat("HH-mm-ss");
		String timeStamp=formate.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name+"-"+timeStamp+".png";
		File scFileDest = new File(path);
		try {
			FileUtils.copyFile(scData, scFileDest);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}

}
