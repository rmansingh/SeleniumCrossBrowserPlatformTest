package pages;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass{

    private static final Logger log = Logger.getLogger(HomePage.class.getName());

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(className = "login")
    public WebElement btnLogin;

    @FindBy(linkText = "Women")
    public WebElement menuitemWomen;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10,50);
        PageFactory.initElements(driver, this);
    }

    public LoginPage gotoLoginPage(){
        log("Navigating to Login page.");
        waitForVisibilityOf(btnLogin);
        btnLogin.click();
        return new LoginPage(driver);
    }

    public WebElement waitForVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



}
