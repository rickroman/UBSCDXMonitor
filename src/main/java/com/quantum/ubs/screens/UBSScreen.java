package com.quantum.ubs.screens;

import com.quantum.utils.UBSUtils;

public class UBSScreen {

    private String targetModel;

    public UBSScreen(){
        this.targetModel = UBSUtils.getModel();
    }

    public boolean isIPhone(){
        return "iphone".equalsIgnoreCase(targetModel);
    }

    public boolean isIPad(){
        return "ipad".equalsIgnoreCase(targetModel);
    }

    public void validate(){
        iphone();
        ipad();
    }

    public void ipad() {
    }

    public void iphone() {

    }

}
