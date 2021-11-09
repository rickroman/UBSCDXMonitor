package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.utils.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.gl.E;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.bytebuddy.implementation.bytecode.Throw;
import java.util.Map;
import java.util.HashMap;
import java.time.*;
import java.util.concurrent.TimeUnit;

import com.quantum.utils.UBSUtils;


@QAFTestStepProvider
public class EquityAwardsStepDefs {

    private static final String Secured_equity_uname = "secured.BzOYecc1Y/h1KI04dhivkg==";
    private static final String Secured_equity_pw = "secured.C68G7Vqodlvt8un3EM7Tiw==";

    @When("CDX Equity Awards login")
    public void equityAwardsLogin() {


        //declare the Map for script parameters
        Map<String, Object> params = new HashMap<>();
        params.put("text", Secured_equity_uname);
        params.put("by", "xpath");
        params.put("value", "//*[@value=\"Username\"]");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params);

        new QAFExtendedWebElement("login.next.iphone").click();

        Map<String, Object> params4 = new HashMap<>();
        params4.put("text", Secured_equity_pw);
        params4.put("by", "xpath");
        params4.put("value", "//XCUIElementTypeSecureTextField");
        DeviceUtils.getQAFDriver().executeScript("mobile:application.element:set", params4);

        new QAFExtendedWebElement("login.signin.btn").click();
        // 2 validations of home page loading
        UBSUtils.declineFaceID();
        validateEquityAwardsHP();

    }


    @When("validate activity")
    public void validateActivity() {
        new QAFExtendedWebElement("equityAwards").click();
        new QAFExtendedWebElement("equityActivity").click();
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        new QAFExtendedWebElement("orders.completed").isDisplayed();
        new QAFExtendedWebElement("orders.disclosures").isDisplayed();


    }

    @When("validate holdings")
    public void validateHoldings() {
        new QAFExtendedWebElement("equityAwards").click();
        new QAFExtendedWebElement("equityHoldings").click();
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        new QAFExtendedWebElement("holdings.awards").isDisplayed();
        new QAFExtendedWebElement("holdings.shares").isPresent();




    }
    @When("check transactions")
    public void checkTransactions() {
        new QAFExtendedWebElement("equityAwards").click();
        new QAFExtendedWebElement("EquityTransactions").click();
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        new QAFExtendedWebElement("transactionsWelcome").isPresent();


    }
    @When("validate awards education")
    public void validateEducation() {
        new QAFExtendedWebElement("equityAwards").click();
        new QAFExtendedWebElement("EquityAwardsEducation").click();
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        new QAFExtendedWebElement("education.progress").isPresent();


    }

    @When("check notifications")
    public void checkNotificatiobs() {
        new QAFExtendedWebElement("equityAwards").click();
        new QAFExtendedWebElement("EquityNotify").click();
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        new QAFExtendedWebElement("  notifications,actionable").isPresent();



        new QAFExtendedWebElement("Home").click();
        validateEquityAwardsHP();


    }
    @When("check MW balances")
    public void checkMWBalances(){
        new QAFExtendedWebElement("hp.mywealth").click();
        new QAFExtendedWebElement("mw.balances").click();
        new QAFExtendedWebElement("mw.balances.assets").isPresent();
        new QAFExtendedWebElement("mw.balances.investmentAssets").isDisplayed();


    }
    @When("check MW Holdings")
    public void checkMWHoldings() {

        new QAFExtendedWebElement("hp.mywealth").click();
        new QAFExtendedWebElement("mw.holdings").click();
        new QAFExtendedWebElement("mw.holdings.none").isDisplayed();


    }
    @When("check MW Activity")
    public void checkMWActivity() {

        new QAFExtendedWebElement("hp.mywealth").click();
        new QAFExtendedWebElement("mw.activity").click();
        new QAFExtendedWebElement("mw.activity.none").isDisplayed();


    }
    @When("check MW Financial Tools")
    public void checkMWTools() {
        new QAFExtendedWebElement("hp.mywealth").click();
        new QAFExtendedWebElement("mw.tools").click();
        new QAFExtendedWebElement("mw.tools.netWorth").isDisplayed();
        new QAFExtendedWebElement("cashFlow").click();
        new QAFExtendedWebElement("know.moves").isDisplayed();
        new QAFExtendedWebElement("spending").click();
        new QAFExtendedWebElement("expense.analysis").isDisplayed();
        new QAFExtendedWebElement("Home").click();
        validateEquityAwardsHP();
    }
    @When("check my information")
    public void checkMyInfo(){
        new QAFExtendedWebElement("menu.iphone").click();
        new QAFExtendedWebElement("my.info").click();
        new QAFExtendedWebElement("username").isDisplayed();

    }
    @When("EW check settings")
    public void checkSettings(){
        new QAFExtendedWebElement("menu.iphone").click();
        new QAFExtendedWebElement("settings").click();
        new QAFExtendedWebElement("ew.settings").isDisplayed();

    }
    @When("EW check support")
    public void checkSupport(){
        new QAFExtendedWebElement("menu.iphone").click();
        new QAFExtendedWebElement("support").click();
        new QAFExtendedWebElement("market.hours").isDisplayed();

    }
    @When("EW check legal")
    public void checkLegal(){
        new QAFExtendedWebElement("menu.iphone").click();
        new QAFExtendedWebElement("legal").click();
        new QAFExtendedWebElement("valuation").isDisplayed();
        new QAFExtendedWebElement("legal.cancel").click();


    }
    @When("EW get in touch")
    public void getInTouch(){
        new QAFExtendedWebElement("menu.iphone").click();
        new QAFExtendedWebElement("get.in.touch").click();
        new QAFExtendedWebElement("toll.free").isDisplayed();
        new QAFExtendedWebElement("touch.close").click();
    }



    private void validateEquityAwardsHP() {

        try { new QAFExtendedWebElement("closeHPNotification").click(); } catch (Exception e){ System.out.println("no notification popup"); }
        new QAFExtendedWebElement("holdingsSummary").isDisplayed();
        String todayValue = new QAFExtendedWebElement("todaysValue").getText();
        System.out.println("today value is: " + todayValue);

    }
}
