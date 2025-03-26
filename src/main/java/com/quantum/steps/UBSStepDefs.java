/**
 *
 */
package com.quantum.steps;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
import static com.quantum.utils.QAFDriverUtils.click;
import static com.quantum.utils.QAFDriverUtils.getAttribute;
import static com.quantum.utils.QAFDriverUtils.getText;
import static com.quantum.utils.QAFDriverUtils.launchApp;
import static com.quantum.utils.QAFDriverUtils.scrollUp;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.StatementTax.StatementTax;
import com.quantum.ubs.screens.accounts.Balance;
import com.quantum.ubs.screens.accounts.FinancialTools;
import com.quantum.ubs.screens.accounts.Holdings;
import com.quantum.ubs.screens.bankingservice.BankingServices;
import com.quantum.ubs.screens.menu.ContactAdvisor;
import com.quantum.ubs.screens.menu.Feedback;
import com.quantum.ubs.screens.menu.LegalServices;
import com.quantum.ubs.screens.menu.Logout;
import com.quantum.ubs.screens.menu.Mindset;
import com.quantum.ubs.screens.menu.Profile;
import com.quantum.ubs.screens.menu.Relationship;
import com.quantum.ubs.screens.menu.Settings;
import com.quantum.ubs.screens.menu.Support;
import com.quantum.ubs.screens.milestone.MileStone;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class UBSStepDefs {

	// old name
	// private static final String securedUsername =
	// "secured./h2sxa3ub4PCwXhsgCxWJQ==";
	// new name
	private static final String securedUsername = "secured.KynB3uCmThTJX618aF5yBA==";

	private static final String securedPassword = "secured.PVOjXGpIv4MTtvrOEvYUiw==";

	@Then("^I restart all devices$")
	public void daily_restart() {

		Map<String, Object> params = new HashMap<>();
		DeviceUtils.getQAFDriver().executeScript("mobile:device:ready", params);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		Map<String, Object> pars = new HashMap<>();
		DeviceUtils.getQAFDriver().executeScript("mobile:handset:reboot", pars);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		Map<String, Object> pars2 = new HashMap<>();
		DeviceUtils.getQAFDriver().executeScript("mobile:handset:recover", pars2);
		try {
			Thread.sleep(90000);
		} catch (InterruptedException e) {
		}

	}

	@Then("^I Clear UBS Cache$")
	public static void clearAdvantageCache() {

		launchApp("name", "Settings");

		Map<String, Object> params22 = new HashMap<>();
		params22.put("content", "App info");
		params22.put("source", "camera");
		params22.put("timeout", "20");
		params22.put("threshold", "100");
		boolean checkPointResult = checkPointTextVisual(params22);

		if (checkPointResult) {

			click("settings.search.ubsLink");

		} else {

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Samsung account");
			params2.put("source", "camera");
			params2.put("timeout", "30");
			params2.put("threshold", "100");
			Object result = checkPointTextVisual(params2);

			click("settings.search");

			Map<String, Object> params = new HashMap<>();
			params.put("label", "Search");
			params.put("text", "UBS");
			params.put("timeout", "20");
			params.put("threshold", "90");
			Object result2 = DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params);

			click("settings.search.ubsLink");

		}

		Map<String, Object> params3 = new HashMap<>();
		params3.put("content", "Storage");
		params3.put("scrolling", "scroll");
		params3.put("next", "SWIPE=(50%,65%),(50%,35%)");
		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

		Map<String, Object> params33 = new HashMap<>();
		params33.put("label", "Storage");
		params33.put("timeout", "30");
		params33.put("threshold", "90");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params33);

		Map<String, Object> params4 = new HashMap<>();
		params4.put("content", "Cache");
		params4.put("scrolling", "scroll");
		params4.put("next", "SWIPE=(50%,65%),(50%,35%)");
		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params4);

		click("settings.ubs.cache");

		// DeviceUtils.closeApp("name", "Settings");

	}

	// public String os = new QAFExtendedWebElement().getDescription();

	@When("I launch CDX")
	public void launch_cdx() {

		// Launch the UBS App

		if (UBSUtils.getModel().equals("iphone")) {

			try {
				DeviceUtils.closeApp("identifier", "com.ubs.clientMobile");
			} catch (Exception e) {
				System.out.println("app was not open");
			}

			launchApp("identifier", "com.ubs.clientMobile");
			CommonStep.assertPresent("login.signin.btn");
		} else if (UBSUtils.getModel().equals("ipad")) {
				launchApp("name", "UBS");
				
				CommonStep.assertPresent("iPad.signin.btn");
			} else {
				
			
			launchApp("name", "UBS");
			CommonStep.assertPresent("login.signin.btn");
			}
		}
		

		// Assert that Login Message is displayed

		

