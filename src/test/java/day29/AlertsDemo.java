package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
//		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
//		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		String aText=driver.findElement(By.xpath("//p[@id='result']")).getText();
		if(aText.equals("You clicked: Cancel"))
			System.out.println("You clicked dismiss");
		else
			System.out.println("You clicked accept");
		
		
//		driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
//		Thread.sleep(3000);
//		Alert alert=driver.switchTo().alert();
//		alert.sendKeys("shiv");
//		Thread.sleep(3000);
//		alert.accept();
		
	}

}
