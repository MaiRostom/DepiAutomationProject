package testCases;

import base.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T07_TestCases extends BaseSteps{


        @Test(priority = 1)
        public void verifyTheURLISTestPage() {
            testCase.clickOnTestLink();
            String expectedUrl = "https://automationexercise.com/test_cases";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "The current URL should be the Testcases page.");
        }
    }


