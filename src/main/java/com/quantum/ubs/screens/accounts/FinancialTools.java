package com.quantum.ubs.screens.accounts;

import static com.quantum.utils.QAFDriverUtils.checkPointTextVisual;
import static com.quantum.utils.QAFDriverUtils.click;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.UBSCommonSteps;
import com.quantum.utils.UBSUtils;

public class FinancialTools extends UBSScreen {
	
	 public void android(){
	    	
	        if (!isAndroid()) return;

	        // Navigate to Financial tools
	        click("android.main.accounts");
	        
	        click("accounts.financial.tools");
	        
			
			/*
			 * Map<String, Object> params29 = new HashMap<>(); params29.put("label",
			 * "Financial tools"); params29.put("timeout", "30"); params29.put("threshold",
			 * "90"); DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
			 * params29);
			 */
			  
			 

	        // Validate the Financial tools message is displayed
	        boolean isPresent = CommonStep.verifyVisible("android.financialtools.msg");
	        assertTrue(isPresent,"Financial Tools Message is not present upon navigating to Financial tools screen.");

	        // Click on Cash flow
	        Map<String, Object> params2 = new HashMap<>();
	        params2.put("label", "Cash Flow");
	        params2.put("timeout", "30");
	        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

	        //click("cash.flow.android");
	        

	        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
	        
	        //Validate the Cash Flow message is displayed
	        Map<String, Object> params7 = new HashMap<>();
			params7.put("content", "Know how your money moves");
			params7.put("source", "camera");
			params7.put("timeout", "30");
			params7.put("threshold", "90");
			isPresent = checkPointTextVisual(params7);
	        assertTrue(isPresent,"Cash Flow Message is not present upon navigating to Financial tools screen.");

	        // Navigate to Cash Flow spending
	        click("cash.flow.spending");
	        

	        //Validate the Cash Flow message is displayed
	        Map<String, Object> params3 = new HashMap<>();
			params3.put("content", "Expense Analysis");
			params3.put("source", "camera");
			params3.put("timeout", "30");
			params3.put("threshold", "90");
			isPresent = checkPointTextVisual(params3);
	       // isPresent = CommonStep.verifyVisible("cash.flow.expenses");
	        assertTrue(isPresent,"Cash Flow expenses is not present upon navigating to Financial tools screen.");

	        UBSCommonSteps.navigateToHome();
	    }

    public void iphone(){
    	
        if (!isIPhone()) return;

        // Navigate to Financial tools
        click("iphone.main.accounts");
        click("accounts.financial.tools");

        // Validate the Financial tools message is displayed
        boolean isPresent = CommonStep.verifyVisible("iphone.financialtools.msg");
        assertTrue(isPresent,"Financial Tools Message is not present upon navigating to Financial tools screen.");

        // Click on Cash flow
        click("cash.flow.iphone");

        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        //Validate the Cash Flow message is displayed
        isPresent = CommonStep.verifyVisible("cash.flow.msg");
        assertTrue(isPresent,"Cash Flow Message is not present upon navigating to Financial tools screen.");

        // Navigate to Cash Flow spending
        click("cash.flow.spending");
        

        //Validate the Cash Flow message is displayed
        isPresent = CommonStep.verifyVisible("cash.flow.expenses");
        assertTrue(isPresent,"Cash Flow expenses is not present upon navigating to Financial tools screen.");

        UBSCommonSteps.navigateToHome();
    }

    public void ipad(){
    	
        if (!isIPad()) return;

        Map<String, Object> params2 = new HashMap<>();
        params2.put("label", "Accounts");
        params2.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params2);

        new QAFExtendedWebElement("accounts.balances").isDisplayed();
        
