package day34;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DOBDatePickerDemo {

	static Month convertMonth(String month)
	{
		HashMap<String,Month> map=new HashMap<String, Month>();
		map.put("January", Month.JANUARY);
		map.put("February", Month.FEBRUARY);
		map.put("March", Month.MARCH);
		map.put("April", Month.APRIL);
		map.put("May", Month.MAY);
		map.put("June", Month.JUNE);
		map.put("July", Month.JULY);
		map.put("August", Month.AUGUST);
		map.put("September", Month.SEPTEMBER);
		map.put("October", Month.OCTOBER);
		map.put("November", Month.NOVEMBER);
		map.put("December", Month.DECEMBER);
		
		
		
		Month vmonth=map.get(month);
		if(vmonth==null)
		{
			System.out.println("invalid month");
		}
		return vmonth;
	}

	static void selectDate(WebDriver driver, String RequiredMonth, String RequiredDate )
	{
		while(true)
		{
			String displayedMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			Month curruntMonth = convertMonth(displayedMonth);
			Month expectedMonth=convertMonth(RequiredMonth);
			int result=expectedMonth.compareTo(curruntMonth);

			if(result>0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			else if(result<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else
			{
				break;
			}

		}
		List<WebElement>Displayeddates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//a"));
		for(WebElement dt:Displayeddates)
		{
			if(dt.getText().equals(RequiredDate))
			{
				dt.click();
				break;
			}
		}
	}
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
		String RequiredMonth="January";
		String RequiredDate ="15";

		WebElement curruntYear=driver.findElement(By.xpath("//select[@aria-label='Select year'][@data-handler='selectYear']"));
		Select year = new Select(curruntYear);
		year.selectByValue(RequiredYear);

		selectDate(driver, RequiredMonth, RequiredDate);

		




	}

}
