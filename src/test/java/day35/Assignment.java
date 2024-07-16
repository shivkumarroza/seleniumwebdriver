package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement buttoncopyText=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		field1.clear();
		field1.sendKeys("welcome");
		String text=field1.getAttribute("value");
		
		Actions act = new Actions(driver);
		act.doubleClick(buttoncopyText).perform();
		
		if(text.equals("welcome"))
			System.out.println("Text is copied");
		else
			System.out.println("Text is not copied : Testcase Failed");
		
		
	}

}
