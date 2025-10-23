package com.quantum.ubs.screens.menu;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.CommonStep;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSCommonSteps;

public class Logout extends UBSScreen {

    public void iphone(){

        if (!isIPhone()) return;

        // If iPhone Menu needs to be Open
        //UBSCommonSteps.openMenu();
        CommonStep.waitForVisible("main.sign.out");
        QAFDriverUtils.click("main.sign.out");
    }

    public void android(){

        if (!isAndroid()) return;

        // If android Menu needs to be Open
        UBSCommonSteps.openMenu();
        //QAFDriverUtils.click("main.sign.out");
        
        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }

        
        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Sign out");
        params2.put("timeout", "30");
        params2.put("threshold", "100");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

    }
    public void perform(){

        iphone();
        android();
        // Click on Logout
        if (!isAndroid()) {
        	// QAFDriverUtils.click("main.sign.out");
        }
       
    }
}
