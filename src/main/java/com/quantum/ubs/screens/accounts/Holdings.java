package com.quantum.ubs.screens.accounts;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSUtils;

import static com.quantum.utils.QAFDriverUtils.*;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class Holdings extends UBSScreen {

	public void iphone() {

		if (!isIPhone())
			return;
		boolean isPresent, isAmountFormatted;
		// Navigate to Holding screen
		click("iphone.main.accounts");
		click("accounts.holdings");
		
		
		// Verify Holding message is Displayed
//        isPresent = CommonStep.verifyPresent("holdings.msg");
//        assertTrue(isPresent,"Holding Message is not present upon switch to Accounts > Holdings option.");

		// Verify Holding message is Displayed
		isPresent = CommonStep.verifyVisible("holdings.cash");
		assertTrue(isPresent, "Holding cash is not present upon switch to Accounts > Holdings option.");

		// Switch to UBS tab
		if (!QAFDriverUtils.isOptionalElementPresent("iphone.intraday")) {
			click("iphone.ubs");
		}

		// Verify Prior Day is Displayed
		isPresent = CommonStep.verifyVisible("iphone.priorday");
		assertTrue(isPresent, "Prior Day is not present upon switch to Accounts > Holdings option.");

		// Verify Intra Day is Displayed
		isPresent = CommonStep.verifyVisible("iphone.intraday");
		assertTrue(isPresent, "Intra Day is not present upon switch to Accounts > Holdings option.");

		// Verify Holding cash is Displayed
		isPresent = CommonStep.verifyVisible("iphone.holdings.cash");
		assertTrue(isPresent, "Holding Cash is not present upon switch to Accounts > Holdings option.");

		// Assert the Holding Grand Total is well formatted.
		String holdingsGrandTotal = getText("iphone.holdings.grandTotal");
		isAmountFormatted = UBSUtils.validateAmount(holdingsGrandTotal);
		assertTrue(isAmountFormatted,
				"Holding Grand total amount is not in correct format $x,xxx.xx. Amount displayed : "
						+ holdingsGrandTotal);

		// Switch to All Tab
		click("iphone.all");

		// check All Accounts Selected
		click("iphone.movenext");

//       iphone.account.select.button
		try {
			new QAFExtendedWebElement("iphone.account.select.all.button").click();

		} catch (Exception e) {
			System.out.println("All accounts already selected.");
		}

		new QAFExtendedWebElement("iphone.account.apply.button").click();

		// Verify the Total value is present
		isPresent = CommonStep.verifyVisible("iphone.total.value");
		assertTrue(isPresent, "Total Value is not present upon switch to All accounts option.");

		// Switch to UBS Tab
		click("iphone.ubs");
	}

	private void iPad() {
		if (!isIPad())
			return;
	}
	
	public void android() {
		if (!isAndroid())
			return;
		
		boolean isPresent, isAmountFormatted;
		// Navigate to Holding screen
		click("android.main.accounts");
		//click("accounts.holdings");

		
		Map<String, Object> params4 = new HashMap<>();
		params4.put("label", "Holdings");
		params4.put("source", "camera");
		params4.put("timeout", "20");
		params4.put("threshold", "90");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);

		// Verify Holding message is Displayed
//        isPresent = CommonStep.verifyPresent("holdings.msg");
//        assertTrue(isPresent,"Holding Message is not present upon switch to Accounts > Holdings option.");

		// Verify Holding message is Displayed
		//isPresent = CommonStep.verifyVisible("holdings.cash");
		
		click("holdings.filterAccounts");
		
		click("holdings.selectAll");
		
		click("holdings.apply");
		
		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "Cash");
		params2.put("source", "camera");
		params2.put("timeout", "30");
		params2.put("threshold", "100");
		isPresent = checkPointTextVisual(params2);
		
		assertTrue(isPresent, "Holding cash is not present upon switch to Accounts > Holdings option.");

		// Switch to UBS tab
		
//		try {
//		Map<String, Object> params3 = new HashMap<>();	
//		params3.put("content", "Intraday");
//		params3.put("source", "camera");
//		params3.put("timeout", "30");
//		params3.put("threshold", "90");
//		isPresent = checkPointTextVisual(params3);
//		} catch (Exception e) {
//			
//		}
		
		if (!isPresent) {
			click("android.ubs");
			
		}

		// Verify Prior Day is Displayed
		isPresent = CommonStep.verifyVisible("android.priorday");
		assertTrue(isPresent, "Prior Day is not present upon switch to Accounts > Holdings option.");

		// Verify Intra Day is Displayed
		isPresent = CommonStep.verifyVisible("android.intraday");
		assertTrue(isPresent, "Intra Day is not present upon switch to Accounts > Holdings option.");

		// Verify Holding cash is Displayed
		//isPresent = CommonStep.verifyVisible("android.holdings.cash");
		//assertTrue(isPresent, "Holding Cash is not present upon switch to Accounts > Holdings option.");

		// Assert the Holding Grand Total is well formatted.
		String holdingsGrandTotal = getText("android.holdings.grandTotal");
		isAmountFormatted = UBSUtils.validateAmount(holdingsGrandTotal);
		assertTrue(isAmountFormatted,
				"Holding Grand total amount is not in correct format $x,xxx.xx. Amount displayed : "
						+ holdingsGrandTotal);

		// Switch to All Tab
		///////ASK ABOUT THIS
		click("android.all");

		// check All Accounts Selected
		//click("android.movenext");

//       iphone.account.select.button
		//try {
		//	new QAFExtendedWebElement("android.account.select.all.button").click();

		//} catch (Exception e) {
		//	System.out.println("All accounts already selected.");
		//}

		//new QAFExtendedWebElement("android.account.apply.button").click();

		// Verify the Total value is present
		//isPresent = CommonStep.verifyVisible("android.total.value");
		
		Map<String, Object> params7 = new HashMap<>();
		params7.put("content", "Total value");
		params7.put("source", "camera");
		params7.put("timeout", "30");
		params7.put("threshold", "90");
		isPresent = checkPointTextVisual(params7);
		
		assertTrue(isPresent, "Total Value is not present upon switch to All accounts option.");

		// Switch to UBS Tab
		click("android.ubs");
	}

	public void validate() {
		iphone();
		iPad();
		android();
	}
}
