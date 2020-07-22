/**
 *
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.ReportUtils;
import com.quantum.utils.UBSUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

//import javafx.scene.web.WebView;

@QAFTestStepProvider
public class ValidationSteps {


    @Then("validate cash at a glance")
    public void cashAtGlance() {


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

}
