package com.quantum.steps;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;

import cucumber.api.java.en.When;

@QAFTestStepProvider
public class EquityAwardsStepDefs {

	private static final String Secured_equity_uname = "secured.BzOYecc1Y/h1KI04dhivkg==";
	private static final String Secured_equity_pw = "secured.C68G7Vqodlvt8un3EM7Tiw==";

	String model = DeviceUtils.getDeviceProperty("model");

	@When("CDX Equity Awards login")
	public void equityAwardsLogin() {

		UBSCommonSteps.login(Secured_equity_uname, Secured_equity_pw);

//        //declare the Map for script parameters
//        Map<String, Object> params = new HashMap<>();
//        params.put("text", Secured_equity_uname);
//        params.put("by", "xpath");
//        params.put("value", "//*[@value=\"Username\"]");
//        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);
//
//        new QAFExtendedWebElement("login.next.iphone").click();
//
//        Map<String, Object> params4 = new HashMap<>();
//        params4.put("text", Secured_equity_pw);
//        params4.put("by", "xpath");
//        params4.put("value", "//XCUIElementTypeSecureTextField");
//        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);
//
//        new QAFExtendedWebElement("login.signin.btn").click();
//        // 2 validations of home page loading
//        UBSUtils.declineFaceID();
		validateEquityAwardsHP();

	}

