package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjog\\\\Desktop\\\\Mannual And Automation Testing By Velocity\\\\Selenium Libarary\\\\chromedriver_win32\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");

	}

}
