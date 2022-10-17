package com.quantum.ubs.screens.bankingservice;

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

public class BankingServices extends UBSScreen {

    public void navigateToBankingService(){
        // Click on Banking Service
        click("banking.services");
    }

    public void navigateToGlance(){

        // Navigate to Banking Service
        navigateToBankingService();

        // At a glance
        click("glance");

        boolean isPresent = CommonStep.verifyPresent("glance.recent");
        assertTrue(isPresent,"Glance recent is not present upon navigating to Banking Service > At Glance.");

    }

    public void navigateToTransferFund(){
        // Navigate to Banking Service
        navigateToBankingService();
        click("transfer.funds");
    }

    public void navigateToDepositCheque(){
        navigateToBankingService();

        // deposit check
        click("deposit.check");
        boolean isPresent = CommonStep.verifyVisible("noaccount");
        assertTrue(isPresent,"No Accounts is not present upon navigating to Banking Service > Deposit Cheque.");
    }

    public void navigateToPayBill(){

        navigateToBankingService();

        // pay bills
        click("Pay Bills");
        boolean isPresent = CommonStep.verifyVisible("bills.payment");
        assertTrue(isPresent,"Bills Payment is not present upon navigating to Banking Service > Pay Bills.");
    }

    public void iphone(){
        if (!isIPhone()) return;

        // Navigate to glance
        navigateToGlance();

        String balance = getText("glance.value");
        boolean isBalanceFormatted = UBSUtils.validateAmount(balance);

        assertTrue(isBalanceFormatted, "Glance Value doesn't matches the format criteria. Glance amount - " + balance);

        UBSCommonSteps.navigateToHome();

        // transfer funds
        navigateToTransferFund();

        // Verify Funds move is present
//        boolean isPresent = CommonStep.verifyVisible("funds.move");
//        assertTrue(isPresent,"Funds Move is not present upon move to Banking Service > Transfer Fund.");

        // Navigate to Schedule transfers
        click("schedule.transfers");

        // check manage scheduled transfers
       boolean isPresent = CommonStep.verifyVisible("transfering.out");
        assertTrue(isPresent,"Transferring out is not present upon move to Banking Service > Transfer Fund > Scheduled Transfers.");

        // Navigate to Pay Bill
        navigateToPayBill();

        // Navigate to Home
        UBSCommonSteps.navigateToHome();

        navigateToBankingService();

        // pay credit card
        click("pay.ubs");
        isPresent = CommonStep.verifyVisible("bills.payment");
        assertTrue(isPresent,"Credit Cards Bills Payment is not present upon move to Banking Service > Pay Bills.");

        // new QAFExtendedWebElement("pay.credit").isDisplayed();
        UBSCommonSteps.navigateToHome();

        // Navigate to Deposit Cheque
        navigateToDepositCheque();

        // Navigate to Home
        UBSCommonSteps.navigateToHome();
        UBSUtils.validateShortHomePage();

    }

    public void ipad(){
        if (!isIPad()) return;
        // new QAFExtendedWebElement("banking.services").click();
        Map<String, Object> params5 = new HashMap<>();
        params5.put("label", "Banking Services");
        params5.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // At a glance
        new QAFExtendedWebElement("glance.recent").isDisplayed();
        String a = new QAFExtendedWebElement("glance.value").getText();
        System.out.println("glance value is: " + a);
        if (!UBSUtils.validateAmount(a)) {
            throw new RuntimeException("No dollar amount has loaded: " + a);
        }

        // transfer funds
        // new QAFExtendedWebElement("transfer.funds").click();
        Map<String, Object> params10 = new HashMap<>();
        params10.put("label", "Transfer Funds");
        params10.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params10);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new QAFExtendedWebElement("funds.move").isPresent();

        // scheduled transfers
        new QAFExtendedWebElement("schedule.transfers").click();
        Map<String, Object> params = new HashMap<>();
        params.put("content", "does not have any scheduled transfers");
        params.put("timeout", 20);
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);
        new QAFExtendedWebElement("profile.back").click();

        new QAFExtendedWebElement("banking.services").click();

        // pay bills
        new QAFExtendedWebElement("Pay Bills").click();
        Map<String, Object> params2 = new HashMap<>();
        params2.put("content", "pay bills outside");
        params2.put("timeout", 20);
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

        // pay credit card
        new QAFExtendedWebElement("ipad.credit").click();
        Map<String, Object> params20 = new HashMap<>();
        params20.put("content", "credit card payment");
        params20.put("timeout", 20);
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params20);

        // deposit check
        new QAFExtendedWebElement("deposit.check").click();
        Map<String, Object> params11 = new HashMap<>();
        params11.put("label", "deposit checks");
        params11.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params11);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new QAFExtendedWebElement("noaccount").isDisplayed();

        // return home
        new QAFExtendedWebElement("back").click();
        new QAFExtendedWebElement("home").click();
        Map<String, Object> params13 = new HashMap<>();
        params13.put("label", "Home");
        params13.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params13);

        UBSUtils.validateShortHomePage();
    }

}
