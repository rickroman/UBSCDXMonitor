/**
 *
 */
package com.quantum.steps;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
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
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "cash available");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,85%),(50%,45%)");
			//params2.put("maxscroll", 10);
			Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
	        
			
			String glanceAmount = QAFDriverUtils.getText("android.cash.glance");
			boolean isAmountFormatted = UBSUtils.validateAmount(glanceAmount);

			assertTrue(isAmountFormatted,
					"Amount in a Glance is not in correct format $x,xxx.xx. Amount displayed : " + glanceAmount);

			
		} else if(model.equalsIgnoreCase("iPhone-15 Pro Max")) {
		
			

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

		} else {

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "cash at a glance");
			params2.put("scrolling", "scroll");
			params2.put("next", "SWIPE=(50%,85%),(50%,55%)");

			boolean checkPointResult = checkPointTextVisual(params2);
			assertTrue(checkPointResult, "Scroll to Glance Amount failed");

			String amountAtGlance = getText("home.glance");
			assertTrue(UBSUtils.validateAmount(amountAtGlance),
					"Amount in a Glance is not in correct format $x,xxx.xx. Amount displayed : " + amountAtGlance);

//            String a = new QAFExtendedWebElement("home.glance").getText();
//            System.out.println("cash at a glance: " + a);
//            if (!UBSUtils.validateAmount(a)) {
//                throw new RuntimeException("No dollar amount has loaded: " + a);
//            }

			// scroll back up
			Map<String, Object> params = new HashMap<>();
			params.put("content", "\"net balance\", \"includes ubs and external accounts\"");
			params.put("scrolling", "scroll");
			params.put("target", "any");
			params.put("next", "SWIPE=(50%,55%),(50%,85%)");
			params.put("maxscroll", 10);

			checkPointResult = checkPointTextVisual(params);

			assertTrue(checkPointResult, "Scroll Back up failed");
		}
	}
	


}
