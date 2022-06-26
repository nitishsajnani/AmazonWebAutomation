
package  in.amazon.webfactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	private static String browser;
	static Process p = null;

	private static final DesiredCapabilities capabilities = new DesiredCapabilities();

	public WebDriver getDriver(Map<String, String> seleniumconfig) {
		browser = System.getProperty("browser");
		if (seleniumconfig.get("server").equalsIgnoreCase("local")) {
		if (browser == null || browser.isEmpty()) {
			browser = seleniumconfig.get("browser");
		}
		System.out.println("Browser=" + browser);
		Reporter.log(browser, true);
			if (browser.equalsIgnoreCase("firefox")) {
				return getFirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				return getChromeDriver();
			}
		return new FirefoxDriver();}
	if (seleniumconfig.get("server").equalsIgnoreCase("remote")) {
		if (browser == null || browser.isEmpty()) {
			browser = seleniumconfig.get("browser");
		}
		System.out.println("Browser=" + browser);
		Reporter.log(browser, true);
			if (browser.equalsIgnoreCase("chrome")||browser.equalsIgnoreCase("firefox")) {
				return remoteDriver(browser,seleniumconfig.get("remoteURL"));
			}}
	 return remoteDriver(browser,seleniumconfig.get("remoteURL"));
		}
	
	

	private static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);

		chromePrefs.put("plugins.plugins_disabled",
				new String[] { "Adobe Flash Player", "Chrome PDF Viewer", "plugins.always_open_pdf_externally" });
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory",
				System.getProperty("user.dir") );
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--disable-extensions");
		options.addArguments("test-type");
		options.addArguments("--disable-impl-side-painting");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		ChromeDriver driver = new ChromeDriver(cap);
		driver.manage().deleteAllCookies();
		return driver;
	}

	private static WebDriver getFirefoxDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		WebDriverManager.firefoxdriver().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		profile.setPreference("browser.cache.disk.enable", false);
		profile.setPreference("browser.download.dir",
				System.getProperty("user.dir"));
		return new FirefoxDriver();
	}
	
	private static WebDriver remoteDriver(String browser, String remoteURL) {
		DesiredCapabilities capForChrome = DesiredCapabilities.chrome();
		DesiredCapabilities capForFirefox= DesiredCapabilities.firefox();
	
	    if(browser.equalsIgnoreCase("chrome"))
			try {
				return new RemoteWebDriver(new URL(remoteURL),capForChrome);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				return new RemoteWebDriver(new URL(remoteURL),capForFirefox);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 return null;
	}
		
	}