//        if(UBSUtils.getModel().equals("iphone")) {
//
//
//          
//
//
//        }else {
//
//
//            try { DeviceUtils.closeApp("UBS", "name");
//            }catch (Exception e){ System.out.println("app was not open"); }
//            DeviceUtils.startApp("UBS", "name");
//
//        }
//        DeviceUtils.getQAFDriver().findElement("login.message").isPresent();

	


	@When("I debug launch CDX")
	public void debugLaunch_cdx() {

		if (UBSUtils.getModel().equals("iphone")) {

			try {
				DeviceUtils.closeApp("Wealth QA", "name");
			} catch (Exception e) {
				System.out.println("app was not open");
			}
			DeviceUtils.startApp("Wealth QA", "name");

		} else {

			try {
				DeviceUtils.closeApp("Wealth QA", "name");
			} catch (Exception e) {
				System.out.println("app was not open");
			}
			DeviceUtils.startApp("Wealth QA", "name");

		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DeviceUtils.getQAFDriver().findElement("login.message").isPresent();
	}

	@When("Login to CDX")
	public void loginCDX() {

		String model = DeviceUtils.getDeviceProperty("model");

		// if(UBSUtils.getModel().equals("iphone")) {
		if (model.equalsIgnoreCase("iPhone-15 Pro Max")) {

			UBSCommonSteps.login(securedUsername, securedPassword);

		
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Net Balance");
			params2.put("timeout", "60");
			params2.put("threshold", "90");

			boolean checkPointResult = checkPointTextVisual(params2);

			UBSUtils.declineFaceID();
			 //UBSUtils.clearImportantNotice();
			 //UBSUtils.declineTaxDocs();
			UBSUtils.declineZelleMotice();
			UBSUtils.validateHomePage();
			
		} else if (model.equalsIgnoreCase("iPhone-16 Pro Max")) {
			
	UBSCommonSteps.login(securedUsername, securedPassword);

		
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Net Balance");
			params2.put("timeout", "60");
			params2.put("threshold", "90");

			boolean checkPointResult = checkPointTextVisual(params2);

			UBSUtils.declineFaceID();
			// UBSUtils.clearImportantNotice();
			 //UBSUtils.declineTaxDocs();
			//UBSUtils.declineMarketClosures();
			UBSUtils.declineZelleMotice();
			UBSUtils.validateHomePage();
			
			
		} else if (model.equalsIgnoreCase("Galaxy S24 Ultra")) {

			// enter credentials
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "Username");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params1);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Map<String, Object> params = new HashMap<>();
			params.put("label", "Username");
			params.put("text", securedUsername);
			params.put("timeout", "20");
			params.put("threshold", "90");
			params.put("label.direction", "above");
			params.put("label.offset", "3%");
			Object result = DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params);

			new QAFExtendedWebElement("field.password").click();

			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "Password");
			params4.put("text", securedPassword);
			params4.put("timeout", "20");
			params4.put("threshold", "90");
			// params4.put("label.direction","above"); //params4.put("label.offset", "3%");
			// DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params4);
			DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params4);

			// new QAFExtendedWebElement("field.password").sendKeys(securedPassword);

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}

			
			new QAFExtendedWebElement("login.signin.btn").click();
			UBSUtils.declineFaceID();
			// UBSUtils.clearImportantNotice();
			//UBSUtils.declineMarketClosures();
			UBSUtils.declineTaxDocs();
			UBSUtils.validateHomePage();
		} else {
			// enter credentials
			/*
			 * Map<String, Object> params1 = new HashMap<>(); params1.put("content",
			 * "Username"); DeviceUtils.getQAFDriver().executeScript("mobile:text:select",
			 * params1); try { Thread.sleep(4000); } catch (InterruptedException e) {
			 * e.printStackTrace(); }
			 */

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}

			Map<String, Object> params = new HashMap<>();
			params.put("label", "Username");
			params.put("text", securedUsername);
			params.put("timeout", "20");
			params.put("threshold", "90");
			//params.put("label.direction", "above");
			//params.put("label.offset", "3%");
			Object result = DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params);

			/*
			 * Map<String, Object> params3 = new HashMap<>(); params3.put("text",
			 * securedUsername); //params3.put("by", "xpath"); params3.put("by", "xpath");
			 * //params3.put("value", "//XCUIElementTypeTextField");
			 * params3.put("value","");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set",
			 * params3);
			 */
			// new QAFExtendedWebElement("field.username").sendKeys("securetest66");
			//new QAFExtendedWebElement("login.next").click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}


			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "Password");
			params4.put("text", securedPassword);
			params4.put("timeout", "20");
			params4.put("threshold", "90");
			//params4.put("label.direction", "above");
			//params4.put("label.offset", "3%");
			DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params4);
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}


			// new QAFExtendedWebElement("field.password").sendKeys("cantGue33");
			
			new QAFExtendedWebElement("iPad.signin.btn").click();
			// 2 validations of home page loading
			UBSUtils.declineFaceID();
			// UBSUtils.clearImportantNotice();
			 //UBSUtils.declineTaxDocs();
			//UBSUtils.declineMarketClosures();
			UBSUtils.validateHomePage();
		}

	}

	@When("debug_Login to CDX")
	public void debugLoginCDX() {

		new QAFExtendedWebElement("field.username").sendKeys("cdx07");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// new QAFExtendedWebElement("debug.next").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new QAFExtendedWebElement("field.password").sendKeys("New@ols2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Map<String, Object> params = new HashMap<>();
		params.put("label", "Sign in");
		params.put("timeout", 15);
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * 
		 * Map<String, Object> params4 = new HashMap<>(); params4.put("text",
		 * Secured_dpw); params4.put("by", "xpath"); params4.put("value",
		 * "//XCUIElementTypeSecureTextField");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set",
		 * params4);
		 * 
		 */

		// new QAFExtendedWebElement("debug.next").click();

		// new QAFExtendedWebElement("login.next.iphone").click();
		// new QAFExtendedWebElement("debug.pw").click();

		/*
		 * Map<String, Object> params4 = new HashMap<>(); params4.put("text", "yaron");
		 * params4.put("by", "xpath"); params4.put("value", "//*[@value=\"Password\"]");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set",
		 * params4);
		 * 
		 * 
		 * // new QAFExtendedWebElement("field.password").sendKeys("cantGue33");
		 * 
		 * 
		 */
		// new QAFExtendedWebElement("login.signin.btn").click();
		// 2 validations of home page loading
		UBSUtils.validateHomePage();

	}

	@Then("check milestone")
	public void checkMilestone() {

		MileStone mileStoneScreens = new MileStone();

		mileStoneScreens.validate();

//		if (UBSUtils.getModel().equalsIgnoreCase("iphone")) {
//
////			new QAFExtendedWebElement("main.milestones").click();
////			new QAFExtendedWebElement("mile.scouts").click();
////			new QAFExtendedWebElement("mile.bsa").isDisplayed();
////			new QAFExtendedWebElement("mile.resources").isDisplayed();
////
////			// click on article
////			System.out.println("milestone article");
////			Map<String, Object> params2 = new HashMap<>();
////			params2.put("label", "donation to the scouts");
////			params2.put("timeout", 30);
////			params2.put("label.direction", "Above");
////			params2.put("label.offset", "35%");
////
////			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
////			try {
////				Thread.sleep(3000);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
////
////			Map<String, Object> params = new HashMap<>();
////			params.put("label", "done");
////			params.put("timeout", 30);
////			params.put("screen.top", "0%");
////			params.put("screen.height", "13%");
////			params.put("screen.width", "100%");
////			params.put("screen.left", "0%");
////			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
////
////			new QAFExtendedWebElement("iphone.activity.back").click();
////			try {
////				Thread.sleep(3000);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
////			new QAFExtendedWebElement("home").isPresent();
////			new QAFExtendedWebElement("home").click();
////			UBSUtils.validateShortHomePage();
//
//		} else {
//
////			Map<String, Object> params4 = new HashMap<>();
////			params4.put("label", "PUBLIC:monitoring/milestones_ipad.png");
////			params4.put("timeout", "30");
////			DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);
////			new QAFExtendedWebElement("mile.scouts").click();
////			try {
////				Thread.sleep(5000);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
////
////			new QAFExtendedWebElement("mile.bsa").isDisplayed();
////
////			// click on article
////			Map<String, Object> params2 = new HashMap<>();
////			params2.put("label", "Resources");
////			params2.put("ignorecase", "case");
////			params2.put("timeout", 30);
////			params2.put("label.direction", "Above");
////			params2.put("label.offset", "9%");
////			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
////			try {
////				Thread.sleep(3000);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
////
////			new QAFExtendedWebElement("xbutton").click();
////			new QAFExtendedWebElement("milestones.page").isDisplayed();
////
////			/*
////			 * Map<String, Object> params = new HashMap<>();
////			 * params.put("label","PUBLIC:monitoring/milestones_ipad_back.png");
////			 * params.put("timeout", "30");
////			 * DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click",
////			 * params); new QAFExtendedWebElement("retirement").isDisplayed(); try {
////			 * Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
////			 * 
////			 */
////			new QAFExtendedWebElement("home").click();
////			Map<String, Object> params5 = new HashMap<>();
////			params5.put("label", "home");
////			params5.put("timeout", "30");
////			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);
////			UBSUtils.validateShortHomePage();
//
//		}
	}

	@Then("validate banking services")
	public void bankingServices() {

		BankingServices bankingServicesScreen = new BankingServices();
		bankingServicesScreen.validate();
	}

	@Then("view insights")
	public void viewInsights() throws Exception {

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("iPhone-15 Pro Max")) {

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "AS OF");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,50%),(50%,30%)");
			params2.put("maxscroll", "18");

			boolean checkPointResult = checkPointTextVisual(params2);

			System.out.println(checkPointResult);

			assertTrue(checkPointResult, "Scroll to 'Market Insights failed");

