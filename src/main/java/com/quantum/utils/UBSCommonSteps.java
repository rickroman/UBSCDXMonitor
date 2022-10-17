package com.quantum.utils;


import static com.quantum.utils.QAFDriverUtils.*;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class UBSCommonSteps {
	
	public static void login(String userName, String password) {

		click("login.signin.btn");
				
		// Set User Name
		setValue("xpath", "//*[@value='Username']", userName);
		
    	click("login.next.iphone");
    	
    	// Set Password
		setValue("xpath", "//XCUIElementTypeSecureTextField", password);

    	// Click on Sign in
    	click("login.signin.btn");
    	
    	// If Setup Face ID prompt is present dismiss it
//    	if(isOptionalElementPresent("login.Not.Now")) {
//    		QAFDriverUtils.click("login.Not.Now");
//			if(isOptionalElementPresent("login.OK.got.it")){
//				QAFDriverUtils.click("login.OK.got.it");
//			}
//    	}

		String locator = ConfigurationManager.getBundle().getString("login.Not.Now");

		System.out.println(locator);

    	// Assert Home Screen is displayed
    	CommonStep.assertPresent("main.net.balance");
		
	}
	
	public static boolean isIPhone() {
		return UBSUtils.getModel().equals("iphone");
	}
	
	public static void openMenu() {
		click("menu.iphone");
	}

	public static void navigateToHome() {
		click("home");
	}

}
