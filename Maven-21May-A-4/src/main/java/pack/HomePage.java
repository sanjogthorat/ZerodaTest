package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath = "//input[@type='text']")
	private WebElement searchBox;
	@FindBy (xpath = "(//span[text()='TATAMOTORS'])[1]")
	private WebElement tatashare;
	@FindBy (xpath = "(//li[@class='item'])[6]")
	private WebElement wishlist7thnumber;
	@FindBy (xpath = "//button[@class='button-blue buy']")
	private WebElement buyButton;
	@FindBy (xpath = "(//button[@type='button'])[2]")
	private WebElement sellButton;
	@FindBy (xpath = "//span[text()='EH6261']")
	private WebElement accoundIdButton;
	@FindBy (xpath = "//a[@target='_self']")
	private WebElement logoutButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendTataShare() {
		searchBox.sendKeys("TATAMOTORS");
	}
	public void clickOnShare() {
		tatashare.click();
	}
	public void clickOn7ThWishlist() {
		wishlist7thnumber.click();
	}
	public void againOnceClickOnShare() {
		tatashare.click();
	}
	public void buyTheShare() {
		buyButton.click();
	}
	public void sellTheShare() {
		sellButton.click();
	}
	
	public void clickOnAccountIdButton()
	{
		accoundIdButton.click();
	}
	public void clickOnLogOutButton()
	{
		logoutButton.click();
	}
	
	
	
	
	
	
}
