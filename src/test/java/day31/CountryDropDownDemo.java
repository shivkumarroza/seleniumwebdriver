package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountryDropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();

		WebElement countryDropDown = driver.findElement(By.id("country-list"));

		Select countries = new Select(countryDropDown);

		System.out.println("No Country options : "+countries.getOptions().size());

		countries.selectByVisibleText("India");

		WebElement stateDropDown = driver.findElement(By.id("state-list"));
		Select states = new Select(stateDropDown);

		System.out.println("No States options : "+states.getOptions().size());

		states.selectByVisibleText("Delhi");

		Thread.sleep(5000);
		driver.quit();

	}

}
