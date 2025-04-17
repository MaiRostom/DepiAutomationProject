package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P18_TestcasesPage {
    WebDriver driver;

    public P18_TestcasesPage (WebDriver driver){
        this.driver=driver;
    }
    private By TestcaseBut=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

    public void clickOnTestLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Add WebDriverWait
        WebElement TestLinkElement = wait.until(ExpectedConditions.elementToBeClickable(TestcaseBut)); // Wait until the element is clickable
        TestLinkElement.click();  // Perform the click action
    }

}
