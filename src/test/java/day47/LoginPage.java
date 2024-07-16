package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// without using PageFactory
public class LoginPage {
	private WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators

	private By text_userName_loc=By.xpath("//input[@placeholder='Username']");
	private By text_password_loc=By.xpath("//input[@placeholder='Password']");
	private By btn_login_loc=By.xpath("//button[normalize-space()='Login']");
	
	//Action Methods
	
	public void setUserName(String userName)
	{
		driver.findElement(text_userName_loc).sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(text_password_loc).sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(btn_login_loc).click();
	}
	

}
