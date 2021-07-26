package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class LaptopsPage{

    @FindBy(name = "searchline")
    private WebElement brandSearchField;

    @FindBy(xpath = "//a[@class='checkbox-filter__link']//label[contains(text(),'HP')]")
    private WebElement brand;

    @FindBy(xpath="//select//option")
    private List<WebElement> optionsElements;

    @FindBy(xpath ="//a[@class='goods-tile__picture ng-star-inserted']")
    private List<WebElement> mostExpensiveDevice;

    WebDriver driver;

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchByKeyword (final String keyword) { brandSearchField.sendKeys(keyword, Keys.ENTER); }

    public void clickOnBrand() { brand.click();}

    public void chooseElementOptions() {
        for (WebElement webElement : optionsElements) {
            if (webElement.getText().equals("От дорогих к дешевым")) {
                webElement.click();
                break;
            }
        }
    }

    public void chooseMostExpensiveDevice() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(mostExpensiveDevice));
        mostExpensiveDevice.get(0).click();}

    }