        new QAFExtendedWebElement("accounts.currentBalance").isPresent();
        try { Thread.sleep(11000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        Map<String, Object> params22 = new HashMap<>();
        params22.put("content", "Total Value");
        params22.put("timeout", "30");
        
        boolean isPresent = checkPointTextVisual(params22);
        
        if (!isPresent) {
        	 new QAFExtendedWebElement("ipad.accounts.ubsorAll").click();
        }

        String balance = new QAFExtendedWebElement("total.value").getAttribute("name");
        
        if (!UBSUtils.validateAmount(balance)) {
            throw new RuntimeException("No dollar amount has loaded: " + balance);
        }

        String selectedAccounts = new QAFExtendedWebElement("ipad.balances.selected.accounts").getAttribute("name");
        
        
        if(!"All".equals(selectedAccounts)) {
        	
        	// click on all, validate and return
            new QAFExtendedWebElement("ipad.balances.all").click();
            
        }
        
        
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
        
        CommonStep.waitForVisible("ipad.all.assets");
        
//        new QAFExtendedWebElement("all.assets").isPresent();
        
        new QAFExtendedWebElement("ipad.ubs").click();
        
        
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
       ////////////// CommonStep.waitForVisible("accounts.currentBalance");
//        new QAFExtendedWebElement("accounts.currentBalance").isPresent();

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(DeviceUtils.getQAFDriver().getUnderLayingDriver());
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.withMessage("Not able to Switch to Prior Day Balance");
        
        wait.until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
		        String selectedBalanceType =  new QAFExtendedWebElement("ipad.balances.selected.type").getAttribute("name");
		        boolean isSelected = !"Prior day".equals(selectedBalanceType);
		        if(isSelected) {
		        	new QAFExtendedWebElement("ipad.balances.priorday").click();
		        }
		        
				return !isSelected;
			}
		});
        
        CommonStep.waitForVisible("ipad.prior.day.investments");
        
        // check prior day
//        try {
//            new QAFExtendedWebElement("ipad.balances.priorday").click();
//        } catch (Exception e) {
//
//            new QAFExtendedWebElement("iphone.ubs").click();
//            new QAFExtendedWebElement("ipad.balances.priorday").click();
//
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new QAFExtendedWebElement("prior.day.investments").isDisplayed();
        
        
        
//        new QAFExtendedWebElement("balances.intraday").click();
        
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new QAFExtendedWebElement("accounts.balances").isDisplayed();
        
        wait.until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
		        String selectedBalanceType =  new QAFExtendedWebElement("ipad.balances.selected.type").getAttribute("name");
		        boolean isSelected = !"Intraday".equals(selectedBalanceType);
		        if(isSelected) {
		        	new QAFExtendedWebElement("ipad.balances.priorday").click();
		        }
		        
				return !isSelected;
			}
		});

        CommonStep.waitForVisible("accounts.balances");
        /*
         * // click on holdings & validate // set long timeout for holdings page on iPad
         * DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(300,
         * TimeUnit.SECONDS);
         * DeviceUtils.getQAFDriver().manage().timeouts().setScriptTimeout(300,
         * TimeUnit.SECONDS);
         *
         *
         * new QAFExtendedWebElement("accounts.holdings").click();
         *
         * // check holdings values try { Thread.sleep(20000); } catch
         * (InterruptedException e) { e.printStackTrace(); }
         *
         *
         *
         *
         * String holdingsGrandTotal = new
         * QAFExtendedWebElement("ipad.holdings.grandTotal").getText();
         * System.out.println("holding grand total:" + holdingsGrandTotal);
         * if(!UBSUtils.validateNumber(holdingsGrandTotal)) {
         *
         * Map<String, Object> params12 = new HashMap<>(); params12.put("label",
         * "Holdings"); params12.put("timeout", "30");
         * DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
         * params12);
         *
         *
         * holdingsGrandTotal = new
         * QAFExtendedWebElement("ipad.holdings.grandTotal").getText();
         * System.out.println("holding grand total:" + holdingsGrandTotal);
         *
         *
         *
         * throw new RuntimeException("No dollar amount has loaded: " +
         * holdingsGrandTotal); }
         *
         * String holdingsAmount = new
         * QAFExtendedWebElement("activity.amounts").findElements("activity.amounts").
         * get(0).getText(); System.out.println("holdings amount: " + holdingsAmount);
         * if(!UBSUtils.validateNumber(holdingsAmount)) {throw new
         * RuntimeException("No dollar amount has loaded: " + holdingsAmount); }
         *
         *
         *
         * new QAFExtendedWebElement("iphone.ubs").click(); new
         * QAFExtendedWebElement("holdings.ubs.change").isPresent();
         *
         * DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(60,
         * TimeUnit.SECONDS);
         *
         * // check prior day
         *
         * try{ new QAFExtendedWebElement("balances.priorday").isDisplayed(); }catch
         * (Exception e) { System.out.println("clicking on ubs"); new
         * QAFExtendedWebElement("iphone.ubs").click(); }
         *
         *
         * new QAFExtendedWebElement("balances.priorday").click(); new
         * QAFExtendedWebElement("holdings.quantity").isPresent(); new
         * QAFExtendedWebElement("balances.intraday").click();
         *
         * new QAFExtendedWebElement("balances.all").click(); new
         * QAFExtendedWebElement("holdings.cash").isPresent();
         *
         *
         */

        // click on Activity & validate

        Map<String, Object> params3 = new HashMap<>();
        params3.put("label", "Activity");
        params3.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params3);
        
        try {Thread.sleep(5000);}catch(Exception e) {}
        
        // new QAFExtendedWebElement("accounts.activity").click();
        
        CommonStep.waitForVisible("ipad.activity.type");
