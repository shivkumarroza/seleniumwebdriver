package day32;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
//		//number of rows in table
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
//		System.out.println("No of rows in table : "+rows);
//		
//		//no of coloumns
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//tr/th")).size();
//		System.out.println("No of Coloumns in table : "+cols);
//		
		//specific table data
//		String bookName=driver.findElement(By.xpath(" //table[@name='BookTable']//tr[7]//td[3]")).getText();
//		System.out.println(bookName);
//		
//		for(int i=1;i<=1;i++)
//		{
//			for(int j=1;j<=cols;j++)
//			{
//				text=driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+j+"]")).getText();
//				System.out.print(text+"\t");
//			}
//			System.out.println();
//		}
//		
//		
//		for(int i=2;i<=rows;i++)
//		{
//			for(int j=1;j<=cols;j++)
//			{
//				
//				text=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
//				System.out.print(text+"\t");
////				
//			}
//			System.out.println();
//		}
		
//		//print bookname whose author is mukesh
//		List<WebElement> authors=driver.findElements(By.xpath(" //table[@name='BookTable']//tr//td[2]"));
//		List<WebElement> bookNames = driver.findElements(By.xpath(" //table[@name='BookTable']//tr"));
//		for(int i=2;i<=authors.size();i++)
//		{
//			String author= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
//			if(author.equals("Mukesh"))
//			{
//				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
//				System.out.println(author+" : "+bookName);
//				
//			}
//		}
//		int booksSize = driver.findElements(By.xpath("//table[@name='BookTable']//tr/td[1]")).size();
//		//print price based on book Name
//		for(int r=2;r<=booksSize;r++)
//		{
//			String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
//			if(book.equalsIgnoreCase("Learn Java"))
//			{
//				String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
//				System.out.println(price);
//			}
//		
//		}
		
		
		int sum=0;
		int[] priceList=new int[rows-1];
		for(int i=2;i<=rows;i++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[4]")).getText();
//			sum=sum+Integer.parseInt(price);
			priceList[i-2]=Integer.parseInt(price);
			
		}
		Arrays.sort(priceList);
		System.out.println(Arrays.toString(priceList));
//		System.out.println("Total sum of books is : "+sum);
		driver.quit();
		

	}

}
