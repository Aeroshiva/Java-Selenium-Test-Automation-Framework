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
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();

	}

	/**
	 * This constructor in BrowserUtility: Initializes the private driver variable.
	 * Makes the driver accessible to all child classes (e.g., MyAccountPage,
	 * LoginPage, etc.) via a method like getDriver().
	 * 
	 * @param BrowserUtility
	 */

	public BrowserUtility(WebDriver driver) {
		super(); // calls Object class constructor (implicitly done anyway)
		this.driver.set(driver); // assigns the passed driver to this class's instance variable
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching the Browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			logger.error("Invlaid Browser Name......Please Select Chrome or Edge only!");
			System.err.print("Invlaid Browser Name......Please Select Chrome or Edge only!");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching the Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}

	}

	public BrowserUtility(Browser browserName, String isHeadless) {
		boolean headless = Boolean.parseBoolean(isHeadless);
		logger.info("Launching the Browser for " + browserName);
		if (browserName == Browser.CHROME) {

			if (headless) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

		} else if (browserName == Browser.EDGE) {
			if (headless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

		} else if (browserName == Browser.FIREFOX) {
			if (headless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

	}

	public void goToWebsite(String url) {
		logger.info("Visiting the Website" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximising the browser window");
		driver.get().manage().window().maximize(); // chaining of methods

	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		logger.info("Element found and performing the Click");
		element.click();
	}
	
	
	public void clickOnCheckBox(By locator) {
		logger.info("Finding Element with the locator" + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and performing the Click");
		element.click();
	}
	

	public void clickOn(WebElement element) {
		logger.info("Element found and performing the Click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and now enter text" + textToEnter);

		element.sendKeys(textToEnter);
	}

	public void clearText(By textBoxLocator) {
		logger.info("Finding Element with the locator" + textBoxLocator);

		// WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));

		logger.info("Element Found and now clearing the text box field");

		element.clear();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding Element with the locator" + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
		logger.info("Selecting the Option" + optionToSelect);

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and now enter special key" + keyToEnter);

		element.sendKeys(keyToEnter);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);

		List<WebElement> elementsList = driver.get().findElements(locator);
		logger.info("Element Found and now printing the List of Elements");

		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementsList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}

		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding Element with the locator" + locator);

		List<WebElement> elementsList = driver.get().findElements(locator);
		logger.info("Element Found and now printing the List of Elements");

		return elementsList;
	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visible Text" + element.getText());

		return element.getText();
	}

	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator" + locator);

		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now returning the visible text" + element.getText());

		return element.getText();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File screenshotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		String timeStamp = format.format(date);

		String path = "." + File.separator + "screenshots" + File.separator + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;

	}

	public void quit() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}

}
