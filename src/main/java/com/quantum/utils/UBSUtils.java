package com.quantum.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class UBSUtils  {
    
	public static String model = getModel();
    
    public static void validateHomePage() {
    	
        new QAFExtendedWebElement("main.net.balance").isDisplayed();
        DeviceUtils.waitForPresentTextVisual("total Assets",60);
        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }


    }

    public static void declineFaceID() {


        try {


            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "Enable Face ID");
            params3.put("timeout", "30");
            String result = (String) DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

            if (result.equalsIgnoreCase("true")) {



                if(model.equalsIgnoreCase("iphone")) {
                    //successful checkpoint code
                    Map<String, Object> params = new HashMap<>();
                    params.put("content", "Not Now");
                    DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
                }else {
                    new QAFExtendedWebElement("ipad.face.decline").click();

                }
            }


        } catch (Exception e) {
            System.out.println("caught declinefaceID:");
        }

    }




    public static void validateShortHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();

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

    }catch (Exception e) {
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
        //  String device = "";

        Map<String, Object> params = new HashMap<>();
        params.put("property", "model");
        String model =  DeviceUtils.getQAFDriver().executeScript("mobile:handset:info", params).toString();
        if(model.contains("iPhone")) {
            model = "iphone";
        }else { model="ipad";}
      //  System.out.println("model is " + model);
        return model;


    }

}
