import Pages.HomePage;
import Pages.ProductsPage;
import org.testng.annotations.*;
import utilities.commonHelper.AssertionHelper;
import utilities.extentReport.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class BrowseProducts extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;

    @BeforeTest
    public void setup(){
        homePage = new HomePage();
        productsPage = new ProductsPage();
    }

    @Test
    public void browseProducts(){
        homePage.clickOnProducts();
        AssertionHelper.assertTrue(productsPage.isProductsLoaded(), "Products not loaded");

        productsPage.searchForProduct("T-shirt");
        AssertionHelper.assertTrue(productsPage.isSearchResultRelevant("T-shirt"), "Search results are not relevant");

        productsPage.openFirstProductDetails();
        AssertionHelper.assertNotNull(productsPage.getProductName(), "Name null");
        AssertionHelper.assertNotNull(productsPage.getProductCategory(), "Category null");
        AssertionHelper.assertNotNull(productsPage.getProductPrice(), "Price null");
        AssertionHelper.assertNotNull(productsPage.getProductDescription(), "Description null");
    }
}
