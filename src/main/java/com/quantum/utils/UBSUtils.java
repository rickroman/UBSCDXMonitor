package com.quantum.utils;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.UBSStepDefs;

import java.util.HashMap;
import java.util.Map;

public class UBSUtils  {

    public static void validateHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();
        DeviceUtils.waitForPresentTextVisual("total Assets",60);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("content", "cash at a glance");
        params2.put("scrolling", "scroll");
        params2.put("next","SWIPE=(50%,85%),(50%,55%)");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);



        String a = new QAFExtendedWebElement("home.glance").getText();
        System.out.println("cash at a glance: " + a);
        if(!UBSUtils.validateAmount(a)) {throw new RuntimeException("No dollar amount has loaded: " + a); }



        // scroll back up
        Map<String, Object> params = new HashMap<>();
        params.put("content","\"net balance\", \"includes ubs and external accounts\"");
        params.put("scrolling","scroll");
        params.put("target","any");
        params.put("next","SWIPE=(50%,55%),(50%,85%)");
        params.put("maxscroll",10);
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);


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
