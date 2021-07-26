package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class LaptopsPage extends BasePage{

    @FindBy(name = "search")
    private WebElement searchField;

    @FindBy(xpath="//a[@class='checkbox-filter__link']//label[contains(text(),'HP')]")
    private WebElement deviceBrand;

    @FindBy(xpath="//select//option")
    private List<WebElement> optionsElements;

    @FindBy(xpath ="//a[@class='goods-tile__picture ng-star-inserted']")
    private List<WebElement> mostExpensiveDevice;

    public LaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchByKeyword (final String keyword) { searchField.sendKeys(keyword, Keys.ENTER); }

    public void chooseLaptop() { deviceBrand.click();}

    public void chooseElementOptions() {
        for (WebElement webElement : optionsElements) {
            if (webElement.getText().equals("От дорогих к дешевым")) {
                webElement.click();
                break;
            }
        }
    }

    public void chooseMostExpensiveDevice() {mostExpensiveDevice.get(0).click();}

    }



