package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
public class LoginTest2 {

	public static void main(String[] args) {
		
		HomePage homePage = new HomePage(Browser.CHROME);
		homePage.goToLoginPage().doLoginWith("fekake3041@ofacer.com", "admin123").clickOn(null);
		
		
		
		
		
		
		
		
	}

}
