package day38;

import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaptureScrenshots {
	public static void getfullPhoto(WebDriver driver, String testName)
	{
		String folderPath=System.getProperty("user.dir")+"/screenshots/";
		Date date = new Date();
		String sDate=date.toString().replaceAll(":", "_").replaceAll(" ", "");
		String path=folderPath+testName+sDate+".png";
		System.out.println(path);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(path);
		
		srcFile.renameTo(destFile);
	}
	
	public static void getElementPhoto(WebElement element)
	{
		String folderPath=System.getProperty("user.dir")+"/screenshots/";
//		System.out.println(element.getText());
		File srcFile=element.getScreenshotAs(OutputType.FILE);
		File destFile=new File(folderPath+element.getTagName()+"_ele.png");
		
		srcFile.renameTo(destFile);
	}

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement featuredProductSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//		getfullPhoto(driver, "testcase1");
		getElementPhoto(featuredProductSection);
		
		driver.quit();

	}

}
