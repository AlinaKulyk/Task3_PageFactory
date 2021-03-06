package pages.test;

import model.RozetkaFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AddToCartPage;
import pages.HomePage;
import pages.LaptopsPage;
import pages.SumCheckingPage;
import util.PropertiesReader;
import util.XMLtoObject;
import java.util.concurrent.TimeUnit;

public class SelectionTest {

    private WebDriver driver;


    @BeforeTest
    public void setUp() {
        PropertiesReader propertiesReader = new PropertiesReader();
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
        propertiesReader.getURL();
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
        RozetkaFilter rozetkaFilter = new RozetkaFilter();
        rozetkaFilter = new XMLtoObject().convert();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        HomePage homePage = new HomePage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        AddToCartPage addToCartPage = new AddToCartPage(driver);

        SumCheckingPage sumCheckingPage = new SumCheckingPage(driver);
        homePage.searchByKeyword(rozetkaFilter.getProductGroup());
        laptopsPage.searchByKeyword(rozetkaFilter.getBrand());
        laptopsPage.clickOnBrand();
        laptopsPage.chooseElementOptions();
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        laptopsPage.chooseMostExpensiveDevice();
        addToCartPage.pressButtonBuy();
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
      Assert.assertTrue(sumCheckingPage.checkProductSum(rozetkaFilter.getSum()));

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}


