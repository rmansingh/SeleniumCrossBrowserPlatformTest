package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends HomePage {

    @FindBy(css = "h1")
    public WebElement lblHeading;

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    public WebElement lblSecondLastStage;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    public WebElement lblLastStage;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    public WebElement lblConfirmationMessage;


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean assertURLContains(String url) {
        return driver.getCurrentUrl().contains(url);
    }

}
