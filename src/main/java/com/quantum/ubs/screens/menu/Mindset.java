package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

public class Mindset extends UBSScreen {

    @Override
    public void iphone() {
        if(!isIPhone()) return;

        UBSCommonSteps.openMenu();
        
        
        new QAFExtendedWebElement("mindset").click();

//        Map<String, Object> params2 = new HashMap<>();
//        params2.put("label", "Mindset and Interests");
//        params2.put("timeout", "30");
//        
//        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        
        
        new QAFExtendedWebElement("interest").isDisplayed();

        UBSCommonSteps.openMenu();
    }
    
    @Override
    public void android() {
        if(!isAndroid()) return;

        UBSCommonSteps.openMenu();
        
        
        new QAFExtendedWebElement("mindset").click();

//        Map<String, Object> params2 = new HashMap<>();
//        params2.put("label", "Mindset and Interests");
//        params2.put("timeout", "30");
//        
//        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        
        
        //new QAFExtendedWebElement("interest").isDisplayed();
        Map<String, Object> params2 = new HashMap<>();
        params2.put("content", "Has your perspective");
        params2.put("timeout", "30");
        params2.put("threshold", "90");
        boolean isPresent = checkPointTextVisual(params2);

        assertTrue(isPresent, "Has your perspective changed is not on the screen");
        
       
         

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
