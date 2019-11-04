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
import net.bytebuddy.implementation.bytecode.Throw;


@QAFTestStepProvider
public class UBSStepDefs {

    QAFExtendedWebElement d = new QAFExtendedWebElement("login.message");

    @When("I launch CDX")
	public void launch_cdx() {
	    try {
            DeviceUtils.closeApp("com.ubs.cdx.uat", "identifier");
        }catch (Exception e){ System.out.println("app was not open"); }
        DeviceUtils.startApp("com.ubs.cdx.uat", "identifier");
        DeviceUtils.getQAFDriver().findElement("bibi").isPresent();






	}
	@When("Login to CDX")
    public void loginCDX() {

	    new QAFExtendedWebElement("field.username").sendKeys("username");
        new QAFExtendedWebElement("field.password").sendKeys("password");
        new QAFExtendedWebElement("btn.login").click();

        // Validation - visual validation

    }




}
