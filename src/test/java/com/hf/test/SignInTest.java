package com.hf.test;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseClass {
    public static final Logger log = Logger.getLogger(SignInTest.class.getName());

    @Test()
    public void signInTest() {
        log("------------------- Starting SignInTest Test -------------------");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        AccountCreationPage accountCreationPage = loginPage.createAccount(email);
        log("Entering personal information.");
        waitForVisibilityOf(accountCreationPage.radioTitle).click();
        accountCreationPage.txtFirstName.sendKeys(name);
        accountCreationPage.txtlastName.sendKeys(surname);
        accountCreationPage.txtPassword.sendKeys("Qwerty");
        accountCreationPage.enterDateOfBirth("1", "1", "2000");
        accountCreationPage.txtCompany.sendKeys("Company");
        accountCreationPage.txtAddress1.sendKeys("Qwerty, 123");
        accountCreationPage.txtAddress2.sendKeys("zxcvb");
        accountCreationPage.txtCity.sendKeys("Qwerty");
        accountCreationPage.enterState("Colorado");
        accountCreationPage.txtZipCode.sendKeys("12345");
        accountCreationPage.txtAdditionalInformation.sendKeys("Qwerty");
        accountCreationPage.txtPhone.sendKeys("12345123123");
        accountCreationPage.txtMobile.sendKeys("12345123123");
        accountCreationPage.txtAlias.sendKeys("hf");
        MyAccountPage myAccountPage = accountCreationPage.submitAccountDetails();
        waitForVisibilityOf(myAccountPage.lblHeading);

        assertEquals(myAccountPage.lblHeading.getText(), "MY ACCOUNT");
        assertEquals(myAccountPage.lblAccountName.getText(), name + " " + surname);
        assertTrue(myAccountPage.lblAccountInfo.getText().contains("Welcome to your account."));
        assertTrue(myAccountPage.linkSignOut.isDisplayed());
        assertTrue(myAccountPage.assertURLContains("controller=my-account"));

        log("------------------- Ending SignInTest Test -------------------");
    }

}
