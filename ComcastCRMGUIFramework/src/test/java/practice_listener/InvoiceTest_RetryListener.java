package practice_listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.baseTest.BaseClass2;
//@Listeners(com.comcast.crm.ListenerUtility.Listener_implementationClass.class)
public class InvoiceTest_RetryListener {
	
	//private static final String Login = null;
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImp.class)
	public void activate_Sim()
	{
		System.out.println("execute Test1=CreateInvoiceTest");
		
		
		Assert.assertEquals("", "Login");
		System.out.println("step 1");
		System.out.println("step 2");

		System.out.println("step 3");

		System.out.println("step 4");


	}

}
