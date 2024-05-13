package practiceTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestDataProvider_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String FName, String Lname)
	{
		System.out.println("firstname"+FName +", LAstNAme"+ Lname);
	}



@DataProvider
public Object[][] getData()
{
	Object[][] obArr= new Object[3][2];
	
	obArr[0][0]= "Preethi";
	obArr[0][1]= "Tester";
	obArr[1][0]= "Same";
	obArr[1][1]= "Sd";
	
	obArr[2][0]= "Jhon";
	obArr[2][1]= "Mark";
	
	return obArr;
	
	
	
}

}
