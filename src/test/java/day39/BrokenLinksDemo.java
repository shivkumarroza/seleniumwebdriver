package day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Broken link test procedure 
 1. Link get href atribute - href="https://abc.com"
 2. - href="https://abc.com" -->server -->status code
 3. statusCode>=400 broken link
    <400 not a broken link

 */

public class BrokenLinksDemo {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total no of links : "+allLinks.size());

		int brokencount=0;
		int notBorkenLink=0;
		int respCode=0;
		for(WebElement link:allLinks)
		{
			String linkhrefAttValue=link.getAttribute("href");
			if(linkhrefAttValue==null || linkhrefAttValue.isEmpty())
			{
				System.out.println("href value is empty so cannot check the link");
				continue;
			}
			try {
			URL url = new URL(linkhrefAttValue);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			respCode=conn.getResponseCode();
			}
			catch(Exception e)
			{
				
			}
			if(respCode>=400)
			{
				System.out.println("Broken link "+"\n"+linkhrefAttValue);
				brokencount++;
			}
			else
			{
				System.out.println("link is working fine : "+linkhrefAttValue);
				notBorkenLink++;
			}
			
		}
		
		System.out.println("Total no of broken links : "+brokencount);

	}

}
