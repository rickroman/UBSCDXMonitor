package com.quantum.utils;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.UBSStepDefs;

public class UBSUtils  {

    public static final String Secured_uname = "secured./h2sxa3ub4PCwXhsgCxWJQ==";
    public static final String Secured_pw = "secured.Xh05tx5pw3z3iyHVTztGsQ==";

    public static void validateHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();
        DeviceUtils.waitForPresentTextVisual("total Assets",60);

    }
    public static boolean validateAmount(String str) {

        String d = str.substring(0,1);
        System.out.println("yoyo:" + d);
        if(d.equalsIgnoreCase("$")){
            return  true;
        }else {

            return false;


        }



    }

}
