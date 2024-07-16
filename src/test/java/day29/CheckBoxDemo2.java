package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo2 {

	public static void main(String[] args) {
		// //tbody/tr/td/input
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//tbody/tr/td/input"));

		for(WebElement element : checkboxes)
		{
			element.click();
		}
	}

}
