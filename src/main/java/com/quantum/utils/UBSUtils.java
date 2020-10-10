package com.quantum.utils;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.UBSStepDefs;

import java.util.HashMap;
import java.util.Map;

public class UBSUtils  {

    public static void validateHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();
        DeviceUtils.waitForPresentTextVisual("total Assets",60);
        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }


    }


    public static void validateShortHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();

    }
    public static boolean validateAmount(String str) {

        // get 1st character and check it is a dollar symbol
        String d = str.substring(0,1);
        String n = str.substring(1,6);
        n = n.replace(",","");
        n = n.replace(".","");
        if(d.equalsIgnoreCase("$")){
            // check number is positive
            long i=Long.parseLong(n);
            System.out.println("long is: " + i);
            if(!(i>0)) { return false; }
            System.out.println("amount validated as positive: " + str);
            return  true;
        }else { return false; }

    }

    public static boolean validateNumber(String str) {

        // check if first character is a minus sign
        String one = str.substring(0,1);
        if(one.equalsIgnoreCase("-")){
            System.out.println("negative number");
            str = str.replace("-","");

        }






        // get 1st character and check it is a dollar symbol
        String d = str.substring(0,1);
        String n = str.substring(1,3);
        n = n.replace(",","");
        n = n.replace(".","");
        if(d.equalsIgnoreCase("$")){

            if(isNumeric(n)) {
               System.out.println("number validated: " + n);
                return true;
            }
        }

        return false;
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
