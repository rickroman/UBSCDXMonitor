package com.quantum.utils;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class QAFDriverUtils {
	
	public static long ELEMENT_WAIT_TIMEOUT_IN_SECS = 30L;
	
	public static boolean isEnabled(String locator) {
		return CommonStep.verifyEnabled(locator);
	}
	
	public static String getAttribute(String locator, String attribute) {
		
		QAFWebElement elem = getQAFWebElement(locator);
		
		if (elem==null) return "Element not found with locator - " + locator;
		
		return elem.getAttribute(attribute);
	}
	
	public static boolean findElementVisual(Map<String,Object> params) {
		String result = (String)DeviceUtils.getQAFDriver().executeScript("mobile:text:find", params);
		return Boolean.getBoolean(result);
	}
	
	public static void scrollUp(String content,int...maxScroll) {
		
		int mscroll = maxScroll.length > 0? maxScroll[0]:10;
		
		Map<String, Object> params = new HashMap<>();
        params.put("content",content);
        params.put("scrolling", "scroll");
        params.put("target","any");
        params.put("next","SWIPE_DOWN");
        params.put("maxscroll",mscroll);
        
        findElementVisual(params);
	}
	
	public static void scrollDown(String content) {
		
		
		
	}

	public static void clickVisualText(Map<String,Object> params){
		DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
	}
	
	public static boolean checkPointTextVisual(Map<String,Object> params) {
		
		String result = (String)DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);

		return Boolean.parseBoolean(result);
	}
	
	public static void executeScript(String command, Map<String,Object> params) {
		
		DeviceUtils.getQAFDriver().executeScript(command, params);
	}
	
	public static String getText(String locator) {
		return CommonStep.getText(locator);
	}
	
	
	public static void setValue(String by, String locator, String value) {
		
		Map<String, Object> params = new HashMap<>();
        params.put("text", value);
        params.put("by", by);
        params.put("value", locator);
        
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);
	}
	
	public static void launchApp(String by, String value) {
		
		// Close the App if already opened
		try {
			DeviceUtils.closeApp(value, by);
		}catch(Exception e) {
			System.out.println("App not running");
		}
		
		DeviceUtils.startApp(value, by);
		
	}

	public static boolean isOptionalElementPresent(String locator) {
		return CommonStep.verifyVisible(locator);
	}
	
	public static QAFWebElement getQAFWebElement(String locator) {
		CommonStep.waitForPresent(locator, ELEMENT_WAIT_TIMEOUT_IN_SECS);
		return new QAFExtendedWebElement(locator);
	}
	
	
	public static void click(String locator) {
		
		QAFWebElement webElement = getQAFWebElement(locator);
		if(webElement!=null) webElement.click();
	}
	
	public static void setValue(String locator,String value) {	
		QAFWebElement webElement = getQAFWebElement(locator);
		if(webElement!=null) webElement.sendKeys(value);
	}
	
	
	
	

}
