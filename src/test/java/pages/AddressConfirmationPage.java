package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressConfirmationPage extends HomePage {

    @FindBy(name = "processAddress")
    public WebElement btnCheckout;

    public AddressConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ShippingDetailPage proceedToCheckOut(){
        log("Checkout and proceed to Shipping Details Page.");
        waitForVisibilityOf(btnCheckout).click();
        return new ShippingDetailPage(driver);
    }


}
