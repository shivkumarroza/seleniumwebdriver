package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetAllPricesinDescendingOrder {

	public static void main(String[] args) {
//		//div[@class='Nx9bqj']
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement electronics = driver.findElement(By.xpath("//div[@class='_1wE2Px']"));
		
		WebElement gaming = driver.findElement(By.xpath("//a[normalize-space()='Gaming']"));
		
		
		
		

	}

}
