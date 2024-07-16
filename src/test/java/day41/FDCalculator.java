package day41;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-mysore/fixed-deposit-calculator-SBM-BSB007.html?classic=true");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String XL_Path="/Users/shiv/eclipse-workspace/seleniumwebdriver/data/output.xlsx";
		String sheetName="data";
		
		int rowCount=Excel.getRowCount(XL_Path, sheetName);
		
		for(int i=1;i<=rowCount;i++)
		{
			//get the data from excel
			String Principal = Excel.getData(XL_Path, sheetName, i, 0);
			String RateofInterest = Excel.getData(XL_Path, sheetName, i, 1);
			String Period1 = Excel.getData(XL_Path, sheetName, i, 2);
			String Period2 = Excel.getData(XL_Path, sheetName, i, 3);
			String Frequency = Excel.getData(XL_Path, sheetName, i, 4);
			String Maturityvalue = Excel.getData(XL_Path, sheetName, i, 5);
			
			Thread.sleep(3000);
			//pass the values to page
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(Principal);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(RateofInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Period1);
			
			WebElement per2=driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select select = new Select(per2);
			select.selectByVisibleText(Period2);
			
			driver.findElement(By.xpath("//select[@id='frequency']")).sendKeys(Frequency);
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			
			String expMaturityvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(expMaturityvalue)==Double.parseDouble(Maturityvalue))
			{
				System.out.println("pass");
				Excel.setData(XL_Path, sheetName, i, 7, "Pass");
			}
			else
			{
				System.out.println("Fail");
				Excel.setData(XL_Path, sheetName, i, 7, "Fail");
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
			//validate
		}

	}

}
