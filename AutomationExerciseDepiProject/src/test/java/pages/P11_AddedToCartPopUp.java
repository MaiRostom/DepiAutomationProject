package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P11_AddedToCartPopUp {
    WebDriver driver;
    WebDriverWait wait;
    public P11_AddedToCartPopUp(WebDriver driver){
        this.driver=driver;
    }
    //Locators
    private By addedMessageLocator = By.xpath("//h4[@class='modal-title w-100']");
    private By productaddedTextLocator = By.cssSelector("div.modal-body p.text-center:first-of-type");
    private By viewCartLinkLocator = By.cssSelector(".modal-body a[href='/view_cart']");
    private By continueShoppingButtonLocator = By.cssSelector("div.modal-footer button.close-modal");
    private By addToCartPopUpLocator =By.cssSelector("div[class=\"modal-content\"]");



    //Actions
    public String getProductAddedMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productAddedTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productaddedTextLocator));
        return productAddedTextElement.getText();
    }



    public String getAddedText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addedTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addedMessageLocator));
        return addedTextElement.getText(); // Should return "Added!"
    }


    public boolean isContinueShoppingButtonVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueShoppingButtonElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(continueShoppingButtonLocator)
        );
        return continueShoppingButtonElement.isDisplayed();
    }

    public boolean isViewCartButtonVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCartButtonElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(viewCartLinkLocator)
        );
        return viewCartButtonElement.isDisplayed();
    }

    public boolean isAddToCartPopUpVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartPopUpElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(addToCartPopUpLocator)
        );
        return addToCartPopUpElement.isDisplayed();
    }
    public boolean isAddToCartPopUpINVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // This returns true if the element becomes invisible or is not present
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(addToCartPopUpLocator));
    }



    public void clickContinueShoppingButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButtonLocator));
        button.click();
    }
    public void clickViewCartLink() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCartLink = wait.until(ExpectedConditions.elementToBeClickable(viewCartLinkLocator));
        viewCartLink.click();
    }




    }



