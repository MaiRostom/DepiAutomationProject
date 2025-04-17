package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TC22_AddToCartFromRecommendedItemsTests extends BaseSteps {

    // Test Data
    private final String url = "http://automationexercise.com";
    private final String recommendedItemsText = "RECOMMENDED ITEMS";

    @Test
    public void testAddToCartFromRecommendedItems() {



        Actions actions = new Actions(driver);
        actions.scrollToElement(homePage.getFooterElement()).perform();


        //assertTrue(homePage.isRecommendedItemsVisible(recommendedItemsText), "Recommended items are not visible");


        homePage.addRecommendedProductToCart();


        homePage.clickViewCartButton();


        assertTrue(cartPage.isCartPageDisplayed(), "Cart page is not displayed");
        assertTrue(cartPage.isProductDisplayedInCart(), "Product is not displayed in cart");
    }





        }



