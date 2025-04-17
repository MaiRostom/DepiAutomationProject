package testCases;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P00_HomePage;
import pages.P06_Products;

import java.time.Duration;
import java.util.List;

public class T04_ProductTests extends BaseSteps {


@Test(priority = 1)
public void verifyTheURLISProduct() {
    homePage.clickOnProductLink();
    String expectedUrl = "https://automationexercise.com/products";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl, "The current URL should be the products page.");
}
    @Test(priority =2)
    public void verifyThatAllProductsTextAppear(){
        String actualResult=productsPage.allProductTextAppear();
    String expectedResult="ALL PRODUCTS";
    Assert.assertTrue(actualResult.contains(expectedResult));
}

    @Test(priority =2)
    public void verifyProductListIsVisible() {
        productsPage.scrollToFirstChildOfProductInfo();
        Assert.assertTrue(productsPage.isProductListVisible(), "Product list is not visible on the page.");
    }
//
//Verify that the 2 buttons are visible
  @Test(priority = 2)
  public void verifyViewProductButtonIsVisible() {
    Assert.assertTrue(productsPage.isViewProductButtonVisible(), "'View Product' button is not visible");
 }

    @Test(priority = 2)
    public void verifyAddToCartButtonIsVisible() {
        Assert.assertTrue(productsPage.isAddToCartButtonVisible(), "'Add to Cart' button is not visible");
    }
    @Test(priority = 3)
    public void verifyClickOnAddToCart(){
        productsPage.clickAddToCartButton();
        Assert.assertTrue(addedToCartPopUp.isAddToCartPopUpVisible(), "'View Cart' popup is not  visible");
        Assert.assertTrue(addedToCartPopUp.isViewCartButtonVisible(), "'View Cart' button is not   visible");
        Assert.assertTrue(addedToCartPopUp.isContinueShoppingButtonVisible(), "'Continue Shopping' button is not visible");
        addedToCartPopUp.clickContinueShoppingButton();
    }
    @Test(priority = 4)
    public void verifyClickOnViewProduct(){
        productsPage.clickOnViewProduct();
        String expectedUrl ="https://automationexercise.com/product_details/1";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The current URL should be the products Details Page.");
    }



}
