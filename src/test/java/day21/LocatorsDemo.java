package day21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//		//name locator
//		driver.findElement(By.name("search")).sendKeys("mac");
//		
//		//id locator
//		boolean b = driver.findElement(By.id("logo")).isDisplayed();
//		System.out.println(b);
		//linkTest Locator
//		driver.findElement(By.linkText("Tablets")).click();
		//partialLinkText locator
//		driver.findElement(By.partialLinkText("Table")).click();
		
		//className locator
//		List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
//		System.out.println(headerLinks.size());
		
		//tagName locator - total number of links on the page
//		List<WebElement>header_links=driver.findElements(By.tagName("a"));
//		System.out.println("Total Number of links in home page "+header_links.size());
		
		//tagName locator - total number of images on the page
		List<WebElement>img_links=driver.findElements(By.tagName("img"));
		System.out.println("Total Number of links in home page "+img_links.size());
		driver.quit();
	}

}
