package pages;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends HomePage {

    @FindBy(css = "h1")
    public WebElement lblHeading;

    @FindBy(className = "account")
    public WebElement lblAccountName;

    @FindBy(className = "info-account")
    public WebElement lblAccountInfo;

    @FindBy(className = "logout")
    public WebElement linkSignOut;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean assertURLContains(String url) {
        return driver.getCurrentUrl().contains(url);
    }

}
