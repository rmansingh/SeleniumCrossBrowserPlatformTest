package com.hf.test;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @Author: Sahil Mutreja
 * @Desc: Test case to validate product check out activity
 */
public class CheckoutTest extends BaseClass {

    @Test
    public void checkoutTest() {
        log("------------------- Starting CheckoutTest Test -------------------");

        /* Getting Test Data from JSON File which can be used in this test case */
        log("Getting Test Data from JSON File which can be used in this test case.");
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
