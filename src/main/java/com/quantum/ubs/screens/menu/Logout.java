package com.quantum.ubs.screens.menu;

import com.quantum.ubs.screens.UBSScreen;
import com.quantum.utils.QAFDriverUtils;
import com.quantum.utils.UBSCommonSteps;

public class Logout extends UBSScreen {

    public void iphone(){

        if (!isIPhone()) return;

        // If iPhone Menu needs to be Open
        UBSCommonSteps.openMenu();
    }

    public void perform(){

        iphone();
        // Click on Logout
        QAFDriverUtils.click("main.sign.out");
    }
}
