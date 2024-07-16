package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDatePickerDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.id("datepicker")).click();
		
		String Year = "2025";
		String Month="May";
		String Date ="20";
		
		selectpastDate(driver, "5", "June", "1990");
//		selectFutureDate(driver, Date, Month,Year);
		
//		driver.quit();

	}
	
	public static void selectFutureDate(WebDriver driver,String date, String month, String year)
	{
		while(true)
		{
			String curruntMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curruntYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(curruntMonth.equals(month) && curruntYear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	
	public static void selectpastDate(WebDriver driver,String date, String month, String year)
	{
		while(true)
		{
			String curruntMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curruntYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(curruntMonth.equals(month) && curruntYear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}

}
