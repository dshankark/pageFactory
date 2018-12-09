package pages.pagFry;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtRep implements ITestListener{
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Ends");
		reports.endTest(test);
		reports.flush();

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Start the Test");
		reports = new ExtentReports("./test-output/extent.html",true);


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO,result.getMethod().getMethodName()+"  test started");
		TakesScreenshot ss= (TakesScreenshot)Browser.driver;
		File srcfile= ss.getScreenshotAs(OutputType.FILE);
		File destfile= new File("C://ss//"+result.getMethod().getMethodName()+".png");
		String file=test.addScreenCapture("C://ss//"+result.getMethod().getMethodName()+".png");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName()+"test failed", file);
		test.log(LogStatus.FAIL,result.getMethod().getMethodName()+" test failed "+ result.getThrowable().getMessage());
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO,result.getMethod().getMethodName()+" test is started");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO,result.getMethod().getMethodName()+" test passed");

	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	public void onExecutionFinish() {
		// TODO Auto-generated method stub

	}

	public void onExecutionStart() {
		// TODO Auto-generated method stub

	}

}
