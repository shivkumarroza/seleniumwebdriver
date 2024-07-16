package day48;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	public LoginPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


//	@FindBy(xpath="//input[@placeholder='Username']") 
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	private WebElement username;

	@FindBy(xpath="//input[@placeholder='Password']") 
	private WebElement password;

	@FindBy(xpath="//button[normalize-space()='Login']") 
	private WebElement login;
	
	public void setUsername(String username) {
		this.username.sendKeys(username);;
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLogin() {
		this.login.click();
	}

	




}
