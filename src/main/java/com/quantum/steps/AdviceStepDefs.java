package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import javafx.scene.web.WebView;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.quantum.utils.UBSUtils;

@QAFTestStepProvider
public class AdviceStepDefs {

    private static final String Secured_adv_uname = "secured.bCJ359l8IQ5kJGkJP+BDyQ==";
    private static final String Secured_adv_pw = "secured.AsF9GOU366inlD9jtNAKig==";
    @When("Advice Login to CDX")
    public void adviceLoginCDX() {


        //declare the Map for script parameters
        Map<String, Object> params = new HashMap<>();
        params.put("text", Secured_adv_uname);
        params.put("by", "xpath");
        params.put("value", "//*[@value=\"Username\"]");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);

        new QAFExtendedWebElement("login.next.iphone").click();
        //   new QAFExtendedWebElement("field.password.iphone").click();



        Map<String, Object> params4 = new HashMap<>();
        params4.put("text", Secured_adv_pw);
        params4.put("by", "xpath");
        params4.put("value", "//XCUIElementTypeSecureTextField");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);


        new QAFExtendedWebElement("login.signin.btn").click();
        // 2 validations of home page loading
        UBSUtils.declineFaceID();
        UBSUtils.validateHomePage();

    }
    @Then("Check Advice Section")
    public void checkAdvice() {

        randomlySelectAdvantage();

        new QAFExtendedWebElement("explore.advice").isDisplayed();
        new QAFExtendedWebElement("zero.accounts").click();
        new QAFExtendedWebElement("select.accounts").isPresent();
        new QAFExtendedWebElement("advice.cancel").click();
        new QAFExtendedWebElement("explore.advice").isDisplayed();


        // check fa
        Map<String, Object> params2 = new HashMap<>();
        params2.put("content","Contact your financial advisor");
        params2.put("scrolling", "scroll");
        params2.put("next","SWIPE=(50%,85%),(50%,55%)");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

        try {Thread.sleep(6000); } catch (InterruptedException e) { e.printStackTrace(); }
        // tap 562 2239
        Map<String, Object> params3 = new HashMap<>();
        params3.put("location","663,2061,663,2061");
        DeviceUtils.getQAFDriver().executeScript("mobile:touch:tap", params3);

        Map<String, Object> params4 = new HashMap<>();
        params4.put("content", "toll free");
        params4.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params4);

        new QAFExtendedWebElement("advisor.close").click();
        new QAFExtendedWebElement("home").click();





    }

    private void randomlySelectAdvantage() {

        int coin = coinToss();
        System.out.println("coin came up:" + coin);



        switch(coin) {
            case 0:
                new QAFExtendedWebElement("advice").click();

                break;
            case 1:
                Map<String, Object> params2 = new HashMap<>();
                params2.put("content","View your proposed portfolio");
                params2.put("scrolling", "scroll");
                params2.put("next","SWIPE=(50%,85%),(50%,55%)");
                DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

                new QAFExtendedWebElement("advice").click();

                break;
            default:
                // code block

        }



    }




        public static int coinToss() {
            int min = 0;
            int max = 1;
            //Generate random double value from 50 to 100
            System.out.println("Random value in double from "+min+" to "+max+ ":");
            double random_double = Math.random() * (max - min + 1) + min;
            System.out.println(random_double);

            //Generate random int value from 50 to 100
            System.out.println("Random value in int from "+min+" to "+max+ ":");
            int random_int = (int)(Math.random() * (max - min + 1) + min);
            System.out.println(random_int);
            return random_int;
        }


}
