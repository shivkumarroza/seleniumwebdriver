package day26;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class FlipkartSortProduct {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("mobile phones");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		List<WebElement>priceList=driver.findElements(By.cssSelector(".Nx9bqj"));
		Map<WebElement, Integer> map = new HashMap<WebElement, Integer>();
		
		for(int i=0;i<priceList.size();i++)
		{
			map.put(priceList.get(i), Integer.parseInt(priceList.get(i).getText().replaceAll("₹", "").replaceAll(",", "")));
		}
		
		List<Entry<WebElement, Integer>> list = new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
		list.sort(Entry.<WebElement, Integer>comparingByValue().reversed());
		
		for(Entry element : list)
		{
			System.out.println(element.getValue());
		}
		
		list.get(list.size()-4).getKey().click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> browserWindows = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(browserWindows);
		driver.switchTo().window(windows.get(windows.size()-1));
		
		System.out.println(driver.getTitle());
		
		String aText=driver.findElement(By.xpath("//div[@class='Nx9bqj' and text()='₹6,999']")).getText().replaceAll("₹", "").replaceAll(",", "");
		Assert.assertEquals(aText, "6999");
		System.out.println("All Verifications are pass");
//		driver.quit();
	}

}
