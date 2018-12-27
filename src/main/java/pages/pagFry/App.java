package pages.pagFry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Hello world!
 *
 */
public class App{
	public WebDriver driver;
	public void temp(){
		System.setProperty("webdriver.chrome.driver","c://Chrome//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Assert.assertTrue(false);
		System.out.println("Next statment");

	}}