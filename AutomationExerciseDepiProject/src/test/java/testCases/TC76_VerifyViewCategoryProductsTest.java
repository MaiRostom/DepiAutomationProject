package testCases;
import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSteps;

public class TC76_VerifyViewCategoryProductsTest extends BaseSteps {


    @Test(priority = 1)
    public void verifyCategorySidebarIsVisible() {
        boolean isVisible = categoryProductsPage.isCategorySidebarVisible();
        Assert.assertTrue(isVisible, "Category sidebar is not visible.");
    }

    @Test(priority = 2)
    public void verifyUserCanViewWomenDressCategoryProducts() {
        categoryProductsPage.clickOnCategoryByName("Women");
        categoryProductsPage.clickOnSubCategoryByName("Dress");

        String expectedHeader = "WOMEN - DRESS PRODUCTS";
        boolean isCorrect = categoryProductsPage.isCategoryHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for Women > Dress is not displayed correctly.");

        int count = categoryProductsPage.getDisplayedCategoryProductsCount();
        Assert.assertTrue(count > 0, "No products found in Women > Dress category.");
    }

    @Test(priority = 2)
    public void verifyUserCanViewMenTshirtsCategoryProducts() {
        categoryProductsPage.clickOnCategoryByName("Men");
        categoryProductsPage.clickOnSubCategoryByName("Tshirts");

        String expectedHeader = "MEN - TSHIRTS PRODUCTS";
        boolean isCorrect = categoryProductsPage.isCategoryHeaderContains(expectedHeader);
        Assert.assertTrue(isCorrect, "Header for Men > Tshirts is not displayed correctly.");

        int count = categoryProductsPage.getDisplayedCategoryProductsCount();
        Assert.assertTrue(count > 0, "No products found in Men > Tshirts category.");
    }
}

