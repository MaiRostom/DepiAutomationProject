package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class CategoryPrductPage {


        WebDriver driver;

        public CategoryPrductPage(WebDriver driver) {
            this.driver = driver;
        }


        public boolean isCategorySidebarVisible() {
            return driver.findElement(By.xpath("//div[@class='left-sidebar']")).isDisplayed();
        }


        public void clickOnCategoryByName(String categoryName) {
            WebElement category = driver.findElement(By.xpath("//div[@class='panel-group category-products']//a[contains(text(),'" + categoryName + "')]"));
            category.click();
        }


        public void clickOnSubCategoryByName(String subCategoryName) {
            WebElement subCategory = driver.findElement(By.xpath("//div[@class='panel-group category-products']//a[contains(text(),'" + subCategoryName + "')]"));
            subCategory.click();
        }


        public boolean isCategoryHeaderContains(String expectedHeader) {
            WebElement header = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            return header.getText().toUpperCase().contains(expectedHeader.toUpperCase());
        }


        public int getDisplayedCategoryProductsCount() {
            List<WebElement> products = driver.findElements(By.cssSelector(".features_items .product-image-wrapper"));
            return products.size();
        }
    }

