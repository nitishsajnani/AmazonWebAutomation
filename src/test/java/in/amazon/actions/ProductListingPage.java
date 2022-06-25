package in.amazon.actions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import in.amazon.getpageobjects.GetPage;
public class ProductListingPage extends GetPage {

	WebDriver driver;
	public ProductListingPage(WebDriver driver) {
		super(driver, "ProductListing");
		this.driver = driver;
	}
	public void ScrollToBrandSelectionBox() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element("brand_txt"));
		try {
			Thread.sleep(500);
			 logMessage("User scrolled to brand selection box");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 logMessage("User not able to find brand selection box");

		}
		}
	public void selectbrand() {
	 	clickOnButton(element("brand_checkbox"),"brand checkbox");
	}
	public void clickOnSort() {
	 	clickOnButton(element("sortFeature_dd"),"sort by feature");
	 	clickOnButton(element("sort_dd"),"sort");
	 	//clickOnButton(element("sortFeature_dd"),"sort by high to low");

	}
	
	public void selectProductByIndex(int position) {
	List<WebElement> products=elements("product_link");
	products.get(position).click();
   
	}
	
	public void switchedToWindow() {
		
	   
		}
	
}