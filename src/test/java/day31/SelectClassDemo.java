package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement countriesdropwDown=driver.findElement(By.cssSelector("#country"));
		Select countries = new Select(countriesdropwDown);
		List<WebElement> Countryvalues = countries.getOptions();
		System.out.println("No of options : "+Countryvalues.size());
		
		for(WebElement element : Countryvalues)
		{
			
			countries.selectByVisibleText(element.getText());
			Thread.sleep(2000);
		}
	}

}
