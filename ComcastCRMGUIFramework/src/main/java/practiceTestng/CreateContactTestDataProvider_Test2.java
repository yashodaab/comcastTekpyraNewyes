package practiceTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestDataProvider_Test2 {
	@Test(dataProvider="getData")
	public void createContactTest(String FName, String Lname, long PhoneNum)
	{
		System.out.println("firstname :"+FName +", LAstNAme: "+ Lname +", Phonenum" +PhoneNum);
	}



@DataProvider
public Object[][] getData()
{
	Object[][] obArr= new Object[3][3];
	
	obArr[0][0]= "Preethi";
	obArr[0][1]= "Tester";
	obArr[0][2]= 121324747l;
	
	obArr[1][0]= "Same";
	obArr[1][1]= "Sd";
	obArr[1][2]= 34357821325l;
	
	obArr[2][0]= "Jhon";
	obArr[2][1]= "Mark";
	
	obArr[2][2]= 23456789098l;
	
	return obArr;
	
	
	
}

}
