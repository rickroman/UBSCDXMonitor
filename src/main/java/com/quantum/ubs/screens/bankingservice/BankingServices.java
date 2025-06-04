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

	public void navigateToBankingService() {
		// Click on Banking Service
		click("banking.services");
	}

	public void navigateToGlance() {

			
		// Navigate to Banking Service
		navigateToBankingService();

		if (!isAndroid()) {
			
		
			
		// At a glance
		click("glance");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "UBS Cash");
		//params2.put("timeout","50");
		//params2.put("threshold", "90");
		params2.put("scrolling", "scroll");
		params2.put("next", "SWIPE=(50%,75%),(50%,55%)");
		boolean isPresent = checkPointTextVisual(params2);
		assertTrue(isPresent, "Glance Core Savings is not present upon navigating to Banking Service > At Glance.");

		}
	}

	public void navigateToTransferFund() {
		// Navigate to Banking Service
		navigateToBankingService();
		click("transfer.funds");
	}

	public void navigateToDepositCheque() {

		String model = DeviceUtils.getDeviceProperty("model");
		navigateToBankingService();

		// deposit check

		click("deposit.check");
		if (model.equalsIgnoreCase("Galaxy S22 Ultra") || model.equalsIgnoreCase("Galaxy S24 Ultra")) {

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "No eligible accounts");
			params2.put("timeout", "30");
			params2.put("threshold", "90");
			boolean isPresent = checkPointTextVisual(params2);

		} else {

			boolean isPresent = CommonStep.verifyVisible("noaccount");
			assertTrue(isPresent, "No Accounts is not present upon navigating to Banking Service > Deposit Cheque.");
		}
	}

	public void navigateToPayBill() {

		String model = DeviceUtils.getDeviceProperty("model");
		navigateToBankingService();

		// pay bills
		if (model.equalsIgnoreCase("Galaxy S24 Ultra")) {
			
			
			
			new QAFExtendedWebElement("bankingServices.payBill").click();
			
			/*
			 * Map<String, Object> params3 = new HashMap<>(); params3.put("label",
			 * "Pay a Bill"); params3.put("timeout", "30"); params3.put("threshold", "90");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
			 * params3);
			 */
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Choose a UBS withdrawl account");
			params2.put("timeout", "30");
			params2.put("threshold", "90");
			boolean isPresent = checkPointTextVisual(params2);

			assertTrue(isPresent, "Bills Payment is not present upon navigating to Banking Service > Pay a Bill.");

		} else {

			click("Pay a Bill");

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Choose a UBS withdrawl account");
			params2.put("timeout", "30");
			params2.put("threshold", "90");
			boolean isPresent = checkPointTextVisual(params2);

			
			assertTrue(isPresent, "Bills Payment is not present upon navigating to Banking Service > Pay a Bill.");

		}
	}

	public void iphone() {
		if (!isIPhone())
			return;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "Cash Available");
		params2.put("timeout","50");
		params2.put("threshold", "90");
		//params2.put("scrolling", "scroll");
		//params2.put("next", "SWIPE=(50%,75%),(50%,55%)");
		boolean isPresent3 = checkPointTextVisual(params2);
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

		//boolean isPresent = CommonStep.verifyVisible("transfering.out");
		//assertTrue(isPresent,
		//		"Transferring out is not present upon move to Banking Service > Transfer Fund > Scheduled Transfers.");

		// Navigate to Pay Bill
		navigateToPayBill();

		// Navigate to Home
		UBSCommonSteps.navigateToHome();

		navigateToBankingService();

		// pay credit card
		//click("pay.ubs");
		//isPresent = CommonStep.verifyVisible("bills.payment");
		//assertTrue(isPresent, "Credit Cards Bills Payment is not present upon move to Banking Service > Pay Bills.");

		// new QAFExtendedWebElement("pay.credit").isDisplayed();
		UBSCommonSteps.navigateToHome();

		// Navigate to Deposit Cheque
		navigateToDepositCheque();

		// Navigate to Home
		UBSCommonSteps.navigateToHome();
		UBSUtils.validateShortHomePage();

	}

	public void android() {
		if (!isAndroid())
			return;

		// Navigate to glance
		navigateToGlance();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		//12-10-24 Removing "Glance stuff for Android as it causes the app to fail.
		/*
		 * Map<String, Object> params22 = new HashMap<>(); params22.put("content",
		 * "UBS Cash"); params22.put("timeout", "45"); params22.put("threshold", "90");
		 * boolean isPresent = checkPointTextVisual(params22);
		 * 
		 * String balance = getText("glance.value"); boolean isBalanceFormatted =
		 * UBSUtils.validateAmount(balance);
		 * 
		 * assertTrue(isBalanceFormatted,
		 * "Glance Value doesn't matches the format criteria. Glance amount - " +
		 * balance);
		 */
		
		
		//////////////////////////////
		
		UBSCommonSteps.navigateToHome();

		// transfer funds
		navigateToTransferFund();

		// Verify Funds move is present
//        boolean isPresent = CommonStep.verifyVisible("funds.move");
//        assertTrue(isPresent,"Funds Move is not present upon move to Banking Service > Transfer Fund.");

		// Navigate to Schedule transfers
		click("schedule.transfers");

		// check manage scheduled transfers
		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "Transferring out");
		params2.put("timeout", "30");
		params2.put("threshold", "90");

		//boolean isPresent2 = checkPointTextVisual(params2);

		//assertTrue(isPresent2,
				//"Transferring out is not present upon move to Banking Service > Transfer Fund > Scheduled Transfers.");

		// Navigate to Pay Bill
		navigateToPayBill();

		// Navigate to Home
		UBSCommonSteps.navigateToHome();

		navigateToBankingService();

		// pay credit card
		Map<String, Object> params223 = new HashMap<>();
		params223.put("content", "Take care of UBS credit card payments");
		params223.put("timeout", "30");
		params223.put("threshold", "90");

		boolean isPresent3 = checkPointTextVisual(params223);
		//click("pay.ubs");
		
		
		/*
		 * Map<String, Object> params23 = new HashMap<>(); params23.put("label",
		 * "Pay UBS Credit Card and Credit Line"); params23.put("timeout", "30");
		 * params23.put("threshold", "90");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
		 * params23);
		 * 
		 * 
		 * isPresent = checkPointTextVisual(params22);
		 */
		
		//assertTrue(isPresent, "Credit Cards Bills Payment is not present upon move to Banking Service > Pay Bills.");

		// new QAFExtendedWebElement("pay.credit").isDisplayed();
		UBSCommonSteps.navigateToHome();

		// Navigate to Deposit Cheque
		navigateToDepositCheque();

		// Navigate to Home
		UBSCommonSteps.navigateToHome();
		UBSUtils.validateShortHomePage();

	}

	public void ipad() {
		if (!isIPad())
			return;
		// new QAFExtendedWebElement("banking.services").click();
		Map<String, Object> params5 = new HashMap<>();
		params5.put("label", "Banking Services");
		params5.put("timeout", "30");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);
		
		Map<String, Object> params321 = new HashMap<>();
		params321.put("content", "Transfer Funds In");
		params321.put("timeout", "30");
		params321.put("threshold", "90");
		boolean isPresent3 = checkPointTextVisual(params321);

		
		
		
		new QAFExtendedWebElement("bankingServices.glance").click();
		
		
		

		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "UBS Cash");
		params2.put("timeout","50");
		params2.put("threshold", "90");
		//params2.put("scrolling", "scroll");
		//params2.put("next", "SWIPE=(50%,75%),(50%,55%)");
		boolean isPresent4 = checkPointTextVisual(params2);
		
		
		// Navigate to glance
		// At a glance
		
		Map<String, Object> params432 = new HashMap<>();
		params432.put("content", "Recent Cash and Credit Activity");
		params432.put("timeout", "30");
		params432.put("threshold", "90");
		boolean isPresent432 = checkPointTextVisual(params432);
		
		//new QAFExtendedWebElement("glance.recent").isDisplayed();
		String a = new QAFExtendedWebElement("glance.value").getText();
		System.out.println("glance value is: " + a);
		if (!UBSUtils.validateAmount(a)) {
			throw new RuntimeException("No dollar amount has loaded: " + a);
		}

		new QAFExtendedWebElement("bankingServices.glance").click();
		
		// transfer funds
		// new QAFExtendedWebElement("transfer.funds").click();
		Map<String, Object> params10 = new HashMap<>();
		params10.put("label", "Transfer Funds");
		params10.put("timeout", "30");
		params10.put("index", "2");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params10);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new QAFExtendedWebElement("funds.move").isPresent();

		// scheduled transfers
		new QAFExtendedWebElement("ipad.schedule.transfers").click();
		Map<String, Object> params = new HashMap<>();
		params.put("content", "does not have any scheduled transfers");
		params.put("timeout", 20);
		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);
		//new QAFExtendedWebElement("profile.back").click();

		new QAFExtendedWebElement("banking.services").click();

		// pay bills
		Map<String, Object> params11 = new HashMap<>();
		params11.put("label", "Pay a Bill");
		params11.put("timeout", "30");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params11);
		
		Map<String, Object> params6 = new HashMap<>();
		params6.put("content", "Choose payee");
		params6.put("timeout", 20);
		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params6);

		new QAFExtendedWebElement("banking.services").click();

		
		// pay credit card
		new QAFExtendedWebElement("ipad.credit").click();
		Map<String, Object> params20 = new HashMap<>();
		params20.put("content", "Take care of UBS credit");
		params20.put("timeout", 20);
		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params20);

		new QAFExtendedWebElement("banking.services").click();
		// deposit check
		new QAFExtendedWebElement("deposit.check").click();
		Map<String, Object> params1111 = new HashMap<>();
		params1111.put("label", "You have not added any eligible account");
		params1111.put("timeout", "30");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params1111);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new QAFExtendedWebElement("noaccount").isDisplayed();

		// return home
		//new QAFExtendedWebElement("profile.back").click();
		new QAFExtendedWebElement("home").click();
		Map<String, Object> params13 = new HashMap<>();
		params13.put("label", "Home");
		params13.put("timeout", "30");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params13);

		UBSUtils.validateShortHomePage();
	}

}
