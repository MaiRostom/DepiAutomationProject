package testCases;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21_AddReviewOnProduct extends BaseSteps {
    @Test(priority = 1)
    public void verifyUserCanSubmitReviewForProduct() {

        homePage.clickOnProductLink();
        productsPage.clickOnViewProduct();
       reviewPage.enterReviewDetails("Test User","testuser@example.com","This is a test review from automation script.");
        // Click Submit
        reviewPage.submitReview();

        // Message
        boolean isMessageDisplayed = reviewPage.isReviewSubmittedSuccessfully();
        Assert.assertTrue(isMessageDisplayed, "Review success message not displayed.");
    }

}
