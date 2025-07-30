package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import utilities.commonHelper.ElementHelper;
import utilities.driverManger.DriverManger;

public class ProductsPage {
    WebDriver driver;

    By productsList = By.cssSelector(".features_items .product-image-wrapper");
    By productNames = By.cssSelector(".productinfo h2");
    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By firstProductDetailsBtn = By.xpath("(//a[contains(text(),'View Product')])[1]");

    By detailsName = By.cssSelector(".product-information h2");
    By detailsCategory = By.cssSelector(".product-information p");
    By detailsPrice = By.cssSelector(".product-information span span");
    By detailsDescription = By.cssSelector("#description p");

    public ProductsPage(){
        this.driver = DriverManger.getDriver();
    }

    public boolean isProductsLoaded(){
        List<WebElement> products = ElementHelper.getElements(driver, productsList);
        return !products.isEmpty();
    }

    public void searchForProduct(String product){
        ElementHelper.sendText(product, driver, searchInput);
        ElementHelper.click(driver, searchButton);
    }

    public boolean isSearchResultRelevant(String product){
        List<WebElement> names = ElementHelper.getElements(driver, productNames);
        if(names.isEmpty()) return false;
        for(WebElement el : names){
            if(!el.getText().toLowerCase().contains(product.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    public void openFirstProductDetails(){
        ElementHelper.click(driver, firstProductDetailsBtn);
    }

    public String getProductName(){
        return ElementHelper.getText(driver, detailsName);
    }

    public String getProductCategory(){
        return ElementHelper.getText(driver, detailsCategory);
    }

    public String getProductPrice(){
        return ElementHelper.getText(driver, detailsPrice);
    }

    public String getProductDescription(){
        return ElementHelper.getText(driver, detailsDescription);
    }
}
