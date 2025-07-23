package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage  extends BrowserUtility{

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.xpath("//input[@id='search_query_top']");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title='Add my first address']");
	
	
	
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
	
	
	public SearchResultPage searchForAProduct(String productName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResultsPage = new SearchResultPage(getDriver());
		return searchResultsPage;
		

	}
	
	public AddressPage goToAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}
	
	
	

}
