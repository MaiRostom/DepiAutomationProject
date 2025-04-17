package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class P02_Login {
    WebDriver driver;

    public P02_Login(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = (By.xpath("//button[text()='Login']"));


    public void testLogin(String email, String password) {
        // Enter valid email
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        // Wait and check if login successful
        WebElement loggedInAs = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        Assert.assertTrue(loggedInAs.isDisplayed(), "Logout");
    }


}
