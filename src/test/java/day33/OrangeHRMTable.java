package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//aside[@class='oxd-sidepanel']//li[1]")).click();
		int rows=driver.findElements(By.xpath("//div[@class='oxd-table-body'][@role='rowgroup']/div//div[@role='cell'][1]")).size();
		
		for(int i=1;i<=rows;i++)
		{
			String userName=driver.findElement(By.xpath("//div[@class='oxd-table-body'][@role='rowgroup']/div["+i+"]//div[@role='cell'][2]")).getText();
			String EmployeeName=driver.findElement(By.xpath("//div[@class='oxd-table-body'][@role='rowgroup']/div["+i+"]//div[@role='cell'][4]")).getText();
			System.out.println(userName+"\t"+EmployeeName);
//			System.out.println();
		}

	}

}
