package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		String actual_Title = driver.getTitle();
		
		if (actual_Title.equals("Your Store")) 
			System.out.println("Test is passed");
		else {
			System.out.println("Test failed");
		}
		
		driver.close();
		

	}

}
