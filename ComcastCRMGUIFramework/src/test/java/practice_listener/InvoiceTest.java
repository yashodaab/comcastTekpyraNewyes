package practice_listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.baseTest.BaseClass2;
//@Listeners(com.comcast.crm.ListenerUtility.Listener_implementationClass.class)
public class InvoiceTest extends BaseClass2 {
	
	//private static final String Login = null;
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute Test1=CreateInvoiceTest");
		String acttile=driver.getTitle();
		Assert.fail();
		System.out.println(acttile);
		Assert.assertEquals(acttile, "Login");
		System.out.println("step 1");
		System.out.println("step 2");

		System.out.println("step 3");

		System.out.println("step 4");


	}
	@Test
	public void CreateInvoiceWithContactTest()
	{
		System.out.println("execute Test2=CreateInvoiceWithContactTest");
		System.out.println("step 1");
		System.out.println("step 2");

		System.out.println("step 3");

		System.out.println("step 4");

	}

}
