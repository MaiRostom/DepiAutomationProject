package testCases;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T05_ProductDetailsTests extends BaseSteps {

    @Test(priority = 1)
    public void verifyProductName() {
        productsPage.clickOnViewProduct();
        String expectedResult = "Blue Top";
        String actualResult =productDetails.getProductName();
        Assert.assertEquals(actualResult, expectedResult, "The product name is Blue Top");
    }
    @Test(priority = 2)
    public void verifyCategoryName() {
        String expectedResult = "Women > Tops";
        String actualResult =productDetails.getCategoryText();
        Assert.assertEquals(actualResult, expectedResult, "The Cateogry name is Women > Tops");
    }
    @Test(priority = 2)
    public void verifyImageIsDisplayed() {
        Assert.assertTrue(productDetails.getViewImage().isDisplayed(), "Image' is visible.");


    }
    @Test(priority = 2)
    public void verifyPrice() {
        String expectedResult = "500";
        String actualResult =productDetails.getPriceText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test(priority = 2)
    public void verifyAvailability() {
        String expectedResult = "In Stock";
        String actualResult =productDetails.getAvailabilityStatus();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    public void verifyCondition() {
        String expectedResult = "New";
        String actualResult =productDetails.getConditionStatus();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    public void verifyBrand() {
        String expectedResult = "Polo";
        String actualResult =productDetails.getBrandText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    public void verifyQuantity() {
        String expectedResult = "1";
        String actualResult =productDetails.getQuantity();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    public void verifyAddToCart() {
        productDetails.addToCart();
        String expectedAdded="Added!";
        String actualAddedText=addedToCartPopUp.getAddedText();
        Assert.assertTrue(actualAddedText.contains(expectedAdded));

        String expectedProductAdded="Your product has been added to cart.";
        String actualProductAddedText=addedToCartPopUp.getProductAddedMessage();
        Assert.assertTrue(actualProductAddedText.contains(expectedProductAdded));

        Assert.assertTrue(addedToCartPopUp.isAddToCartPopUpVisible(), "'View Cart' button is visible.");
        Assert.assertTrue(addedToCartPopUp.isViewCartButtonVisible(), "'View Cart' button is visible.");
        Assert.assertTrue(addedToCartPopUp.isContinueShoppingButtonVisible(), "Continue Shopping' button is visible");

    }


}
