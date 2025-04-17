package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P13_CheckOut {
    WebDriver driver;
    public P13_CheckOut(WebDriver driver){
        this.driver=driver;
    }


    private final By placeOrderButton = By.xpath("//a[text()='Place Order']");

    // Locators - Delivery Address Summary Section
    private final By deliveryFullName = By.cssSelector("#address_delivery .address_firstname.address_lastname");
    private final By deliveryCompany = By.xpath("(//ul[@id='address_delivery']//li[contains(@class,'address_address1')])[1]");
    private final By deliveryAddress1 = By.xpath("(//ul[@id='address_delivery']//li[contains(@class,'address_address1')])[2]");
    private final By deliveryAddress2 = By.xpath("(//ul[@id='address_delivery']//li[contains(@class,'address_address1')])[3]");
    private final By deliveryCityStateZip = By.cssSelector("#address_delivery .address_city.address_state_name.address_postcode");
    private final By deliveryCountry = By.cssSelector("#address_delivery .address_country_name");
    private final By deliveryPhone = By.cssSelector("#address_delivery .address_phone");


//

    // Locators - Billing Address Section
    private final By billingFullName = By.cssSelector("#address_invoice .address_firstname.address_lastname");
    private final By billingCompany = By.xpath("(//ul[@id='address_invoice']//li[contains(@class,'address_address1')])[1]");
    private final By billingAddress1 = By.xpath("(//ul[@id='address_invoice']//li[contains(@class,'address_address1')])[2]");
    private final By billingAddress2 = By.xpath("(//ul[@id='address_invoice']//li[contains(@class,'address_address1')])[3]");
    private final By billingCityStateZip = By.cssSelector("#address_invoice .address_city.address_state_name.address_postcode");
    private final By billingCountry = By.cssSelector("#address_invoice .address_country_name");
    private final By billingPhone = By.cssSelector("#address_invoice .address_phone");

    //

    public String getBillingFullNameText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingFullName)).getText();
    }

    public String getBillingCompanyText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingCompany)).getText();
    }

    public String getBillingAddress1Text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress1)).getText();
    }

    public String getBillingAddress2Text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress2)).getText();
    }

    public String getBillingCityStateZipText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityStateZip)).getText();
    }

    public String getBillingCountryText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingCountry)).getText();
    }

    public String getBillingPhoneText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingPhone)).getText();
    }

    public String getDeliveryFullNameText() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryFullName)).getText();
}

    public String getDeliveryCompanyText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryCompany)).getText();
    }

    public String getDeliveryAddress1Text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddress1)).getText();
    }

    public String getDeliveryAddress2Text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddress2)).getText();
    }

    public String getDeliveryCityStateZipText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryCityStateZip)).getText();
    }

    public String getDeliveryCountryText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryCountry)).getText();
    }

    public String getDeliveryPhoneText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryPhone)).getText();
    }



    public void clickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        button.click();
    }}