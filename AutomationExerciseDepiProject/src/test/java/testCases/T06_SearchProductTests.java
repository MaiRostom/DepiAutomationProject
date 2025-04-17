package testCases;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T06_SearchProductTests extends BaseSteps {
    @Test(priority = 1)
    public void verifySearchOnProduct() {
        homePage.clickOnProductLink();
        productsPage.searchProduct("dress");
        productsPage.clickSearchButton();

        List<String> productNames = searchProducts.getSearchResultsText();

        boolean containsDress = productNames.stream()
                .anyMatch(name -> name.toLowerCase().contains("dress"));

        Assert.assertTrue(containsDress, "Search results should contain 'dress'");
    }

}
