package com.quantum.ubs.screens.accounts;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSUtils;

import static com.quantum.utils.QAFDriverUtils.*;
import static org.testng.Assert.assertTrue;

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

	public void validate() {
		iphone();
		iPad();
	}
}
