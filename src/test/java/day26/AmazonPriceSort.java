package day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AmazonPriceSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Mobile phones");
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
		
		List<WebElement> allPricesList=driver.findElements(By.cssSelector("span.a-price-whole"));
		Map<WebElement,Integer> map = new HashMap<WebElement, Integer>();
		
		for(int i=0;i<allPricesList.size();i++)
		{
			map.put(allPricesList.get(i), Integer.parseInt(allPricesList.get(i).getText().replaceAll(",", "")));
		}
		
		List<Entry<WebElement,Integer>> list = new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
		list.sort(Entry.<WebElement,Integer>comparingByValue());
		
		for(Entry element :list)
		{
			System.out.println(element.getValue());
		}
		
		list.get(0).getKey().click();
		list.get(list.size()-2).getKey().click();
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
