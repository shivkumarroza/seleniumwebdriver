package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageScrollDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//scroll based on pixel
//		js.executeScript("window.scrollBy(0,500)");
		
		//scrollBased on element
//		WebElement btn = driver.findElement(By.xpath("//a[normalize-space()='1']"));
//		js.executeScript("arguments[0].scrollIntoView()", btn);
		
		//scroll to the bottom
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//setValue to input box using js
//		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
//		js.executeScript("arguments[0].setAttribute('value','John')", name);
		
		js.executeScript("document.body.style.zoom='50%'");
		js.executeScript("document.body.style.zoom='70%'");

	}

}
