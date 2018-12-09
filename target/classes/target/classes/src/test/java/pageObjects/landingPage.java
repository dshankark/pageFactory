package pageObjects;




import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class landingPage {


	public WebDriver driver;
	By login =By.cssSelector("[href*='sign_in']");
	


	public landingPage(WebDriver driver) {


		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement landing() {
		// TODO Auto-generated method stub
		return  driver.findElement(login);
	}

	@Test
	public void getScreenshot() throws IOException, InvalidFormatException, HeadlessException, AWTException {
	//	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(src, new File("C:\\ss\\ss.png"));	
		


		FileOutputStream fos = new FileOutputStream(new File("C:\\ss\\Screenshot.docx"));
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph p= document.createParagraph();
		XWPFRun r = p.createRun();
		String screenshot_name = System.currentTimeMillis() + ".png";
		BufferedImage image = new Robot()
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        File file = new File("c:\\ss\\" + screenshot_name);
        ImageIO.write(image, "png", file);
        InputStream pic = new FileInputStream("c:\\ss\\" + screenshot_name);
        r.addBreak();
        
		r.addPicture(pic, document.PICTURE_TYPE_PNG,screenshot_name, Units.toEMU(350), Units.toEMU(350));
		
		document.write(fos);
		pic.close();
		file.delete();
		
		fos.flush();
		fos.close();
		




	}
}

