package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListner implements ITestListener{ 
	
	
	public void onStart(ITestContext context) {
	 System.out.println("Test execution started....");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test method started....");
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test method success....");
	  }
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test method failed....");
	  }

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test method skipped....");
	  }
	
	
	public void onFinish(ITestContext context) {
		System.out.println("Test execution Finished....");
	}
}
