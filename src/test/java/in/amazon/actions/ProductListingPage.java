package in.amazon.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import in.amazon.getpageobjects.GetPage;
public class ProductListingPage extends GetPage {

	WebDriver driver;
	public ProductListingPage(WebDriver driver) {
		super(driver, "ProductListing");
		this.driver = driver;
	}
	public void ScrollToFilterSelectionBox(String filterType) {
		scrollToElement(element("brand_txt",filterType));
		try {
			Thread.sleep(500);
			 logMessage("User scrolled to brand selection box "+filterType);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 logMessage("User not able to find selection box");

		}
		}
	public void selectbrand(String brandName) {
		waitForPageToLoadCompletely();
	 	clickOnButton(element("brand_checkbox",brandName),"brand "+ brandName);
	 	hardWait(5);
	}
	public void clickOnSort(String sortingType) {
		element("sortFeature_dd").click();
	 	clickOnButton(element("sort_dd",sortingType),sortingType);
	}
	
	public void selectProductByIndex(int position) {
       hardWait(5);
		List<WebElement> element = elements("product_link");
	element.get(position).click();
	openNewTab();
	
	}
}