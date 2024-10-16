package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import static com.quantum.utils.QAFDriverUtils.click;

import java.util.HashMap;
import java.util.Map;

public class Settings extends UBSScreen {
    @Override
    public void iphone() {

        if(!isIPhone()) return;

        // Relationship
        UBSCommonSteps.openMenu();

        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Settings");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        new QAFExtendedWebElement("settings.reset").isDisplayed();

        UBSCommonSteps.openMenu();
    }

    @Override
    public void android() {

        if(!isAndroid()) return;

        // Relationship
        UBSCommonSteps.openMenu();

        click("menu.settings");
      
        
        Map<String, Object> params22 = new HashMap<>();
        params22.put("content", "Reset Username");
        params22.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params22);
        
       
        UBSCommonSteps.navigateToHome();
		UBSUtils.validateShortHomePage();
    }

    @Override
    public void ipad() {
    	if(!isIPad()) return;

        new QAFExtendedWebElement("iPadSettings").click();
        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Settings");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        
        Map<String, Object> params22 = new HashMap<>();
        params22.put("content", "Reset Password");
        params22.put("threshold", "90");
        params22.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params22);
        
        
        //new QAFExtendedWebElement("settings.reset").isDisplayed();
        new QAFExtendedWebElement("information").click();
        
        Map<String, Object> params3 = new HashMap<>();
        params3.put("label", "information");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params3);
    }
}
