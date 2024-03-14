package com.quantum.ubs.screens.menu;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.utils.QAFDriverUtils.*;
import static org.testng.Assert.assertTrue;

public class Profile extends UBSScreen {

    public void validate(){
        iphone();
        ipad();
        android();
    }

    public void iphone(){
        if (!isIPhone()) return;

        // Open the menu
        UBSCommonSteps.openMenu();

        // Navigate to My Information
        click("profile.my.information");
        
        Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "ubs.com");
		params2.put("scrolling", "scroll");
		params2.put("next", "SWIPE=(50%,50%),(50%,30%)");
		params2.put("maxscroll", "11");

		boolean isPresent = checkPointTextVisual(params2);


        // Check whether Primary Email is Displayed
         //isPresent = CommonStep.verifyVisible("profile.iphone.primary");
        assertTrue(isPresent,"Primary Email is not present upon navigating to Menu > My Information.");

        // Navigate to Relationship screen
        new Relationship().navigateToRelationshipIphone();

        // Open Team
        click("profile.iphone.team");

        // Verify Advice is displayed
       // isPresent = CommonStep.verifyVisible("profile.iphone.advice");
        
        Map<String, Object> params24 = new HashMap<>();
		params24.put("content", "ubs.com");
		params24.put("scrolling", "scroll");
		params24.put("next", "SWIPE=(50%,50%),(50%,30%)");
		params24.put("maxscroll", "11");

		 isPresent = checkPointTextVisual(params24);
		
        assertTrue(isPresent,"UBS Advisory team is not present upon navigating to Menu > Relationship > UBS Teams.");

        // Navigate to Home
        UBSCommonSteps.navigateToHome();

        UBSUtils.validateShortHomePage();

    }

    public void android(){
        if (!isAndroid()) return;

        // Open the menu
        UBSCommonSteps.openMenu();

        // Navigate to My Information
        click("profile.my.information");

        // Check whether Primary Email is Displayed
        //boolean isPresent = CommonStep.verifyVisible("profile.android.primary");
        
        Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "ubs.com");
		params2.put("scrolling", "scroll");
		params2.put("next", "SWIPE=(50%,50%),(50%,30%)");
		params2.put("maxscroll", "11");

		boolean isPresent = checkPointTextVisual(params2);

        
        assertTrue(isPresent,"Primary Email is not present upon navigating to Menu > My Information.");

        // Navigate to Relationship screen
        
        new Relationship().navigateToRelationshipAndroid();

        // Open Team
        click("profile.android.team");

        // Verify Advice is displayed
        Map<String, Object> params7 = new HashMap<>();
		params7.put("content", "Chris");
		params7.put("source", "camera");
		params7.put("timeout", "30");
		params7.put("threshold", "90");
		isPresent = checkPointTextVisual(params7);
        //isPresent = CommonStep.verifyVisible("profile.android.advice");
        assertTrue(isPresent,"UBS Advisory team is not present upon navigating to Menu > Relationship > UBS Teams.");

        // Navigate to Home
        UBSCommonSteps.navigateToHome();

        UBSUtils.validateShortHomePage();

    }


    public void ipad(){
        if (!isIPad()) return;

        click("main.profile");

        Map<String, Object> params5 = new HashMap<>();
        params5.put("label", "Profile");
        params5.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);

        new QAFExtendedWebElement("profile.primary").isDisplayed();
        /*
         * // meeting window new QAFExtendedWebElement("profile.meetings").click(); new
         * QAFExtendedWebElement("profile.no.meeting").isDisplayed();
         *
         * // new QAFExtendedWebElement("profile.back").click(); new
         * QAFExtendedWebElement("main.profile").click();
         */
        // card
        new QAFExtendedWebElement("profile.settings").click();
        Map<String, Object> params1 = new HashMap<>();
        params1.put("label", "Settings");
        params1.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params1);
        new QAFExtendedWebElement("ipad.card.security").click();
        new QAFExtendedWebElement("profile.nocard").isDisplayed();
        new QAFExtendedWebElement("ipad.setttings.close").click();
        new QAFExtendedWebElement("main.profile").click();
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);
    }
}
