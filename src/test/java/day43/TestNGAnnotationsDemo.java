package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 TC1
1. Login
2. Search
3. Logout
4. Login
5. Adv search
6. Logout

 */
public class TestNGAnnotationsDemo {
	@Test(priority=1)
	void openApp()
	{
		System.out.println("app opened");
		Assert.assertTrue(true);
	}
	
	@Test(priority=2, dependsOnMethods = "openApp")
   void login()
   {
	   System.out.println("Login Successful");
	   Assert.assertTrue(true);
   }
   
   @Test(priority=3,dependsOnMethods= "login")
   void Search()
   {
	   System.out.println("Search");
	   Assert.assertTrue(false);
   }
 
   @Test(priority=4,dependsOnMethods= {"login","Search"})
   void Advsearch()
   {
	   System.out.println("Advanced Search");
	   Assert.assertTrue(true);
   }
   
   @Test(priority=5,dependsOnMethods= {"login"})
   void Lgout()
   {
	   System.out.println("Logout Successful");
	   Assert.assertTrue(true);
   }
}
