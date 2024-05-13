package com.comcast.crm.orgtest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileytility.ExcelUtility;
import com.comcast.crm.generic.fileytility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objrctrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objrctrepositoryutility.HomePage;
import com.comcast.crm.objrctrepositoryutility.LoginPage;
import com.comcast.crm.objrctrepositoryutility.OrganizationInfoPage;


public class CreateOrganizationWithPhoneNumberTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
FileUtility flib= new FileUtility();
		
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		//read data from excel
		String orgname=elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
		String phonenum=elib.getDataFromExcel("org", 7, 3);
		

		//at compile time driver is null based on user input it goes this is runtime polymorphism
		WebDriver driver= null;
		
		if(BROWSER.equals("chrome"))
		{
			 driver= new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox"))
		{
			 driver= new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			 driver= new ChromeDriver(); 
		}
		
		
		wlib.waitForPageToLoad(driver);
		//Step 1:Login to APP
	
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		
		//sTEP2: NAVIGATE TO ORGANIZATION
		
		HomePage op = new HomePage(driver);
		op.getorglink().click();
		
		//sTEP 3:cREATE ORGANIZATION
		CreateNewOrganizationPage cog = new CreateNewOrganizationPage(driver);
		//cog.CreateOrg(orgname);
		
	//step enter all details and create organization
		
		cog.CreateOrgPhone(orgname, phonenum);

		//verify header phone number 

		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actualph=oip.getphonedetail().getText();
		
		Thread.sleep(2000);
		if(actualph.equals(phonenum))
		{
			System.out.println(phonenum +"is verified==PASS");
		}
		else
		{
			System.out.println(phonenum+"is not verified==FAIL");
		}

		//logout
		Thread.sleep(3000);
		op.logout();
		driver.quit();
		
		
	}

}
