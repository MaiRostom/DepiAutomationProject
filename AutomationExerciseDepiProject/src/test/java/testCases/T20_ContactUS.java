package testCases;

import base.BaseSteps;
import org.testng.annotations.Test;

public class T20_ContactUS extends BaseSteps {
    @Test(priority = 1)
    public void ContactUsSuccess() {
        homePage.clickContactUsLink();
        contactUsPage.enterName("ahmed");
        contactUsPage.enterEmail("ahmed@gmail.com");
        contactUsPage.enterMessage("Hello");
        contactUsPage.enterSubject("Hi");
        contactUsPage.clickSubmitButton();


    }
}
