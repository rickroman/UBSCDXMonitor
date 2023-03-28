package com.quantum.ubs.screens.accounts;

import com.qmetry.qaf.automation.step.CommonStep;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSUtils;

import static com.quantum.utils.QAFDriverUtils.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class Balance extends UBSScreen {

    public static void switchToUBSTab(){
    	String model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("Galaxy S22 Ultra")) {
			//android
    	try {
    		CommonStep.waitForPresent("android.intraday", 10);
    	}catch(Exception e) {
    		
    		 click("android.ubs");
    	}
		} else {
			//iPhone
			try {
	    		CommonStep.waitForPresent("iphone.intraday", 10);
	    	}catch(Exception e) {
	    		
	    		 click("iphone.ubs");
	    	}
		}
        //if(!QAFDriverUtils.isOptionalElementPresent("iphone.intraday")){
           
       // }
    }

    public void iphone(){
        if (!isIPhone()) return;

        // Click on Account tab in bottom navigation bar
        click("iphone.main.accounts");
        
        CommonStep.waitForVisible("iphone.accounts.balances");

        // Click on Balance option
        click("iphone.accounts.balances");
        
       // CommonStep.waitForVisible("investment.header", 90);
        //CommonStep.waitForVisible("investment.title");
        
        Map<String, Object> params1 = new HashMap<>();
		params1.put("content", "Investment");
		params1.put("source", "camera");
		params1.put("timeout", "20");
		params1.put("threshold", "90");
		Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);
        
        
        String balance = getAttribute("total.value", "name");
        
        boolean isBalanceFormatted = UBSUtils.validateAmount(balance);

        assertTrue(isBalanceFormatted, "Balance amount doesn't matches the format criteria. Balance amount - " + balance);

        // Switch to UBS tab if not defaulted
        switchToUBSTab();

        // Select intra day
        click("iphone.intraday");

        int isSelected = Integer.valueOf(getAttribute("iphone.intraday","value")).intValue();
        assertEquals(isSelected,1,"Intra Day is not selected");

        String totalValue = getAttribute("total.value","name");

        // Validate the amount is well formatted.
        boolean isAmountFormated = UBSUtils.validateAmount(totalValue);

        // Assert the isAmountFormatted is well formatted.
        assertTrue(isAmountFormated,
                "Total amount is not in correct format $x,xxx.xx. Amount displayed : " + totalValue);

        // Select Prior day
        click("iphone.priorday");
        isSelected = Integer.valueOf(getAttribute("iphone.priorday","value")).intValue();
        assertEquals(isSelected,1,"Prior Day is not selected");

        // Check whether Changed amount widget is displayed
        boolean isPresent = CommonStep.verifyVisible("iphone.change.value");
        assertTrue(isPresent,"Change Value widget is not present upon switch to Prior Day option.");

        // Validate All accounts option
        click("iphone.all");

        // Check whether Investment Assets is displayed
        isPresent = CommonStep.verifyVisible("iphone.investment.assets");
        assertTrue(isPresent,"Investment Assets is not present upon switch to All accounts option.");

        // Switch Back to UBS Account option
        click("iphone.ubs");
    }

    public void android(){
        if (!isAndroid()) return;

        // Click on Account tab in bottom navigation bar
        click("android.main.accounts");
        
        CommonStep.waitForVisible("android.accounts.balances");

        // Click on Balance option
        click("android.accounts.balances");
        
       // CommonStep.waitForVisible("investment.header", 90);
        //CommonStep.waitForVisible("investment.title");
        
        Map<String, Object> params1 = new HashMap<>();
		params1.put("content", "Assets");
		params1.put("source", "camera");
		params1.put("timeout", "20");
		params1.put("threshold", "90");
		Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params1);
        
		boolean isALLScreen = checkPointTextVisual(params1);
		
		if (isALLScreen) {
			switchToUBSTab();
		}
        
        String balance = getAttribute("total.value", "name");
        
        boolean isBalanceFormatted = UBSUtils.validateAmount(balance);

        assertTrue(isBalanceFormatted, "Balance amount doesn't matches the format criteria. Balance amount - " + balance);

        // Switch to UBS tab if not defaulted
        switchToUBSTab();

        // Select intra day
        click("android.intraday");

        int isSelectedInt = 0;//Integer.valueOf(getAttribute("android.intraday","checked")).intValue();
        //assertEquals(isSelected,1,"Intra Day is not selected");
        
        String isSelected = getAttribute("android.intraday", "checked");
        assertEquals(isSelected,"true","Intra Day is not selected");
        
        if (isSelected.equalsIgnoreCase("true")) {
        	isSelectedInt=1;
        }else {
        	isSelectedInt=0;
        }

        String totalValue = getAttribute("total.value","name");

        // Validate the amount is well formatted.
        boolean isAmountFormated = UBSUtils.validateAmount(totalValue);

        // Assert the isAmountFormatted is well formatted.
        assertTrue(isAmountFormated,
                "Total amount is not in correct format $x,xxx.xx. Amount displayed : " + totalValue);

        // Select Prior day
        click("android.priorday");
        isSelectedInt = 0;
       // isSelectedInt = Integer.valueOf(getAttribute("android.priorday","value")).intValue();
        //assertEquals(isSelectedInt,1,"Prior Day is not selected");
        
        isSelected = getAttribute("android.priorday", "checked");
        assertEquals(isSelected,"true","Prior Day is not selected");
        
        if (isSelected.equalsIgnoreCase("true")) {
        	isSelectedInt=1;
        }else {
        	isSelectedInt=0;
        }

        // Check whether Changed amount widget is displayed
        
        Map<String, Object> params4 = new HashMap<>();
        params4.put("content", "Change in Value");
        params4.put("timeout", "50");
        params4.put("screen.top", "30%");
		params4.put("screen.height", "12%");
		params4.put("screen.left", "32%");
		params4.put("screen.width", "36%");
		//Object result3 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params4);
		boolean isPresent = checkPointTextVisual(params4);
		
		
		try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //isPresent = (boolean) result3;//CommonStep.verifyVisible("android.change.value");
        assertTrue(isPresent,"Change Value widget is not present upon switch to Prior Day option.");

        // Validate All accounts option
        click("android.all");

        // Check whether Investment Assets is displayed
        isPresent = CommonStep.verifyVisible("android.investment.assets");
        assertTrue(isPresent,"Investment Assets is not present upon switch to All accounts option.");

        // Switch Back to UBS Account option
        click("android.ubs");
    }
    private void iPad(){
        if (!isIPad()) return;
    }

}
