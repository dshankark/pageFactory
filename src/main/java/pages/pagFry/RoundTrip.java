package pages.pagFry;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtRep.class)
public class RoundTrip {
	WebDriver driver;
	int i=0;

	@Test(priority=0, groups={"two_way"})
	public void browser() {
		Browser br= new Browser();
		driver = br.setBrowser();

	}


	@Test(priority=1, groups= {"two_way"})
	public void roundTr() {
		System.out.println("Entering rountrip Login homepage method");
		HomePage hp=new HomePage(driver);

		hp.sethomeretparam("Chennai", "Trichy");

	}
	@Test(priority=2, groups= {"two_way"})
	public void roundFlightView() throws InterruptedException{
		System.out.println("Entering roundtrip flightview method");
		FlightPage ftp=new FlightPage(driver);
		List<WebElement> ls=ftp.roundListSize();

		for (WebElement ws:ls ) {

			i++;
			System.out.println("Entering value of i is "+i);
			try {
				WebElement price = driver.findElement(By.xpath("//div[contains(@class,'row legsContainer')]//div[1]//nav[1]//ul[1]//li["+i+"]//div[1]//label[1]//table[1]//tbody[1]//tr[1]//th[6]"));
				if(price!=null) {
					String fare = price.getText();

					String fare1=fare.substring(1);
					String fare2=fare1.replace(",","");
					System.out.println(fare2);
				}
				else {

					System.out.println("No Such Element");
				}
			}catch(NoSuchElementException e) {System.out.println(e);}
		}
		System.out.println("Length is "+i);
	}

}

