package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends HomePage{

    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    public WebElement btnCheckOut;

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public AddressConfirmationPage proceedToCheckOut(){
        log("Checkout and proceed to Address Confirmation Page.");
        waitForVisibilityOf(btnCheckOut).click();
        return new AddressConfirmationPage(driver);
    }
}
