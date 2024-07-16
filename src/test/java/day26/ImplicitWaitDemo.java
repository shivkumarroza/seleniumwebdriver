package day26;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ImplicitWaitDemo {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		try {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		WebElement Name=driver.findElement(By.cssSelector("input#name"));
		System.out.println("Name status "+Name.isEnabled());
		Name.sendKeys("shiv");
		
		
		WebElement Email=driver.findElement(By.xpath("//input[@id='email']"));
		System.out.println("Email status "+Email.isEnabled());
		Email.sendKeys("kumar");
		
		
		
		WebElement Phone=driver.findElement(By.xpath("//input[@class='form-control' and @id='phone']"));
		System.out.println("Phone status "+Phone.isEnabled());
		Phone.sendKeys("8431974579");
	
		
		WebElement Address=driver.findElement(By.cssSelector("textarea#textarea"));
		System.out.println("Address status "+Address.isEnabled());
		Address.sendKeys("#232, Bangalore");
		
		
		WebElement Male=driver.findElement(By.xpath("//input[@value='male']"));
		System.out.println("Male radio button status "+Male.isSelected());
		Male.click();

		
		WebElement Female=driver.findElement(By.xpath("//input[@value='female']"));
		System.out.println("Female radio button status "+Female.isSelected());
		Female.click();
		
		
		WebElement Sunday=driver.findElement(By.xpath("//input[@id='sunday']"));
		System.out.println("Sunday checkbox status "+Sunday.isSelected());
		Sunday.click();
		
		WebElement Monday=driver.findElement(By.xpath("//input[@id='monday']"));
		System.out.println("Monday checkbox status "+Monday.isSelected());
		Monday.click();
		
		
		WebElement Tuesday=driver.findElement(By.xpath("//input[@id='tuesday']"));
		System.out.println("Tuesday checkbox status "+Tuesday.isSelected());
		Tuesday.click();
	
		
		WebElement Wednesday=driver.findElement(By.xpath("//input[@id='wednesday']"));
		System.out.println("Wednesday checkbox status "+Wednesday.isSelected());
		Wednesday.click();
		
		
		WebElement Thursday=driver.findElement(By.xpath("//input[@id='thursday']"));
		System.out.println("Thursday checkbox status "+Thursday.isSelected());
		Thursday.click();
	
		
		WebElement Friday=driver.findElement(By.xpath("//input[@id='friday']"));
		System.out.println("Friday checkbox status "+Friday.isSelected());
		Friday.click();
	
		
		WebElement Saturday=driver.findElement(By.xpath("//input[@id='saturday']"));
		System.out.println("Saturday checkbox status "+Saturday.isSelected());
		Saturday.click();
	
		
		WebElement Countries=driver.findElement(By.cssSelector("#country"));
		Select selectCountries = new Select(Countries);
		selectCountries.selectByValue("canada");
		selectCountries.selectByVisibleText("United Kingdom");
	
		
		WebElement NewBrowserWindow=driver.findElement(By.xpath("//button[text()='New Browser Window']"));
		System.out.println("Sunday checkbox status"+NewBrowserWindow.isSelected());
		NewBrowserWindow.click();
	
		
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		Thread.sleep(2000);
		Alert jsAlert=driver.switchTo().alert();
		jsAlert.accept();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
		Thread.sleep(2000);
		Alert confirmBoxAlert=driver.switchTo().alert();
		confirmBoxAlert.dismiss();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		Thread.sleep(2000);
		Alert promptAlert=driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("shiv");
		promptAlert.accept();
		
		WebElement copyTextButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions action = new Actions(driver);
		action.doubleClick(copyTextButton).build().perform();
		
		WebElement drag=driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		
		WebElement drop=driver.findElement(By.xpath("//p[normalize-space()='Drop here']"));
		
		action.dragAndDrop(drag, drop).build().perform();
		}
		finally {
			driver.quit();
		}
		
		

	}

}
