package day28;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class toMethodImp implements Navigation {

	public static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		driver= new ChromeDriver();
		URL url = new URL("https://opensource-demo.orangehrmlive.com/");
		toMethodImp imp = new toMethodImp();
		imp.to(url);
//		driver.quit();

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forward() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void to(String url) {
		
		driver.get(url);
	}

	@Override
	public void to(URL url) {
		if(url instanceof URL)
		{
			System.out.println(url.toString());
			driver.get(url.toString());
		}
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	

}
