package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P09_BrandProducts {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By brandSidebar = By.cssSelector(".brands_products");
    private final By brandLinks = By.cssSelector(".brands_products .nav.nav-pills.nav-stacked li a");
    private final By brandHeader = By.cssSelector(".features_items h2.title.text-center");
    private final By productsList = By.cssSelector(".features_items .product-image-wrapper");

    public P09_BrandProducts(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBrandSidebarVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(brandSidebar));
        return sidebar.isDisplayed();
    }

    public void clickOnBrandByName(String brandName) {
        // Wait until brand links are visible
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandLinks));
        List<WebElement> brands = driver.findElements(brandLinks);

        for (WebElement brand : brands) {
            if (brand.getText().trim().equalsIgnoreCase(brandName)) {
                wait.until(ExpectedConditions.elementToBeClickable(brand)).click();
                break;
            }
        }
    }



    public boolean isBrandHeaderContains(String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(brandHeader));
        return header.getText().toUpperCase().contains(text.toUpperCase());
    }

    public int getDisplayedBrandProductsCount() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsList));
        return products.size();
    }

}