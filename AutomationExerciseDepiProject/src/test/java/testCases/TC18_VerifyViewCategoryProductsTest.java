package testCases;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_VerifyViewCategoryProductsTest extends BaseSteps {

    @Test(priority = 1)
    public void openHomePageAndVerifyCategorySidebarIsVisible() {
        driver.get("https://automationexercise.com");
        boolean isVisible = categoryProductsPage.isCategorySidebarVisible();
        Assert.assertTrue(isVisible, "Category sidebar is not visible.");
    }

    @Test(priority = 2)
    public void verifyUserCanViewWomenCategoryProducts() {
        categoryProductsPage.clickOnCategoryByName("Women");
        categoryProductsPage.clickOnSubCategoryByName("Dress");

        String expectedHeader = "WOMEN - DRESS PRODUCTS";
        boolean isCorrect = categoryProductsPage.isCategoryHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for Women > Dress is not displayed correctly.");
    }

    @Test(priority = 2)
    public void verifyUserCanViewMenCategoryProducts() {
        categoryProductsPage.clickOnCategoryByName("Men");
        categoryProductsPage.clickOnSubCategoryByName("Tshirts");

        String expectedHeader = "MEN - TSHIRTS PRODUCTS";
        boolean isCorrect = categoryProductsPage.isCategoryHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for Men > Tshirts is not displayed correctly.");
    }

    @Test(priority = 2)
    public void verifyWomenCategoryProductListIsNotEmpty() {
        categoryProductsPage.clickOnCategoryByName("Women");
        categoryProductsPage.clickOnSubCategoryByName("Dress");

        int count = categoryProductsPage.getDisplayedCategoryProductsCount();
        Assert.assertTrue(count > 0, "No products found in Women > Dress category.");
    }

    @Test(priority = 2)
    public void verifyMenCategoryProductListIsNotEmpty() {
        categoryProductsPage.clickOnCategoryByName("Men");
        categoryProductsPage.clickOnSubCategoryByName("Tshirts");

        int count = categoryProductsPage.getDisplayedCategoryProductsCount();
        Assert.assertTrue(count > 0, "No products found in Men > Tshirts category.");
    }
}