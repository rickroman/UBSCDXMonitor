package com.quantum.steps;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;

import java.util.ArrayList;
import java.util.HashMap;
//import javafx.scene.web.WebView;
import java.util.Map;

import org.openqa.selenium.By;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@QAFTestStepProvider
public class AdviceStepDefs {

	private static final String Secured_adv_uname = "secured.Gq+WQTu1bIsFqdtmCCyvdQ==";
	private static final String Secured_adv_pw = "secured.59XoQmXOn/GqOP4JMypzFg==";

	@When("Advice Login to CDX")
	public void adviceLoginCDX() {

		String model = UBSUtils.getModel().toString();

		if (model.equals("iphone")) {
			// declare the Map for script parameters
			Map<String, Object> params = new HashMap<>();
			params.put("text", Secured_adv_uname);
			params.put("by", "xpath");
			params.put("value", "//*[@value=\"Username\"]");
			DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);

			new QAFExtendedWebElement("login.next.iphone").click();
			// new QAFExtendedWebElement("field.password.iphone").click();

			Map<String, Object> params4 = new HashMap<>();
			params4.put("text", Secured_adv_pw);
			params4.put("by", "xpath");
			params4.put("value", "//XCUIElementTypeSecureTextField");
			DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);

			new QAFExtendedWebElement("login.signin.btn").click();
			// 2 validations of home page loading
			UBSUtils.declineFaceID();
			//UBSUtils.declineTaxDocs();
			//UBSUtils.clearImportantNotice();
			//UBSUtils.declineMarketClosures();
			UBSUtils.validateHomePage();
			

		} else if (model.equalsIgnoreCase("android")) {

			UBSCommonSteps.login(Secured_adv_uname, Secured_adv_pw);

			/*
			 * Map<String, Object> params = new HashMap<>(); params.put("text",
			 * Secured_adv_uname); params.put("by", "xpath"); params.put("value",
			 * "//*[@label=\"Username\"]");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set",
			 * params);
			 * 
			 * new QAFExtendedWebElement("login.next.android").click(); // new
			 * QAFExtendedWebElement("field.password.iphone").click();
			 * 
			 * Map<String, Object> params4 = new HashMap<>(); params4.put("text",
			 * Secured_adv_pw); params4.put("by", "xpath"); params4.put("value",
			 * "//XCUIElementTypeSecureTextField");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set",
			 * params4);
			 * 
			 * new QAFExtendedWebElement("login.signin.btn").click();
			 */
			// 2 validations of home page loading

			UBSUtils.declineFaceID();
			UBSUtils.declineTaxDocs();
			//UBSUtils.clearImportantNotice();
			//UBSUtils.declineMarketClosures();
			UBSUtils.validateHomePage();
		} else {
			Map<String, Object> params = new HashMap<>();
			params.put("content", "Username");
			DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Map<String, Object> params3 = new HashMap<>();
			params3.put("text", Secured_adv_uname);
			params3.put("by", "xpath");
			params3.put("value", "//XCUIElementTypeTextField");
			DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params3);

			// new QAFExtendedWebElement("field.username").sendKeys("securetest66");
			new QAFExtendedWebElement("login.next").click();

			Map<String, Object> params4 = new HashMap<>();
			params4.put("text", Secured_adv_pw);
			params4.put("by", "xpath");
			params4.put("value", "//XCUIElementTypeSecureTextField");
			DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);

			// new QAFExtendedWebElement("field.password").sendKeys("cantGue33");
			new QAFExtendedWebElement("login.signin.btn").click();

			// 2 validations of home page loading
			UBSUtils.declineFaceID();
			//UBSUtils.clearImportantNotice();
			UBSUtils.declineTaxDocs();
			UBSUtils.validateHomePage();
		}

	}

	@Then("Check Advice Section")
	public void checkAdvice() {

		randomlySelectAdvantage();
		// new QAFExtendedWebElement("advice.portfolio.guidance").isDisplayed();
		// new QAFExtendedWebElement("advice.portfolio.guidance").click();

		String model = UBSUtils.getModel().toString();

		if (model.equals("android")) {
			Map<String, Object> params3 = new HashMap<>();
			params3.put("content", "Explore UBS Advice Advantage");
			params3.put("timeout", "30");
			params3.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

			// new QAFExtendedWebElement("zero.accounts").click();

			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "1 of 7 Accounts Analyzed");
			params4.put("timeout", "30");
			params4.put("threshold", "85");
			ArrayList genericOptions1 = new ArrayList();
			genericOptions1.add("natural-language=true");
			params4.put("ocr", genericOptions1);
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);

			Map<String, Object> params5 = new HashMap<>();
			params5.put("content", "Select accounts to include");
			params5.put("timeout", "30");
			params5.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params5);
			
			////////////////////////////////////////////////////////
			
			new QAFExtendedWebElement("advice").click();
			
			Map<String, Object> editRisk = new HashMap<>();
			editRisk.put("label", "UBS Advice Portfolio Program");
			editRisk.put("threshold", "80");
			editRisk.put("timeout", "40");

			editRisk.put("ignorecase", "nocase");
			editRisk.put("words", "words");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", editRisk);

			
			new QAFExtendedWebElement("advice").click();
			new QAFExtendedWebElement("adviceMenuChoice").click();
		

			/*
			 * Map<String, Object> params45 = new HashMap<>(); params45.put("content",
			 * "Cancel"); //params45.put("timeout", "30"); params45.put("threshold", "90");
			 * params45.put("scrolling", "scroll"); params45.put("next",
			 * "SWIPE=(50%,85%),(50%,55%)");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params45);
			 */
			
			/*
			 * for (int i = 0; i < 2; i++) { Map<String, Object> params1 = new HashMap<>();
			 * params1.put("start", "50%,75%"); params1.put("end", "50%,35%");
			 * params1.put("duration", "0"); Object result1 =
			 * DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1); }
			 */

			/*
			 * Map<String, Object> params7 = new HashMap<>(); params7.put("content",
			 * "Cancel"); params7.put("scrolling", "scroll"); params7.put("next",
			 * "SWIPE=(50%,85%),(50%,55%)");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params7);
			 */
			/*
			 * Map<String, Object> params6 = new HashMap<>(); params6.put("label",
			 * "Cancel"); //params6.put("scrolling", "scroll"); params6.put("timeout",
			 * "30"); params6.put("next", "SWIPE=(50%,85%),(50%,55%)");
			 * 
			 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
			 * params6);
			 */
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

		} else {
			new QAFExtendedWebElement("explore.advice").isDisplayed();
			//new QAFExtendedWebElement("zero.accounts").click();
			
			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "1 of 1 Accounts Analyzed");
			params4.put("timeout", "30");
			params4.put("threshold", "80");
			ArrayList genericOptions1 = new ArrayList();
			genericOptions1.add("natural-language=true");
			params4.put("ocr", genericOptions1);
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);

			
			new QAFExtendedWebElement("select.accounts").isPresent();

			
			
			for (int i = 0; i < 1; i++) {
				Map<String, Object> params1 = new HashMap<>();
				params1.put("start", ",50%,45%");
				params1.put("end", "50%,40%");
				params1.put("duration", "0");
				Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1);
			}
			
			
			
			Map<String, Object> params3 = new HashMap<>();
			params3.put("content", "Cancel");
			//params3.put("scrolling", "scroll");
			//params3.put("next", "SWIPE=(50%,65%),(50%,35%)");
			params3.put("timeout", "30");
			params3.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);
			new QAFExtendedWebElement("advice.bottomCancel").click();
			new QAFExtendedWebElement("explore.advice").isDisplayed();
		}

	}

	@Then("Navigate advice advantage")
	public void navigateAdvice() {

		String model = UBSUtils.getModel().toString();

		if (model.equals("android")) {
			System.out.println(DeviceUtils.getCurrentContextHandles());

			Map<String, Object> editRisk = new HashMap<>();
			editRisk.put("label", "Edit Risk");
			//editRisk.put("label", "Test Failure");
			editRisk.put("threshold", "80");
			editRisk.put("ignorecase", "nocase");
			editRisk.put("words", "words");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", editRisk);

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Map<String, Object> params7 = new HashMap<>();
			params7.put("content", "When thinking about risk");
			params7.put("timeout", "45");
			params7.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params7);
			
			//new QAFExtendedWebElement("advice.riskClose").click();
			
			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "PUBLIC:CloseRisk_X_S24.png");
			params1.put("timeout", "45");
			params1.put("threshold", "90");
			params1.put("screen.top", "7%");
			params1.put("screen.height", "10%");
			params1.put("screen.width", "100%");
			params1.put("screen.left", "0%");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params1);

			Map<String, Object> params3 = new HashMap<>();
			params3.put("content", "Contact your financial advisor");
			params3.put("scrolling", "scroll");
			params3.put("next", "SWIPE=(50%,55%),(50%,20%)");
			params3.put("maxscroll", 12);
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "Contact your financial advisor");
			params4.put("timeout", "30");
			params4.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);

			Map<String, Object> params6 = new HashMap<>();
			params6.put("content", "Toll Free");
			params6.put("timeout", "30");
			params6.put("threshold", "90");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params6);

			//PUBLIC:CloseRisk_X_iPhone15.png
			
			
			new QAFExtendedWebElement("advisor.close").click();

			new QAFExtendedWebElement("home").click();
			
		

		} else  {

			System.out.println(DeviceUtils.getCurrentContextHandles());

//        Map<String, Object> params2 = new HashMap<>();
//            params2.put("label","Edit Risk Tolerance");
//        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
			
			
			new QAFExtendedWebElement(By.name("Edit Risk Tolerance has popup, link"));

			Map<String, Object> editRisk = new HashMap<>();
			editRisk.put("label", "Edit Risk Tolerance");
			editRisk.put("threshold", "80");
			editRisk.put("timeout", "60");
			editRisk.put("ignorecase", "nocase");
			editRisk.put("words", "words");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", editRisk);

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Map<String, Object> params6 = new HashMap<>();
			params6.put("content", "When thinking about");
			params6.put("timeout", "30");
			params6.put("threshold", "90");
			boolean thinking = checkPointTextVisual(params6);
					//DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params6);


			if (thinking) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "PUBLIC:CloseRisk_X_iPhone16.png");
			params1.put("timeout", "45");
			params1.put("threshold", "90");
			params1.put("screen.top", "7%");
			params1.put("screen.height", "10%");
			params1.put("screen.width", "100%");
			params1.put("screen.left", "0%");
			DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params1);
			}
			
			Map<String, Object> params3 = new HashMap<>();
			params3.put("content", "Contact your financial advisor");
			params3.put("scrolling", "scroll");
			params3.put("next", "SWIPE=(50%,85%),(50%,55%)");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			new QAFExtendedWebElement("adv.advisor").click();

			/*
			 * Map<String, Object> params22 = new HashMap<>();
			 * params22.put("label","Contact your financial advisor");
			 * params22.put("timeout", "40");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
			 * params22);
			 */
			// RJR

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// tap 562 2239

			/*
			 * Map<String, Object> params3 = new HashMap<>();
			 * params3.put("location","663,2061,663,2061");
			 * DeviceUtils.getQAFDriver().executeScript("mobile:touch:tap", params3);
			 */

			// new QAFExtendedWebElement("adv.advisor").click();
			Map<String, Object> params4 = new HashMap<>();
			params4.put("content", "Direct");
			params4.put("threshold", "80");
			params4.put("timeout", "35");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params4);

			new QAFExtendedWebElement("advisor.close").click();

			new QAFExtendedWebElement("home").click();

		}
	}

	private void randomlySelectAdvantage() {

		//int coin = coinToss();
		int coin = 0;
		System.out.println("coin came up:" + coin);

		switch (coin) {
		case 0:
			 try {
		            Thread.sleep(7000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			 
			new QAFExtendedWebElement("advice").click();
			new QAFExtendedWebElement("adviceMenuChoice").click();
			// *[@name="SelectionItem_1"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]

			break;
		case 1:
			
			 try {
		            Thread.sleep(7000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "View and manage account(s)");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,85%),(50%,55%)");
			DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

			 try {
		            Thread.sleep(4000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			 
			new QAFExtendedWebElement("advice").click();
			
			 try {
		            Thread.sleep(4000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

			new QAFExtendedWebElement("adviceMenuChoice").click();

			break;
		default:
			// code block

		}

	}

	public static int coinToss() {
		int min = 0;
		int max = 1;
		// Generate random double value from 50 to 100
		System.out.println("Random value in double from " + min + " to " + max + ":");
		double random_double = Math.random() * (max - min + 1) + min;
		System.out.println(random_double);

		// Generate random int value from 50 to 100
		System.out.println("Random value in int from " + min + " to " + max + ":");
		int random_int = (int) (Math.random() * (max - min + 1) + min);
		System.out.println(random_int);
		return random_int;
	}

}
