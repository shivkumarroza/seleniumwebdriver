package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorLocator {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		//Search by CSS selector id - tagName#id
		//		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Tablets");

		//tagName.className locator
//		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("macbook");
		
		//tagName[Attribute=value]
//		driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("t-shirt");
		
		//tagName.className[attribute=value]
//		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("shiv");
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("shiv");
		


	}

}
