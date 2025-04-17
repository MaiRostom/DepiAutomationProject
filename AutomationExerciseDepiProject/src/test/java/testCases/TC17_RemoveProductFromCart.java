package testCases;

import base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TC17_RemoveProductFromCart extends BaseSteps {
    @Test()
    public void verifyRemoveProductFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage.clickViewCartButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartPageIdentifier")));
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page is not displayed.");

        cartPage.removeFirstProduct();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cart-item")));
        Assert.assertTrue(cartPage.isCartEmpty(), "Product is not removed from the cart.");
    }
}
