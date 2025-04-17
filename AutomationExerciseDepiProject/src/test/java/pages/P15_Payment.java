package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class P15_Payment {
    WebDriver driver;
    public P15_Payment(WebDriver driver){
        this.driver=driver;
    }

    // Locators for Payment Page
    private final By nameOnCardField = By.name("name_on_card");  // Corrected ID
    private final By cardNumberField = By.name("card_number"); // Corrected ID
    private final By cvcField = By.name("cvc");
    private final By expiryMonthField = By.name("expiry_month");
    private final By expiryYearField = By.name("expiry_year");
    private final By payAndConfirmButton = By.id("submit");
    private final By successMessageLocator = By.cssSelector(".alert-success"); // Example:  adjust as needed.
    private final By errorMessageLocator = By.cssSelector(".alert-danger");    // Example
    private final By continueButton = By.cssSelector("a.btn.btn-primary");

// Methods for interacting with the payment page

public void enterNameOnCard(String name) {
    driver.findElement(nameOnCardField).sendKeys(name);
}

public void enterCardNumber(String number) {
    driver.findElement(cardNumberField).sendKeys(number);
}

public void enterCVC(String cvc) {
    driver.findElement(cvcField).sendKeys(cvc);
}

public void enterExpiryMonth(String month) {
    driver.findElement(expiryMonthField).sendKeys(month);
}

public void enterExpiryYear(String year) {
    driver.findElement(expiryYearField).sendKeys(year);
}

public void clickPayAndConfirmButton() {
    driver.findElement(payAndConfirmButton).click();
}

public void clickContinueButton(){
    driver.findElement(continueButton).click();}
    // Combined method to fill payment details
    public void fillPaymentDetails(String name, String number, String cvc, String month, String year) {
        enterNameOnCard(name);
        enterCardNumber(number);
        enterCVC(cvc);
        enterExpiryMonth(month);
        enterExpiryYear(year);
    }

    public String getSuccessMessage() {
        try {
            WebElement successMessageElement = driver.findElement(successMessageLocator);
            return successMessageElement.getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }

    public String getErrorMessage() {
        try {
            WebElement errorMessageElement = driver.findElement(errorMessageLocator);
            return errorMessageElement.getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebElement errorMessageElement = driver.findElement(errorMessageLocator);
            return errorMessageElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
            return successMessage.isDisplayed();

        }
    }
