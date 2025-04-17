package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class P07_SearchProducts {
    WebDriver driver;
    WebDriverWait wait;
    public P07_SearchProducts (WebDriver driver){
        this.driver=driver;
    }
    //Locators
 private By searchResultLocator= By.className("features_items");
    //Actions
    public List<String> getSearchResultsText() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultLocator));

        List<WebElement> productElements = driver.findElements(searchResultLocator);
        return productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
