package com.quantum.ubs.screens.menu;

import static com.quantum.utils.QAFDriverUtils.click;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;

public class Relationship extends UBSScreen {

    public void navigateToRelationshipIphone(){

        if (!isIPhone()) return;

        // Open the menu
        UBSCommonSteps.openMenu();

        // Open Relationship
        click("profile.relationship");
    }
    
    public void navigateToRelationshipAndroid(){

        if (!isAndroid()) return;

        // Open the menu
        UBSCommonSteps.openMenu();

        // Open Relationship
        click("profile.relationship");
    }

    public void iphone(){
        if (!isIPhone()) return;

        // Navigate to Relationship Screen
        navigateToRelationshipIphone();

        // Check whether Primary Email is Displayed
        boolean isPresent = CommonStep.verifyVisible("relationship.community");
        assertTrue(isPresent,"Relationship Community is not present upon navigating to Menu > Relationship.");

        // Navigate the Relationship team
        click("relationship.team");

        // Verify advice is displayed
        isPresent = CommonStep.verifyVisible("relationship.advice");
        assertTrue(isPresent,"Relationship Advice is not present upon navigating to Menu > Relationship.");

        // Open Menu
        UBSCommonSteps.openMenu();

    }

    public void ipad(){
        if (!isIPad()) return;
        new QAFExtendedWebElement("profile.relationship").click();
        Map<String, Object> params8 = new HashMap<>();
        params8.put("label", "relationships");
        params8.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params8);
        // close to me

        // external professionals
//        click("external.pro");
//        new QAFExtendedWebElement("external.pro").click();
        Map<String, Object> params = new HashMap<>();
        params.put("label", "External Professionals");
        params.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
        
        Map<String, Object> params1 = new HashMap<>();
        params1.put("label", "Community");
        params1.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params1);
        
//        click("relationship.community");
//        new QAFExtendedWebElement("relationship.community").click();
        
        
//        click("community.bsa");
       ////////// new QAFExtendedWebElement("community.bsa").isDisplayed();
        // new QAFExtendedWebElement("profile.team").click();

        Map<String, Object> params3 = new HashMap<>();
        params3.put("label", "UBS Team");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params3);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("content", "UBS Wealth Advice");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
        new QAFExtendedWebElement("close.tome").click();

    }
}
