package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadingProperties {

	public static void main(String[] args) {
		String value="";
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("/Users/shiv/eclipse-workspace/seleniumwebdriver/data/config.properties"));
			value=p.getProperty("appURL");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
		
		Set<String> keys = p.stringPropertyNames();
		System.out.println(keys);
		
		System.out.println(p.keySet());
		
		System.out.println(p.values());
		
		

	}

}
