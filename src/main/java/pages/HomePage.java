package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//a[contains(text(), 'Ноутбуки и компьютеры')]")
    private WebElement laptopsAndComputersButton;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterLaptops() { laptopsAndComputersButton.click(); }

}
