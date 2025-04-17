package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P12_Cart {
    WebDriver driver;
    WebDriverWait wait;
    public P12_Cart(WebDriver driver){
        this.driver=driver;
    }

    // Locators
    //private final By cartPageHeader = By.cssSelector("li[class='active']");
    private final By cartItemsTable = By.cssSelector("table#cart_items");
    private By dataRows = By.cssSelector("table#cart_info_table tbody tr");

    private final By removeProductButtons = By.cssSelector("table#cart_items tr td.cart_delete a");
    private final By emptyCartMessage = By.cssSelector("table#cart_items tr td p[class='text-center']");
    private final By continueShoppingButton = By.cssSelector("button.btn.btn-default.check_out");
    private By proceedToCheckoutBtn = By.cssSelector("a.btn.btn-default.check_out");
    private By proceedToCheckoutButton = By.cssSelector("a.btn.btn-default.check_out");

    //Locators of first row
    private By productRow1 = By.id("product-1");
    // Locators for columns inside the product row
    private By descriptionLocator1 = By.className("cart_description");
    private By priceLocator1 = By.className("cart_price");
    private By quantityLocator1 = By.className("cart_quantity");
    private By totalPriceLocator1 = By.className("cart_total");
    // Locators for the product row and individual elements for product-2
    private By productRow2 = By.id("product-2");
    private By descriptionLocator2 = By.className("cart_description");
    private By priceLocator2 = By.className("cart_price");
    private By quantityLocator2 = By.className("cart_quantity");
    private By totalLocator2 = By.className("cart_total");
    private By deleteButtonLocator2 = By.className("cart_delete");

    private By shoppingCartTab = By.cssSelector("li.active");

    // Actions


    public boolean isShoppingCartDisplayed() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement shoppingCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartTab));
        return shoppingCartElement.isDisplayed() && shoppingCartElement.getText().contains("Cart");
    }

    // Action Method to Get Cart Items
    public List<WebElement> getCartItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dataRows));
    }

    // Action Method to Get Count of Cart Items
    public int getItemsCount() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dataRows));
        return rows.size();
    }

    // Action Method to Remove Product by Index
    public void removeProduct(int index) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> removeButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeProductButtons));

        int zeroBasedIndex = index - 1;
        if (zeroBasedIndex >= 0 && zeroBasedIndex < removeButtons.size()) {
            removeButtons.get(zeroBasedIndex).click();
        } else {
            throw new org.openqa.selenium.NoSuchElementException("Invalid product index: " + index);
        }
    }

    // Action Method to Remove the First Product
    public void removeFirstProduct() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> removeButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeProductButtons));

        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click();
        } else {
            throw new org.openqa.selenium.NoSuchElementException("No products in the cart to remove");
        }
    }

    // Action Method to Check if Cart is Empty
    public boolean isCartEmpty() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement emptyCartMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
            return emptyCartMessageElement.isDisplayed() && emptyCartMessageElement.getText().contains("Your cart is empty!");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; // Cart is not empty if the message is not found
        }
    }

    // Action Method to Click Continue Shopping Button
    public void clickContinueShoppingButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        button.click();
    }

//Actions of first row

    public String getProductName() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow1));

        WebElement descriptionElement = productRowElement.findElement(descriptionLocator1);

        String productName = descriptionElement.findElement(By.tagName("h4")).getText();

        return productName;
    }

    // Action Method to get Product Price
    public String getProductPrice() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow1));
        WebElement priceElement = productRowElement.findElement(priceLocator1);
        return priceElement.findElement(By.tagName("p")).getText();
    }

    // Action Method to get Product Quantity
    public String getProductQuantity() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow1));
        WebElement quantityElement = productRowElement.findElement(quantityLocator1);
        return quantityElement.findElement(By.tagName("button")).getText();
    }

    // Action Method to get Total Price of Product
    public String getProductTotalPrice() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow1));
        WebElement totalPriceElement = productRowElement.findElement(totalPriceLocator1);
        return totalPriceElement.findElement(By.className("cart_total_price")).getText();
    }

//Actions of Row2
    public String getProductName2() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow2));
        WebElement descriptionElement = productRowElement.findElement(descriptionLocator2);
        String productName = descriptionElement.findElement(By.tagName("h4")).getText();
        return productName;
    }



    // Method to get the product price from product-2
    public String getProductPrice2() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow2));
        WebElement priceElement = productRowElement.findElement(priceLocator2);
        return priceElement.findElement(By.tagName("p")).getText();
    }

    // Method to get the product quantity from product-2
    public String getProductQuantity2() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow2));
        WebElement quantityElement = productRowElement.findElement(quantityLocator2);
        return quantityElement.findElement(By.tagName("button")).getText();
    }

    // Method to get the product total price from product-2
    public String getProductTotalPrice2() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow2));
        WebElement totalElement = productRowElement.findElement(totalLocator2);
        return totalElement.findElement(By.className("cart_total_price")).getText();
    }

    // Method to delete the product from the cart (product-2)
    public void deleteProduct2() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement productRowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productRow2));
        WebElement deleteButton = productRowElement.findElement(deleteButtonLocator2).findElement(By.tagName("a"));
        deleteButton.click();
    }

    // Action Method to Check if Proceed to Checkout Button is Displayed
    public boolean isProceedToCheckoutDisplayed() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn));
        return element.isDisplayed();
    }
    public boolean isCartPageDisplayed() {
        return driver.findElement(By.cssSelector("#cart_items")).isDisplayed();
    }

    public boolean isProductDisplayedInCart() {
        List<WebElement> cartItems = driver.findElements(By.cssSelector("#cart_items tbody tr"));
        return cartItems.size() > 0;
    }
    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        checkoutButton.click();
    }


}



