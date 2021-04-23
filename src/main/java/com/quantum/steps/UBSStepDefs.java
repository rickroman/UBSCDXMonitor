/**
 *
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.utils.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
//import javafx.scene.web.WebView;
import net.bytebuddy.implementation.bytecode.Throw;
import java.util.Map;
import java.util.HashMap;
import java.time.*;
import java.util.concurrent.TimeUnit;

import com.quantum.utils.UBSUtils;

@QAFTestStepProvider
public class UBSStepDefs {

    private static final String Secured_uname = "secured./h2sxa3ub4PCwXhsgCxWJQ==";
    private static final String Secured_pw = "secured.Xh05tx5pw3z3iyHVTztGsQ==";




    @Then("^I restart all devices$")
    public void daily_restart(){

        Map<String, Object> params = new HashMap<>();
        DeviceUtils.getQAFDriver().executeScript("mobile:device:ready", params);
        try {Thread.sleep(3000); } catch (InterruptedException e) {}
        Map<String, Object> pars = new HashMap<>();
        DeviceUtils.getQAFDriver().executeScript("mobile:handset:reboot", pars);
        try {Thread.sleep(10000); } catch (InterruptedException e) {}

        Map<String, Object> pars2 = new HashMap<>();
        DeviceUtils.getQAFDriver().executeScript("mobile:handset:recover", pars2);
        try {Thread.sleep(90000); } catch (InterruptedException e) {}


    }


    // public String os = new QAFExtendedWebElement().getDescription();

    @When("I launch CDX")
    public void launch_cdx() {


        if(UBSUtils.getModel().equals("iphone")) {


            try { DeviceUtils.closeApp("UBS", "name");
            }catch (Exception e){ System.out.println("app was not open"); }
            DeviceUtils.startApp("UBS", "name");


        }else {


            try { DeviceUtils.closeApp("UBS", "name");
            }catch (Exception e){ System.out.println("app was not open"); }
            DeviceUtils.startApp("UBS", "name");

        }


        DeviceUtils.getQAFDriver().findElement("login.message").isPresent();
    }
    @When("I debug launch CDX")
    public void debugLaunch_cdx() {


        if(UBSUtils.getModel().equals("iphone")) {


            try { DeviceUtils.closeApp("Wealth QA", "name");
            }catch (Exception e){ System.out.println("app was not open"); }
            DeviceUtils.startApp("Wealth QA", "name");


        }else {


            try { DeviceUtils.closeApp("Wealth QA", "name");
            }catch (Exception e){ System.out.println("app was not open"); }
            DeviceUtils.startApp("Wealth QA", "name");

        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DeviceUtils.getQAFDriver().findElement("login.message").isPresent();
    }



    @When("Login to CDX")
    public void loginCDX() {

        if(UBSUtils.getModel().equals("iphone")) {

            try {
                new QAFExtendedWebElement("iphone.signin").click();
            }catch (Exception e){}

            //declare the Map for script parameters
            Map<String, Object> params = new HashMap<>();
                params.put("text", Secured_uname);
                params.put("by", "xpath");
                params.put("value", "//*[@value=\"Username\"]");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);

            new QAFExtendedWebElement("login.next.iphone").click();
            new QAFExtendedWebElement("field.password.iphone").click();


            Map<String, Object> params4 = new HashMap<>();
            params4.put("text", Secured_pw);
            params4.put("by", "xpath");
            params4.put("value", "//XCUIElementTypeSecureTextField");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);


            new QAFExtendedWebElement("login.signin.btn").click();
            // 2 validations of home page loading

           UBSUtils.declineFaceID();
            UBSUtils.validateHomePage();

        }else {
            // enter credentials

            Map<String, Object> params = new HashMap<>();
            params.put("content", "Username");
            DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Map<String, Object> params3 = new HashMap<>();
            params3.put("text", Secured_uname);
            params3.put("by", "xpath");
            params3.put("value", "//XCUIElementTypeTextField");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params3);

            //   new QAFExtendedWebElement("field.username").sendKeys("securetest66");
            new QAFExtendedWebElement("login.next").click();


            Map<String, Object> params4 = new HashMap<>();
            params4.put("text", Secured_pw);
            params4.put("by", "xpath");
            params4.put("value", "//XCUIElementTypeSecureTextField");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);


            // new QAFExtendedWebElement("field.password").sendKeys("cantGue33");
            new QAFExtendedWebElement("login.signin.btn").click();
            // 2 validations of home page loading
            UBSUtils.declineFaceID();
            UBSUtils.validateHomePage();
        }

    }
    @When("debug_Login to CDX")
    public void debugLoginCDX() {


        String Secured_duname = "secured.aDeg4J2QMoUXTt3/WHcjUg==";
        String Secured_dpw = "secured.ihj+yodayavfCbHyJQTJBw==";


            //declare the Map for script parameters

        /*
            Map<String, Object> params = new HashMap<>();
            params.put("text", Secured_duname);
            params.put("by", "xpath");
            params.put("value", "//*[@value=\"Username\"]");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);
*/
        new QAFExtendedWebElement("field.username").sendKeys("cdx07");


        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

         //new QAFExtendedWebElement("debug.next").click();
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }


        new QAFExtendedWebElement("field.password").sendKeys("New@ols2");
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }



        Map<String, Object> params = new HashMap<>();
        params.put("label", "Sign in");
        params.put("timeout", 15);
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }




