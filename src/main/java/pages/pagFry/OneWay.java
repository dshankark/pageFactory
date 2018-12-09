package pages.pagFry;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OneWay {

	WebDriver driver;
	int i=1;

	@Test(priority=0, groups= {"one_way"})
	public void browser() {
		Browser br= new Browser();
		driver = br.setBrowser();

	}

	@Test(priority=1, groups= {"one_way"})
	public void Loginhome() {
		System.out.println("Entering oneway Login homepage method");
		HomePage ow= new HomePage(driver);
		ow.sethomeparam("Chennai", "Madurai");
		String Tit=ow.homeTitle();
		System.out.println(Tit);
		Assert.assertEquals("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.", Tit);


	}

	@Test(priority=2,groups= {"one_way"})
	public void FlightList() throws InterruptedException {
		System.out.println("Entering oneway flightlist method");
		FlightPage Fp=new FlightPage(driver);
		List<WebElement> ls=Fp.listSize();
		//	List<WebElement>  ls =driver.findElements(By.xpath("//ul[contains(@class,'listView flights')]/li[contains(@class,'listItem')]"));
		for (WebElement ws:ls ) {


			if (i==1) {
				String Topfare=driver.findElement(By.xpath("//li[contains(@class,'listItem showTabs nonBundled')]//th[@id='BaggageBundlingTemplate']")).getText();
				System.out.println(Topfare);
				i++;
			}
			//String fare=driver.findElement(By.xpath("//ul[contains(@class,'listView flights')]/li[j]/table[1]/tbody[2]/tr[1]/th[6]")).getText();
			else if(i>1) {
				String fare = driver.findElement(By.xpath("//ul[contains(@class,'listView flights')]//li["+i+"]//table[1]//tbody[2]//tr[1]//th[6]")).getText();

				String fare1=fare.substring(1);
				String fare2=fare1.replace(",","");
				System.out.println(fare2);
				i++;
			}
		}

	}

}


