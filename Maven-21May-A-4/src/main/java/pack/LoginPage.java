package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath = "//input[@id='userid']")
	private WebElement userName;
	@FindBy (xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement loginbutton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUsername(String user) {
		userName.sendKeys(user);
	}
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnLoginButton() {
		loginbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
