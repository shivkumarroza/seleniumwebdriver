package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMExample2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		SearchContext shadow=driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
		SearchContext shadow1=shadow.findElement(By.cssSelector("shop-home.iron-selected")).getShadowRoot();
		shadow1.findElement(By.cssSelector("a[aria-label='Ladies Outerwear Shop Now']")).click();
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
