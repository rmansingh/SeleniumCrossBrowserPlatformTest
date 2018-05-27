package com.hf.test;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogInTest extends BaseClass {

    @Test()
    public void logInTest() {
        log("------------------- Starting LogInTest Test -------------------");
        HomePage homePage = new HomePage(driver);
        String fullName = "Joe Black";

        LoginPage loginPage = homePage.gotoLoginPage();
        MyAccountPage myAccountPage = loginPage.login(existingUserEmail, existingUserPassword);
        waitForVisibilityOf(myAccountPage.lblHeading);

        assertEquals(myAccountPage.lblHeading.getText(),"MY ACCOUNT");
        assertEquals(myAccountPage.lblAccountName.getText(),fullName);
        assertTrue(myAccountPage.lblAccountInfo.getText().contains("Welcome to your account."));
        assertTrue(myAccountPage.linkSignOut.isDisplayed());
        assertTrue(myAccountPage.assertURLContains("controller=my-account"));

        log("------------------- Ending LogInTest Test -------------------");
    }
}
