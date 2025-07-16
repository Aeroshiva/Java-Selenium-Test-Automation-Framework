package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage  extends BrowserUtility{

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");
	
	
	/**
	 * when MyAccountPage constructor calls super(driver), it's saying:	"Please run the constructor from BrowserUtility and 
	pass this WebDriver instance to it so that it sets everything up
	 * @param MyAccountPage 
	 */
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUsername() {
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	

}
