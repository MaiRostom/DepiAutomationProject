package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;
import testCases.T07_TestCases;

public class BaseSteps {
    public WebDriver driver;
    public P00_HomePage homePage;
    public P06_Products productsPage;
    public P10_ProductDetails productDetails;
    public P11_AddedToCartPopUp addedToCartPopUp;
    public P07_SearchProducts searchProducts;
    public P12_Cart cartPage;
    public P08_CategoryProducts categoryProductsPage;
    public P09_BrandProducts brandProductsPage;
    public P19_ReviewPage reviewPage;
    public P17_ContactUsForm contactUsPage;
   public  P01_SignupLogin signupLogin;
   public  P03_Register register;
   public  P02_Login login;
   public P18_TestcasesPage testCase;
    public P13_CheckOut checkOutPage;
    public P15_Payment paymentPage;
    public P16_PaymentDone paymentDone;
    public CategoryPrductPage categoryPrductPage;
    public BrandProductsPage brandProductPage;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

         signupLogin=new P01_SignupLogin(driver);

        homePage=new P00_HomePage(driver);
        productsPage=new P06_Products(driver);
        productDetails =new P10_ProductDetails(driver);
        addedToCartPopUp=new P11_AddedToCartPopUp(driver);
        searchProducts=new P07_SearchProducts(driver);
        cartPage=new P12_Cart(driver);
        categoryProductsPage=new P08_CategoryProducts(driver);
        brandProductsPage=new P09_BrandProducts(driver);
        reviewPage=new P19_ReviewPage(driver);
        contactUsPage=new P17_ContactUsForm(driver);
        register=new P03_Register(driver);
        login=new P02_Login(driver);
        testCase=new P18_TestcasesPage(driver);
        checkOutPage=new P13_CheckOut(driver);
        paymentPage=new P15_Payment(driver);
        paymentDone =new P16_PaymentDone(driver);
        categoryPrductPage =new CategoryPrductPage(driver);
        brandProductPage=new BrandProductsPage(driver);
                driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();

    }

}
