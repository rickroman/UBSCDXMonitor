package com.quantum.ubs.screens.accounts;

import com.qmetry.qaf.automation.step.CommonStep;
import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSUtils;

import static com.quantum.utils.QAFDriverUtils.*;
import static com.quantum.utils.QAFDriverUtils.click;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Balance extends UBSScreen {

    public static void switchToUBSTab(){
        if(!QAFDriverUtils.isOptionalElementPresent("iphone.intraday")){
            click("iphone.ubs");
        }
    }

    public void iphone(){
        if (!isIPhone()) return;

        // Click on Account tab in bottom navigation bar
        click("iphone.main.accounts");

        // Click on Balance option
        click("iphone.accounts.balances");
        String balance = getAttribute("total.value", "name");
        
        boolean isBalanceFormatted = UBSUtils.validateAmount(balance);

        assertTrue(isBalanceFormatted, "Balance amount doesn't matches the format criteria. Balance amount - " + balance);

        // Switch to UBS tab if not defaulted
        switchToUBSTab();

        // Select intra day
        click("iphone.intraday");

        int isSelected = Integer.valueOf(getAttribute("iphone.intraday","value")).intValue();
        assertEquals(isSelected,1,"Intra Day is not selected");

        String totalValue = getAttribute("total.value","name");

        // Validate the amount is well formatted.
        boolean isAmountFormated = UBSUtils.validateAmount(totalValue);

        // Assert the isAmountFormatted is well formatted.
        assertTrue(isAmountFormated,
                "Total amount is not in correct format $x,xxx.xx. Amount displayed : " + totalValue);

        // Select Prior day
        click("iphone.priorday");
        isSelected = Integer.valueOf(getAttribute("iphone.priorday","value")).intValue();
        assertEquals(isSelected,1,"Prior Day is not selected");

        // Check whether Changed amount widget is displayed
        boolean isPresent = CommonStep.verifyVisible("iphone.change.value");
        assertTrue(isPresent,"Change Value widget is not present upon switch to Prior Day option.");

        // Validate All accounts option
        click("iphone.all");

        // Check whether Investment Assets is displayed
        isPresent = CommonStep.verifyVisible("iphone.investment.assets");
        assertTrue(isPresent,"Investment Assets is not present upon switch to All accounts option.");

        // Switch Back to UBS Account option
        click("iphone.ubs");
    }

    private void iPad(){
        if (!isIPad()) return;
    }

}
