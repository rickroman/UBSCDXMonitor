package com.quantum.utils;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
import static com.quantum.utils.QAFDriverUtils.click;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class UBSUtils {

	public static String model = getModel();

	public static void validateHomePage() {

		// new QAFExtendedWebElement("main.net.balance").isDisplayed();
		// DeviceUtils.waitForPresentTextVisual("Total assets",60);

		Map<String, Object> params2 = new HashMap<>();
		params2.put("content", "Net Balance");
		params2.put("timeout", "60");
		params2.put("threshold", "90");

		boolean checkPointResult = checkPointTextVisual(params2);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void declineTaxDocs() {
		Map<String, Object> params11 = new HashMap<>();
		params11.put("content", "Looking for tax documents?");
		params11.put("timeout", "30");
		String result = (String) DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params11);

		if (result.equalsIgnoreCase("true")) {
			if (model.equalsIgnoreCase("iphone")) {

				Map<String, Object> params = new HashMap<>();
				params.put("label", "PUBLIC:TaxDocsCloseiPhone.png");
				params.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
				
				//PUBLIC:TaxDocsCloseiPhone.png
			} else if (model.equalsIgnoreCase("android")) {

				Map<String, Object> params = new HashMap<>();
				params.put("label", "PUBLIC:TaxDocsCloseS24.png");
				params.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
				// PUBLIC:TaxDocsCloseS24.png
			} else {

				Map<String, Object> params = new HashMap<>();
				params.put("label", "PUBLIC:TaxDocsCloseS24.png");
				params.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
				
			}

		}

	}
	
	public static void clearImportantNotice() {
		Map<String, Object> params11 = new HashMap<>();
		params11.put("content", "Important Notice");
		params11.put("timeout", "30");
		params11.put("threshold", "80");
		String result = (String) DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params11);

		if (result.equalsIgnoreCase("true")) {
			if (model.equalsIgnoreCase("iphone")) {

				Map<String, Object> params = new HashMap<>();
				params.put("label", "PUBLIC:TaxDocsCloseiPhone.png");
				params.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
				
				//PUBLIC:TaxDocsCloseiPhone.png
			} else if (model.equalsIgnoreCase("android")) {

				Map<String, Object> params = new HashMap<>();
				params.put("label", "PUBLIC:TaxDocsCloseS24.png");
				params.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
				// PUBLIC:TaxDocsCloseS24.png
			} else {

				Map<String, Object> params = new HashMap<>();
				params.put("label", "TaxDocsCloseiPad.png");
				params.put("timeout", "30");
				DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
				
			}

		}

	}

	public static void declineFaceID() {

		try {
			
			Map<String, Object> params3 = new HashMap<>();
			if (model.equalsIgnoreCase("android")) {
				params3.put("content", "Biometric Authentication");
			}else {
				params3.put("content", "Enable Face ID");
				
			}
			
			params3.put("timeout", "10");
			String result = (String) DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

			if (result.equalsIgnoreCase("true")) {

				if (model.equalsIgnoreCase("iphone")) {
					// successful checkpoint code
					Thread.sleep(4000);
					click("field.bioPassword");

					//Map<String, Object> params33 = new HashMap<>();
					//params33.put("location", "232,1705");
					//Object res = DeviceUtils.getQAFDriver().executeScript("mobile:touch:tap", params33);

					Thread.sleep(4000);
					Map<String, Object> params = new HashMap<>();
					params.put("content", "Not Now");
					DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);

				} else if (model.equalsIgnoreCase("android")) {

					

					Map<String, Object> params = new HashMap<>();
					params.put("label", "Not Now");
					params.put("timeout", "30");
					params.put("threshold", "90");
					DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);

				} else {
					new QAFExtendedWebElement("ipad.face.decline").click();

				}
			}

		} catch (Exception e) {
			System.out.println("caught declinefaceID:");
		}

	}

	public static void validateShortHomePage() {

		String model = DeviceUtils.getDeviceProperty("model");
		if (model.equalsIgnoreCase("Galaxy S22 Ultra")||model.equalsIgnoreCase("Galaxy S24 Ultra")) {

			for (int i = 0; i < 4; i++) {
				Map<String, Object> params1 = new HashMap<>();
				params1.put("start", ",50%,15%");
				params1.put("end", "50%,85%");
				params1.put("duration", "0");
				Object result1 = DeviceUtils.getQAFDriver().executeScript("mobile:touch:swipe", params1);
			}

			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "Net Balance");
			params2.put("timeout", "60");
			params2.put("threshold", "90");

			boolean checkPointResult = checkPointTextVisual(params2);
		} else {
			new QAFExtendedWebElement("main.net.balance").isDisplayed();
		}

	}

	public static boolean validateAmount(String amountStr) {

		String amountPattern = "^(-?)(\\$)([\\d,])+(\\.(\\d)+)?";

		Pattern pattern = Pattern.compile(amountPattern);

		Matcher matcher = pattern.matcher(amountStr);

		return matcher.find();

//        // get 1st character and check it is a dollar symbol
//        String e = str.substring(0, 1);
//        String n = str.substring(1, 4);
//        n = n.replace(",", "");
//        n = n.replace(".", "");
//        if (e.equalsIgnoreCase("$")) {
//
//            System.out.println("n is: " + n);
//            if (n == null) {
//                return false;
//            }
//            try {
//                double d = Double.parseDouble(n);
//            } catch (NumberFormatException nfe) {
//                return false;
//            }
//            return true;
//
//
//        }else { return false;}
	}

	public static boolean validateNumber(String str) {
		try {
			// check if first character is a minus sign
			String one = str.substring(0, 1);
			if (one.equalsIgnoreCase("-")) {
				System.out.println("negative number");
				str = str.replace("-", "");

			}

			// get 1st character and check it is a dollar symbol
			String d = str.substring(0, 1);
			String n = str.substring(1, 3);
			n = n.replace(",", "");
			n = n.replace(".", "");
			if (d.equalsIgnoreCase("$")) {

				if (isNumeric(n)) {
					System.out.println("number validated: " + n);
					return true;
				}
			}

			return false;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static String getModel() {
		// String device = "";

		Map<String, Object> params = new HashMap<>();
		params.put("property", "model");
		String model = DeviceUtils.getQAFDriver().executeScript("mobile:handset:info", params).toString();
		if (model.contains("iPhone")) {
			model = "iphone";
		} else if (model.contains("Galaxy")) {
			model = "android";
		} else {
			model = "ipad";
		}
		// System.out.println("model is " + model);
		return model;

	}

}
