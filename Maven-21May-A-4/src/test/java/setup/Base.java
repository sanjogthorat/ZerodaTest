package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjog\\Desktop\\Mannual And Automation Testing\\Selenium Libarary\\105\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		 return driver;
	}
	
	public static WebDriver openFireFoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sanjog\\Desktop\\Mannual And Automation Testing\\Selenium Libarary\\Firefox\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver = new FirefoxDriver(option);
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
