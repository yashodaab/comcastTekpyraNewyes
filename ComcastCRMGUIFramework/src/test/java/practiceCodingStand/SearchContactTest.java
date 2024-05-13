package practiceCodingStand;

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objrctrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author Preethi
 */
public class SearchContactTest extends BaseClass {
	/**
	 * scenario :login()==> navigateconatct==>create contact()
	 */
	@Test
	public void searchContactTest()
	{
		/*step1 : login to app */
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp("kil", "user", "pass");
		
	}

}
