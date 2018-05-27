package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends HomePage{

    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
    public WebElement firstProduct;

    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ProductSummaryPage gotoFirstProduct() {
        log("Navigating to first product summary page.");
        firstProduct.click();
        firstProduct.click();
        return new ProductSummaryPage(driver);
    }
}
