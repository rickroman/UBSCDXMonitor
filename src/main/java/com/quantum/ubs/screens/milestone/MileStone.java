package com.quantum.ubs.screens.milestone;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSUtils;

public class MileStone extends UBSScreen {

	@Override
	public void ipad() {
		
		if (!isIPad()) return;
		
		
		new QAFExtendedWebElement("main.ipad.milestone").click();
		
		
		CommonStep.verifyVisible("mile.scouts");
		
		//CommonStep.verifyVisible("mile.bsa");
		

		// click on article - Currently no articles so I am excluding this RR-1-31-23
		/*
		 * Map<String, Object> params2 = new HashMap<>(); params2.put("label",
		 * "Resources"); params2.put("ignorecase", "case"); params2.put("timeout", 30);
		 * params2.put("label.direction", "Above"); params2.put("label.offset", "9%");
		 */
		//DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Currently no articles so I am excluding this RR-1-31-23
		//CommonStep.click("xbutton");
		//CommonStep.click("mile.back");
		
		CommonStep.assertVisible("milestones.page");
		
		/*
		 * Map<String, Object> params = new HashMap<>();
		 * params.put("label","PUBLIC:monitoring/milestones_ipad_back.png");
		 * params.put("timeout", "30");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click",
		 * params); new QAFExtendedWebElement("retirement").isDisplayed(); try {
		 * Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
		 * 
		 */
		
		
		CommonStep.click("home");
		
		/*
		 * Map<String, Object> params5 = new HashMap<>(); params5.put("label", "home");
		 * params5.put("timeout", "30");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
		 * params5);
		 */
		
		UBSUtils.validateShortHomePage();
		
	}

	@Override
	public void iphone() {
		
		 if (!isIPhone()) return;
		
		CommonStep.click("main.milestones");
		CommonStep.assertVisible("mile.scouts");
		
		//CommonStep.assertVisible("mile.bsa");
		//CommonStep.assertVisible("mile.resources");
		
		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "11 per year");
		//params2.put("scrolling", "scroll");
		//params2.put("next", "SWIPE=(50%,50%),(50%,30%)");
		params2.put("threshold", "80");
		params2.put("timeout", "30");

		boolean checkPointResult = checkPointTextVisual(params2);

		System.out.println(checkPointResult);
		
		// click on article
		System.out.println("milestone article");
		
//		CommonStep.click("activity.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * Map<String, Object> params = new HashMap<>(); params.put("label", "done");
		 * params.put("timeout", 30); params.put("screen.top", "0%");
		 * params.put("screen.height", "13%"); params.put("screen.width", "100%");
		 * params.put("screen.left", "0%");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
		 */
		//CommonStep.click("iphone.activity.back");
		
		CommonStep.verifyPresent("home");
		
		CommonStep.click("home");
		
		UBSUtils.validateShortHomePage();
	}

	public void android() {
		
		 if (!isAndroid()) return;
		 
		
		CommonStep.click("main.milestones");
		
		for (int i = 0; i < 5; i++) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("start", ",50%,15%");
			params1.put("end", "50%,85%");
			params1.put("duration", "0");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1);
		}
		
		CommonStep.click("mile.scouts");
		
		//CommonStep.assertVisible("mile.bsa");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		
		for (int i = 0; i < 5; i++) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("start", ",50%,15%");
			params1.put("end", "50%,85%");
			params1.put("duration", "0");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1);
		}
		
		System.out.println("milestone article");
		
//		CommonStep.click("activity.back");
		
		for (int i = 0; i < 5; i++) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("start", ",50%,15%");
			params1.put("end", "50%,85%");
			params1.put("duration", "0");
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1);
		}
		
		Map<String, Object> params2 = new HashMap<>();
		params2.put("label", "donation to the scouts");
		params2.put("timeout", 30);
		params2.put("label.direction", "Above");
		params2.put("label.offset", "35%");

		//DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * Map<String, Object> params = new HashMap<>(); params.put("label", "done");
		 * params.put("timeout", 30); params.put("screen.top", "0%");
		 * params.put("screen.height", "13%"); params.put("screen.width", "100%");
		 * params.put("screen.left", "0%");
		 * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
		 */
		CommonStep.click("android.activity.back");
		
		CommonStep.verifyPresent("home");
		
		CommonStep.click("home");
		
		UBSUtils.validateShortHomePage();
	}

}
