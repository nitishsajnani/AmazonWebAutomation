package in.amazon.webfactory;

import in.amazon.actions.HomePageAction;
import in.amazon.actions.ProductListingPage;
import in.amazon.actions.ProductPage;
import in.amazon.getpageobjects.GetPage;
import in.amazon.utilities.CustomFunctions;

import static in.amazon.utilities.YamlReader.setYamlFilePath;
public class AmazonTestInitiator extends TestSessionInitiator{

	public HomePageAction homePage;
	public ProductListingPage productListingPage;
	public ProductPage productPage;

		private void _initPage() {
			homePage=new HomePageAction(driver);
			productListingPage=new ProductListingPage(driver);
			productPage=new ProductPage(driver);
		}

	public AmazonTestInitiator(String testname) {
		super();
		setProduct();
		setYamlFilePath();
		configureBrowser();
		_initPage();
	}

	public void setProduct(){
		product = "Amazon";
		CustomFunctions.setProduct(product);

		GetPage.setProduct(product);
	}
	
	
}

