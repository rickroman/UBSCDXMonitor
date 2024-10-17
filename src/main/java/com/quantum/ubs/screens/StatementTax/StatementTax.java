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

		if (!isIPad())
			return;

	}

	@Override
	public void iphone() {

		if (!isIPhone())
			return;

		UBSCommonSteps.openMenu();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CommonStep.click("main.statementtax");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> params454 = new HashMap<>();
		params454.put("label", "Tax Forms");
		params454.put("source", "camera");
		params454.put("timeout", "40");
		params454.put("threshold", "90");
		params454.put("label.direction", "left");
		params454.put("label.offset", "70%");
		params454.put("screen.top", "12%");
		params454.put("screen.left", "0%");
		params454.put("screen.height", "28%");
		params454.put("screen.width", "100%");
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params454);

		
		//CommonStep.click("statementtax.taxforms");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.AllOf2Accounts");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Error 3-15-24 CommonStep.assertVisible("statementtax.account");

		//CommonStep.assertVisible("statementtax.liqiudity");
		
		CommonStep.click("statementtax.back");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CommonStep.assertVisible("statementtax.AllOf2Accounts");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CommonStep.assertVisible("statementtax.accountstatement");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.accountstatement");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//CommonStep.assertVisible("statementtax.account");

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//CommonStep.click("statementtax.ccstatements");

		CommonStep.assertVisible("statementtax.houseStateWSummary");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//CommonStep.click("statementtax.back");


		CommonStep.click("statementtax.houseStateWSummary");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//CommonStep.assertVisible("statementtax.account");

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.houseStaSummary");

		//CommonStep.assertVisible("statementtax.account");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		// WE ENCOUNTERED an ERROR
		
		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.assertVisible("statementtax.commodityFX");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CommonStep.click("statementtax.commodityFX");

		//CommonStep.assertVisible("statementtax.account");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.verifyPresent("home");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonStep.click("home");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		UBSUtils.validateShortHomePage();
	}

	public void android() {

		if (!isAndroid())
			return;

		UBSCommonSteps.openMenu();

		CommonStep.click("main.statementtax");
		CommonStep.click("statementtax.taxforms");

		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", "UN 91973");
		params1.put("source", "camera");
		params1.put("timeout", "20");
		params1.put("threshold", "90");
		Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		// VG 91734

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.accountstatement");

		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//CommonStep.click("statementtax.ccstatements");

		//DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		//CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.houseStateWSummary");

		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.houseStaSummary");

		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		CommonStep.click("statementtax.back");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CommonStep.click("statementtax.commodityFX");

		DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

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

}
