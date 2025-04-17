package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P00_HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public P00_HomePage(WebDriver driver){
        this.driver=driver;
    }
//Locators
    private  By productLink=By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a");
    private  By headerLocator = By.xpath("//h1[span[text()='Automation'] and contains(text(), 'Exercise')]");
    private By headingLocator = By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
private  By contactUsLink =By.cssSelector("a[href=\"/contact_us\"]");
    private final By subscriptionSection = By.id("footer");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successAlert = By.cssSelector("div.alert-success"); // "You have been successfully subscribed!"
    private final By logBut = By.xpath("//li[a/@href='/login']/a/i[@class='fa fa-lock']");

     public String url = "http://automationexercise.com";
     public String subscriptionEmail = "testsubscriber" + System.currentTimeMillis() + "@example.com";
     public String expectedSubscriptionText = "SUBSCRIPTION";
     public String expectedSuccessMessage = "You have been successfully subscribed!";


    //Actions
    public void clickOnProductLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Add WebDriverWait
        WebElement productLinkElement = wait.until(ExpectedConditions.elementToBeClickable(productLink)); // Wait until the element is clickable
        productLinkElement.click();  // Perform the click action
    }

    public String getHeaderText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return headerElement.getText();  // Returns "Automation Exercise"
    }
    public String getHeadingText() {
        WebElement headingElement = driver.findElement(headingLocator);  // Locate the element
        return headingElement.getText();  // Return the text content of the heading
    }

    //  (e.g., "AutomationExercise")
    public boolean isHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
            return header.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //(e.g., "Full-Fledged practice website...")
    public boolean isHeadingDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));
            return heading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    // Actions
    public boolean isSubscriptionSectionDisplayed() {
        return driver.findElement(subscriptionSection).isDisplayed();
    }

    public void subscribeWithEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subscribeButton).click();
    }
    public boolean isSubscriptionSuccessAlertDisplayed() {
        return driver.findElement(successAlert).isDisplayed();
    }
    public void clickContactUsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
        contactLink.click();
    }



    public WebElement getFooterElement() {
        return driver.findElement(By.cssSelector("footer"));
    }

    public String getSubscriptionText() {
        return driver.findElement(By.cssSelector("div#newsletter h2")).getText();
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(By.id("susbscribe_email")).sendKeys(email);
    }

    public void clickSubscriptionArrowButton() {
        driver.findElement(By.id("subscribe")).click();
    }

    public String getSubscriptionSuccessMessage() {
        return driver.findElement(By.cssSelector("div.alert-success")).getText();
    }

    public boolean isRecommendedItemsVisible(String expectedText) {
        WebElement recommendedItemsHeading = driver.findElement(By.cssSelector("div#recommended_items h2"));
        return recommendedItemsHeading.isDisplayed() && recommendedItemsHeading.getText().equals(expectedText);
    }
    public void addRecommendedProductToCart() {

        List<WebElement> recommendedProducts = driver.findElements(By.cssSelector("div.recommended-item-wrapper"));
        if (!recommendedProducts.isEmpty()) {
            WebElement firstProduct = recommendedProducts.get(0);
            WebElement addToCartButton = firstProduct.findElement(By.cssSelector("a.add-to-cart"));
            addToCartButton.click();
        }        }

    public void clickLoginButton() {
        // Find the login button using the private locator
        WebElement loginButton = driver.findElement(logBut);

        // Perform the click action
        loginButton.click();
    }
    public void clickViewCartButton() {
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
    }
}


