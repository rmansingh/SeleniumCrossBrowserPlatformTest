package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentConfirmationPage extends HomePage {

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    public WebElement btnConfirmOrder;

    public PaymentConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public OrderConfirmationPage confirmOrder(){
        log("Confirm payment details and proceed to Order Confirmation Page.");
        waitForVisibilityOf(btnConfirmOrder).click();
        return new OrderConfirmationPage(driver);
    }

}
