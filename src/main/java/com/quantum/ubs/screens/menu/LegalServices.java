package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;

import java.util.HashMap;
import java.util.Map;

public class LegalServices extends UBSScreen {

    public void iphone(){

        if (!isIPhone()) return;
        new QAFExtendedWebElement("menu.iphone").click();
        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Legal and disclosures");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

        Map<String, Object> params3 = new HashMap<>();
        params3.put("content", "products and services described");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new QAFExtendedWebElement("legal.cancel").click();
        /*
         * Map<String, Object> params4 = new HashMap<>(); params4.put("label",
         * "Cancel"); params4.put("timeout", "30");
         * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
         * params4);
         */
    }

    public void ipad(){

    }
}
