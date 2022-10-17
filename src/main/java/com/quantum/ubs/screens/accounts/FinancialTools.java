package com.quantum.ubs.screens.accounts;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.utils.QAFDriverUtils.*;
import static org.testng.Assert.assertTrue;

public class FinancialTools extends UBSScreen {

    public void iphone(){
        if (!isIPhone()) return;

        // Navigate to Financial tools
        click("iphone.main.accounts");
        click("accounts.financial.tools");

        // Validate the Financial tools message is displayed
        boolean isPresent = CommonStep.verifyVisible("iphone.financialtools.msg");
        assertTrue(isPresent,"Financial Tools Message is not present upon navigating to Financial tools screen.");

        // Click on Cash flow
        click("cash.flow.iphone");

        //Validate the Cash Flow message is displayed
        isPresent = CommonStep.verifyVisible("cash.flow.msg");
        assertTrue(isPresent,"Cash Flow Message is not present upon navigating to Financial tools screen.");

        // Navigate to Cash Flow spending
        click("cash.flow.spending");

        //Validate the Cash Flow message is displayed
        isPresent = CommonStep.verifyVisible("cash.flow.expenses");
        assertTrue(isPresent,"Cash Flow expenses is not present upon navigating to Financial tools screen.");

        UBSCommonSteps.navigateToHome();
    }

    public void ipad(){
        if (!isIPad()) return;

        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Accounts");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

        new QAFExtendedWebElement("accounts.balances").isDisplayed();
        new QAFExtendedWebElement("accounts.currentBalance").isPresent();

        String balance = new QAFExtendedWebElement("total.value").getAttribute("name");
        if (!UBSUtils.validateAmount(balance)) {
            throw new RuntimeException("No dollar amount has loaded: " + balance);
        }

        // click on all, validate and return
        new QAFExtendedWebElement("balances.all").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new QAFExtendedWebElement("all.assets").isPresent();
        new QAFExtendedWebElement("iphone.ubs").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new QAFExtendedWebElement("accounts.currentBalance").isPresent();

        // check prior day
        try {
            new QAFExtendedWebElement("balances.priorday").click();
        } catch (Exception e) {

            new QAFExtendedWebElement("iphone.ubs").click();
            new QAFExtendedWebElement("balances.priorday").click();

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new QAFExtendedWebElement("prior.day.investments").isDisplayed();
        new QAFExtendedWebElement("balances.intraday").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new QAFExtendedWebElement("accounts.balances").isDisplayed();

        /*
         * // click on holdings & validate // set long timeout for holdings page on iPad
         * DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(300,
         * TimeUnit.SECONDS);
         * DeviceUtils.getQAFDriver().manage().timeouts().setScriptTimeout(300,
         * TimeUnit.SECONDS);
         *
         *
         * new QAFExtendedWebElement("accounts.holdings").click();
         *
         * // check holdings values try { Thread.sleep(20000); } catch
         * (InterruptedException e) { e.printStackTrace(); }
         *
         *
         *
         *
         * String holdingsGrandTotal = new
         * QAFExtendedWebElement("ipad.holdings.grandTotal").getText();
         * System.out.println("holding grand total:" + holdingsGrandTotal);
         * if(!UBSUtils.validateNumber(holdingsGrandTotal)) {
         *
         * Map<String, Object> params12 = new HashMap<>(); params12.put("label",
         * "Holdings"); params12.put("timeout", "30");
         * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
         * params12);
         *
         *
         * holdingsGrandTotal = new
         * QAFExtendedWebElement("ipad.holdings.grandTotal").getText();
         * System.out.println("holding grand total:" + holdingsGrandTotal);
         *
         *
         *
         * throw new RuntimeException("No dollar amount has loaded: " +
         * holdingsGrandTotal); }
         *
         * String holdingsAmount = new
         * QAFExtendedWebElement("activity.amounts").findElements("activity.amounts").
         * get(0).getText(); System.out.println("holdings amount: " + holdingsAmount);
         * if(!UBSUtils.validateNumber(holdingsAmount)) {throw new
         * RuntimeException("No dollar amount has loaded: " + holdingsAmount); }
         *
         *
         *
         * new QAFExtendedWebElement("iphone.ubs").click(); new
         * QAFExtendedWebElement("holdings.ubs.change").isPresent();
         *
         * DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(60,
         * TimeUnit.SECONDS);
         *
         * // check prior day
         *
         * try{ new QAFExtendedWebElement("balances.priorday").isDisplayed(); }catch
         * (Exception e) { System.out.println("clicking on ubs"); new
         * QAFExtendedWebElement("iphone.ubs").click(); }
         *
         *
         * new QAFExtendedWebElement("balances.priorday").click(); new
         * QAFExtendedWebElement("holdings.quantity").isPresent(); new
         * QAFExtendedWebElement("balances.intraday").click();
         *
         * new QAFExtendedWebElement("balances.all").click(); new
         * QAFExtendedWebElement("holdings.cash").isPresent();
         *
         *
         */

        // click on Activity & validate

        Map<String, Object> params3 = new HashMap<>();
        params3.put("label", "Activity");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params3);
        // new QAFExtendedWebElement("accounts.activity").click();
        new QAFExtendedWebElement("activity.type").isDisplayed();
        // check number of first activity
        String a = new QAFExtendedWebElement("activity.amounts").findElements("activity.amounts").get(0).getText();
        System.out.println("activity amount: " + a);
        if (!UBSUtils.validateNumber(a)) {
            throw new RuntimeException("No dollar amount has loaded: " + a);
        }

        // check activity filter
        new QAFExtendedWebElement("accounts.activity").click();
        new QAFExtendedWebElement("activity.account").isDisplayed();

        Map<String, Object> params = new HashMap<>();
        params.put("content", "Filter");
        DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);

        // new QAFExtendedWebElement("filter.btn").click();
        new QAFExtendedWebElement("ytd").click();
        // new QAFExtendedWebElement("filter.apply").click();
        Map<String, Object> params4 = new HashMap<>();
        params4.put("label", "Apply");
        params4.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);
        new QAFExtendedWebElement("activity.account").isDisplayed();

        // Financial tools
        // new QAFExtendedWebElement("accounts.financial.tools").click();

        Map<String, Object> params5 = new HashMap<>();
        params5.put("label", "Financial tools");
        params5.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);
        new QAFExtendedWebElement("financial.tools.msg").isDisplayed();
        new QAFExtendedWebElement("net.balanc").isPresent();

        new QAFExtendedWebElement("cash.flow").click();

        Map<String, Object> params6 = new HashMap<>();
        params6.put("label", "Cash flow");
        params6.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params6);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new QAFExtendedWebElement("cash.flow.msg").isDisplayed();
        // new QAFExtendedWebElement("cash.flow.spending").click();
        Map<String, Object> params7 = new HashMap<>();
        params7.put("label", "Spending");
        params7.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params7);
        new QAFExtendedWebElement("cash.flow.expenses").isDisplayed();

        // go back to home page
        new QAFExtendedWebElement("back").click();
        // new QAFExtendedWebElement("home").click();
        Map<String, Object> params8 = new HashMap<>();
        params8.put("label", "Home");
        params8.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params8);
    }


}
