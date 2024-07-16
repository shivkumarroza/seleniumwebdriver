package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	public WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		driver=new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	@Test(dataProvider="dp1")
	void loginApp(String email, String pwd)
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		boolean status = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']//img")).isDisplayed();
		
		
		if(status==true)
		{
			System.out.println("Profile picture is displayed");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}

	@DataProvider(name="dp1", indices = {0,4})
	Object[][] loginData()
	{
		Object[][] data = {
				{"abc","xyz"},
				{"abc","abc@123"},
				{"ram","sam"},
				{"shankar","bholenath"},
				{"rajkumar","Punit"},
				{"Admin","admin123"}
				
		};
		return data;
	}
}
