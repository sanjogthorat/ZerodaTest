package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradeBookOrConsole {

	//button[@type='submit']
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement gethistory;
	
	
	public TradeBookOrConsole(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void getReportOfTrading() {
		gethistory.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
