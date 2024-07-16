package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		//accept unsecured certs or expired SSL cert websites
		options.setAcceptInsecureCerts(true); 
		
		// runs test execution in background
		options.addArguments("--headless=new");
		
		//hide Controlled by automated software message
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		//incognito mode
		options.addArguments("--incognito");
		
		//add extensions at runtime
		File sHub=new File("/Users/shiv/Downloads/SelectorsHub-Chrome-Web-Store.crx");
		File uBlock=new File("/Users/shiv/Downloads/uBlock-Chrome-Web-Store.crx");
		options.addExtensions(sHub,uBlock);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
