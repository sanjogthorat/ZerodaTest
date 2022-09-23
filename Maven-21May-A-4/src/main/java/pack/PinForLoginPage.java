package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinForLoginPage {

	@FindBy (xpath = "//input[@id='pin']")
	private WebElement loginPin;
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement continueButton;
	
	public PinForLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendLoginPin() {
		loginPin.sendKeys("001119");
	}
	public void selectContinueButton() {
		continueButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
