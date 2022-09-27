package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browsers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		 return driver;
	}
	
	public static WebDriver openFireFoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\browsers\\geckodriver.exe");
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver = new FirefoxDriver(option);
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
