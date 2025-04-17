package testCases;

import base.BaseSteps;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_VerifySubscribtionHomePage extends BaseSteps {
    @Test(priority=1)

    public void testVerifySubscriptionInHomePage() {


        Actions actions = new Actions(driver);
        actions.scrollToElement(homePage.getFooterElement()).perform();


//String subscriptionText = homePage.getSubscriptionText();
       // Assert.assertEquals(subscriptionText, homePage.expectedSubscriptionText, "Subscription text is incorrect");


        homePage.enterSubscriptionEmail(homePage.subscriptionEmail);
        homePage.clickSubscriptionArrowButton();


        String successMessage = homePage.getSubscriptionSuccessMessage();
        Assert.assertEquals(successMessage, homePage.expectedSuccessMessage, "Success message is incorrect");
    }

}
