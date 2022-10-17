package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import java.util.HashMap;
import java.util.Map;

public class ContactAdvisor extends UBSScreen {

    public void iphone(){

        if(!isIPhone()) return;
        UBSCommonSteps.openMenu();
        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "contact financial advisor");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

        Map<String, Object> params3 = new HashMap<>();
        params3.put("content", "toll free");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

        Map<String, Object> params4 = new HashMap<>();
        params4.put("label", "Close");
        params4.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ipad(){
        if(!isIPad()) return;
        new QAFExtendedWebElement("contact").click();
        new QAFExtendedWebElement("tollfree").isDisplayed();
        new QAFExtendedWebElement("close").click();
        UBSUtils.validateShortHomePage();
    }



}
