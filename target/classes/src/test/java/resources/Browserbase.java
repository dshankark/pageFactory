package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserbase {

	public WebDriver driver;
	public Properties pro;
	public  WebDriver initializeDriver() throws IOException {

		pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Shankar Kumar\\eclipse-workspace\\Framework\\src\\test\\java\\resources\\globalData.properties");
		pro.load(fis);
		String browserName=pro.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
			driver= new ChromeDriver(); 



		}
		else if (browserName.equals("firefox")) {

		}

		else if (browserName.equals("IE")) {
		}
		return driver;	
	}
}
