package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiddenDropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		Thread.sleep(2000);
		
		WebElement listExpander=driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[7]//div[1]//div[2]//div[1]//div[1]//div[1]"));
		listExpander.click();
		Thread.sleep(5000);
		List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println("Number of options "+options.size());
		
		for(WebElement element : options)
		{
			System.out.println(element.getText());
		}
		
		options.get(1).click();
		
//		driver.findElement(By.xpath("//span[contains(normalize-space(),'Full-Time Contract')]")).click();
		
		
		

	}

}
