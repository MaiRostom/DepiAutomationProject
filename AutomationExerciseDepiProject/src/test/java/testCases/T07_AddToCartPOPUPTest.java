package testCases;


import base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T07_AddToCartPOPUPTest extends BaseSteps {
    WebDriverWait wait;


    @Test(priority = 1)
    public void verifyAddedText() {
        homePage.clickOnProductLink();
        productsPage.clickOnViewProduct();
        productDetails.addToCart();
        String expectedResult = "Added!";
        String actualResult =addedToCartPopUp.getAddedText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 2)
    public void verifyProductAddedText() {
        String expectedResult = "Your product has been added to cart";
        String actualResult =addedToCartPopUp.getProductAddedMessage();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    public void verifyContinueShoppingButtonVisibility() {
        // Check if the "Continue Shopping" button is visible
        boolean isContinueShoppingButtonVisible = addedToCartPopUp.isContinueShoppingButtonVisible();

        // Assert that the button is visible
        Assert.assertTrue(isContinueShoppingButtonVisible, "Continue Shopping button is not visible.");
    }
    @Test(priority = 3)
    public void verifyContinueShoppingButtonNavigation() {
        // Wait and click the Continue Shopping button
        addedToCartPopUp.clickContinueShoppingButton();  // should already include WebDriverWait inside

        //Assert we're still on the same product details page
        String expectedURL = "https://automationexercise.com/product_details/1";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL), "URL mismatch after clicking Continue Shopping");


        //Assert that POP Element is no longer visible
        Assert.assertTrue(addedToCartPopUp.isAddToCartPopUpINVisible(), "'View Cart' PopUp is NOT visible");
    }
    @Test(priority = 4)
    public void verifyViewCartButtonNavigation() {
        productDetails.addToCart();
        addedToCartPopUp.clickViewCartLink();
        String expectedUrl ="https://automationexercise.com/view_cart";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The current URL should be view cart");
            }




}
