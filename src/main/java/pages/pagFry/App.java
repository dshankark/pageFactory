package pages.pagFry;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class App extends Browser{
	WebDriver driver;
	{
		TakesScreenshot ss= ((TakesScreenshot)driver);
		File Srcfile= ss.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm-dd-yyyy_hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String dt= dtf.format(now);

		File destfile= new File("C://SS"+dt+".png");
		try {
			FileUtils.copyFile(Srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}}
