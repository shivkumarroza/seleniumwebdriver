package day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 Broken link test procedure 
 1. Link get href atribute - href="https://abc.com"
 2. - href="https://abc.com" -->server -->status code
 3. statusCode>=400 broken link
    <400 not a broken link

 */

public class BrokenLinksDemo3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total Number of links : "+allLinks.size());
		
		isBrokkenLink(allLinks);
	}
	
	
	public static void isBrokkenLink(List<WebElement> allLinks)
	{
		for(WebElement link:allLinks)
		{
			String hrefAttValue = link.getAttribute("href");
			if(hrefAttValue.isEmpty() || hrefAttValue==null)
			{
				System.out.println("href value is either null or empty so cannot check");
				continue;
			}
			try {
			URL url = new URL(hrefAttValue);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.connect();
			int respCode=connection.getResponseCode();

			if(respCode>=400)
			{
				System.out.println(hrefAttValue+" ==> Broken Link :"+respCode);
			}
			else
			{
				System.out.println(hrefAttValue+" ==> Not a broken link :"+respCode);
			}
			}
			catch(Exception e)
			{
				System.out.println("Exception occured : "+e.getMessage());
			}

		}
	}
}

