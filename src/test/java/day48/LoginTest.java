package day48;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	
	public WebDriver driver;
	
	@Parameters({"url"})
	@BeforeClass
	void setup(String url)
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}
	
	@Parameters({"userName","Password","title"})
	@Test
	void login(String username, String password,String title)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("username");
		lp.setPassword("password");
		lp.clickLogin();
		AssertJUnit.assertEquals(driver.getTitle(), title);
	}
	
	@AfterMethod
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
