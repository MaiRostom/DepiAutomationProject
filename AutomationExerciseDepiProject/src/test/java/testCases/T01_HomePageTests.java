package testCases;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T01_HomePageTests extends BaseSteps {
    @Test(priority = 1)
    public void verifyTheURLISProduct() {
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The current URL should be the products page.");
    }
    @Test(priority = 1)
    public void verifyTheHomePage() {
        Assert.assertTrue(homePage.isHeaderDisplayed(), "'Automation Excersice' ");
        Assert.assertTrue(homePage.isHeadingDisplayed(), "'Full-Fledged practice website for Automation Engineers");

    }

}
