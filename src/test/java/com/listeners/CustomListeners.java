package com.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestBase.Test_Base;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends Test_Base implements ITestListener,ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {
		/*System.out.println("result--"+arg0);
		System.out.println("testing--"+arg0.getName().toUpperCase());
		System.out.println(rep.startTest(arg0.getName().toUpperCase()));*/		
		test = rep.startTest(result.getName().toUpperCase());
		System.out.println("called");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL,result.getName().toUpperCase()+" FAIL");
		rep.endTest(test);
		rep.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		rep.endTest(test);
		rep.flush();
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
