package testCases;

import base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC19_VerifyViewBrandProductsTest extends BaseSteps {
    @Test(priority = 1)
    public void openHomePageAndVerifyBrandSidebarIsVisible() {
        boolean isVisible = brandProductsPage.isBrandSidebarVisible();
        Assert.assertTrue(isVisible, "Brand sidebar is not visible.");
    }

    @Test(priority = 2)
    public void verifyUserCanViewPoloBrandProducts() {
        brandProductsPage.clickOnBrandByName("Polo");

        String expectedHeader = "BRAND - POLO PRODUCTS";
        boolean isCorrect = brandProductsPage.isBrandHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for Polo brand is not displayed correctly.");
    }

    @Test(priority = 2)
    public void verifyUserCanViewHNMBrandProducts() {
        brandProductsPage.clickOnBrandByName("H&M");

        String expectedHeader = "BRAND - H&M PRODUCTS";
        boolean isCorrect = brandProductsPage.isBrandHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for H&M brand is not displayed correctly.");
    }

    @Test(priority = 2)
    public void verifyPoloBrandProductListIsNotEmpty() {
        brandProductsPage.clickOnBrandByName("Polo");

        int count = brandProductsPage.getDisplayedBrandProductsCount();
        Assert.assertTrue(count > 0, "No products found under Polo brand.");
    }

    @Test(priority = 2)
    public void verifyHNMBrandProductListIsNotEmpty() {
        brandProductsPage.clickOnBrandByName("H&M");

        int count = brandProductsPage.getDisplayedBrandProductsCount();
        Assert.assertTrue(count > 0, "No products found under H&M brand.");
    }
}
