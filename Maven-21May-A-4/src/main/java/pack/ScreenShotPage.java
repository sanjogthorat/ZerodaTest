package pack;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class ScreenShotPage {
	  private WebDriver driver;
		 DateFormat date = new SimpleDateFormat("dd-MM-yy_hh-mm-ss");     
	     Date systemdate = new Date();
		String s = date.format(systemdate);
		
		
		public ScreenShotPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		public void takeScreenshot () throws IOException, InterruptedException
		{
			 TakesScreenshot takes = (TakesScreenshot)driver;
	         File src = takes.getScreenshotAs(OutputType.FILE);
	         File dest = new File("C:\\Users\\Sanjog\\Desktop\\Mannual And Automation Testing\\Screenshots"+s+".jpeg");
	         Thread.sleep(10000);
	         FileHandler.copy(src, dest);
}
}