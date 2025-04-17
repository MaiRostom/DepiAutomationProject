package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P16_PaymentDone {
    WebDriver driver;
    WebDriverWait wait;
    public P16_PaymentDone(WebDriver driver){
        this.driver=driver;
    }
    private final By confirmationMessageLocator = By.cssSelector("p[style*='font-size: 20px'][style*='font-family: garamond']");

    private By downloadInvoiceButton = By.xpath("//a[text()='Download Invoice']");
    public void clickDownloadInvoice() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(downloadInvoiceButton)).click();
    }
    public String getConfirmationMessageText() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
            return messageElement.getText();

    }
    public boolean isConfirmationMessageDisplayed() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessageLocator));
            return messageElement.isDisplayed();

    }


}
