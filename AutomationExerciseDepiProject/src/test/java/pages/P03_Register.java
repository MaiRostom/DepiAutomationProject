package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_Register {
    WebDriverWait wait;
    WebDriver driver;
    private final By alreadyExist = By.xpath(" //*[@id=\"form\"]/div/div/div[3]/div/form/p");

    public P03_Register(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By deleteBut = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private final By confirmDelete = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private final By CountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private final By Title = By.id("id_gender1");
    private final By Password = By.id("password");
    private final By Days = By.id("days");
    private final By Months = By.id("months");
    private final By Years = By.id("years");
    private final By YearNewsletter = By.id("newsletter");
    private final By Offers = By.id("optin");
    private final By FirstName = By.id("first_name");
    private final By LastName = By.id("last_name");
    private final By Company = By.id("company");
    private final By Address = By.id("address1");
    private final By Country = By.id("country");
    private final By State = By.id("state");
    private final By City = By.id("city");
    private final By Zipcode = By.id("zipcode");
    private final By MobileNumber = By.id("mobile_number");
    private final By CreateAccount_But = By.xpath("//button[@data-qa='create-account']");

    //Actions
    public void fillSignupForm(String password, String days, String months, String years, String First, String Last,String company, String address, String country, String state, String city, String zipcode, String Number) {

        driver.findElement(Title).click();
        driver.findElement(Password).sendKeys(password);
        driver.findElement(Days).sendKeys(days);
        driver.findElement(Months).sendKeys(months);
        driver.findElement(Years).sendKeys(years);
        driver.findElement(YearNewsletter).click(); // Newsletter checkbox
        driver.findElement(Offers).click(); // Special offers
        driver.findElement(FirstName).sendKeys(First);
        driver.findElement(LastName).sendKeys(Last);
        driver.findElement(Company).sendKeys(company);
        driver.findElement(Address).sendKeys(address);
        driver.findElement(Country).sendKeys(country);
        driver.findElement(State).sendKeys(state);
        driver.findElement(City).sendKeys(city);
        driver.findElement(Zipcode).sendKeys(zipcode);
        driver.findElement(MobileNumber).sendKeys(Number);
        driver.findElement(CreateAccount_But).click();
        driver.findElement(CountButton).click();
        driver.findElement(deleteBut).click();



    }
    public String alreadyExist() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyExist));
        return element.getText();
    }
    public String chkDelete() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDelete));
        return element.getText();
    }


}
