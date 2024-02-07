package com.quantum.listeners;

import org.testng.ITestResult;

public class QuantumReportiumListenerUBS extends QuantumReportiumListener{

	
	@Override
	public void onTestFailure(ITestResult testResult) {
		
		//check for pop-ups and throw exception for known issues and throw exception
		
		super.onTestFailure(testResult);
		
		
	}
}
