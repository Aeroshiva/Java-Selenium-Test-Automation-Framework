package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver(); // Loose Coupling
		
		
		BrowserUtility browserUtility = new BrowserUtility(Br);
		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
		browserUtility.maximizeWindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
		browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "fekake3041@ofacer.com");
		
		
		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "admin123");

		By submitButton = By.id("SubmitLogin");
		browserUtility.clickOn(submitButton);
		
		
		
		
	}

}
