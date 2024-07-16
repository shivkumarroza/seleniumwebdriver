package day37;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFilesDemo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(null)
		
		WebElement filesButton=driver.findElement(By.xpath("//input[@id='filesToUpload']"));
		String file1="/Users/shiv/Desktop/shiv1.txt";
		String file2="/Users/shiv/Desktop/shiv2.txt";
		
		File srcFile=filesButton.getScreenshotAs(OutputType.FILE);
		File destFile=new File("/Users/shiv/Desktop/shiv1.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		filesButton.sendKeys(file1+"\n"+file2);
		
		String uploadedFIleName1 = driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText();
		String uploadedFIleName2 = driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText();
	
		int noOfFiles=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
	
		if(noOfFiles==2)
		{
			System.out.println("2 files uploaded");
		}
		else
		{
			System.out.println("failed");
		}
		if(uploadedFIleName1.equals("shiv1.txt") && uploadedFIleName2.equals("shiv2.txt"))
		{
			System.out.println("Files Uploaded successfully");
		}
		else
		{
			System.out.println("Files Upload failed");
		}

	}

}
