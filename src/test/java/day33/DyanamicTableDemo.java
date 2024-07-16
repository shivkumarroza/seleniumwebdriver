package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanamicTableDemo {

	public static void main(String[] args) throws InterruptedException {
		//
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		int noPages=driver.findElements(By.xpath("//ul[@id='pagination']//li/a")).size();
		System.out.println(noPages);

		for(int p=1;p<=noPages;p++)
		{
			if(p>1)
			{
				driver.findElement(By.xpath("//ul[@id='pagination']//li["+p+"]/a")).click();
				//				Thread.sleep(3000);

			}

			int noRows=driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
			for(int i=1;i<=noRows;i++)
			{
				String Name=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[2]")).getText();
				String Price=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[3]")).getText();
				WebElement Select=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[4]/input"));
				Select.click();
				Thread.sleep(3000);
				System.out.println(Name);
				System.out.println(Price);
				System.out.println(Select.isSelected());
				Thread.sleep(1000);
			}



		}
		driver.quit();

	}

}
