package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WeDriverMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
//		WebElement Name=driver.findElement(By.cssSelector("input#name"));
//		System.out.println("Name status "+Name.isEnabled());
//		Name.sendKeys("shiv");
//		Thread.sleep(2000);
//		
//		WebElement Email=driver.findElement(By.xpath("//input[@id='email']"));
//		System.out.println("Email status "+Email.isEnabled());
//		Email.sendKeys("kumar");
//		Thread.sleep(2000);
//		
//		
//		WebElement Phone=driver.findElement(By.xpath("//input[@class='form-control' and @id='phone']"));
//		System.out.println("Phone status "+Phone.isEnabled());
//		Phone.sendKeys("8431974579");
//		Thread.sleep(2000);
//		
//		WebElement Address=driver.findElement(By.cssSelector("textarea#textarea"));
//		System.out.println("Address status "+Address.isEnabled());
//		Address.sendKeys("#232, Bangalore");
//		Thread.sleep(2000);
//		
//		WebElement Male=driver.findElement(By.xpath("//input[@value='male']"));
//		System.out.println("Male radio button status "+Male.isSelected());
//		Male.click();
//		Thread.sleep(2000);
//		
//		WebElement Female=driver.findElement(By.xpath("//input[@value='female']"));
//		System.out.println("Female radio button status "+Female.isSelected());
//		Female.click();
//		Thread.sleep(2000);
//		
//		WebElement Sunday=driver.findElement(By.xpath("//input[@id='sunday']"));
//		System.out.println("Sunday checkbox status "+Sunday.isSelected());
//		Sunday.click();
//		
//		WebElement Monday=driver.findElement(By.xpath("//input[@id='monday']"));
//		System.out.println("Monday checkbox status "+Monday.isSelected());
//		Monday.click();
//		Thread.sleep(2000);
//		
//		WebElement Tuesday=driver.findElement(By.xpath("//input[@id='tuesday']"));
//		System.out.println("Tuesday checkbox status "+Tuesday.isSelected());
//		Tuesday.click();
//		Thread.sleep(2000);
//		
//		WebElement Wednesday=driver.findElement(By.xpath("//input[@id='wednesday']"));
//		System.out.println("Wednesday checkbox status "+Wednesday.isSelected());
//		Wednesday.click();
//		Thread.sleep(2000);
//		
//		WebElement Thursday=driver.findElement(By.xpath("//input[@id='thursday']"));
//		System.out.println("Thursday checkbox status "+Thursday.isSelected());
//		Thursday.click();
//		Thread.sleep(2000);
//		
//		WebElement Friday=driver.findElement(By.xpath("//input[@id='friday']"));
//		System.out.println("Friday checkbox status "+Friday.isSelected());
//		Friday.click();
//		Thread.sleep(2000);
//		
//		WebElement Saturday=driver.findElement(By.xpath("//input[@id='saturday']"));
//		System.out.println("Saturday checkbox status "+Saturday.isSelected());
//		Saturday.click();
//		Thread.sleep(2000);
		
//		WebElement Countries=driver.findElement(By.cssSelector("#country"));
//		Select selectCountries = new Select(Countries);
//		selectCountries.selectByValue("canada");
//		selectCountries.selectByVisibleText("United Kingdom");
//		Thread.sleep(2000);
		
//		WebElement NewBrowserWindow=driver.findElement(By.xpath("//button[text()='New Browser Window']"));
////		System.out.println("Sunday checkbox status"+NewBrowserWindow.isSelected());
//		NewBrowserWindow.click();
//		Thread.sleep(2000);
		
//		Set<String> windows=driver.getWindowHandles();
//		ArrayList<String> windowsArray=new ArrayList<String>(windows);
		
//		System.out.println(windowsArray);
//		Thread.sleep(2000);
//		driver.switchTo().window(windowsArray.indexOf(1));
		
//		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
//		Thread.sleep(2000);
//		Alert jsAlert=driver.switchTo().alert();
//		jsAlert.accept();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
//		Thread.sleep(2000);
//		Alert confirmBoxAlert=driver.switchTo().alert();
//		confirmBoxAlert.dismiss();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
//		Thread.sleep(2000);
//		Alert promptAlert=driver.switchTo().alert();
//		System.out.println(promptAlert.getText());
//		promptAlert.sendKeys("shiv");
//		promptAlert.accept();
//		Thread.sleep(2000);
//		
//		driver.quit();
//		
//		WebElement copyTextButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions action = new Actions(driver);
//		action.doubleClick(copyTextButton).build().perform();
		
		WebElement drag=driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		
		WebElement drop=driver.findElement(By.xpath("//p[normalize-space()='Drop here']"));
		
		action.dragAndDrop(drag, drop).build().perform();
		
		

	}

}
