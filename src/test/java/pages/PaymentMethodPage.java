package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage extends HomePage {

    @FindBy(className = "bankwire")
    public WebElement btnPayByBankWire;

    @FindBy(className = "cheque")
    public WebElement btnPayByCheck;

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PaymentConfirmationPage payVia(PaymentMethod paymentMethod){
        log("Choosing payment method and proceed to Payment Confirmation Page.");
        if(paymentMethod.equals(PaymentMethod.PayByBankWire))
            btnPayByBankWire.click();
        else
            btnPayByCheck.click();
        return new PaymentConfirmationPage(driver);
    }

    public static enum PaymentMethod{
        PayByBankWire("bankwire"),
        PayByCheck("check");

        String method;
        PaymentMethod(String method) {
            this.method = method;
        }
    }
}