//        new QAFExtendedWebElement("activity.type").isDisplayed();
        
        // check number of first activity
        String a = new QAFExtendedWebElement("activity.amounts").findElements("activity.amounts").get(0).getText();
        
        System.out.println("activity amount: " + a);
        if (!UBSUtils.validateNumber(a)) {
            throw new RuntimeException("No dollar amount has loaded: " + a);
        }

        // check activity filter
        new QAFExtendedWebElement("accounts.activity").click();
        
        
        CommonStep.waitForVisible("ipad.activity.account");
        
//        new QAFExtendedWebElement("activity.account").isDisplayed();
        
        
        new QAFExtendedWebElement("ipad.filter").click();
        
//        Point point = filter.getLocation();
//        
//        @SuppressWarnings("deprecation")
//		TouchAction touchActions = new TouchAction<>(DriverUtils.getIOSDriver());
//        touchActions.tap(TapOptions.tapOptions().withElement(ElementOption.element(filter))).perform();
        
        
//        
//        PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
//        
//        Sequence sequence = new Sequence(finger, 0);
//        sequence.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), point.x, point.y));
//        sequence.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
//        sequence.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
//        
//        DriverUtils.getIOSDriver().perform(Arrays.asList(sequence));
        
        
//        Actions actions = new Actions(DriverUtils.getIOSDriver());
//        actions.click(filter).build().perform();
        

//        Map<String, Object> params = new HashMap<>();
//        params.put("content", "Filter");
//        DeviceUtils.getQAFDriver().executeScript("mobile:text:select", params);

        // new QAFExtendedWebElement("filter.btn").click();
        new QAFExtendedWebElement("ytd").click();
        // new QAFExtendedWebElement("filter.apply").click();
        Map<String, Object> params4 = new HashMap<>();
        params4.put("label", "Apply");
        params4.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params4);
        new QAFExtendedWebElement("activity.account").isDisplayed();

        // Financial tools
        // new QAFExtendedWebElement("accounts.financial.tools").click();

        Map<String, Object> params5 = new HashMap<>();
        params5.put("label", "Financial tools");
        params5.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params5);
        
        
        
        new QAFExtendedWebElement("financial.tools.msg").isDisplayed();
        
        
        new QAFExtendedWebElement("net.balanc").isPresent();

       // new QAFExtendedWebElement("cash.flow").click();

        CommonStep.waitForVisible("Net Worth", 20);
       
        Map<String, Object> params6 = new HashMap<>();
        params6.put("label", "Cash flow");
        params6.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params6);
        
        Map<String, Object> params7 = new HashMap<>();
        params7.put("label", "Spending");
        params7.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params7);
        
        Map<String, Object> params8 = new HashMap<>();
        params8.put("label", "Cash flow");
        params8.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params8);

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new QAFExtendedWebElement("cash.flow.msg").isDisplayed();
        
        // new QAFExtendedWebElement("cash.flow.spending").click();
        
        Map<String, Object> params9 = new HashMap<>();
        params9.put("label", "Spending");
        params9.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params9);
        
        new QAFExtendedWebElement("cash.flow.expenses").isDisplayed();

        // go back to home page
        new QAFExtendedWebElement("back").click();
        // new QAFExtendedWebElement("home").click();
        
        Map<String, Object> params11 = new HashMap<>();
        params11.put("label", "Home");
        params11.put("timeout", "30");
        DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click", params11);
    }


}
