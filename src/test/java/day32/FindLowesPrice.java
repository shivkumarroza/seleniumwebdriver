package day32;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindLowesPrice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		WebElement departureCity=driver.findElement(By.name("fromPort"));
		Select depcity = new Select(departureCity);
		depcity.selectByValue("Portland");
		
		WebElement destinationCity=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destCity = new Select(destinationCity);
		destCity.selectByValue("Rome");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
//		System.out.println(rows);
		
		double[] priceList = new double[rows];
		for(int r=1;r<=rows;r++)
		{
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText().replace("$", "");
//			System.out.println(price);
			priceList[r-1]=Double.parseDouble(price);
			
		}
		
		Arrays.sort(priceList);
//		System.out.println("elements in Array : "+Arrays.toString(priceList));
		
		for(int r=1;r<=rows;r++)
		{
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText().replace("$", "");
			if(price.equals(String.valueOf(priceList[0])))
			{
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]")).click();
				break;
			}
			
		}
		
		driver.findElement(By.name("inputName")).sendKeys("shiv");
		
		driver.findElement(By.name("address")).sendKeys("#21,Bangalore");
		
		driver.findElement(By.name("city")).sendKeys("Bangalore");
		
		driver.findElement(By.name("state")).sendKeys("Karnataka");
		
		driver.findElement(By.name("zipCode")).sendKeys("560098");
		
		
		Select cardType = new Select(driver.findElement(By.name("cardType")));
		cardType.selectByVisibleText("American Express");
		
		driver.findElement(By.name("creditCardNumber")).sendKeys("1234567890123456");
//		driver.quit();
		
		driver.findElement(By.name("creditCardMonth")).sendKeys("6");
		
		driver.findElement(By.name("creditCardYear")).sendKeys("2024");
		
		driver.findElement(By.name("nameOnCard")).sendKeys("shivkumar");
		
		driver.findElement(By.name("rememberMe")).click();
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		String successMessage = driver.findElement(By.xpath("//h1[.='Thank you for your purchase today!']")).getText();
		
		String bookingID=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		System.out.println("booking id is : "+bookingID);
		
		if(successMessage.equals("Thank you for your purchase today!"))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail");

	}

}
