package day47;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest2 {
	public WebDriver driver;
	
	@BeforeMethod
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	void login()
	{
		LoginPage2 lp2 = new LoginPage2(driver);
		lp2.setUserName("Admin");
		lp2.setPassword("admin123");
		lp2.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterMethod
	void tearDown()
	{
		driver.quit();
	}
}
