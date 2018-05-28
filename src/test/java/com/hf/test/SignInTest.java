package com.hf.test;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utility.TestDataGenerator;

import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @Author: Sahil Mutreja
 * @Desc: Test case to validate new user sign in activity
 */
public class SignInTest extends BaseClass {

    @Test()
    public void signInTest() {
        log("------------------- Starting SignInTest Test -------------------");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";

        AccountCreationPage accountCreationPage = loginPage.createAccount(email);
        log("Entering personal information.");
        waitForVisibilityOf(accountCreationPage.radioTitle).click();

        /*Entering Random values in the form using TestDataGenerator class*/
        TestDataGenerator.ValueType alphabet = TestDataGenerator.ValueType.ALPHABET;
        TestDataGenerator.ValueType number = TestDataGenerator.ValueType.NUMBER;
        TestDataGenerator.ValueType alphanumeric = TestDataGenerator.ValueType.ALPHANUMERIC;
        String name = TestDataGenerator.randomAlphaNumeric(5,alphabet);
        String surname = TestDataGenerator.randomAlphaNumeric(5,alphabet);
        accountCreationPage.enterFirstName(name);
        accountCreationPage.enterLastName(surname);
        accountCreationPage.enterPassword(TestDataGenerator.randomAlphaNumeric(5,alphanumeric));
        accountCreationPage.enterDateOfBirth("1", "1", "2000");
        accountCreationPage.enterCompany(TestDataGenerator.randomAlphaNumeric(5,alphabet));
        accountCreationPage.enterAddress1(TestDataGenerator.randomAlphaNumeric(10,alphabet));
        accountCreationPage.enterAddress2(TestDataGenerator.randomAlphaNumeric(5,alphabet));
        accountCreationPage.enterCity(TestDataGenerator.randomAlphaNumeric(6,alphabet));
        accountCreationPage.enterState(TestDataGenerator.randomAlphaNumeric(1,number));
        accountCreationPage.enterZipCode(TestDataGenerator.randomAlphaNumeric(5,number));
        accountCreationPage.enterAdditionalInfo(TestDataGenerator.randomAlphaNumeric(5,number));
        accountCreationPage.enterPhone(TestDataGenerator.randomAlphaNumeric(11,number));
        accountCreationPage.enterMobile(TestDataGenerator.randomAlphaNumeric(11,number));
        accountCreationPage.enterAlias(TestDataGenerator.randomAlphaNumeric(3,alphabet));
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