	@When("validate activity")
	public void validateActivity() {
		new QAFExtendedWebElement("equityAwards").click();
		new QAFExtendedWebElement("equityActivity").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new QAFExtendedWebElement("orders.completed").isDisplayed();
		
		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {

			for (int i = 0; i < 7; i++) {
				Map<String, Object> params1 = new HashMap<>();
				params1.put("start", ",50%,85%");
				params1.put("end", "50%,15%");
				params1.put("duration", "0");
				Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1);
			}

		}
		new QAFExtendedWebElement("orders.disclosures").isDisplayed();

	}

	@When("validate holdings")
	public void validateHoldings() {
		new QAFExtendedWebElement("equityAwards").click();
		new QAFExtendedWebElement("equityHoldings").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new QAFExtendedWebElement("holdings.awards").isDisplayed();
		new QAFExtendedWebElement("holdings.shares").isPresent();

	}

	@When("check transactions")
	public void checkTransactions() {
		new QAFExtendedWebElement("equityAwards").click();
		new QAFExtendedWebElement("EquityTransactions").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new QAFExtendedWebElement("transactionsWelcome").isPresent();

	}

	@When("validate awards education")
	public void validateEducation() {
		new QAFExtendedWebElement("equityAwards").click();
		new QAFExtendedWebElement("EquityAwardsEducation").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new QAFExtendedWebElement("education.progress").isPresent();

	}

	@When("check notifications")
	public void checkNotificatiobs() {
		new QAFExtendedWebElement("equityAwards").click();
		new QAFExtendedWebElement("EquityNotify").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new QAFExtendedWebElement("notifications,actionable").isPresent();

		new QAFExtendedWebElement("Home").click();
		validateEquityAwardsHP();

	}

	@When("check MW balances")
	public void checkMWBalances() {
		new QAFExtendedWebElement("hp.mywealth").click();
		new QAFExtendedWebElement("mw.balances").click();

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			// temporary checkpoint for android
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "Add your external accounts");
			params1.put("source", "camera");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		} else {
			new QAFExtendedWebElement("mw.balances.assets").isPresent();
			new QAFExtendedWebElement("mw.balances.investmentAssets").isDisplayed();
		}
	}

	@When("check MW Holdings")
	public void checkMWHoldings() {

		new QAFExtendedWebElement("hp.mywealth").click();
		new QAFExtendedWebElement("mw.holdings").click();

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "Add your external accounts");
			params1.put("source", "camera");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);
		} else {
			new QAFExtendedWebElement("mw.holdings.none").isDisplayed();
		}

	}

	@When("check MW Activity")
	public void checkMWActivity() {

		new QAFExtendedWebElement("hp.mywealth").click();
		new QAFExtendedWebElement("mw.activity").click();

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {

			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "No activities match");
			params1.put("source", "camera");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		} else {
			new QAFExtendedWebElement("mw.activity.none").isDisplayed();
		}
	}

	@When("check MW Financial Tools")
	public void checkMWTools() {
		new QAFExtendedWebElement("hp.mywealth").click();
		new QAFExtendedWebElement("mw.tools").click();

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "You are currently not enrolled");
			params1.put("source", "camera");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		} else {

			new QAFExtendedWebElement("mw.tools.netWorth").isDisplayed();
			new QAFExtendedWebElement("cashFlow").click();
			new QAFExtendedWebElement("know.moves").isDisplayed();
			new QAFExtendedWebElement("spending").click();
			
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "Expense Analysis");
			params1.put("source", "camera");
			params1.put("timeout", "90");
			params1.put("threshold", "90");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

			
			//new QAFExtendedWebElement("expense.analysis").isDisplayed();

		}
		new QAFExtendedWebElement("Home").click();
		validateEquityAwardsHP();
	}

	@When("check my information")
	public void checkMyInfo() {

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			new QAFExtendedWebElement("menu.android").click();
			new QAFExtendedWebElement("my.info").click();
			new QAFExtendedWebElement("username").isDisplayed();
		} else {
			new QAFExtendedWebElement("menu.iphone").click();
			new QAFExtendedWebElement("my.info").click();
			new QAFExtendedWebElement("username").isDisplayed();
		}

	}

	@When("EW check settings")
	public void checkSettings() {

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			new QAFExtendedWebElement("menu.android").click();
		} else {
			new QAFExtendedWebElement("menu.iphone").click();
		}
		new QAFExtendedWebElement("settings").click();
		new QAFExtendedWebElement("ew.settings").isDisplayed();

	}

	@When("EW check support")
	public void checkSupport() {
		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			new QAFExtendedWebElement("menu.android").click();
		} else {
			
		new QAFExtendedWebElement("menu.iphone").click();
		
		}

		new QAFExtendedWebElement("support").click();
		new QAFExtendedWebElement("market.hours").isDisplayed();
	}

	@When("EW check legal")
	public void checkLegal() {
		
		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			new QAFExtendedWebElement("menu.android").click();
		} else {
			new QAFExtendedWebElement("menu.iphone").click();
		}
		
		new QAFExtendedWebElement("legal").click();
		new QAFExtendedWebElement("valuation").isDisplayed();
		new QAFExtendedWebElement("legal.cancel").click();

	}

	@When("EW get in touch")
	public void getInTouch() {
		
		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			new QAFExtendedWebElement("menu.android").click();
		} else {
			new QAFExtendedWebElement("menu.iphone").click();
		}
		new QAFExtendedWebElement("get.in.touch").click();
		new QAFExtendedWebElement("toll.free").isDisplayed();
		new QAFExtendedWebElement("touch.close").click();
	}

	private void validateEquityAwardsHP() {

		// temp checkpoint
		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			
			try {

				new QAFExtendedWebElement("login.Not.Now").click();

			} catch (Exception e) {
				System.out.println("no biometric popup");
			}

			try {
				Map<String, Object> params2 = new HashMap<>();
				params2.put("label", "Go to Notifications");
				params2.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

				new QAFExtendedWebElement("home").click();

			} catch (Exception e) {
				System.out.println("no notification popup");
			}

			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "Today's Value");
			params1.put("source", "camera");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		} else {

			try {
				new QAFExtendedWebElement("closeHPNotification").click();
			} catch (Exception e) {
				System.out.println("no notification popup");
			}
			new QAFExtendedWebElement("home.getintouch").isDisplayed();
			// new QAFExtendedWebElement("holdingsSummary").isDisplayed();

		}

		// String todayValue = new QAFExtendedWebElement("todaysValue").getText();
		// System.out.println("today value is: " + todayValue);

	}
}
