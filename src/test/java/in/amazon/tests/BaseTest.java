package in.amazon.tests;

import java.io.IOException;
import static in.amazon.utilities.YamlReader.getYamlValue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import in.amazon.webfactory.AmazonTestInitiator;

@Listeners()
public class BaseTest {
	protected boolean isTestRunCreated = false;
	protected AmazonTestInitiator amazon;
	protected String product;
	protected int counterForTests;
	protected int failCount;
	protected String baseUrl;

	public BaseTest(String baseUrl) {
		this.baseUrl = baseUrl;
		System.out.println("baseURL::" + baseUrl);
	}

	@BeforeClass
	public void beforeMethod() {
		amazon = new AmazonTestInitiator(this.getClass().getSimpleName());
		amazon.launchApplication(getYamlValue(baseUrl));
	}

	@AfterClass(alwaysRun = true)
	public void close_Test_Session() throws IOException {
		//amazon.closeBrowserSession();
	}

}
