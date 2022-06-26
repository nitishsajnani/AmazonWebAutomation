package in.amazon.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestAmazon extends BaseTest {

	public TestAmazon(String baseUrl) {
		super("loginApp.baseUrl");
	}
	
	@Test
	public void TC001_UserNavigateToShopByDepartment() {
		amazon.homePage.clickHamburgerButton();
		amazon.homePage.ScrollToFilterType("Shop By Department");
		amazon.homePage.clickOnDepartment();
		amazon.homePage.clickTVlink();
		Reporter.log("User navigated to department home page",true);
	}
	
	@Test
	public void TC002_UserNavigateToProductBrandSelectionBox() {
        amazon.productListingPage.ScrollToFilterSelectionBox("Brands");
        amazon.productListingPage.selectbrand("Samsung");
		Reporter.log("User select product brand",true);

	}
	@Test
	public void TC003_UserSortingTheProductByHighToLowPrice() {
		
        amazon.productListingPage.clickOnSort("Price: High to Low");
		Reporter.log("Sort the product by price high to low ",true);
	}	
	
	@Test
	public void TC004_OpenSecondHighestProductInNewWindow() {
		amazon.productListingPage.selectProductByIndex(1);//
		Reporter.log("User open product which is  second highest in price",true);

	}	
	@Test
	public void TC005_verifyAboutThisAndLogProductDetailSection() {
		amazon.productPage.verifyAboutThis("About this item");
		amazon.productPage.logProductDescription();
		Reporter.log("User verify about this section and log product description",true);

	}	
}