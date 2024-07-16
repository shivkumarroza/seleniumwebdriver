package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		
		//find the first text area
		WebElement textArea1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		textArea1.sendKeys("Welcome");
		
		//CMD+A
		act.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND)
		
		//CMD+C
		.keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND)
		//Tab
		.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		//CMD+V
		act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
		
		driver.quit();
		
		act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
		

	}

}
