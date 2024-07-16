package waste;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelexcutionDemo {
	WebDriver driver;

	@Parameters({"browser","url"})
	@BeforeClass
	void setup(String br,String url)
	{
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		case "safari" : driver=new SafariDriver();break;
		default : System.out.println("invalid browser"); return;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	void testLogo()
	{
		boolean logoStatus=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		AssertJUnit.assertTrue(logoStatus);
	}
	
	@Test
	void testTitle()
	{
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test
	void testCurruntURL()
	{
		String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		AssertJUnit.assertEquals(driver.getCurrentUrl(), url);
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
