package pages.pagFry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	WebDriver driver;
	@FindBy(xpath="//input[@id='RoundTrip']")
	WebElement Trip;
	@FindBy(xpath="//input[@id='ReturnDate']")
	WebElement Rtdt;
	@FindBy (xpath="//a[contains(text(),'25')]")
	WebElement Rdt;
	@FindBy (xpath="//input[@id='FromTag']")
	WebElement homefrmloc;
	@FindBy (xpath="//input[@id='ToTag']")
	WebElement hometoloc;
	@FindBy (xpath="//input[@id='DepartDate']")
	WebElement homedepdt;
	@FindBy (xpath="//a[contains(text(),'20')]")
	WebElement homedt;
	@FindBy (xpath="//input[@id='SearchBtn']")
	WebElement homesrchbt;


	public  HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public String homeTitle() {
		return driver.getTitle();
	}
	public void roundtrip() {
		Trip.click();
	}
	public void setFromLoc(String homefrm) {
		homefrmloc.sendKeys(homefrm);
	}
	public void setToLoc(String hometo) {
		hometoloc.sendKeys(hometo);
	}
	public void setDep() {
		homedepdt.click();
		homedt.click();
	}
	public void setRet() {
		Rtdt.click();
		Rdt.click();
	}
	public void searchhome() {
		homesrchbt.click();
	}


	public void sethomeparam(String homefrm,String hometo) {

		this.setFromLoc(homefrm);
		this.setToLoc(hometo);
		this.setDep();
		this.searchhome();

	}
	public void sethomeretparam(String homefrm,String hometo) {
		this.roundtrip();
		this.setFromLoc(homefrm);
		this.setToLoc(hometo);
		this.setDep();
		this.setRet();
		this.searchhome();

	}

}
