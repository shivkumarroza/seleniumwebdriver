package day31;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSuggestionList {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("APjFqb")).sendKeys("selenium");


		//		List<WebElement> suggestions = driver.findElements(By.className("sbct"));
//		Thread.sleep(2000);
		TimeUnit.SECONDS.sleep(5);
		List<WebElement> suggestions = driver.findElements(By.className("wM6W7d"));
		System.out.println("Total suggetions : "+suggestions.size());

		for(int i=0;i<suggestions.size();i++)
		{
			if(!(suggestions.get(i).getText().isEmpty())) {
				System.out.println(suggestions.get(i).getText());
//				if(suggestions.get(i).getText().equals("selenium")) {
//					suggestions.get(i).click();
//					break;}
			}
		}

		driver.quit();
	}

}
