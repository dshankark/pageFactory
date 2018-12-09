package pages.pagFry;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {

	WebDriver driver;
	int i=1;
	@FindBy(xpath="//ul[contains(@class,'listView flights')]/li[contains(@class,'listItem')]")
	List<WebElement> listView;
	@FindBy(xpath="//div[contains(@class,'listItem')]")
	List<WebElement> roundList;

	public  FlightPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public List<WebElement> listSize() throws InterruptedException {
		//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(30000);
		return listView;
	}

	public List<WebElement> roundListSize() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'row legsContainer')]//div[1]//nav[1]//ul[1]//li[1]//div[1]//label[1]//table[1]//tbody[1]//tr[1]//th[6]")));
		Thread.sleep(30000);
		return roundList;

	}


}
