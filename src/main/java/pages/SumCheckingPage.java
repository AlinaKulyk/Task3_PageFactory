//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class SumCheckingPage {
//
//    @FindBy(name = "//div[@class='cart-receipt__sum-price']")
//    private WebElement price;
//
//    WebDriver driver;
//
//    public SumCheckingPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public void checkProductSum() {
//
//        int sum;
//        String strPrice = price.getText();
//        strPrice = strPrice.substring(0, strPrice.length() - 2);
//        sum = Integer.parseInt(strPrice);
//
//        if (sum < 50000) {
//            System.out.println("Sum Of Products < 50 000");
//        } else
//            System.out.println("Sum Of Products > 50 000");
//    }
//}

