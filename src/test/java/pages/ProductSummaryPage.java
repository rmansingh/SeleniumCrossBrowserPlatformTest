package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSummaryPage extends HomePage{

    @FindBy(name = "Submit")
    public WebElement btnSubmit;

    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    public WebElement btnProceedToCheckout;

    public ProductSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public ShoppingCartSummaryPage proceedToCheckout(){
        log("Checkout and proceed to Shopping Cart Summary Page.");
        waitForVisibilityOf(btnProceedToCheckout).click();
        return new ShoppingCartSummaryPage(driver);
    }

    public void addToCart(){
        log("Adding product to cart.");
        waitForVisibilityOf(btnSubmit).click();
    }

}
