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


            try { DeviceUtils.closeApp("Wealth", "name");
            }catch (Exception e){ System.out.println("app was not open"); }
            DeviceUtils.startApp("Wealth", "name");

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
    @Then("validate accounts")
    public void validateAccounts() {


        if(getModel().equalsIgnoreCase("iphone")) {
            //click accoints and check balance of prior day
            new QAFExtendedWebElement("main.accounts").click();
            new QAFExtendedWebElement("iphone.accounts.balances").click();
            new QAFExtendedWebElement("iphone.priorday").isPresent();
            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }


            // click on holdings & validate
            new QAFExtendedWebElement("main.accounts").click();

            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }
       new QAFExtendedWebElement("accounts.holdings").click();
            try { Thread.sleep(3000); } catch (InterruptedException e) {e.printStackTrace(); }

            //  new QAFExtendedWebElement("holdings.msg").isDisplayed();
        new QAFExtendedWebElement("holdings.cash").isPresent();

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

            // click on holdings & validate
            new QAFExtendedWebElement("accounts.holdings").click();
            //  new QAFExtendedWebElement("holdings.msg").isDisplayed();
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

        }else {
            new QAFExtendedWebElement("main.profile").click();
            new QAFExtendedWebElement("profile.primary").isDisplayed();

            new QAFExtendedWebElement("profile.relationship").click();
            new QAFExtendedWebElement("profile.team").click();

            Map<String, Object> params2 = new HashMap<>();
            params2.put("content", "UBS Wealth Advice");
            params2.put("timeout", "30");
            DeviceUtils.getQAFDriver().executeScript("mobile:checkpoint:text", params2);

            new QAFExtendedWebElement("back").click();
            new QAFExtendedWebElement("home").click();
        }
        validateHomePage();

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
