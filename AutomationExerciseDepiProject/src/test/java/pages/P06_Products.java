package pages;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P06_Products {
    WebDriverWait wait;
    WebDriver driver;

    public P06_Products (WebDriver driver){
        this.driver=driver;
    }


    //Locators
    private By allProductsTitleLocator = By.cssSelector("h2.title.text-center");
    private By productListLocator= By.className("features_items");
    private  By viewProductButtonLocator=By.cssSelector("a[href='/product_details/1']");
    private By addToCartButtonLocator = By.cssSelector("a.btn.add-to-cart[data-product-id='1']");
    private By addToCartButton2Locator = By.cssSelector("a.btn.add-to-cart[data-product-id='2']");

    private By searchProductLocator =By.id("search_product");
private  By searchButtonLocator=By.id("submit_search");
    private By productLocator = By.cssSelector(".features_items .single-products");
//




    // Locators for each product's col-sm-4 and overlay content
    //private By firstProduct = By.xpath(".//div[@class='features_items']//div[@class='col-sm-4'][1]");
    //private By secondProduct = By.xpath(".//div[@class='features_items']//div[@class='col-sm-4'][2]");
   //private By overlayContentLocator = By.className("overlay-content");

    // ==== Locators ====
    private By allProducts = By.cssSelector(".feature_items .col-sm-4");

    private By productName = By.cssSelector(".productinfo p");
    private By productPrice = By.cssSelector(".productinfo h2");
    private By addToCartButton = By.cssSelector(".productinfo .add-to-cart");


    //Actions
    // Helper method to return all product elements
    private List<WebElement> getAllProducts() {
        return driver.findElements(allProducts);
    }
//==== Methods for Product 1 ====
public String getProductName1() {
    WebElement product = getAllProducts().get(0);
    WebElement nameElement = wait.until(ExpectedConditions.visibilityOf(
            product.findElement(productName)
    ));
    return nameElement.getText();
}

    public String getProductPrice1() {
        WebElement product = getAllProducts().get(0);
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOf(
                product.findElement(productPrice)
        ));
        return priceElement.getText();
    }

    public void clickAddToCart1() {
        WebElement product = getAllProducts().get(0);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                product.findElement(addToCartButton)
        ));
        button.click();
    }

    // ==== Methods for Product 2 ====
    public String getProductName2() {
        WebElement product = getAllProducts().get(1);
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOf(
                product.findElement(productName)
        ));
        return nameElement.getText();
    }

    public String getProductPrice2() {
        WebElement product = getAllProducts().get(1);
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOf(
                product.findElement(productPrice)
        ));
        return priceElement.getText();
    }

    public void clickAddToCart2() {
        WebElement product = getAllProducts().get(1);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                product.findElement(addToCartButton)
        ));
        button.click();
    }

    // Method to get the name of the first product
//    public String getFirstProductName() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement firstProductOverlay = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
//        String name = firstProductOverlay.findElement(By.tagName("p")).getText();
//        return  name;
//    }
//    public String getFirstProductPrice() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement firstProductOverlay = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
//        String price = firstProductOverlay.findElement(By.tagName("h2")).getText();
//        return price;
//    }
//    public String getSecondProductName() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement secondProductOverlay = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProduct));
//        String name = secondProductOverlay.findElement(By.tagName("p")).getText();
//        return  name;
//    }
//    public String getSecondProductPrice() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement secondProductOverlay = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProduct));
//        String price = secondProductOverlay.findElement(By.tagName("h2")).getText();
//        return  price;
//    }

    public String allProductTextAppear() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsTitleLocator));
        return element.getText();
    }






    public boolean isAddToCartButtonVisible() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewCartButtonElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator)
        );
        return viewCartButtonElement.isDisplayed();
    }

    public boolean isViewProductButtonVisible() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartPopUpElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(viewProductButtonLocator)
        );
        return addToCartPopUpElement.isDisplayed();
    }
    public boolean isProductListVisible() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productList = wait.until(ExpectedConditions.visibilityOfElementLocated(productListLocator));
        return productList.isDisplayed();
    }

    public void clickOnViewProduct() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewProductButton = wait.until(ExpectedConditions.elementToBeClickable(viewProductButtonLocator));
        viewProductButton.click();

    }
    public void clickAddToCartButton() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        addToCartButton.click();
    }
    public void searchProduct(String item) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchProductLocator));
        searchInput.clear();
        searchInput.sendKeys(item);
    }
    public void clickSearchButton() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
    }

    // Scroll to the first product in the list
    public void scrollToFirstChildOfProductInfo() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productInfoDiv = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.productinfo.text-center"))
        );
        WebElement firstChild = productInfoDiv.findElement(By.xpath("./*"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstChild
        );
    }
        public void hoverOnFirstProductAndAddToCart() {
             wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement productList = driver.findElement(productListLocator);
            WebElement firstProduct = productList.findElements(productLocator).get(0);

            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).perform();

            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    firstProduct.findElement(addToCartButtonLocator)
            ));

            addToCartBtn.click();
        }


    public void hoverAndClickOnSecondItem() {
        List<WebElement> products = driver.findElements(productLocator);
        WebElement secondProduct = products.get(1);
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProduct).perform(); // Hover over the second product
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                secondProduct.findElement(addToCartButton2Locator)
        ));

        // Click the "Add to cart" button
        addToCartBtn.click();
    }


}





