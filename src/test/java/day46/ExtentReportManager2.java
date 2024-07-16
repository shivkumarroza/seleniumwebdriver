package day46;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager2 implements ITestListener {
	public ExtentSparkReporter extentReporter; //UI of report
	public ExtentReports extent; // common config info and system info
	public ExtentTest test; // test creating and updating status



	public void onStart(ITestContext context) {
		String dateTime=new Date().toString().replaceAll(":", "_");
		extentReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/Report-"+dateTime+".html");
		extentReporter.config().setDocumentTitle("Automation Report");
		extentReporter.config().setReportName("Functional Testing");
		extentReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(extentReporter);
		
		extent.setSystemInfo("Computer Name", "Macbook Air");
		extent.setSystemInfo("Tester", "shivkumar");
		extent.setSystemInfo("OS", "Catalina");
		extent.setSystemInfo("Browser", "Chrome");

	}


	public void onTestSuccess(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Passed TestCase is : "+result.getName());

	}

	public void onTestFailure(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Failed Test case is : "+result.getName());
		test.log(Status.FAIL, "cause of failure : "+result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Skipped test case is : "+result.getName());

	}


	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
