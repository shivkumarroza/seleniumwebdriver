package day25;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		String text=driver.findElement(By.xpath("//a[normalize-space()='NLC India L']/self::a")).getText();
		System.out.println("self "+text);
		
		text=driver.findElement(By.xpath("//a[normalize-space()='HLE Glascoat']")).getText();
		System.out.println("Parent: "+text);
		
		//Parents
		List<WebElement>parentElements=driver.findElements(By.xpath("//*[contains(text(),'Investment')]/parent::*"));
		System.out.println("Total parents "+parentElements.size());
		for(WebElement element : parentElements)
		{
			System.out.println(element.getText());
		}
		driver.quit();
	}

}
