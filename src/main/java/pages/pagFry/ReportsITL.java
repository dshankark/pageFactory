package pages.pagFry;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

public class ReportsITL implements ITestListener{
	WebDriver driver;



	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@BeforeTest
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase failed is :"+Result.getName());

		TakesScreenshot ss= ((TakesScreenshot)Browser.driver);
		File Srcfile= ss.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String dt= dtf.format(now);
		System.out.println("local time is "+dt);
		File destfile= new File("C://SS//"+Result.getName()+dt+".png");
		System.out.println(destfile.getPath());
		try {
			FileUtils.copyFile(Srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The test Result is :"+Result.getName());

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase passes is :"+Result.getName());
	}

}
