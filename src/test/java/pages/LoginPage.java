package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {

    @FindBy(id="email_create")
    public WebElement txtNewEmail;

    @FindBy(id="SubmitCreate")
    public WebElement btnCreateAccount;

    @FindBy(id="email")
    public WebElement txtEmail;

    @FindBy(id="passwd")
    public WebElement txtPassword;

    @FindBy(id="SubmitLogin")
    public WebElement btnSubmitLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public AccountCreationPage createAccount(String email){
        log("Entering email for new account and submitting.");
        txtNewEmail.sendKeys(email);
        btnCreateAccount.click();
        return new AccountCreationPage(driver);
    }

    public MyAccountPage login(String existingUserEmail,String existingUserPassword) {
        log("Entering email, password and click submit.");
        txtEmail.sendKeys(existingUserEmail);
        txtPassword.sendKeys(existingUserPassword);
        btnSubmitLogin.click();
        return new MyAccountPage(driver);
    }

}
