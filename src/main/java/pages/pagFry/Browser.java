package pages.pagFry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	static WebDriver driver;
	public WebDriver setBrowser() {
		System.out.println("Executing the browser class");
		System.setProperty("webdriver.chrome.driver","c://Chrome//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		return driver;
	}
}