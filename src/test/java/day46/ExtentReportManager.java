package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; // Populate common info on the report
	public ExtentTest test;  // Creating test case entries and update status of the test methods
	
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreports.html");
		sparkReporter.config().setDocumentTitle("Automation report");
		sparkReporter.config().setReportName("Function testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("SystemName", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Author", "Shivkumar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "firefox");
		
		}
		
		
		public void onTestSuccess(ITestResult result) {
			
			test=extent.createTest(result.getName()); // create a new entry in the report
			test.log(Status.PASS, "Test case Passed is : "+result.getName()); // update the status p/f/s
			
		  }
		
		public void onTestFailure(ITestResult result) {
			
			test=extent.createTest(result.getName());
			test.log(Status.FAIL, "Test case Failed is : "+result.getName());
			test.log(Status.FAIL, "Cause for failure is : "+result.getThrowable());
			
		  }

		public void onTestSkipped(ITestResult result) {
			
			test=extent.createTest(result.getName());
			test.log(Status.SKIP, "Skipped test case is : "+result.getName());
			
		  }
		
		
		public void onFinish(ITestContext context) {
			extent.flush();
		}

}
