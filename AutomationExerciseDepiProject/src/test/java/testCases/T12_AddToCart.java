package testCases;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T12_AddToCart extends BaseSteps {

    @Test(priority = 1)
    public void verifysigninSignup() {
        homePage.clickLoginButton();
        login.testLogin("mai.rostom@dxc.com","123456");
    }

    @Test(priority = 2)
    public void verifyHoverAncAddToCart() {
        homePage.clickOnProductLink();
        productsPage.hoverOnFirstProductAndAddToCart();
        Assert.assertTrue(addedToCartPopUp.isAddToCartPopUpVisible());
    }

    @Test(priority = 3)
    public void verifyHoverOnSecondProductAncAddToCart() {
        addedToCartPopUp.clickContinueShoppingButton();
        productsPage.hoverAndClickOnSecondItem();
        Assert.assertTrue(addedToCartPopUp.isAddToCartPopUpVisible());

    }

    @Test(priority = 4)
    public void verifycartyPOPUPINvisible() {
        addedToCartPopUp.clickViewCartLink();

        Assert.assertTrue(addedToCartPopUp.isAddToCartPopUpINVisible());
    }

    @Test(priority = 5)
    public void verifyThatWeAreInCartPage() {
        String expectedURL = "https://automationexercise.com/view_cart";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "The URl should be view cart");
        Assert.assertTrue(cartPage.isShoppingCartDisplayed());
        Assert.assertTrue(cartPage.isProceedToCheckoutDisplayed());
    }

    @Test(priority = 5)
    public void  VerifybothProductAreAddedToCart (){
        Assert.assertEquals(cartPage.getItemsCount(),2,"The items are not 2");
    }
    @Test(priority  =5)
        public void verifyCorrectItemsInRow1()
    {
      Assert.assertTrue(cartPage.getProductName().contains("Blue Top"));
        Assert.assertTrue(cartPage.getProductPrice().contains("500"));
        Assert.assertEquals(cartPage.getProductQuantity(),"1","The Blue Top Quantity is not correct");
       Assert.assertTrue(cartPage.getProductTotalPrice().contains("500"));

    }
    @Test(priority  =5)
    public void verifyCorrectItemsInRow2()
    {
        Assert.assertTrue(cartPage.getProductName2().contains("Men"));
        Assert.assertTrue(cartPage.getProductPrice2().contains("400"));
        Assert.assertEquals(cartPage.getProductQuantity2(),"1","The MenTshirt Quantity is not correct");
        Assert.assertTrue(cartPage.getProductTotalPrice2().contains("400"));
    }
    @Test(priority  =6)
    public void proceedToCheckOut()
    {
        cartPage.clickProceedToCheckout();

    }
    @Test(priority  =7)
    public void verifyCheckOutData()
    {
        Assert.assertEquals(checkOutPage.getDeliveryFullNameText(),checkOutPage.getBillingFullNameText());
        Assert.assertEquals(checkOutPage.getDeliveryAddress1Text(),checkOutPage.getBillingAddress1Text());
        Assert.assertEquals(checkOutPage.getDeliveryCountryText(),checkOutPage.getBillingCountryText());
        Assert.assertEquals(checkOutPage.getDeliveryCompanyText(),checkOutPage.getBillingCompanyText());
        Assert.assertEquals(checkOutPage.getDeliveryPhoneText(),checkOutPage.getBillingPhoneText());

    }
    @Test(priority  =8)
    public void verifyPayment()
    {
        checkOutPage.clickPlaceOrderButton();
        paymentPage.fillPaymentDetails("Mai Rostom","12345678910254","123","12","2026");
        paymentPage.clickPayAndConfirmButton();
    }
    @Test(priority  =9)
    public void paymentDone()
    {Assert.assertTrue(paymentDone.isConfirmationMessageDisplayed());
       paymentDone.clickDownloadInvoice();
    }




}
