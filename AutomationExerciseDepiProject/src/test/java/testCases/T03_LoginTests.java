package testCases;

import base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T03_LoginTests extends BaseSteps {
    WebDriver driver;

    @Test(priority = 1)
    public void ValidSignIn() {
        login.testLogin("asaa@gmail.com", "12345");

    }
    @Test(priority = 2)
    public void SignInWithoutMail() {
        login.testLogin("", "12345");

    }

    @Test(priority = 2)
    public void SignupWithoutPassword() {
        login.testLogin("asaa@gmail.com", "");

    }
    @Test(priority = 2)
    public void SignInInvalidData() {
        login.testLogin("asaa@gmail.com", "aawfwf");

    }
}
