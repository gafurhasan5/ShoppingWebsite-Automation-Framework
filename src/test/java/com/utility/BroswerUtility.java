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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
=======
import org.openqa.selenium.firefox.FirefoxOptions;
>>>>>>> refs/heads/feture/headlessFeatureAndLamdaTestBranch

import com.constants.Browser;
import com.constants.Size;

public abstract class BroswerUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;
	public WebDriver getDriver() {
		return driver.get();
	}

	public BroswerUtility(WebDriver driver) {
		super();
<<<<<<< HEAD
		this.driver.set(driver);// create instance of driver variable
		wait =new WebDriverWait(driver, Duration.ofSeconds(30L));
=======
		this.driver.set(driver);
		// create instance of driver variable
>>>>>>> refs/heads/feture/headlessFeatureAndLamdaTestBranch
	}

	public BroswerUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
<<<<<<< HEAD
			driver.set(new ChromeDriver());
			wait =new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
=======
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				 options.addArguments("--headless=new");
		            options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
>>>>>>> refs/heads/feture/headlessFeatureAndLamdaTestBranch
		} else if (browserName == Browser.EDGE) {

<<<<<<< HEAD
			driver.set(new EdgeDriver());
			wait =new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
=======
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");// headless
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				;
			} else {
				driver.set(new EdgeDriver());
			}

>>>>>>> refs/heads/feture/headlessFeatureAndLamdaTestBranch
		} else if (browserName == Browser.FIREFOX) {

<<<<<<< HEAD
			driver.set(new FirefoxDriver());
			wait =new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
=======
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");// headless
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}

>>>>>>> refs/heads/feture/headlessFeatureAndLamdaTestBranch
		} else {
			logger.error("Invalid Browser Name....Please select correct Browser");
			System.err.print("Invalid Browser Name....Please select correct Browser");
		}
	}

	public void goToWebSite(String URL) {
		logger.info("Visiting the website" + URL);
		driver.get().get(URL);
		wait =new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
	}

	public void maximizeWindow() {
		logger.info("Maximizing the Browser window");
		driver.get().manage().window().maximize();
		wait =new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
	}

	public void clickOn(By locator) {
		logger.info("Finding Elements with locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Elements Found and Now Performing click");
		element.click();
	}
	public void clickOnCheckBox(By locator) {
		logger.info("Finding Elements with locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Elements Found and Now Performing click");
		element.click();
	}
	public void enterText(By locator, String email) {
		logger.info("Finding Elements with locator" + locator);
<<<<<<< HEAD
		//WebElement element =driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
=======
		WebElement element = driver.get().findElement(locator);
>>>>>>> refs/heads/feture/headlessFeatureAndLamdaTestBranch
		logger.info("Elements Found and Now Enter Text");
		element.sendKeys(email);
	}
	public void clearText(By clearTextlocator) {
		logger.info("Finding Elements with locator" +  clearTextlocator);
		//WebElement element =driver.get().findElement( clearTextlocator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(clearTextlocator));
		logger.info("clear the Text field");
		element.clear();
		
	}
	public String getVisibilityText1(By locator) {
		logger.info("Finding Elements with locator:" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding Elements with locator:" + locator);  
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and Now printed the List:");
		return elementList;

	}
//	public void selectDropDown(By locator) {
//		logger.info("Finding Elements with locator" + locator);
//		WebElement countryDropdown = driver.get().findElement(locator);
//		logger.info("Elements Found and Now Performing click");
//		countryDropdown.click();
//	}
	public void selectFromDropDown(By dropdownlocator) {
		logger.info("Finding Elements with locator" + dropdownlocator);
		WebElement element=driver.get().findElement(dropdownlocator);
		  Select select=new Select( element);
		  logger.info("Selecting the Option: "); 
		  select.selectByIndex(4);
		}
	
	public void selectFromDropDownByVisibleText(By dropdownlocator,String size) {
		logger.info("Finding Elements with locator" + dropdownlocator);
		WebElement element=driver.get().findElement(dropdownlocator);
		
		  Select select=new Select( element);
		  logger.info("Selecting the Option: "); 
		  select.selectByVisibleText(size);
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
