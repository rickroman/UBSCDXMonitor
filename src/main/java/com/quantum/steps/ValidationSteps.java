/**
 *
 */
package com.quantum.steps;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
import static com.quantum.utils.QAFDriverUtils.click;
import static com.quantum.utils.QAFDriverUtils.getText;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSUtils;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class ValidationSteps {

	@Then("validate cash at a glance")
	public void cashAtGlance() {
		
		String model = DeviceUtils.getDeviceProperty("model");
		
		
		if (model.equalsIgnoreCase("Galaxy S24 Ultra")) {
			
			/*
			 * Map<String, Object> params = new HashMap<>(); params.put("start", "20%,60%");
			 * params.put("end", "20%,30%"); params.put("duration", "3"); Object res =
			 * DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params);
			 */
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "cash available");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,50%),(50%,20%)");
			params2.put("maxscroll", 12);
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
	        
			
			String glanceAmount = QAFDriverUtils.getText("android.cash.glance");
			boolean isAmountFormatted = UBSUtils.validateAmount(glanceAmount);

			assertTrue(isAmountFormatted,
					"Amount in a Glance is not in correct format $x,xxx.xx. Amount displayed : " + glanceAmount);

			
		} else if(model.equalsIgnoreCase("iPhone-17 Pro Max")) {
		
			

			String glanceAmount = QAFDriverUtils.getText("iphone.cash.glance");
        	boolean isAmountFormatted = UBSUtils.validateAmount(glanceAmount);
        	
        	assertTrue(isAmountFormatted, 
        			"Amount in a Glance is not in correct format $x,xxx.xx. Amount displayed : " + glanceAmount);
        	
        	


//            String a = new QAFExtendedWebElement("iphone.cash.glance").getText();
//            System.out.println("cash at a glance: " + a);
//            
//            
//            
//            if (!UBSUtils.validateAmount(a)) {
//                throw new RuntimeException("No dollar amount has loaded: " + a);
//            }

		} else if(model.equalsIgnoreCase("iPhone-16 Pro Max")) {
			String glanceAmount = QAFDriverUtils.getText("iphone.cash.glance");
        	boolean isAmountFormatted = UBSUtils.validateAmount(glanceAmount);
        	
        	assertTrue(isAmountFormatted, 
        			"Amount in a Glance is not in correct format $x,xxx.xx. Amount displayed : " + glanceAmount);
        	
		} else {

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "cash at a glance");
			params2.put("timeout","30");
			params2.put("threshold","80");
			//params2.put("scrolling", "scroll");
			//params2.put("next", "SWIPE=(50%,85%),(50%,55%)");

			boolean checkPointResult = checkPointTextVisual(params2);
			
			assertTrue(checkPointResult, "Glance link not on home page");

			click("home.cashGlanceLink");
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			
			Map<String, Object> params3 = new HashMap<>();
			params3.put("content", "See why cash matters");
			params3.put("timeout","30");
			params3.put("threshold","80");
			//params2.put("scrolling", "scroll");
			//params2.put("next", "SWIPE=(50%,85%),(50%,55%)");

			boolean checkPointResult2 = checkPointTextVisual(params3);
			
			assertTrue(checkPointResult2, "Click to Glance Amount failed");
			
			String amountAtGlance = getText("glance.value");
			assertTrue(UBSUtils.validateAmount(amountAtGlance),
					"Amount in a Glance is not in correct format $x,xxx.xx. Amount displayed : " + amountAtGlance);

//            String a = new QAFExtendedWebElement("home.glance").getText();
//            System.out.println("cash at a glance: " + a);
//            if (!UBSUtils.validateAmount(a)) {
//                throw new RuntimeException("No dollar amount has loaded: " + a);
//            }

			// back home
			click("home");
			
			
			
			  Map<String, Object> params6 = new HashMap<>(); 
			  params6.put("content", "includes your ubs and external accounts");
			  params6.put("timeout","30");
			  params6.put("threshold","80");
			  
			  checkPointResult = checkPointTextVisual(params6);
			  
			 
			 
		}
	}
	


}
