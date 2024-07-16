package day47;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	@FindBy(xpath = "//input[@placeholder='Username']") 
	private WebElement text_userName;
	
	@FindBy(xpath="//input[@placeholder='Password']") 
	private WebElement text_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	private WebElement login_btn;
	
	public LoginPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String userName)
	{
		text_userName.sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		text_password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login_btn.click();
	}
}
