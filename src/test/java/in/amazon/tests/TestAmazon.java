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
		amazon.homePage.ScrollToShopByDepartment();
		amazon.homePage.clickOnDepartment();
		amazon.homePage.clickTVlink();
		Reporter.log("User navigated to department home page",true);
	}
	
	@Test
	public void TC002_UserNavigateToProductBrandSelectionBox() {
        amazon.productListingPage.ScrollToBrandSelectionBox();
        amazon.productListingPage.selectbrand();
		Reporter.log("User navigated to product brand selection box ",true);

	}
	@Test
	public void TC003_UserSortingTheProductByHighToLowPrice() {
		//amazon.productListingPage.selectProductByIndex(2);
        amazon.productListingPage.clickOnSort();
        amazon.productListingPage.clickOnSort();
		Reporter.log("User navigated to product brand selection box ",true);

	}	
	@Test
	public void TC004_OpenSecondHighestProductInNewWindow() {
		amazon.productListingPage.switchedToWindow();
		Reporter.log("User navigated to product brand selection box ",true);

	}	
	@Test
	public void TC005_verifyAboutThisAndLogProductDetailSection() {
		amazon.productListingPage.switchedToWindow();
		Reporter.log("User navigated to product brand selection box ",true);

	}	
}