package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T02_RegisterTests extends BaseSteps {
    private final By successMessageLocator = By.xpath("//b[contains(text(),'Account Created!')]");

    WebDriver driver;



    @Test(priority = 1)
    public void SignupWithoutName() {
        signupLogin.SignupForm("", "ahmed@gmail.com");

    }

    @Test(priority = 1)
    public void SignupWithoutEmail() {
        signupLogin.SignupForm("ahmed", "ahmeeeeed4@gmail.com");

    }
    @Test(priority = 2)
    public void ValidSignup() {
        signupLogin.SignupForm("ahmed", "ahmed@gmail.com");

    }

    @Test(priority = 2)
    public void ConfirmSignup() {
        signupLogin.SignupForm("ahmed", "ahmeeeeed4@gmail.com");
        register.fillSignupForm(
                "12345",
                "10",
                "2",
                "1999",
                "Mustafa",
                "Magdi",
                "test",
                "test1",
                "egypt",
                "cairo",
                "helwan",
                "12345",
                "01151588182");
        String actualResult= register.chkDelete();
        String expectedResult="ACCOUNT DELETED!";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority = 3)

    public void SignupExistEmail() {
        signupLogin.SignupForm("ahmed", "ahmed@gmail.com");

        String actualResult= register.alreadyExist();
        String expectedResult="Email Address already exist!";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(priority = 3)
    public void SignupWithoutLastname() {
        signupLogin.SignupForm("ahmed", "ahmed@gmail.com");
        register.fillSignupForm(
                "12345",
                "10",
                "2",
                "1999",
                "Mustafa",
                "",
                "test",
                "test1",
                "egypt",
                "cairo",
                "helwan",
                "12345",
                "01151588182");

    }

    @Test(priority = 3)
    public void SignupWithoutPassword() {
        signupLogin.SignupForm("ahmed", "ahmed@gmail.com");
        register.fillSignupForm(
                "",
                "10",
                "2",
                "1999",
                "Mustafa",
                "Magdi",
                "Test",
                "test1",
                "egypt",
                "cairo",
                "helwan",
                "12345",
                "01151588182");

    }

    @Test(priority = 3)
    public void SignupWithoutNumber() {
        signupLogin.SignupForm("ahmed", "ahmed@gmail.com");
        register.fillSignupForm(
                "12345",
                "10",
                "2",
                "1999",
                "Mustafa",
                "Magdi",
                "test",
                "test1",
                "egypt",
                "cairo",
                "helwan",
                "12345",
                "");

    }

}








