package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HiddenpopupForSellSharePage {


	@FindBy (xpath = "//button[@type='submit']")
	private WebElement sellButtonOfPopup;
	
	
	public HiddenpopupForSellSharePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickTheSellButtonOnHiddenPopup() {
		sellButtonOfPopup.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
