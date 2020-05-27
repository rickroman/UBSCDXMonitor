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


@QAFTestStepProvider
public class UBSStepDefs {

    private static final String Secured_uname = "secured./h2sxa3ub4PCwXhsgCxWJQ==";
    private static final String Secured_pw = "secured.Xh05tx5pw3z3iyHVTztGsQ==";




    // public String os = new QAFExtendedWebElement().getDescription();

    public String getModel() {
      //  String device = "";

        Map<String, Object> params = new HashMap<>();
        params.put("property", "model");
        String model =  DeviceUtils.getQAFDriver().executeScript("mobile:handset:info", params).toString();
        if(model.contains("iPhone")) {
            model = "iphone";
        }else { model="ipad";}
        System.out.println("model is " + model);
        return model;


    }

    @When("I launch CDX")
    public void launch_cdx() {


        if(getModel().equals("iphone")) {


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
    @When("Login to CDX")
    public void loginCDX() {



        if(getModel().equals("iphone")) {



            //declare the Map for script parameters
            Map<String, Object> params = new HashMap<>();
                params.put("text", Secured_uname);
                params.put("by", "xpath");
                params.put("value", "//*[@value=\"Username\"]");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);


            new QAFExtendedWebElement("login.next.iphone").click();


            new QAFExtendedWebElement("field.password.iphone").click();

        }else {
            // enter credentials

            Map<String, Object> params = new HashMap<>();
            params.put("content", "Username");
            DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);
            try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }


            Map<String, Object> params3 = new HashMap<>();
            params3.put("text", Secured_uname);
            params3.put("by", "xpath");
            params3.put("value", "//XCUIElementTypeTextField");
            DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params3);

         //   new QAFExtendedWebElement("field.username").sendKeys("securetest66");
            new QAFExtendedWebElement("login.next").click();
        }



        Map<String, Object> params4 = new HashMap<>();
            params4.put("text", Secured_pw);
            params4.put("by", "xpath");
            params4.put("value", "//XCUIElementTypeSecureTextField");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);


       // new QAFExtendedWebElement("field.password").sendKeys("cantGue33");
        new QAFExtendedWebElement("login.signin.btn").click();
        // 2 validations of home page loading
        validateHomePage();

    }

    @Then("check milestone")
    public void checkMilestone() {


        if (getModel().equalsIgnoreCase("iphone")) {

            new QAFExtendedWebElement("main.milestones").click();
            new QAFExtendedWebElement("mile.scouts").click();
            new QAFExtendedWebElement("mile.bsa").isDisplayed();
            new QAFExtendedWebElement("mile.resources").isDisplayed();
            new QAFExtendedWebElement("mile.back").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("home").isPresent();
            new QAFExtendedWebElement("home").click();
            validateHomePage();

        } else {

            Map<String, Object> params4 = new HashMap<>();
            params4.put("label","PUBLIC:monitoring/milestones_ipad.png");
            params4.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params4);
            new QAFExtendedWebElement("mile.scouts").click();
            new QAFExtendedWebElement("mile.bsa").isDisplayed();

            Map<String, Object> params = new HashMap<>();
            params.put("label","PUBLIC:monitoring/milestones_ipad_back.png");
            params.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-image:click", params);
            new QAFExtendedWebElement("retirement").isDisplayed();
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("home").click();
            validateHomePage();

        }
    }


    @Then("validate banking services")
    public void bankingServices() {


        if (getModel().equalsIgnoreCase("iphone")) {
            new QAFExtendedWebElement("banking.services").click();
            // At a glance
            new QAFExtendedWebElement("glance").click();
            new QAFExtendedWebElement("glance.recent").isDisplayed();
            new QAFExtendedWebElement("home").click();

            // transfer funds
            new QAFExtendedWebElement("banking.services").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("transfer.funds").click();
            try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
            new QAFExtendedWebElement("funds.move").isPresent();
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
            validateHomePage();



        } else {

        }
    }

    @Then("view insights")
    public void viewInsights() {

        if(getModel().equalsIgnoreCase("iphone")) {

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

        if(getModel().equalsIgnoreCase("iphone")) {

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


        if(getModel().equalsIgnoreCase("iphone")) {
            //click accounts and check balance of prior day
            new QAFExtendedWebElement("main.accounts").click();
            new QAFExtendedWebElement("iphone.accounts.balances").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }

       //     String balance = new QAFExtendedWebElement("total.value").getAttribute("label");
        //    System.out.println("yaron1: " + balance);

            try{
                new QAFExtendedWebElement("iphone.priorday").isDisplayed();
            }catch (Exception e) {
                System.out.println("clicking on ubs");
                new QAFExtendedWebElement("iphone.ubs").click();
            }

   //          balance = new QAFExtendedWebElement("total.value").getAttribute("label");
    //        System.out.println("yaron2: " + balance);

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
            new QAFExtendedWebElement("iphone.priorday").isPresent();
            new QAFExtendedWebElement("iphone.intraday").click();
            new QAFExtendedWebElement("iphone.holdings.cash").isPresent();
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

            String balance = new QAFExtendedWebElement("total.value").getText();
            System.out.println("yaron1: " + balance);

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
            new QAFExtendedWebElement("accounts.holdings").click();
            new QAFExtendedWebElement("ubs").click();
            new QAFExtendedWebElement("holdings.ubs.change").isPresent();
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
       validateHomePage();
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
        validateHomePage();

    }

    @Then("validate relationship")
    public void validateRelationship() {


        if(getModel().equals("iphone")) {
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

            //



        }else{


            new QAFExtendedWebElement("profile.relationship").click();
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


        if(getModel().equals("iphone")) {
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


        if(getModel().equals("iphone")) {
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


        if(getModel().equals("iphone")) {
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


        if (getModel().equals("iphone")) {

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
            validateHomePage();


        }

    }

    @Then("check legal")
    public void checkLegal() {


        if (getModel().equals("iphone")) {

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


        if (getModel().equals("iphone")) {

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
            validateHomePage();

        }

    }



            @Then("validate profile")
    public void validateProfile() {

        if(getModel().equals("iphone")) {
            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "My information");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);
            new QAFExtendedWebElement("profile.iphone.primary").isDisplayed();

            new QAFExtendedWebElement("menu.iphone").click();
            Map<String, Object> params = new HashMap<>();
            params.put("label", "Relationships");
            params.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params);
            new QAFExtendedWebElement("profile.iphone.team").click();
            new QAFExtendedWebElement("profile.iphone.advice").isDisplayed();
            new QAFExtendedWebElement("home").click();
            validateHomePage();


        }else {
            new QAFExtendedWebElement("main.profile").click();
            new QAFExtendedWebElement("profile.primary").isDisplayed();


        }

    }
    @Then("logout of CDX")
    public void logoutCDX() {
        if(getModel().equals("iphone")) {
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
    private void validateHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();
        DeviceUtils.waitForPresentTextVisual("total Assets",60);

    }




}
