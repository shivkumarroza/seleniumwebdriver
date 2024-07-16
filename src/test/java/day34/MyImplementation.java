package day34;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyImplementation {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='frame-one796456169']"));
		driver.switchTo().frame(frame);
//		driver.findElement(By.xpath("//input[@id='RESULT_TextField-2']")).sendKeys("06/05/1990");
		
		driver.findElement(By.xpath("//span[@role='button'][@class='icon_calendar']")).click();
		
		//Given date,month and Year
		String RequiredYear = "2025";
		String RequiredMonth="November";
		String RequiredDate ="20";
		
		//Not good as - we dont know whether month is in past or future.
		while(true)
		{
			String Month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(Month.equals(RequiredMonth))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		WebElement curruntYear=driver.findElement(By.xpath("//select[@aria-label='Select year'][@data-handler='selectYear']"));
		Select year = new Select(curruntYear);
		year.selectByValue(RequiredYear);

	}

}
