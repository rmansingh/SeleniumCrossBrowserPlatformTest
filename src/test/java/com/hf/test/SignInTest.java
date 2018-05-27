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
        accountCreationPage.enterFirstName(name);
        accountCreationPage.enterLastName(surname);
        accountCreationPage.enterPassword("Qwerty");
        accountCreationPage.enterDateOfBirth("1", "1", "2000");
        accountCreationPage.enterCompany("Company");
        accountCreationPage.enterAddress1("Qwerty, 123");
        accountCreationPage.enterAddress2("zxcvb");
        accountCreationPage.enterCity("Qwerty");
        accountCreationPage.enterState("Colorado");
        accountCreationPage.enterZipCode("12345");
        accountCreationPage.enterAdditionalInfo("Qwerty");
        accountCreationPage.enterPhone("12345123123");
        accountCreationPage.enterMobile("12345123123");
        accountCreationPage.enterAlias("hf");
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
