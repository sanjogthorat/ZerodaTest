package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderOptionsPage {
    private WebDriver driver;
	@FindBy (xpath = "(//a[@href='/orders'])[1]")
	private WebElement orderButton;
	@FindBy (xpath = "//span[text()='Trades']")
	private WebElement tradeButton;
	
	public HeaderOptionsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void openOrders() {
		WebDriverWait wait = new WebDriverWait(driver , 15);
		WebElement orderButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/orders'])[1]")));
		orderButton1.click();
	}
	public void clickOnTradeButton() throws InterruptedException
	{
		Thread.sleep(5000);
		tradeButton.click();
	}
}
