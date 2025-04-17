package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P08_CategoryProducts {
    private WebDriver driver;

    // Locators
    private final By categorySidebar = By.cssSelector(".left-sidebar");
    private final By categoryList = By.cssSelector(".panel-group.category-products");
    private final By categoryNames = By.cssSelector(".panel-group.category-products .panel-heading a");
    private final By subCategoryLinks = By.cssSelector(".panel-group.category-products .panel-collapse a");
    private final By categoryHeader = By.cssSelector(".features_items h2.title.text-center");
    private final By productsList = By.cssSelector(".features_items .product-image-wrapper");

    public P08_CategoryProducts(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCategorySidebarVisible() {
        return driver.findElement(categorySidebar).isDisplayed();
    }

    public void clickOnCategoryByName(String categoryName) {
        List<WebElement> categories = driver.findElements(categoryNames);
        for (WebElement category : categories) {
            if (category.getText().trim().equalsIgnoreCase(categoryName)) {
                category.click();
                break;
            }
        }
    }

    public void clickOnSubCategoryByName(String subCategoryName) {
        List<WebElement> subCategories = driver.findElements(subCategoryLinks);
        for (WebElement subCategory : subCategories) {
            if (subCategory.getText().trim().equalsIgnoreCase(subCategoryName)) {
                subCategory.click();
                break;
            }
        }
    }

    public boolean isCategoryHeaderContains(String text) {
        return driver.findElement(categoryHeader).getText().toUpperCase().contains(text.toUpperCase());
    }

    public int getDisplayedCategoryProductsCount() {
        return driver.findElements(productsList).size();
    }
}