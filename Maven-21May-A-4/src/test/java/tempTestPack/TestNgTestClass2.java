package tempTestPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pack.HeaderOptionsPage;
import pack.HiddenpopupForSellSharePage;
import pack.HomePage;
import pack.LoginPage;
import pack.OrdersPage;
import pack.PinForLoginPage;
import pack.TradeBookOrConsole;
import setup.Base;
import utils.Utility;

public class TestNgTestClass2 extends Base {
private WebDriver driver;
private LoginPage loginPage;
private PinForLoginPage pinForLoginPage;
private HomePage homePage;
private HiddenpopupForSellSharePage hiddenpopupForSellSharePage;
private HeaderOptionsPage headerOptionsPage;
private OrdersPage ordersPage;
private TradeBookOrConsole tradeBookOrConsole;
int testId;
    @Parameters ("browser")
    @BeforeTest
    public void launchBrowser(String browserName)
    {
    	if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browserName.equals("FireFox"))
		{
			driver = openFireFoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException
	{
		
		driver.get("https://kite.zerodha.com/?next=%2Fdashboard");
		loginPage = new LoginPage(driver);
		
		String data = Utility.fetchDataFromExcelSheet("Sanjog Info", 6, 0);
		loginPage.sendUsername(data);
		pinForLoginPage = new PinForLoginPage(driver);
		headerOptionsPage = new HeaderOptionsPage(driver);
		homePage = new HomePage(driver);
		hiddenpopupForSellSharePage = new HiddenpopupForSellSharePage(driver);	
		ordersPage = new OrdersPage(driver);
		tradeBookOrConsole = new TradeBookOrConsole(driver);
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException
	{
		String data = Utility.fetchDataFromExcelSheet("Sanjog Info", 6, 1);
		loginPage.sendPassword(data);
	
		loginPage.clickOnLoginButton();
		
		pinForLoginPage.sendLoginPin();
		
		pinForLoginPage.selectContinueButton();
	
	}
	
	@Test
	public void test() throws InterruptedException, IOException
	{   
	     testId = 10333;
//		String titleOfDashboard = driver.getTitle();
//		Assert.assertEquals(titleOfDashboard, "Kite - Zerodha's fast and elegant flagship trading platform");

		homePage.sendTataShare();
		
		homePage.clickOnShare();
		
		homePage.againOnceClickOnShare();
		Thread.sleep(5000);
		homePage.againOnceClickOnShare();
		homePage.sellTheShare();
		Thread.sleep(5000);
		homePage.sellTheShare();
		hiddenpopupForSellSharePage.clickTheSellButtonOnHiddenPopup();	
		
	}
	

	@Test
	public void test1() throws InterruptedException, IOException 
	{   
		 testId = 10444;
//		String titleOfDashboard = driver.getTitle();
//		Assert.assertEquals(titleOfDashboard, "Kite - Zerodha's fast and elegant flagship trading platform");
		headerOptionsPage.openOrders();
		//headerOptionsPage.clickOnTradeButton();
		ordersPage.viewTheHistoryOfOurTrading();
		Thread.sleep(10000);
		ArrayList <String> listOfOrders = new ArrayList <String> (driver.getWindowHandles());
		driver.switchTo().window(listOfOrders.get(1));
		tradeBookOrConsole.getReportOfTrading();
//		String titleOfReportPage = driver.getTitle();
//		Assert.assertEquals(titleOfReportPage, "Tradebook / Console");
		
	}
	
	@AfterMethod
	public void clickOnLogoutButton(ITestResult result) throws InterruptedException, IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver, testId);
		}
		Thread.sleep(10000);
		homePage.clickOnAccountIdButton();
		homePage.clickOnLogOutButton();
	}
	
	
	@AfterClass
	public void cleanPOMObjects()
	{
		loginPage = null;
		pinForLoginPage = null;
		headerOptionsPage = null;
		homePage = null;
		hiddenpopupForSellSharePage = null;
		ordersPage = null;
		tradeBookOrConsole = null;
	}
	
	@AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
