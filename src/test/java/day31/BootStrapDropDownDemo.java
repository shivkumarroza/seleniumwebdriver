package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://codepen.io/craigwheeler/pen/OOMMVo");
		driver.manage().window().maximize();
		
//		Thread.sleep(3000);
		WebElement frame=driver.findElement(By.id("result"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", options);
		
		List<WebElement> options = driver.findElements(By.xpath("//label[@class='checkbox']"));
		System.out.println("No of options "+options.size());
		for(WebElement element: options)
		{
			Thread.sleep(3000);
			System.out.println(element.getText());
			if(!(element.getText().equals("Select all")))
			{
				element.click();
			}
		}
		driver.quit();

	}

}
