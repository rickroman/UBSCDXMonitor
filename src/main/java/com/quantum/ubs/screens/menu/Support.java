package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;

import java.util.HashMap;
import java.util.Map;

public class Support extends UBSScreen {

    @Override
    public void iphone() {
    	
        if(!isIPhone()) return;

        UBSCommonSteps.openMenu();
        
        CommonStep.click("iphone.menu.support");

//        Map<String, Object> params2 = new HashMap<>();
//        params2.put("label", "Support");
//        params2.put("timeout", "30");
//        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        
        // Wait for the Animated transformation to complete.
        try {Thread.sleep(2000);} catch (Exception e) {}

        
        CommonStep.verifyVisible("iphone.support.need.assistance");
//        Map<String, Object> params3 = new HashMap<>();
//        params3.put("content", "need assistance");
//        params3.put("timeout", "30");
//        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

        new QAFExtendedWebElement("support.close").click();

        /*
         * Map<String, Object> params4 = new HashMap<>();
         * params4.put("label","PUBLIC:monitoring/iphone11settings_x.png");
         * params4.put("timeout", "30");
         * DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click",
         * params4); new QAFExtendedWebElement("menu.iphone").click();
         */
    }

    @Override
    public void ipad() {
        if(!isIPad()) return;

        new QAFExtendedWebElement("support").click();
        
        
        Map<String, Object> params3 = new HashMap<>();
        params3.put("label", "support");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params3);
        
        // Waiting for Animation to complete
        try {Thread.sleep(2000);} catch (Exception e) {}
        new QAFExtendedWebElement("support.done").click();
    }
}