//            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

		} else if (model.equalsIgnoreCase("iPhone-16 Pro Max")) {
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "AS OF");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,50%),(50%,30%)");
			params2.put("maxscroll", "18");

			boolean checkPointResult = checkPointTextVisual(params2);

			System.out.println(checkPointResult);

			assertTrue(checkPointResult, "Scroll to 'Market Insights failed");
		} else if (model.equalsIgnoreCase("Galaxy S24 Ultra")) {

			try {
				Map<String, Object> params2 = new HashMap<>();
				params2.put("content", "AS OF");
				params2.put("scrolling", "scroll");
				params2.put("next", "SWIPE=(50%,85%),(50%,55%)");
				params2.put("threshold", "90");

				Object result2 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

				boolean checkPointResult = checkPointTextVisual(params2);

				// System.out.println(checkPointResult);

				// assertTrue(checkPointResult, "Scroll to 'here are your periodically'
				// failed");
			} catch (Exception e) {
				throw new Exception("here are your periodically :" + e);
			}

		} else {
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "news and insights");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,85%),(50%,55%)");

			boolean checkPointResult = checkPointTextVisual(params2);

			assertTrue(checkPointResult, "Scroll to 'news and insights' failed");

//            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

			// scroll back up
			scrollUp("\"net balance\", \"includes ubs and external accounts\"");

