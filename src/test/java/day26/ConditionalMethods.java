package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		driver.manage().window().maximize();
		
		boolean logo_Status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Logo status : "+logo_Status);
		
		System.out.println("FirstName field is enabled : "+driver.findElement(By.id("FirstName")));
		
		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selection");
		System.out.println("Status of male radio button : "+male_rd.isSelected());
		System.out.println("Status of female radio button : "+female_rd.isSelected());
		
		female_rd.click();
		
		
		System.out.println("After selection");
		System.out.println("Status of male radio button : "+male_rd.isSelected());
		System.out.println("Status of female radio button : "+female_rd.isSelected());
		
		
		boolean newLetter_checkbox = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("NewsLetter CheckBox status : "+newLetter_checkbox);
		
		driver.findElement(By.xpath("//input[@id='Newsletter']")).click();
		
		newLetter_checkbox = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("NewsLetter CheckBox status : "+newLetter_checkbox);
		
//		driver.quit();

	}

}
