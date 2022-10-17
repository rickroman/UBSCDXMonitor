package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;

import java.util.HashMap;
import java.util.Map;

public class Mindset extends UBSScreen {

    @Override
    public void iphone() {
        if(!isIPhone()) return;

        UBSCommonSteps.openMenu();

        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Mindset and Interests");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        new QAFExtendedWebElement("interest").isDisplayed();

        UBSCommonSteps.openMenu();
    }

    @Override
    public void ipad() {
        if(!isIPad()) return;

        new QAFExtendedWebElement("mindset").click();
        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Mindset and Interests");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        new QAFExtendedWebElement("mindset.msg").isDisplayed();
    }
}
