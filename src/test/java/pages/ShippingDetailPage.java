package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingDetailPage extends HomePage {

    @FindBy(id = "uniform-cgv")
    public WebElement chkAgreeTermsAndService;

    @FindBy(name = "processCarrier")
    public WebElement btnCheckout;


    public ShippingDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PaymentMethodPage proceedToCheckOut(){
        log("Checkout and proceed to Payment Method Page.");
        btnCheckout.click();
        return new PaymentMethodPage(driver);
    }
}
