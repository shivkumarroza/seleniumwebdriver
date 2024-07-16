package day36;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadDemo {

	public static void main(String[] args) {
		File file = new File("/Users/shiv/Desktop/shiv copy.txt");
		String path="/Users/shiv/Desktop/shiv copy.txt";
		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice-automation.com/file-upload/");
		//Mthod 1
//		driver.get("https://practice-automation.com/file-upload/");
//		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(path);
		
		//Method 2
		
//		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(file.getAbsolutePath());
		
		//Method 3
		WebElement uploadbtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
		Actions act = new Actions(driver);
		act.click(uploadbtn).keyDown(Keys.COMMAND).sendKeys("A").sendKeys("O").keyUp(Keys.COMMAND).build().perform();
		
		
		
		
		

	}

}
