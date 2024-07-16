package day30;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		/*//frame 1
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.cssSelector("input[name='mytext1']")).sendKeys("shiv");
		driver.switchTo().defaultContent();
		//		driver.switchTo().parentFrame();

		//		frame2
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.cssSelector("input[name='mytext2']")).sendKeys("shiv");
		driver.switchTo().defaultContent();

		//		frame3
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		//		WebElement iframe1=frame3.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(0);

		//		List<WebElement> radiobuttons = driver.findElements(By.xpath("//div[@class='AB7Lab Id5V1']"));
		//		radiobuttons.get(1).click();
		WebElement ele=	driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		driver.switchTo().defaultContent();*/
		
		//frame5
		driver.manage().window().maximize();
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.cssSelector("input[name='mytext5']")).sendKeys("shiv");
		driver.findElement(By.xpath("//a[@href='https://a9t9.com']")).click();
		boolean statusLogo=driver.findElement(By.xpath("//img[@src='/Content/Images/ui.vision.logo2.webp']")).isDisplayed();
		System.out.println(statusLogo);
	}

}
