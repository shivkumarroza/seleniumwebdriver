package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DummyTicketDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dummy-tickets.com/");
		
		driver.findElement(By.xpath("//a[normalize-space()='Both']")).click();
		WebElement From=driver.findElement(By.xpath("(//input[@name='source[]'][@class='suggestion-input required mb-2'])[4]"));
		From.sendKeys("Del");
		List<WebElement> Fromsuggestions = driver.findElements(By.xpath("//p[@class='heading']"));
		for(WebElement ele : Fromsuggestions)
		{
			if(ele.getText().equals("Adelaide International Airport"));
			{
				ele.click();
				break;
			}
		}
		
//		Thread.sleep(2000);
		WebElement To=driver.findElement(By.xpath("(//input[@name='destination[]'][@class='suggestion-input required mb-2'])[4]"));
		To.sendKeys("a");
		
		driver.findElement(By.xpath("//p[normalize-space()='Anaa Airport,']")).click();
		
		WebElement departure=driver.findElement(By.xpath("//div[@class='row p-0 pt-2']//div[@class='col-sm-12 p-0']//label[@for='departure'][normalize-space()='Departure']/following-sibling::input"));
		departure.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", departure);
		
		WebElement month = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		
		Select selectMonth= new Select(month);
		selectMonth.selectByVisibleText("Jun");
		
		WebElement year = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select Selectyear= new Select(year);
		Selectyear.selectByVisibleText("2025");
		
		List<WebElement> DisplayedDates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for(WebElement dt : DisplayedDates)
		{
			if(dt.getText().equals("20"))
			{
				dt.click();
				break;
			}
		}
		
		
		
		

	}

}
