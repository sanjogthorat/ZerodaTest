package tempTestPack;

import java.io.IOException;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pack.HiddenPopupForBuySharePage;
import pack.HomePage;
import pack.LoginPage;
import pack.PinForLoginPage;
import setup.Base;
import utils.Utility;

public class TestNgTestClass extends Base {

	private WebDriver driver;
	private LoginPage loginPage;
	private PinForLoginPage pinForLoginPage;
	private HomePage homePage;
	private HiddenPopupForBuySharePage hiddenPopupForBuySharePage;
	int testId ;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
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
		homePage = new HomePage(driver);
		hiddenPopupForBuySharePage = new HiddenPopupForBuySharePage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException
	{
		String data = Utility.fetchDataFromExcelSheet("Sanjog Info", 6, 1);
		loginPage.sendPassword(data);
		
		loginPage.clickOnLoginButton();
		String data2 = Utility.fetchDataFromExcelSheet("Zeroda pin", 0, 0);
		pinForLoginPage.sendLoginPin(data2);

		pinForLoginPage.selectContinueButton();
		 
	}
	
	@Test
	public void buyShare() throws InterruptedException, IOException
	{   
	      testId = 10111;
//		Thread.sleep(4000);
//		String titleOfDashboard = driver.getTitle();
//		Assert.assertEquals(titleOfDashboard, "Kite - Zerodha's fast and elegant flagship trading platform");
		
		homePage.clickOn7ThWishlist();
	
		homePage.sendTataShare();
	
		homePage.clickOnShare();
	
		homePage.againOnceClickOnShare();
		Thread.sleep(8000);
		homePage.buyTheShare();
		
		hiddenPopupForBuySharePage.sendNoOfSharesinField();

		hiddenPopupForBuySharePage.clearTheLimitFieldFirst();
	
		hiddenPopupForBuySharePage.sendTheNewLimitValue();
		 
		 
		
	}
	

	@Test
	public void testMethod() throws InterruptedException, IOException
	{
		 testId = 10222;
//		String titleOfDashboard = driver.getTitle();
//		Assert.assertEquals(titleOfDashboard, "Kite - Zerodha's fast and elegant flagship trading platform");
		
		homePage.sendTataShare();
	
		homePage.clickOnShare();
		 
	}
	
	@AfterMethod
	public void clickOnLogoutButton(ITestResult result) throws InterruptedException, IOException
	{
	
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver, testId);
		}
			
       
		homePage.clickOnAccountIdButton();

		homePage.clickOnLogOutButton();
	}
	
	
	@AfterClass
	public void cleanPOMObjects()
	{
		loginPage = null;
		pinForLoginPage = null;
		homePage = null;
		hiddenPopupForBuySharePage = null;
	}
	
	@AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
