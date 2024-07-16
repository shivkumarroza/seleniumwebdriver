package day42;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
 1. Open application
 2. test logo present
 3. login to applcation
 4. close
 */
public class HRMDemo {

	public static WebDriver driver;


	@Test(priority = 1)
	void openApp()
	{
		driver=new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2)
	void testLogoPresent()
	{
		boolean status=driver.findElement(By.cssSelector("img[src='/web/images/ohrm_branding.png?v=1711595107870']")).isDisplayed();
		if(status)
			System.out.println("Login page Logo displayed : "+status);
		else
			System.out.println("Login page Logo not displayed : "+status);
	}
	
	
	@Test(priority = 3)
	void Login()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click(); 
		if(driver.findElement(By.xpath("//img[@alt='profile picture' and @class='oxd-userdropdown-img']")).isDisplayed())
			System.out.println("Logo is displayed");
		else
			System.out.println("Logo not displayed");
	}
	
	@Test(priority = 4)
	void closeApp()
	{
		driver.quit();
	}



}
