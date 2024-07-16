package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQuerydatePickerDemo2 {

	//future date
	static void futureDatePicker(WebDriver driver, String Month, String Year, String date)
	{
		while(true) {
			String curruntMonth = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
			String curruntYear = driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
			if(curruntMonth.equals(Month) && curruntYear.equals(Year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //paste date

		List<WebElement> AllDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for(WebElement dt:AllDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	
	//pastDate picker
	static void pastDatePicker(WebDriver driver, String Month, String Year, String date)
	{
		while(true) {
			String curruntMonth = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
			String curruntYear = driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
			if(curruntMonth.equals(Month) && curruntYear.equals(Year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		

		List<WebElement> AllDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for(WebElement dt:AllDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();

		//given month , Year and date
		String Year="2027";
		String Month="June";
		String date ="5";

		futureDatePicker(driver, Month, Year, date);
//		pastDatePicker(driver, Month, Year, date);

		driver.quit();

	}

}
