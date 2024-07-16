package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMessageScreen {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
//		options.addArguments("--incognito");
		File sHub=new File("/Users/shiv/Downloads/SelectorsHub-Chrome-Web-Store.crx");
		File uBlock=new File("/Users/shiv/Downloads/uBlock-Chrome-Web-Store.crx");
		options.addExtensions(sHub,uBlock);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		

	}

}
