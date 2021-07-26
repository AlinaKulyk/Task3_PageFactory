package pages.test;

import model.RozetkaFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.LaptopsPage;
//import pages.SumCheckingPage;
import util.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class SelectionTest {

    private WebDriver driver;

    // PropertiesReader propertiesReader = new PropertiesReader();
    RozetkaFilter rozetkaFilter = new RozetkaFilter();

//    @BeforeTest
//    public void setUp() {
//        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
//        propertiesReader.getURL();
//
//    }

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }


    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void chooseLaptop() {

        WebDriverWait wait = new WebDriverWait(driver, 50);

        HomePage homePage = new HomePage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        AddToCartPage addToCartPage = new AddToCartPage(driver);
//        SumCheckingPage sumCheckingPage = new SumCheckingPage(driver);
//      homePage.searchByKeyword(rozetkaFilter.getProductGroup());
        homePage.searchByKeyword("laptop");
//      laptopsPage.searchByKeyword(rozetkaFilter.getBrand());
        laptopsPage.searchByKeyword("HP");
        laptopsPage.clickOnBrand();
        laptopsPage.chooseElementOptions();
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        laptopsPage.chooseMostExpensiveDevice();
        addToCartPage.pressButtonBuy();
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//      sumCheckingPage.checkProductSum(rozetkaFilter.getSum()); - int значение, а мы переводили xml в string.
//        sumCheckingPage.checkProductSum();

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}


