package day48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	By text_UserName_loc=By.name("username");
	By text_Password_loc=By.name("password");
	By btn_Login_loc=By.name("username");

	//Action methods
	public void setUserName(String userName)
	{
		driver.findElement(text_UserName_loc).sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(text_Password_loc).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_Login_loc).click();
	}
}
