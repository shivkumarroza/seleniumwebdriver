package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BJSDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("search")).sendKeys("water");
		
		List<WebElement> suggestionOptions = driver.findElements(By.xpath("//div[@class='list-item border-0 list-group-item']"));
		
		System.out.println("item Count : "+suggestionOptions.size());
		
		for(WebElement suggetion:suggestionOptions)
		{
			System.out.println(suggetion.getText());
//			suggetion.click();
		}

	}

}
