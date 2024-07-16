package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		/*Set<String> windowsIDs = driver.getWindowHandles();
		//convert to list
		List<String> windowsList = new ArrayList<String>(windowsIDs);
		String parentWindow=windowsList.get(0);
		String childWindow=windowsList.get(1);
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());*/
		
		//Approch 2
		Set<String> windowsIDs = driver.getWindowHandles();
		for(String id:windowsIDs)
		{
			String title=driver.switchTo().window(id).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM"))
				break;
			
		}
		System.out.println(driver.getTitle());
	}

}