//            Map<String, Object> params = new HashMap<>();
//            params.put("content","\"net balance\", \"includes ubs and external accounts\"");
//            params.put("scrolling", "scroll");
//            params.put("target","any");
//            params.put("next","SWIPE=(50%,55%),(50%,85%)");
//            params.put("maxscroll",10);
//            
//            checkPointResult = checkPointTextVisual(params);

//            assertTrue(checkPointResult, "Scroll to 'Net balance' failed");

//            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);
		}

	}

	@Then("view market insights")
	public void viewMarketInsights() throws ParseException {

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "DJIA");
			params2.put("scrolling", "scroll");
			params2.put("threshold", "100");
			params2.put("next", "SWIPE=(50%,85%),(50%,45%)");
			params2.put("screen.top", "0%");
			params2.put("screen.height", "85%");
			params2.put("screen.left", "0%");
			params2.put("screen.width", "20%");
			// params3.put("target", "all");
			params2.put("maxscroll", 13);
			// Object result3 =
			// DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

			Object result2 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

			Pattern pattern = Pattern.compile("((\\d){1,2}/){2}(\\d){4}");

			boolean checkPointResult = checkPointTextVisual(params2);

			// assertTrue(checkPointResult, "DJIA not displayed");

			String djiaAsOf = getText("android.djia.asof");

			Matcher matcher = pattern.matcher(djiaAsOf);

			assertTrue(matcher.find(), "DJIA As Of Date is not in expected format - " + djiaAsOf);

			String updatedOn = getAttribute("home.asof", "text");

			matcher = pattern.matcher(updatedOn);

			assertTrue(matcher.find(), "Updated Date is not in expected format - " + updatedOn);

			String updatedOnStr = matcher.group();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

			Date updatedOnDate = sdf.parse(updatedOnStr);

			Calendar calendar = new GregorianCalendar();
			calendar.setTime(updatedOnDate);

			int actualYear = calendar.get(Calendar.YEAR);

			Year currentYear = Year.now(ZoneId.of("America/New_York"));

			assertEquals(actualYear, currentYear.getValue(),
					"Updated On Years not matching - actual : " + actualYear + " Expected Year - " + currentYear);

			scrollUp("learn more about your accounts");

		} else if (model.equalsIgnoreCase("iPhone-15 Pro Max")) {

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "DJIA");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,90%),(50%,45%)");
			params2.put("target", "all");
			params2.put("maxscroll", 10);

			Pattern pattern = Pattern.compile("((\\d){1,2}/){2}(\\d){4}");

			boolean checkPointResult = checkPointTextVisual(params2);

			assertTrue(checkPointResult, "DJIA not displayed");

			String djiaAsOf = getText("iphone.djia.asof");

			Matcher matcher = pattern.matcher(djiaAsOf);

			assertTrue(matcher.find(), "DJIA As Of Date is not in expected format - " + djiaAsOf);

			String updatedOn = getAttribute("home.asof", "value");

			matcher = pattern.matcher(updatedOn);

			assertTrue(matcher.find(), "Updated Date is not in expected format - " + updatedOn);

			String updatedOnStr = matcher.group();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

			Date updatedOnDate = sdf.parse(updatedOnStr);

			Calendar calendar = new GregorianCalendar();
			calendar.setTime(updatedOnDate);

			int actualYear = calendar.get(Calendar.YEAR);

			Year currentYear = Year.now(ZoneId.of("America/New_York"));

			assertEquals(actualYear, currentYear.getValue(),
					"Updated On Years not matching - actual : " + actualYear + " Expected Year - " + currentYear);

			scrollUp("learn more about your accounts");

		} else {

		}

	}

	@Then("check account activity")
	public void accountActivity() {

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("Galaxy S24 Ultra")) {
			// Click on Account Tab in bottom Navigation Bar
			click("android.main.accounts");

			// Click on Activity option from popup
			click("accounts.activity");

			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Open Select Activities
			// click("activity.filterAccounts");

			Map<String, Object> params45 = new HashMap<>();
			params45.put("label", "PUBLIC:FilterAccountsiGalaxyS24.png");
			params45.put("timeout", "10");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params45);

			try {

				Map<String, Object> params2 = new HashMap<>();
				params2.put("content", "Select all");
				params2.put("source", "camera");
				params2.put("timeout", "30");
				params2.put("threshold", "100");
				boolean isPresent = checkPointTextVisual(params2);

				if (isPresent) {

					// Select accounts
					click("activity.selectAll");

				}
			} catch (Exception e) {

			}

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Clear all");
			params2.put("source", "camera");
			params2.put("timeout", "30");
			params2.put("threshold", "100");
			boolean isPresent = checkPointTextVisual(params2);

			if (isPresent) {
				click("activity.apply");
			}

			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Click on First Activity Displayed
			click("android.activity.first");

			// Get Activity Amount text
			String activityAmount = getText("activity.amount");

			// Validate the amount is well formatted.
			boolean isAmountFormated = UBSUtils.validateAmount(activityAmount);

			// Assert the isAmountFormatted is well formatted.
			assertTrue(isAmountFormated,
					"Activity amount is not in correct format $x,xxx.xx. Amount displayed : " + activityAmount);

			// Navigate back to home screen
			click("android.activity.back");

			// Click on Filter button

			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "PUBLIC:FilterAccountsiGalaxyS24.png");
			params4.put("timeout", "10");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);

			// Click On Year to Date option
			// click("ytd.android");

			// Click on Apply Button
			click("filter.apply");

			// Assert Activity screen is displayed
			CommonStep.assertPresent("filter.btn");

			Map<String, Object> params454 = new HashMap<>();
			params454.put("label", "Home");
			params454.put("source", "camera");
			params454.put("timeout", "20");
			params454.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params454);

			// Click on Home tab in the bottom navigationbar
			// click("home");

			Map<String, Object> params6 = new HashMap<>();
			params6.put("content", "Net Balance");
			params6.put("source", "camera");
			params6.put("timeout", "30");
			params6.put("threshold", "90");
			ArrayList genericOptions1 = new ArrayList();
			genericOptions1.add("natural-language=true");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params6);
		} else if (model.equalsIgnoreCase("iPhone-15 Pro Max") || model.equalsIgnoreCase("iPhone-16 Pro Max")){

			// Click on Account Tab in bottom Navigation Bar
			click("iphone.main.accounts");

			// Click on Activity option from popup
			click("accounts.activity");

			// Open Select Activities
			// click("activity.filterAccounts");

			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Map<String, Object> params = new HashMap<>();
			params.put("label", "PUBLIC:FilterAccountsiPhone.png");
			params.put("timeout", "60");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);

			// PUBLIC:FilterAccountsiPhone.png

			try {

				Map<String, Object> params2 = new HashMap<>();
				params2.put("content", "Select all");
				params2.put("source", "camera");
				params2.put("timeout", "15");
				params2.put("threshold", "100");
				boolean isPresent = checkPointTextVisual(params2);

				if (isPresent) {

					// Select accounts
					click("activity.selectAll");

				}

				click("activity.apply");
			} catch (Exception e) {

			}

			// Click on First Activity Displayed
			click("iphone.activity.first");

			// Get Activity Amount text
			String activityAmount = getText("activity.amount");

			// Validate the amount is well formatted.
			boolean isAmountFormated = UBSUtils.validateAmount(activityAmount);

			// Assert the isAmountFormatted is well formatted.
			assertTrue(isAmountFormated,
					"Activity amount is not in correct format $x,xxx.xx. Amount displayed : " + activityAmount);

			// Navigate back to home screen
			click("iphone.activity.back");

			// Click on Filter button
			click("filter.btn");

			// Click On Year to Date option
			click("ytd.iphone");

			// Click on Apply Button
			click("filter.apply");

			// Assert Activity screen is displayed
			CommonStep.assertPresent("filter.btn");

			// Click on Home tab in the bottom navigationbar
			click("home");

			// Assert HOme Page is displayed
			//CommonStep.assertPresent("main.net.balance");
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Net Balance");
			params2.put("timeout", "60");
			params2.put("threshold", "90");

			boolean checkPointResult = checkPointTextVisual(params2);


		} else {

			// Click on Account Tab in bottom Navigation Bar
			click("iphone.main.accounts");

			// Click on Activity option from popup
		
			click("accounts.activity");

			click("ipad.activity.filterAccounts");
			// Open Select Activities
			// click("activity.filterAccounts");

			try {

				Map<String, Object> params2 = new HashMap<>();
				params2.put("content", "Select all");
				params2.put("source", "camera");
				params2.put("timeout", "30");
				params2.put("threshold", "100");
				boolean isPresent = checkPointTextVisual(params2);

				if (isPresent) {

					// Select accounts
					click("activity.selectAll");

				}

				click("activity.apply");
			} catch (Exception e) {

			}
			// Click on First Activity Displayed
			click("ipad.activity.first");

			// Get Activity Amount text
			String activityAmount = getText("activity.amount");

			// Validate the amount is well formatted.
			boolean isAmountFormated = UBSUtils.validateAmount(activityAmount);

			// Assert the isAmountFormatted is well formatted.
			assertTrue(isAmountFormated,
					"Activity amount is not in correct format $x,xxx.xx. Amount displayed : " + activityAmount);

			// Navigate back to home screen
			click("iphone.activity.back");

			// Click on Filter button
			click("filter.btn");

			// Click On Year to Date option
			click("ytd.iphone");

			// Click on Apply Button
			click("filter.apply");

			// Assert Activity screen is displayed
			CommonStep.assertPresent("filter.btn");

			// Click on Home tab in the bottom navigationbar
			click("home");

			// Assert HOme Page is displayed
			//CommonStep.assertPresent("main.net.balance");
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Net Balance");
			params2.put("timeout", "60");
			params2.put("threshold", "90");

			boolean checkPointResult = checkPointTextVisual(params2);

//        new QAFExtendedWebElement("iphone.main.accounts").click();
//        new QAFExtendedWebElement("accounts.activity").click();
//        
//        // validating first activity
//        new QAFExtendedWebElement("iphone.activity.first").click();
//        String activityAmount = new QAFExtendedWebElement("activity.amount").getText();
//        
//        if(!UBSUtils.validateNumber(activityAmount)) {throw new RuntimeException("No activity amount has loaded: " + activityAmount); }
//        new QAFExtendedWebElement("iphone.activity.back").click();
//
//
//
//        // check activity filter
//        Map<String, Object> params = new HashMap<>();
//        params.put("content", "Filter");
//        params.put("language", "English");
//        params.put("timeout",30);
//        DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
//
//        //  new QAFExtendedWebElement("filter.btn").click();
//        new QAFExtendedWebElement("ytd.iphone").click();
//        new QAFExtendedWebElement("filter.apply").click();
//
//        Map<String, Object> params2 = new HashMap<>();
//        params2.put("content", "updated");
//        params2.put("timeout", "30");
//        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
//
//        new QAFExtendedWebElement("home").click();
//        UBSUtils.validateShortHomePage();
		}

	}

	private void validateAccountsIPhone() {

		/* ==== Holding Account validation ==== */

		// ==== Financial Tools ====

	}

	@Then("validate accounts")
	public void validateAccounts() {

		Balance balanceScreen = new Balance();
		balanceScreen.validate();

		Holdings holdingsScreen = new Holdings();
		holdingsScreen.validate();

		FinancialTools financialToolsScreen = new FinancialTools();
		financialToolsScreen.validate();

		UBSUtils.validateShortHomePage();

	}

	@Then("create milestone")
	public void createMilestone() {
		new QAFExtendedWebElement("main.milestones").click();
		new QAFExtendedWebElement("mile.add").click();
		new QAFExtendedWebElement("mile.travel").click();
		new QAFExtendedWebElement("MilestoneNameComponentViewCell").click();
		new QAFExtendedWebElement("MilestoneNameComponentViewCell").sendKeys("London");
		new QAFExtendedWebElement("mile.next").click();

		// Add details to Milestone
		new QAFExtendedWebElement("mile.start").click();
		new QAFExtendedWebElement("mile.year").click();
		new QAFExtendedWebElement("mile.amount").sendKeys("5000");

		Map<String, Object> params = new HashMap<>();
		params.put("content", "Add Milestone");
		DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
		// validate milestone created
		new QAFExtendedWebElement("milestones.page").isDisplayed();
		new QAFExtendedWebElement("milestone.created").isDisplayed();
	}

	@Then("delete milestone")
	public void deleteMilestone() {
		new QAFExtendedWebElement("milestone.created").click();
		Map<String, Object> params = new HashMap<>();
		params.put("content", "Edit");
		DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);

		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "remove this milestone");
		params2.put("next", "SWIPE_UP");
		params2.put("scrolling", "scroll");
		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
		new QAFExtendedWebElement("milestone.delete").click();
		new QAFExtendedWebElement("milestone.delete.confirm").click();
		new QAFExtendedWebElement("home").click();
		UBSUtils.validateShortHomePage();

	}

	@Then("validate relationship")
	public void validateRelationship() {
		Relationship relationshipScreen = new Relationship();
		relationshipScreen.validate();
	}

	@Then("validate mindset")
	public void validateMindset() {
		Mindset mindsetScreen = new Mindset();
		mindsetScreen.validate();
	}

	@Then("Validate Statement and Tax Forms")
	public void statementAndTaxForms() {
		StatementTax statementAndTaxFormsScreen = new StatementTax();
		statementAndTaxFormsScreen.validate();
	}
	// Validate Statement and Tax Forms

	@Then("check settings")
	public void validateSettings() {
		Settings settingsScreen = new Settings();
		settingsScreen.validate();
	}

	@Then("get support")
	public void getSupport() {
		Support supportScreen = new Support();
		supportScreen.validate();
	}

	@Then("check feedback")
	public void checkFeedback() {
		Feedback feedbackScreen = new Feedback();
		feedbackScreen.validate();
	}

	@Then("check Legal services")
	public void checkLegalServices() {
		LegalServices legalServicesScreen = new LegalServices();
		legalServicesScreen.validate();
	}

	@Then("contact financial advisor")
	public void contactAdvisor() {
		ContactAdvisor contactAdvisorScreen = new ContactAdvisor();
		contactAdvisorScreen.validate();
	}

	@Then("validate profile")
	public void validateProfile() {
		Profile profileScreen = new Profile();
		profileScreen.validate();
	}

	@Then("logout of CDX")
	public void logoutCDX() {

		Logout logoutScreen = new Logout();
		logoutScreen.perform();
	}

}
