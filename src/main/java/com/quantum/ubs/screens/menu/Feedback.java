package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends UBSScreen {

    @Override
    public void ipad() {
        if(!isIPad()) return;
        new QAFExtendedWebElement("feedback").click();
        Map<String, Object> params3 = new HashMap<>();
        params3.put("content", "tell us what you think");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);
        new QAFExtendedWebElement("feedback.cancel").click();

        new QAFExtendedWebElement("profile.return").click();

        Map<String, Object> params4 = new HashMap<>();
        params4.put("label", "PUBLIC:monitoring/ipad_home.png");
        params4.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);
        UBSUtils.validateShortHomePage();
    }

    @Override
    public void iphone() {
        if(!isIPhone()) return;

        UBSCommonSteps.openMenu();

        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Feedback");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

        Map<String, Object> params3 = new HashMap<>();
        params3.put("content", "tell us what you think");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

        new QAFExtendedWebElement("feedback.send").click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
