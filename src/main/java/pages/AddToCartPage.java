package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']")
    private WebElement buttonBuy;

    public AddToCartPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void pressButtonBuy (){
            buttonBuy.click();
        }
    }
