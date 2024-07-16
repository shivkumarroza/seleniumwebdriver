package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoBlazecomDemo {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
//		option.sets
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		
		//get Total Number of links
//		List<WebElement> links=driver.findElements(By.tagName("a"));
////		System.out.println(links);
//		System.out.println("total number of links "+links.size());
//		for(WebElement element:links)
//		{
//			System.out.println(element.getAttribute("href"));
//		}
		
		// get total number of images
//		List<WebElement> total_images = driver.findElements(By.tagName("img"));
//		System.out.println("Total number of images "+total_images.size());
//		
//		for(WebElement element:total_images)
//			{
//				System.out.println(element.getAttribute("src"));
//			}
		
		Thread.sleep(1000);		
		//Click on any link using linkText
//		driver.findElement(By.linkText("Samsung galaxy s6")).click();
		driver.findElement(By.partialLinkText("HTC")).click();
		Thread.sleep(1000);	
		
		
		driver.quit();

	}

}
