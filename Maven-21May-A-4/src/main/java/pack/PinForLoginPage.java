package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinForLoginPage {

	@FindBy (xpath = "//input[@label='PIN']")
	private WebElement loginPin;
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement continueButton;
	
	public PinForLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendLoginPin(String pin) {
		loginPin.sendKeys(pin);
	}
	public void selectContinueButton() {
		continueButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
