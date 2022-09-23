package tempTestPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pack.HeaderOptionsPage;
import pack.HomePage;
import pack.LoginPage;
import pack.OrdersPage;
import pack.PinForLoginPage;
import pack.ScreenShotPage;
import pack.TradeBookOrConsole;

public class TestClass4 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjog\\\\Desktop\\\\Mannual And Automation Testing\\\\Selenium Libarary\\\\105\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/?next=%2Fdashboard");
		
	
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendUsername();
		loginPage.sendPassword();
		loginPage.clickOnLoginButton();
		PinForLoginPage pinForLoginPage = new PinForLoginPage(driver);
		pinForLoginPage.sendLoginPin();
		pinForLoginPage.selectContinueButton();
		HeaderOptionsPage headerOptionsPage = new HeaderOptionsPage(driver);
	
		
		headerOptionsPage.openOrders();
		OrdersPage ordersPage = new OrdersPage(driver);
		ordersPage.viewTheHistoryOfOurTrading();
		Thread.sleep(10000);
		ArrayList <String> listOfOrders = new ArrayList <String> (driver.getWindowHandles());
		driver.switchTo().window(listOfOrders.get(1));
		TradeBookOrConsole tradeBookOrConsole = new TradeBookOrConsole(driver);
		tradeBookOrConsole.getReportOfTrading();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//String consolePageTitle = driver.getTitle();
//		if(consolePageTitle.equals("Tradebook / Console"))
//		{
//			System.out.println("open");
//		}
//		else
//		{
//			System.out.println("not open");
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
