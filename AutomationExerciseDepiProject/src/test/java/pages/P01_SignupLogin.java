package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_SignupLogin {
    WebDriver driver;
     WebDriverWait wait;

    public P01_SignupLogin (WebDriver driver){
        this.driver=driver;
    }
    private final By logBut = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By nameField = By.name("name");
    private final By emailField = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa='signup-button']");
    public void SignupForm(String name, String email) {
        driver.findElement(logBut).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);

    }

    public void clickSignupButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        button.click();
    }
}
