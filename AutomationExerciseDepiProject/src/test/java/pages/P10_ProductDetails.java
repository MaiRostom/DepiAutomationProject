package pages;

import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class P10_ProductDetails {
    WebDriver driver;
    WebDriverWait wait;
    public P10_ProductDetails(WebDriver driver){
        this.driver=driver;
    }
    //Locators
    private By productNameLocator = By.xpath("//h2[text()='Blue Top']");
    private By categoryNameLocator = By.xpath("//p[text()='Category: Women > Tops']");
    private By priceLocator = By.xpath("//span[text()='Rs. 500']");
    private By availabilityLocator = By.xpath("//p[b[text()='Availability:']]");
    private By conditionLocator = By.xpath("//p[b[text()='Condition:']]");
    private By brandLocator = By.xpath("//p[b[text()='Brand:']]");
    private By addToCartButton=By.cssSelector("button[type=\"button\"]");
    private  By quantityLocator=By.id("quantity");
    private By imageLocator=By.cssSelector("img[src=\"/get_product_picture/1\"]");

    //Actions
    // Get Product Name
    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocator));
        return productNameElement.getText();
    }

    // Get Category Text
    public String getCategoryText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryNameLocator));
        String fullText = categoryElement.getText();
        String decodedText = StringEscapeUtils.unescapeHtml4(fullText);
        return decodedText.replace("Category: ", "").trim();
    }

    // Get Price
    public String getPriceText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(priceLocator));
        return priceElement.getText();
    }

    // Get Availability
    public String getAvailabilityStatus() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement availabilityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityLocator));
        String fullText = availabilityElement.getText();
        return fullText.split("Availability:")[1].trim();
    }

    // Get Condition
    public String getConditionStatus() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement conditionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionLocator));
        String fullText = conditionElement.getText();
        return fullText.split("Condition:")[1].trim();
    }

    // Get Brand
    public String getBrandText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brandElement = wait.until(ExpectedConditions.visibilityOfElementLocated(brandLocator));
        String fullText = brandElement.getText();
        return fullText.split("Brand:")[1].trim();
    }

    // Get Quantity
    public String getQuantity() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityLocator));
        return quantityElement.getAttribute("value");
    }

    // Add to Cart
    public void addToCart() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartBtn.click();
    }

    // Get Product Image
    public WebElement getViewImage() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
    }

}
