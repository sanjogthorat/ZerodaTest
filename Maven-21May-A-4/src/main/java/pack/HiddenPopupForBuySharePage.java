package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HiddenPopupForBuySharePage {
	@FindBy (xpath = "(//input[@type='number'])[1]")
	private WebElement noOfShares;
	@FindBy (xpath = "(//input[@type='number'])[2]")
	private WebElement limitValue;
	
	public HiddenPopupForBuySharePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void sendNoOfSharesinField() {
		noOfShares.sendKeys("5");
	}
	public void firstClearTheLimitValueField() {
		limitValue.clear();
	}
	public void clearTheLimitFieldFirst() {
		limitValue.clear();
	}
	public void sendTheNewLimitValue() {
		limitValue.sendKeys("465.75");
	}
}
