package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AuthenticatedPopUpDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		WebElement element=driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
		System.out.println(element.getText());
		if(element.getText().contains("Congratulations! You must have the proper credenti"))
			System.out.println("pass");
		

	}

}
