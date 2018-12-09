package FWproj.Framework;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import resources.Browserbase;

public class Homepage extends Browserbase{
	
	private static Logger logs=LogManager.getLogger(Logger.class.getName());

	@Test
	public void hommePag() throws IOException, InvalidFormatException, HeadlessException, AWTException {
		
		
		driver= initializeDriver();
		
		logs.info("driver intialized");
		String ur=pro.getProperty("url");
		driver.get(ur);
		driver.manage().window().maximize();
		landingPage lp= new landingPage(driver);
		lp.getScreenshot();
		lp.landing().click();;
	}
	
	
}
