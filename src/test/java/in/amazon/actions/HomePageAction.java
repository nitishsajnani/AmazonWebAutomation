package in.amazon.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import in.amazon.getpageobjects.GetPage;

public class HomePageAction extends GetPage {

	WebDriver driver;

	public HomePageAction(WebDriver driver) {
		super(driver, "HomePage");
		this.driver = driver;
	}
	public void clickHamburgerButton() {
	 	clickOnButton(element("hamburger_icon"),"hamburger");
	}
	public void clickOnDepartment() {
	 	clickOnButton(element("department_link"),"tv");
	}
	
	
	public void clickTVlink() {
	 	clickOnButton(element("tv_link"),"tv");
	}

public void ScrollToShopByDepartment() {
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element("shopBydept_txt"));
try {
	Thread.sleep(500);
	 logMessage("User scrolled to shop by department");

} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	 logMessage("User not able to find shop by department");

}
}


}