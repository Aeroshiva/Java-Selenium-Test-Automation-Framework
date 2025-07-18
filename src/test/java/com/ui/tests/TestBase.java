package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the HomePage of the Website")
	public void setup(
		@Optional("chrome")	String browser, 
		@Optional("false") String isLambdaTest, 
		@Optional("true") String isHeadless, ITestResult result) {

		this.isLambdaTest = Boolean.parseBoolean(isLambdaTest);
		boolean headless = Boolean.parseBoolean(isHeadless);
		WebDriver lambdaDriver;
		if (this.isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initialisedLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			logger.info("Load the HomePage of the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}
	}

}
