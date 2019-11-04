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


    @When("I launch CDX")
    public void launch_cdx() {
        try { DeviceUtils.closeApp("Wealth", "name");
        }catch (Exception e){ System.out.println("app was not open"); }
        DeviceUtils.startApp("Wealth", "name");
        DeviceUtils.getQAFDriver().findElement("login.message").isPresent();
    }
    @When("Login to CDX")
    public void loginCDX() {
        // enter credentials
        new QAFExtendedWebElement("field.username").sendKeys("neotest66");
        new QAFExtendedWebElement("login.next").click();
        new QAFExtendedWebElement("field.password").sendKeys("Ols12345");
        new QAFExtendedWebElement("login.signin.btn").click();
        // 2 validations of home page loading
        validateHomePage();

    }
    @Then("validate accounts")
    public void validateAccounts() {
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
        validateHomePage();

    }
    @Then("logout of CDX")
    public void logoutCDX() {
        new QAFExtendedWebElement("main.sign.out").click();
        DeviceUtils.getQAFDriver().findElement("login.message").isPresent();


    }
    private void validateHomePage() {
        new QAFExtendedWebElement("main.net.balance").isDisplayed();
        DeviceUtils.waitForPresentTextVisual("total Assets",60);

    }




}
