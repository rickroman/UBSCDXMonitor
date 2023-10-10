package com.quantum.ubs.screens.StatementTax;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.CommonStep;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

public class StatementTax extends UBSScreen {

	@Override
	public void ipad() {
		
		if (!isIPad()) return;
		
		
	}

	@Override
	public void iphone() {
		
		 if (!isIPhone()) return;
		
		 UBSCommonSteps.openMenu();
		 
		CommonStep.click("main.statementtax");
		CommonStep.click("statementtax.taxforms");
		
		CommonStep.assertVisible("statementtax.account");
		
		// click on article
		//System.out.println("milestone article");
		
		CommonStep.click("statementtax.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		CommonStep.click("statementtax.accountstatement");
		
		CommonStep.assertVisible("statementtax.account");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		//System.out.println("milestone article");
		
		CommonStep.click("statementtax.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.ccstatements");
		
		CommonStep.assertVisible("statementtax.account");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		//System.out.println("milestone article");
		
		CommonStep.click("statementtax.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.houseStateWSummary");
		
		CommonStep.assertVisible("statementtax.account");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		//System.out.println("milestone article");
		
		CommonStep.click("statementtax.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

CommonStep.click("statementtax.houseStaSummary");
		
		CommonStep.assertVisible("statementtax.account");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		//System.out.println("milestone article");
		
		CommonStep.click("statementtax.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
CommonStep.click("statementtax.commodityFX");
		
		CommonStep.assertVisible("statementtax.account");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		//System.out.println("milestone article");
		
		CommonStep.click("statementtax.back");
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		
		CommonStep.verifyPresent("home");
		
		CommonStep.click("home");
		
		UBSUtils.validateShortHomePage();
	}

	public void android() {
		
		 if (!isAndroid()) return;
		
		CommonStep.click("main.milestones");
		CommonStep.click("mile.scouts");
		
		CommonStep.assertVisible("mile.bsa");
		//CommonStep.assertVisible("mile.resources");
		
		// click on article
		System.out.println("milestone article");
		
//		CommonStep.click("activity.back");
		
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
