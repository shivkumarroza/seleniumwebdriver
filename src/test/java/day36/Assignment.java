package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act = new Actions(driver);
		act.click(register).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).perform();

		Set<String>windows=driver.getWindowHandles();
		//		Iterator<String> it = windows.iterator();
		//		while(it.hasNext())
		//		{
		//			String window = it.next();
		//			driver.switchTo().window(window);
		//			System.out.println(driver.getCurrentUrl());
		//		}

		List<String> windowID=new ArrayList<String>(windows);
		String parent=windowID.get(0);
		String child=windowID.get(1);

		System.out.println(windowID);
		driver.switchTo().window(child);
		
//		driver.switchTo().newWindow(null)

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gender-male']")));
		WebElement maleRadioButton=driver.findElement(By.xpath("//input[@id='gender-male']"));
		maleRadioButton.click();
		if(maleRadioButton.isSelected()) {
			System.out.println(driver.getCurrentUrl());
			System.out.println("Test case pass");
		}
		driver.quit();
	}

}
