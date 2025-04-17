package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class BrandProductsPage {
    WebDriver driver;

    public BrandProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isBrandSidebarVisible() {
        return driver.findElement(By.xpath("//div[@class='brands_products']")).isDisplayed();
    }

    public void clickOnBrandByName(String brandName) {
        WebElement brand = driver.findElement(By.xpath("//div[@class='brands-name']//a[contains(text(),'" + brandName + "')]"));
        brand.click();
    }


    public boolean isBrandHeaderContains(String expectedHeader) {
        WebElement header = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        return header.getText().toUpperCase().contains(expectedHeader.toUpperCase());
    }


    public int getDisplayedBrandProductsCount() {
        List<WebElement> products = driver.findElements(By.cssSelector(".features_items .product-image-wrapper"));
        return products.size();
    }
}

