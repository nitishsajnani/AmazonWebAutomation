package in.amazon.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import in.amazon.getpageobjects.GetPage;

public class ProductPage extends GetPage {

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver, "ProductPage");
		this.driver = driver;
	}

	public void verifyAboutThis(String expected) {
		scrollToElement(element("aboutThis_txt"));
		Assert.assertEquals(element("aboutThis_txt").getText(),expected,"Testcase Failed:String is not matched");
		logMessage("Testcase Passed:String is matched");
	}
	public void logProductDescription() {
		logMessage("Product descriptions :"+element("section_txt").getText());
	}
}