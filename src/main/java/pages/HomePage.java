package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(name = "search")
    private WebElement searchField;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void searchByKeyword (final String keyword) { searchField.sendKeys(keyword, Keys.ENTER); }
}
