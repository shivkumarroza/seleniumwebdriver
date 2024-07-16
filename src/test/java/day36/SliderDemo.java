package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		
		//Min slider
		WebElement min_Slider=driver.findElement(By.xpath("//span[1]"));
		
		System.out.println(min_Slider.getLocation()); //(59, 251)
		
		act.dragAndDropBy(min_Slider, 100, 251).perform();
		
		System.out.println(min_Slider.getLocation());  //(160, 250)
		
		
		//Max slider
		WebElement max_Slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println(max_Slider.getLocation()); //(689, 250)
		
		
		act.dragAndDropBy(max_Slider, -300,250).perform();
		
		System.out.println(max_Slider.getLocation());
		
	}

}
