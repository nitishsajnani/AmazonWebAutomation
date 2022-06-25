package in.amazon.getpageobjects;

import static in.amazon.utilities.ConfigPropertyReader.getProperty;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import in.amazon.utilities.SeleniumWait;

public class BaseUi {

	WebDriver driver, driverToUploadImage;
	protected SeleniumWait wait;


	protected String browser;

	protected BaseUi(WebDriver driver, String pageName) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		int timeout;
		timeout = Integer.parseInt(getProperty("Config.properties", "timeout"));
		this.wait = new SeleniumWait(driver, timeout);
	}
	
	public void logMessage(String message) {
		Reporter.setEscapeHtml(true);
		Reporter.log(message, true);
	}
	
	public void clickOnButton(WebElement element,String text) {
			wait.waitForElementToBeVisible(element);
			element.click();
			logMessage("User click on the button: "+ text);	
		}
	
}