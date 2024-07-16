package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssSelctorPratice {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.opencart.com/");
		Thread.sleep(5000);
//		String eleTxt=driver.findElement(By.cssSelector("input.form-control")).getText();
		driver.findElement(By.cssSelector("input.form-control")).sendKeys("tablet");
		driver.findElement(By.cssSelector("button.btn[type=\"button\"][data-lang=\"en-gb\"]")).click();
		String eText=driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		if(eText.equals("There is no product that matches the search criteria."))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		Thread.sleep(5000);
//		System.out.println(eleTxt);
		
		driver.manage().window().fullscreen();
		driver.quit();
	}

}
