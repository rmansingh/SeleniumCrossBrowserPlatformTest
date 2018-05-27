package pages;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends HomePage {

    public static final Logger log = Logger.getLogger(AccountCreationPage.class.getName());

    @FindBy(id = "id_gender2")
    public WebElement radioTitle;

    @FindBy(id = "customer_firstname")
    public WebElement txtFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement txtlastName;

    @FindBy(id = "passwd")
    public WebElement txtPassword;

    @FindBy(id = "days")
    public WebElement dropdownDays;

    @FindBy(id = "months")
    public WebElement dropdownMonths;

    @FindBy(id = "years")
    public WebElement dropdownYears;

    @FindBy(id = "company")
    public WebElement txtCompany;

    @FindBy(id = "address1")
    public WebElement txtAddress1;

    @FindBy(id = "address2")
    public WebElement txtAddress2;

    @FindBy(id = "city")
    public WebElement txtCity;

    @FindBy(id = "id_state")
    public WebElement dropdownState;

    @FindBy(id = "postcode")
    public WebElement txtZipCode;

    @FindBy(id = "other")
    public WebElement txtAdditionalInformation;

    @FindBy(id = "phone")
    public WebElement txtPhone;

    @FindBy(id = "phone_mobile")
    public WebElement txtMobile;

    @FindBy(id = "alias")
    public WebElement txtAlias;

    @FindBy(id = "submitAccount")
    public WebElement btnSubmitAccount;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterDateOfBirth(String days, String months, String years) {
        log("Entering date of birth.");
        Select select = new Select(dropdownDays);
        select.selectByValue("1");
        select = new Select(dropdownMonths);
        select.selectByValue("1");
        select = new Select(dropdownYears);
        select.selectByValue("2000");
    }

    public void enterState(String state) {
        Select select = new Select(dropdownState);
        select.selectByVisibleText(state);
    }

    public MyAccountPage submitAccountDetails() {
        log("Submitting user's personal information.");
        btnSubmitAccount.click();
        return new MyAccountPage(driver);
    }

    public void enterValue(WebElement e, String v) {
        e.sendKeys(v);
    }

    public void enterFirstName(String name) {
        txtFirstName.sendKeys(name);
    }

    public void enterLastName(String surname) {
        txtlastName.sendKeys(surname);
    }

    public void enterPassword(String pass) {
        txtPassword.sendKeys(pass);
    }

    public void enterCompany(String company) {
        txtCompany.sendKeys(company);
    }

    public void enterAddress1(String s) {
        txtAddress1.sendKeys(s);
    }

    public void enterAddress2(String addr) {
        txtAddress2.sendKeys(addr);
    }

    public void enterCity(String qwerty) {
        txtCity.sendKeys(qwerty);
    }

    public void enterZipCode(String s) {
        txtZipCode.sendKeys(s);
    }

    public void enterAdditionalInfo(String s) {
        txtAdditionalInformation.sendKeys(s);
    }

    public void enterPhone(String s) {
        txtPhone.sendKeys(s);
    }

    public void enterMobile(String s) {
        txtMobile.sendKeys(s);
    }

    public void enterAlias(String hf) {
        txtAlias.sendKeys(hf);
    }
}
