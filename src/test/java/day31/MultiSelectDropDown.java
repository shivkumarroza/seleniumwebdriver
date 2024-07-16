package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement colorsdropwDown=driver.findElement(By.id("colors"));
		Select color = new Select(colorsdropwDown);
		System.out.println("No of colors : "+color.getOptions().size());

		for(WebElement option : color.getOptions())
		{
			System.out.println(option.getText());
			if(option.getText().equals("Red") || option.getText().equals("Blue") )
				color.selectByVisibleText(option.getText());
			
		}


		Thread.sleep(5000);
		driver.quit();

	}

}
