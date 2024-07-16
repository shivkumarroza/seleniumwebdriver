package day44;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class PaymentTests {
	
	@Test(priority=1, groups= {"sanity","regression","functional"})
	void paymentInRupees()
	{
		System.out.println("Payment in rupees");
	}
	
	@Test(priority=1, groups= {"sanity","regression","functional"})
	void paymentInDollers()
	{
		System.out.println("Payment in rupees");
	}

}
