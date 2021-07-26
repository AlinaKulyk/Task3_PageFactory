package pages.test;

import model.RozetkaFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LaptopsPage;
import util.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class SelectionTest {

    private WebDriver driver;
    PropertiesReader propertiesReader = new PropertiesReader();
    RozetkaFilter rozetkaFilter = new RozetkaFilter();

    @BeforeTest
    public void setUp() {
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
        propertiesReader.getURL();

//    @BeforeTest
//    public void profileSetUp() {
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//    }
//
//    @BeforeMethod
//    public void testsSetUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://rozetka.com.ua/");
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test
    public void chooseLaptops() {

        HomePage homePage = new HomePage(driver);
        homePage.enterLaptops();

            LaptopsPage laptopsPage = new LaptopsPage(driver);
//            laptopsPage.implicitWait(30);
            laptopsPage.searchByKeyword(rozetkaFilter.getProductGroup());
//            laptopsPage.waitForPageLoadComplete(30);
//            laptopsPage.chooseLaptop();
//            laptopsPage.chooseElementOptions();
//            laptopsPage.waitForPageLoadComplete(50);
//            laptopsPage.chooseMostExpensiveDevice();

    }
}


