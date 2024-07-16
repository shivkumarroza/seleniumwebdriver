package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllSelniumgetMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		System.out.println(driver.getWindowHandle());
		Set<String> windowids = driver.getWindowHandles();
		System.out.println(windowids);
		
		for(String windowid:windowids)
		{
			System.out.println(windowid);
			driver.switchTo().window(windowid);
			Thread.sleep(2000);
			driver.close();
		}
		

	}

}
