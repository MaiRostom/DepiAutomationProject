package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P17_ContactUsForm {
    private WebDriver driver;

    // Locators
    private final By nameField = By.name("name");
    private final By emailField = By.name("email");
    private final By subjectField = By.name("subject");
    private final By messageField = By.id("message");
    private final By uploadFileButton = By.name("upload_file");
    private final By submitButton = By.cssSelector("input[type='submit']");
    private final By successMessageLocator = By.cssSelector(".alert-success");
    private final By errorMessageLocator = By.cssSelector(".alert-danger");

    // Constructor
    public P17_ContactUsForm(WebDriver driver) {
        this.driver = driver;
    }

    // Methods

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }


    public void fillContactForm(String name, String email, String subject, String message, String filePath) {
        enterName(name);
        enterEmail(email);
        enterSubject(subject);
        enterMessage(message);
        uploadFile(filePath);
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
        try {
            WebElement successMessageElement = driver.findElement(successMessageLocator);
            return successMessageElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}


