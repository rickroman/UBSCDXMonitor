package com.quantum.utils;


import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
import static com.quantum.utils.QAFDriverUtils.click;
import static com.quantum.utils.QAFDriverUtils.launchApp;
import static com.quantum.utils.QAFDriverUtils.setValue;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

import cucumber.api.java.en.Then;

public class UBSCommonSteps {
	
	public static void login(String userName, String password) {
		
		if (!isIPhone()) {
			
			// enter credentials
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "Username");
			DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params1);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Map<String, Object> params = new HashMap<>();
			params.put("label", "Username");
			params.put("text", userName);
			params.put("timeout", "20");
			params.put("threshold", "90");
			params.put("label.direction", "above");
			params.put("label.offset", "3%");
			Object result = DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params);

			//new QAFExtendedWebElement("field.password").click();
			
			  Map<String, Object> params4 = new HashMap<>(); 
			  params4.put("label", "Password"); params4.put("text", password); 
			  params4.put("timeout", "20"); params4.put("threshold", "90"); 
			  //params4.put("label.direction","above"); //params4.put("label.offset", "3%");
			  //DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params4);
			  DeviceUtils.getQAFDriver().executeScript("mobile:edit-text:set", params4);
			
		}else {
			
			click("login.signin.btn");
			
			// Set User Name
			setValue("xpath", "//*[@value='Username']", userName);
			
	    	click("login.next.iphone");
	    	
	    	// Set Password
			setValue("xpath", "//XCUIElementTypeSecureTextField", password);
			
		

		
		}

    	// Click on Sign in
    	click("login.signin.btn");
    	
    	// If Setup Face ID prompt is present dismiss it
//    	if(isOptionalElementPresent("login.Not.Now")) {
//    		QAFDriverUtils.click("login.Not.Now");
//			if(isOptionalElementPresent("login.OK.got.it")){
//				QAFDriverUtils.click("login.OK.got.it");
//			}
//    	}
		
	}
	
	public static boolean isIPhone() {
		return UBSUtils.getModel().equals("iphone");
	}
	
	public static void openMenu() {
		
		String model = DeviceUtils.getDeviceProperty("model");
		if (model.equalsIgnoreCase("iPhone-15 Pro Max")) {
			click("menu.iphone");
		} else if(model.equalsIgnoreCase("iPhone-16 Pro Max")) {
			//click("menu.iphone");
		} else if(model.equalsIgnoreCase("Galaxy S24 Ultra")) {
			click("menu.android");
		} else {
			click("menu.android");
		}
		
		
		CommonStep.waitForVisible("main.sign.out");
	}

	
	
	public static void navigateToHome() {
		click("home");
	}

}
