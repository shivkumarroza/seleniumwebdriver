package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement Mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (2)']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(Desktop).moveToElement(Mac).click().build().perform();

	}

}
