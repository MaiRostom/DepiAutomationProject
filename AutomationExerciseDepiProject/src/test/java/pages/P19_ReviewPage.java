package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P19_ReviewPage {
     WebDriver driver;

    public P19_ReviewPage (WebDriver driver){
        this.driver=driver;
    }
    // Locators
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By reviewTextArea = By.id("review");
    private final By submitReviewButton = By.id("button-review");
    private final By successMessage = By.cssSelector("div.alert-success"); // "Thank you for your review."





    // Actions


    public void enterReviewDetails(String name, String email, String review) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(reviewTextArea).sendKeys(review);
    }

    public void submitReview() {
        driver.findElement(submitReviewButton).click();
    }

    public boolean isReviewSubmittedSuccessfully() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
