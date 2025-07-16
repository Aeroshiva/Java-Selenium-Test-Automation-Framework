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

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	Logger logger = LoggerUtility.getLogger(this.getClass());

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
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching the Browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("Invlaid Browser Name......Please Select Chrome or Edge only!");
			System.err.print("Invlaid Browser Name......Please Select Chrome or Edge only!");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching the Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching the Browser for " + browserName);
		if (browserName == Browser.CHROME) {

			if (isHeadless) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());

			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
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
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and performing the Click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);

		WebElement element = driver.get().findElement(locator);

		logger.info("Element Found and now enter text" + textToEnter);

		element.sendKeys(textToEnter);
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

		String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + name + " - "
				+ timeStamp + ".png";
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
