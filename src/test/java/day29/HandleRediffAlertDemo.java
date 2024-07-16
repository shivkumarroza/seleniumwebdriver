package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleRediffAlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://mypage.rediff.com/login/dologin");

		driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();

		Thread.sleep(2000);
		//		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert;
		while(true) {
			try {
				alert=wait.until(ExpectedConditions.alertIsPresent());
				System.out.println("pass");
				break;
				}
			catch(Exception e)
			{

			}

		}
		alert.accept();


	}

}
