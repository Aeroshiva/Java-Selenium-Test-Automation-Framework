package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	
	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless); // to call the parent class constructor from the child constructor 
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

		
	}
	
	public HomePage(WebDriver lambdaDriver) {
		super(lambdaDriver);
	    goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage() { //page functions ---> 
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	
	
	
	
	
}
