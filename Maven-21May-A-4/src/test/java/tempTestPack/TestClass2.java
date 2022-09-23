package tempTestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pack.HiddenPopupForBuySharePage;
import pack.HomePage;
import pack.LoginPage;
import pack.PinForLoginPage;
import pack.ScreenShotPage;

public class TestClass2 {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		HomePage homePage = new HomePage(driver);
		
	
		
		homePage.clickOn7ThWishlist();
		homePage.sendTataShare();
		homePage.clickOnShare();
		homePage.againOnceClickOnShare();
		homePage.buyTheShare();
		HiddenPopupForBuySharePage hiddenPopupForBuySharePage = new HiddenPopupForBuySharePage(driver);
		hiddenPopupForBuySharePage.sendNoOfSharesinField();
		hiddenPopupForBuySharePage.clearTheLimitFieldFirst();
		hiddenPopupForBuySharePage.sendTheNewLimitValue();
		

		
		
		
	}

}