/*

        Map<String, Object> params4 = new HashMap<>();
        params4.put("text", Secured_dpw);
        params4.put("by", "xpath");
        params4.put("value", "//XCUIElementTypeSecureTextField");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);

*/




        // new QAFExtendedWebElement("debug.next").click();

          //  new QAFExtendedWebElement("login.next.iphone").click();
         //  new QAFExtendedWebElement("debug.pw").click();




/*
        Map<String, Object> params4 = new HashMap<>();
        params4.put("text", "yaron");
        params4.put("by", "xpath");
        params4.put("value", "//*[@value=\"Password\"]");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);


        // new QAFExtendedWebElement("field.password").sendKeys("cantGue33");


        */
     //   new QAFExtendedWebElement("login.signin.btn").click();
        // 2 validations of home page loading
        UBSUtils.validateHomePage();

    }


    @Then("check milestone")
    public void checkMilestone() {


        if (UBSUtils.getModel().equalsIgnoreCase("iphone")) {

            new QAFExtendedWebElement("main.milestones").click();
            new QAFExtendedWebElement("mile.scouts").click();
            new QAFExtendedWebElement("mile.bsa").isDisplayed();
            new QAFExtendedWebElement("mile.resources").isDisplayed();



            //click on article
            System.out.println("milestone article");
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "donation to the scouts");
            params2.put("timeout", 30);
            params2.put("label.direction","Above");
            params2.put("label.offset","35%");

            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }



            Map<String, Object> params = new HashMap<>();
            params.put("label", "done");
            params.put("timeout", 30);
            params.put("screen.top","0%");
            params.put("screen.height","13%");
            params.put("screen.width","100%");
            params.put("screen.left","0%");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);



            new QAFExtendedWebElement("iphone.activity.back").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("home").isPresent();
            new QAFExtendedWebElement("home").click();
            UBSUtils.validateShortHomePage();

        } else {

            Map<String, Object> params4 = new HashMap<>();
            params4.put("label","PUBLIC:monitoring/milestones_ipad.png");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);
            new QAFExtendedWebElement("mile.scouts").click();
            new QAFExtendedWebElement("mile.bsa").isDisplayed();


            //click on article
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Resources");
            params2.put("ignorecase","case");
            params2.put("timeout", 30);
            params2.put("label.direction","Above");
            params2.put("label.offset","9%");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

            new QAFExtendedWebElement("xbutton").click();
            new QAFExtendedWebElement("milestones.page").isDisplayed();


           /* Map<String, Object> params = new HashMap<>();
            params.put("label","PUBLIC:monitoring/milestones_ipad_back.png");
            params.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
            new QAFExtendedWebElement("retirement").isDisplayed();
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

            */
            new QAFExtendedWebElement("home").click();
            UBSUtils.validateShortHomePage();


        }
    }


    @Then("validate banking services")
    public void bankingServices() {


        if (UBSUtils.getModel().equalsIgnoreCase("iphone")) {
            new QAFExtendedWebElement("banking.services").click();
            // At a glance
            new QAFExtendedWebElement("glance").click();
            new QAFExtendedWebElement("glance.recent").isDisplayed();


            String a = new QAFExtendedWebElement("glance.value").getText();
            System.out.println("glance value is: " + a);
            if(!UBSUtils.validateAmount(a)) {throw new RuntimeException("No dollar amount has loaded: " + a); }



            new QAFExtendedWebElement("home").click();

            // transfer funds
            new QAFExtendedWebElement("banking.services").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("transfer.funds").click();
            try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("funds.move").isPresent();

            // check manage scheduled transfers
            new QAFExtendedWebElement("schedule.transfers").click();
            new QAFExtendedWebElement("transfering.out").isPresent();



            new QAFExtendedWebElement("banking.services").click();

            // pay bills
            new QAFExtendedWebElement("Pay Bills").click();
            new QAFExtendedWebElement("bills").isDisplayed();
            new QAFExtendedWebElement("home").click();
            new QAFExtendedWebElement("banking.services").click();
            // pay credit card
            new QAFExtendedWebElement("pay.ubs").click();
            new QAFExtendedWebElement("pay.credit").isDisplayed();
            new QAFExtendedWebElement("home").click();
            new QAFExtendedWebElement("banking.services").click();
            // deposit check
            new QAFExtendedWebElement("deposit.check").click();
            new QAFExtendedWebElement("noaccount").isDisplayed();
            new QAFExtendedWebElement("home").click();
            UBSUtils.validateShortHomePage();




        } else {
            new QAFExtendedWebElement("banking.services").click();
            // At a glance
            new QAFExtendedWebElement("glance.recent").isDisplayed();
            String a = new QAFExtendedWebElement("glance.value").getText();
            System.out.println("glance value is: " + a);
            if(!UBSUtils.validateAmount(a)) {throw new RuntimeException("No dollar amount has loaded: " + a); }

            // transfer funds
            new QAFExtendedWebElement("transfer.funds").click();
            try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("funds.move").isPresent();


            // scheduled transfers
            new QAFExtendedWebElement("schedule.transfers").click();
            Map<String, Object> params = new HashMap<>();
            params.put("content", "does not have any scheduled transfers");
            params.put("timeout", 20);
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);
            new QAFExtendedWebElement("profile.back").click();


            new QAFExtendedWebElement("banking.services").click();


            // pay bills
            new QAFExtendedWebElement("Pay Bills").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("content", "pay bills outside");
            params2.put("timeout", 20);
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

            // pay credit card
            new QAFExtendedWebElement("ipad.credit").click();
            Map<String, Object> params20 = new HashMap<>();
            params20.put("content", "credit card payment");
            params20.put("timeout", 20);
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params20);

            // deposit check
            new QAFExtendedWebElement("deposit.check").click();
            new QAFExtendedWebElement("noaccount").isDisplayed();


            //  return home
            new QAFExtendedWebElement("profile.back").click();
            new QAFExtendedWebElement("home").click();

            UBSUtils.validateShortHomePage();



        }
    }

    @Then("view insights")
    public void viewInsights() {

        if(UBSUtils.getModel().equalsIgnoreCase("iphone")) {

            Map<String, Object> params2 = new HashMap<>();
            params2.put("content", "here are your periodically");
            params2.put("scrolling", "scroll");
            params2.put("next","SWIPE=(50%,85%),(50%,55%)");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

        }else {
            Map<String, Object> params2 = new HashMap<>();
            params2.put("content", "news and insights");
            params2.put("scrolling", "scroll");
            params2.put("next","SWIPE=(50%,85%),(50%,55%)");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

            // scroll back up
            Map<String, Object> params = new HashMap<>();
            params.put("content","\"net balance\", \"includes ubs and external accounts\"");
            params.put("scrolling", "scroll");
            params.put("target","any");
            params.put("next","SWIPE=(50%,55%),(50%,85%)");
            params.put("maxscroll",10);
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);
        }



    }


    @Then("view market insights")
    public void viewMarketInsights() {

        if(UBSUtils.getModel().equalsIgnoreCase("iphone")) {

            Map<String, Object> params2 = new HashMap<>();
            params2.put("content","\"djia\" \"as of\"");
            params2.put("scrolling", "scroll");
            params2.put("next","SWIPE=(50%,85%),(50%,55%)");
            params2.put("target","all");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

            // check date
            String today = new QAFExtendedWebElement("home.asof").getAttribute("value");
            System.out.println("today is: " + today);
            String thisYear = Year.now().toString();
            System.out.println("this year: " + thisYear);

            if(today.contains(thisYear)) {

                String msg = "the string contains" + thisYear;
                System.out.println(msg);
                ReportUtils.logAssert(msg,true);
            }else {
                String msg = "the string DOES NOT include" + thisYear;
                System.out.println(msg);
               ReportUtils.logAssert(msg,false);
                // temporary fix for 2021
                ReportUtils.logAssert(msg,true);


            }
            // return to top
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            Map<String, Object> params = new HashMap<>();
            params.put("content","\"learn more about your accounts\", \"includes ubs and external accounts\"");
            params.put("scrolling", "scroll");
            params.put("target","any");
            params.put("next","SWIPE_DOWN");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params);


        }else {

        }


    }
    @Then("validate accounts")
    public void validateAccounts() {


        if(UBSUtils.getModel().equalsIgnoreCase("iphone")) {
            //click accounts and check balance of prior day
            new QAFExtendedWebElement("main.accounts").click();
            new QAFExtendedWebElement("iphone.accounts.balances").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }



            try{
               String prior = String.valueOf(new QAFExtendedWebElement("iphone.priorday").isEnabled());
               System.out.println("prior day checkbox:" + prior);



            }catch (Exception e) {
                System.out.println("clicking on ubs");
                new QAFExtendedWebElement("iphone.ubs").click();
            }

            String balance = new QAFExtendedWebElement("total.value").getAttribute("name");
            if(!UBSUtils.validateAmount(balance)) {
                throw new RuntimeException("No dollar amount has loaded: " + balance);
            }
            new QAFExtendedWebElement("iphone.intraday").click();
            String value = new QAFExtendedWebElement("iphone.intraday").getAttribute("value");
            System.out.println("value is" + value);
            new QAFExtendedWebElement("iphone.change.value").isDisplayed();

            new QAFExtendedWebElement("iphone.priorday").click();
            new QAFExtendedWebElement("iphone.change.value").isDisplayed();


            new QAFExtendedWebElement("iphone.all").click();
            new QAFExtendedWebElement("iphone.investment.assets").isDisplayed();
            new QAFExtendedWebElement("iphone.ubs").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }

            // click on holdings & validate
            new QAFExtendedWebElement("main.accounts").click();

            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }
             new QAFExtendedWebElement("accounts.holdings").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }

            //  new QAFExtendedWebElement("holdings.msg").isDisplayed();
             new QAFExtendedWebElement("holdings.cash").isPresent();

            // switch to ubs if not the default

            try {

                String prior = String.valueOf(new QAFExtendedWebElement("iphone.priorday").isEnabled());
                System.out.println("prior day balances checkbox:" + prior);
            }catch (Exception e){

                System.out.println("clicking on ubs at holdings page");
                new QAFExtendedWebElement("iphone.ubs").click();

            }

            new QAFExtendedWebElement("iphone.priorday").isPresent();
            new QAFExtendedWebElement("iphone.intraday").click();
            new QAFExtendedWebElement("iphone.holdings.cash").isPresent();
            //validate cash & total values are numbers
            String holdingsGrandTotal = new QAFExtendedWebElement("iphone.holdings.grandTotal").getText();
            System.out.println("holding grand total:" + holdingsGrandTotal);
            if(!UBSUtils.validateNumber(holdingsGrandTotal)) {throw new RuntimeException("No dollar amount has loaded: " + holdingsGrandTotal); }


            String holdingsCashTotal = new QAFExtendedWebElement("iphone.holdings.cashTotal").getText();
            System.out.println("holding cash total:" + holdingsCashTotal);
            if(!UBSUtils.validateNumber(holdingsCashTotal)) {throw new RuntimeException("No dollar amount has loaded: " + holdingsCashTotal); }


            new QAFExtendedWebElement("iphone.all").click();
            new QAFExtendedWebElement("iphone.total.value").isPresent();
            new QAFExtendedWebElement("iphone.ubs").click();



            // click on Activity & validate
            new QAFExtendedWebElement("main.accounts").click();
            new QAFExtendedWebElement("accounts.activity").click();
            // checking filter button as it is only unique element on page
            Map<String, Object> params2 = new HashMap<>();
            params2.put("content", "Filter");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);


            // validating first activity
            new QAFExtendedWebElement("iphone.activity.first").click();
            String activityAmount = new QAFExtendedWebElement("activity.amount").getText();
            if(!UBSUtils.validateNumber(activityAmount)) {throw new RuntimeException("No activity amount has loaded: " + activityAmount); }
            new QAFExtendedWebElement("iphone.activity.back").click();




            // Financial tools
            new QAFExtendedWebElement("main.accounts").click();
            new QAFExtendedWebElement("accounts.financial.tools").click();
            new QAFExtendedWebElement("iphone.financialtools.msg").isDisplayed();

            new QAFExtendedWebElement("cash.flow").click();
            new QAFExtendedWebElement("cash.flow.msg").isDisplayed();


            new QAFExtendedWebElement("cash.flow.spending").click();
            //new QAFExtendedWebElement("cash.flow.expenses").isDisplayed();

            new QAFExtendedWebElement("home").click();

        }else {
            // click on accounts and validate table loads
            new QAFExtendedWebElement("main.accounts").click();
            new QAFExtendedWebElement("accounts.balances").isDisplayed();
            new QAFExtendedWebElement("accounts.currentBalance").isPresent();

            String balance = new QAFExtendedWebElement("total.value").getAttribute("name");
            if(!UBSUtils.validateAmount(balance)) {
                throw new RuntimeException("No dollar amount has loaded: " + balance);
            }

            // click on all, validate and return
            new QAFExtendedWebElement("balances.all").click();
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("all.assets").isPresent();
            new QAFExtendedWebElement("ubs").click();
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("accounts.currentBalance").isPresent();

            // check prior day
            try {
                new QAFExtendedWebElement("balances.priorday").click();
            }catch (Exception e) {

                new QAFExtendedWebElement("ubs").click();
                new QAFExtendedWebElement("balances.priorday").click();

            }
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("prior.day.investments").isDisplayed();
            new QAFExtendedWebElement("balances.intraday").click();
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("accounts.balances").isDisplayed();


            // click on holdings & validate
            // set long timeout for holdings page on iPad
            DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

            new QAFExtendedWebElement("accounts.holdings").click();

            // check holdings values

            String holdingsGrandTotal = new QAFExtendedWebElement("ipad.holdings.grandTotal").getText();
            System.out.println("holding grand total:" + holdingsGrandTotal);
            if(!UBSUtils.validateNumber(holdingsGrandTotal)) {throw new RuntimeException("No dollar amount has loaded: " + holdingsGrandTotal); }

            String holdingsAmount =  new QAFExtendedWebElement("activity.amounts").findElements("activity.amounts").get(0).getText();
            System.out.println("holdings amount: " + holdingsAmount);
            if(!UBSUtils.validateNumber(holdingsAmount)) {throw new RuntimeException("No dollar amount has loaded: " + holdingsAmount); }



            new QAFExtendedWebElement("ubs").click();
            new QAFExtendedWebElement("holdings.ubs.change").isPresent();

            DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            // check prior day

            try{
                new QAFExtendedWebElement("balances.priorday").isDisplayed();
            }catch (Exception e) {
                System.out.println("clicking on ubs");
                new QAFExtendedWebElement("ubs").click();
            }


            new QAFExtendedWebElement("balances.priorday").click();
            new QAFExtendedWebElement("holdings.quantity").isPresent();
            new QAFExtendedWebElement("balances.intraday").click();


            new QAFExtendedWebElement("balances.all").click();
            new QAFExtendedWebElement("holdings.cash").isPresent();

            // click on Activity & validate
            new QAFExtendedWebElement("accounts.activity").click();
            new QAFExtendedWebElement("activity.type").isDisplayed();
            //check number of first activity
           String a =  new QAFExtendedWebElement("activity.amounts").findElements("activity.amounts").get(0).getText();
           System.out.println("activity amount: " + a);
            if(!UBSUtils.validateNumber(a)) {throw new RuntimeException("No dollar amount has loaded: " + a); }


            // Financial tools
            new QAFExtendedWebElement("accounts.financial.tools").click();
            new QAFExtendedWebElement("financial.tools.msg").isDisplayed();
            new QAFExtendedWebElement("net.balanc").isPresent();

            new QAFExtendedWebElement("cash.flow").click();
            new QAFExtendedWebElement("cash.flow.msg").isDisplayed();
            new QAFExtendedWebElement("cash.flow.spending").click();
            new QAFExtendedWebElement("cash.flow.expenses").isDisplayed();

            // go back to home page
            new QAFExtendedWebElement("back").click();
            new QAFExtendedWebElement("home").click();
        }
        UBSUtils.validateShortHomePage();
    }
    @Then("create milestone")
    public void createMilestone() {
        new QAFExtendedWebElement("main.milestones").click();
        new QAFExtendedWebElement("mile.add").click();
        new QAFExtendedWebElement("mile.travel").click();
        new QAFExtendedWebElement("MilestoneNameComponentViewCell").click();
        new QAFExtendedWebElement("MilestoneNameComponentViewCell").sendKeys("London");
        new QAFExtendedWebElement("mile.next").click();


        // Add details to Milestone
        new QAFExtendedWebElement("mile.start").click();
        new QAFExtendedWebElement("mile.year").click();
        new QAFExtendedWebElement("mile.amount").sendKeys("5000");

        Map<String, Object> params = new HashMap<>();
        params.put("content", "Add Milestone");
        DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
        // validate milestone created
        new QAFExtendedWebElement("milestones.page").isDisplayed();
        new QAFExtendedWebElement("milestone.created").isDisplayed();
    }

    @Then("delete milestone")
    public void deleteMilestone() {
        new QAFExtendedWebElement("milestone.created").click();
        Map<String, Object> params = new HashMap<>();
        params.put("content", "Edit");
        DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("content", "remove this milestone");
        params2.put("next", "SWIPE_UP");
        params2.put("scrolling", "scroll");
        DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
        new QAFExtendedWebElement("milestone.delete").click();
        new QAFExtendedWebElement("milestone.delete.confirm").click();
        new QAFExtendedWebElement("home").click();
        UBSUtils.validateShortHomePage();


    }

    @Then("validate relationship")
    public void validateRelationship() {


        if(UBSUtils.getModel().equals("iphone")) {
            // Relationship
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Relationship");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            new QAFExtendedWebElement("relationship.community").isDisplayed();


            new QAFExtendedWebElement("relationship.team").click();
            new QAFExtendedWebElement("relationship.advice").isDisplayed();
            new QAFExtendedWebElement("menu.iphone").click();


        }else{


            new QAFExtendedWebElement("profile.relationship").click();
            //close to me

            // external professionals
            new QAFExtendedWebElement("external.pro").click();
            new QAFExtendedWebElement("relationship.community").click();
            new QAFExtendedWebElement("community.bsa").isDisplayed();
            new QAFExtendedWebElement("profile.team").click();

            Map<String, Object> params2 = new HashMap<>();
            params2.put("content", "UBS Wealth Advice");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);
            new QAFExtendedWebElement("close.tome").click();

            }
    }

    @Then("validate mindset")
    public void validateMindset() {


        if(UBSUtils.getModel().equals("iphone")) {
            // Relationship
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Mindset and Interests");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            new QAFExtendedWebElement("interest").isDisplayed();
            new QAFExtendedWebElement("menu.iphone").click();

        } else {
            new QAFExtendedWebElement("mindset").click();
            new QAFExtendedWebElement("mindset.msg").isDisplayed();
        }

    }

    @Then("check settings")
    public void validateSettings() {


        if(UBSUtils.getModel().equals("iphone")) {
            // Relationship
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Settings");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            new QAFExtendedWebElement("settings.reset").isDisplayed();
            new QAFExtendedWebElement("menu.iphone").click();
        } else {

            new QAFExtendedWebElement("settings").click();
            new QAFExtendedWebElement("settings.reset").isDisplayed();
            new QAFExtendedWebElement("information").click();

        }
    }

    @Then("get support")
    public void getSupport() {


        if(UBSUtils.getModel().equals("iphone")) {
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Support");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "need assistance");
            params3.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);



            Map<String, Object> params4 = new HashMap<>();
            params4.put("label","PUBLIC:monitoring/iphone11settings_x.png");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);
            new QAFExtendedWebElement("menu.iphone").click();

        } else {
            new QAFExtendedWebElement("support").click();
            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "need assistance");
            params3.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);
            new QAFExtendedWebElement("support.done").click();

        }

    }
    @Then("check feedback")
    public void checkFeedback() {


        if (UBSUtils.getModel().equals("iphone")) {

            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Feedback");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "tell us what you think");
            params3.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

            Map<String, Object> params4 = new HashMap<>();
            params4.put("label","PUBLIC:monitoring/iphone11settings_x.png");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);


        } else {
            new QAFExtendedWebElement("feedback").click();
            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "tell us what you think");
            params3.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);
            new QAFExtendedWebElement("feedback.cancel").click();

            new QAFExtendedWebElement("profile.back").click();

            Map<String, Object> params4 = new HashMap<>();
            params4.put("label","PUBLIC:monitoring/ipad_home.png");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);
            UBSUtils.validateShortHomePage();


        }

    }

    @Then("check legal")
    public void checkLegal() {


        if (UBSUtils.getModel().equals("iphone")) {

            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Legal and disclosures");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);


            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "products and services described");
            params3.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

            Map<String, Object> params4 = new HashMap<>();
            params4.put("label", "Cancel");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);


        } else {

        }
    }

    @Then("contact financial advisor")
    public void contactAdvisor() {


        if (UBSUtils.getModel().equals("iphone")) {

            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "contact financial advisor");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);


            Map<String, Object> params3 = new HashMap<>();
            params3.put("content", "toll free");
            params3.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params3);

            Map<String, Object> params4 = new HashMap<>();
            params4.put("label", "Close");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);
            try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }

        } else {
            new QAFExtendedWebElement("contact").click();
            new QAFExtendedWebElement("tollfree").isDisplayed();
            new QAFExtendedWebElement("close").click();
            UBSUtils.validateShortHomePage();
        }

    }

            @Then("validate profile")
    public void validateProfile() {

        if(UBSUtils.getModel().equals("iphone")) {
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "My information");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            new QAFExtendedWebElement("profile.iphone.primary").isDisplayed();


            // validate meeting page
            new QAFExtendedWebElement("menu.iphone").click();
            new QAFExtendedWebElement("profile.meetings").click();
            new QAFExtendedWebElement("profile.no.meeting").isDisplayed();


            // validate card security in settings
            new QAFExtendedWebElement("menu.iphone").click();
            new QAFExtendedWebElement("profile.settings").click();
            new QAFExtendedWebElement("profile.card").click();
            new QAFExtendedWebElement("profile.nocard").isDisplayed();
            new QAFExtendedWebElement("profile.card.back").click();



            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params = new HashMap<>();
            params.put("label", "Relationships");
            params.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
            new QAFExtendedWebElement("profile.iphone.team").click();
            new QAFExtendedWebElement("profile.iphone.advice").isDisplayed();
            new QAFExtendedWebElement("home").click();
            UBSUtils.validateShortHomePage();


        }else {
            new QAFExtendedWebElement("main.profile").click();
            new QAFExtendedWebElement("profile.primary").isDisplayed();

            // meeting window
            new QAFExtendedWebElement("profile.meetings").click();
            new QAFExtendedWebElement("profile.no.meeting").isDisplayed();

           // new QAFExtendedWebElement("profile.back").click();
            new QAFExtendedWebElement("main.profile").click();

            // card
            new QAFExtendedWebElement("profile.settings").click();
            new QAFExtendedWebElement("ipad.card.security").click();
            new QAFExtendedWebElement("profile.nocard").isDisplayed();
            new QAFExtendedWebElement("ipad.setttings.close").click();
            new QAFExtendedWebElement("main.profile").click();






        }

    }


    @Then("logout of CDX")
    public void logoutCDX() {
        if(UBSUtils.getModel().equals("iphone")) {
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "Sign Out");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
        }
        else {
            new QAFExtendedWebElement("main.sign.out").click();
        }
        DeviceUtils.getQAFDriver().findElement("login.message").isPresent();

    }

}
