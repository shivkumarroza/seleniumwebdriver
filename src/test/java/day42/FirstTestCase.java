package day42;

import org.testng.annotations.Test;

/*
 open app
 login to app
 logout
 */

public class FirstTestCase {
	
	@Test(priority = 1)
	void openApp()
	{
		System.out.println("Open application");
	}
	
	@Test(priority = 2)
	void loginApp()
	{
		System.out.println("Logged in to app");
	}
	
	@Test(priority = 3)
	void logout()
	{
		System.out.println("Logged out");
	}

}
