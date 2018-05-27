package com.hf.test;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseClass {
    public static final Logger log = Logger.getLogger(CheckoutTest.class.getName());
    //Logging method so that the same log is added in logger as well as in TestNG Report
    public void log(String data) {
        log.info(data);
        Reporter.log(data);
    }
    @Test
    public void checkoutTest() {
        log("------------------- Starting CheckoutTest Test -------------------");

        /*Getting Test Data from JSON File*/
        log("Getting test data from json file.");
        JSONObject testData = getTestData();
        log("Parsed test data is as follows: " + testData.toString());
        /*--------------------------------*/

        HomePage homePage = new HomePage(driver);
        waitForVisibilityOf(homePage.btnLogin);
        LoginPage loginPage = homePage.gotoLoginPage();
        MyAccountPage myAccountPage = loginPage.login(existingUserEmail,existingUserPassword);

        log("Navigating to Women category product list.");
        myAccountPage.navigateMenu("women");
        ProductListPage productList = new ProductListPage(driver);
        ProductSummaryPage productSummaryPage = productList.gotoFirstProduct();
        productSummaryPage.addToCart();
        ShoppingCartSummaryPage shoppingCartSummaryPage = productSummaryPage.proceedToCheckout();
        AddressConfirmationPage addressConfirmationPage = shoppingCartSummaryPage.proceedToCheckOut();
        ShippingDetailPage shippingDetailPage = addressConfirmationPage.proceedToCheckOut();
        waitForVisibilityOf(shippingDetailPage.chkAgreeTermsAndService).click();
        PaymentMethodPage paymentMethodPage = shippingDetailPage.proceedToCheckOut();
        PaymentConfirmationPage paymentConfirmationPage = paymentMethodPage.payVia(PaymentMethodPage.PaymentMethod.PayByBankWire);
        OrderConfirmationPage orderConfirmationPage = paymentConfirmationPage.confirmOrder();

        waitForVisibilityOf(orderConfirmationPage.lblHeading);

        assertEquals(orderConfirmationPage.lblHeading.getText(),"ORDER CONFIRMATION");
        assertTrue(orderConfirmationPage.lblSecondLastStage.isDisplayed());
        assertTrue(orderConfirmationPage.lblLastStage.isDisplayed());
        assertTrue(orderConfirmationPage.lblConfirmationMessage.getText().contains("Your order on My Store is complete."));
        assertTrue(orderConfirmationPage.assertURLContains("controller=order-confirmation"));

        log("------------------- Ending CheckoutTest Test -------------------");
    }
}
