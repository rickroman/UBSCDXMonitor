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
import net.bytebuddy.implementation.bytecode.Throw;
import java.util.Map;
import java.util.HashMap;
import java.time.*;
import java.util.concurrent.TimeUnit;

import com.quantum.utils.UBSUtils;


@QAFTestStepProvider
public class EquityAwardsStepDefs {

    private static final String Secured_equity_uname = "BzOYecc1Y/h1KI04dhivkg==";
    private static final String Secured_equity_pw = "C68G7Vqodlvt8un3EM7Tiw==";

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
        UBSUtils.validateHomePage();

    }
}
