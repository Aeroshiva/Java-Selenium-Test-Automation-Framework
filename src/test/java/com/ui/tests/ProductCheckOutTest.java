package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckOutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "User Logs into the application and searches for a product")
	public void setUp() {
		homePage.maximizeWindow();
		searchResultPage = homePage.goToLoginPage()
				.doLoginWith("fekake3041@ofacer.com", "admin123")
				.searchForAProduct(SEARCH_TERM);
	}
	
	
	
	
	@Test(description="Verify if the logged in User is able to buy a dress", groups = {"e2e", "smoke", "sanity"})
	public void checkOut() {
	String result =	searchResultPage.clickOnTheProductAtIndex(1).changeSize(L).addProductToCart().proceedToCheckOut()
		.goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makeMyPaymentByWire();
	
	Assert.assertTrue(result.contains("complete"));
	}
	
	
	
	
	
	
	
}
