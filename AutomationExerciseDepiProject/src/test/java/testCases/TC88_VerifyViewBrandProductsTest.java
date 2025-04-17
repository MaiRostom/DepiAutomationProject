package testCases;

import base.BaseSteps;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC88_VerifyViewBrandProductsTest extends BaseSteps {


    @Test(priority = 1)
    public void verifyBrandSidebarIsVisible() {
        boolean isVisible = brandProductsPage.isBrandSidebarVisible();
        Assert.assertTrue(isVisible, "Brand sidebar is not visible.");
    }

    @Test(priority = 2)
    public void verifyPoloBrandHeaderAndProductsDisplayed() {
        brandProductsPage.clickOnBrandByName("Polo");

        String expectedHeader = "BRAND - POLO PRODUCTS";
        boolean isCorrect = brandProductsPage.isBrandHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for Polo brand is not displayed correctly.");

        int count = brandProductsPage.getDisplayedBrandProductsCount();
        Assert.assertTrue(count > 0, "No products found under Polo brand.");
    }

    @Test(priority = 2)
    public void verifyHNMBrandHeaderAndProductsDisplayed() {
        brandProductsPage.clickOnBrandByName("H&M");

        String expectedHeader = "BRAND - H&M PRODUCTS";
        boolean isCorrect = brandProductsPage.isBrandHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for H&M brand is not displayed correctly.");

        int count = brandProductsPage.getDisplayedBrandProductsCount();
        Assert.assertTrue(count > 0, "No products found under H&M brand.");
    }
}

