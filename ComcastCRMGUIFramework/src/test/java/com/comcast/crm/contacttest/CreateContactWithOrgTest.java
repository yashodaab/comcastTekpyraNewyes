package com.comcast.crm.contacttest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.fileytility.ExcelUtility;
import com.comcast.crm.generic.fileytility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objrctrepositoryutility.ContactInfoPage;
import com.comcast.crm.objrctrepositoryutility.ContactsPage;
import com.comcast.crm.objrctrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objrctrepositoryutility.HomePage;
import com.comcast.crm.objrctrepositoryutility.LoginPage;
import com.comcast.crm.objrctrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objrctrepositoryutility.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass{
	
	public static void main(String[] args)throws IOException, InterruptedException {
		  
		FileUtility flib= new FileUtility();
		
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
			
			//read data from excel
			
			
			
			String orgname=elib.getDataFromExcel("contact", 7, 2)+jlib.getRandomNumber();
			String contactLastname=elib.getDataFromExcel("contact", 7, 3);
			

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
			HomePage op= new HomePage(driver);
			op.getorglink().click();
			
			
			//sTEP 3:cREATE ORGANIZATION
			CreateNewOrganizationPage corg= new CreateNewOrganizationPage(driver);
			corg.CreateOrg(orgname);
			
		
//			
			//verify the header msg expected result
			
			OrganizationInfoPage oig= new OrganizationInfoPage(driver);
			String headerInfo=oig.getheaderMsg().getText();
			if(headerInfo.contains(orgname))
			{
				System.out.println(orgname+" organization is verified==PASS");
			}
			else
			{
				System.out.println(orgname+"organization not verified==FAIL");
			}
			
			//step 5: navigate to contact module
			op.getcontactlink().click();
			//step6 
			
//			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//			
//		//step enter all details and create organization
//			driver.findElement(By.name("lastname")).sendKeys(contactLastname);
//			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
			ContactsPage cp= new ContactsPage(driver);
			cp.createContactWithOrg(contactLastname);
			
			//switch to child window
			
			wlib.switchToTabOnURL(driver, "module=Accounts");
			//here
			cp.getSearchtextinChildwin().sendKeys(orgname);
			cp.getsearchbtnChildWind().click();
			
			
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			
			//switch to parent window
			wlib.switchToTabOnURL(driver, "Contacts&action");
			cp.getsaveBtn().click();
			
			
			//verify the header message
			ContactInfoPage cip=new ContactInfoPage(driver);
			headerInfo=cip.getcontactInfodetail().getText();
			if(headerInfo.contains(contactLastname))
			{
				System.out.println(contactLastname+ " contact header is verified==PASS");
			}
			else
			{
				System.out.println(contactLastname+ " contact header not is verified==FAIL");
			}
			
			//verify header orgname info expected
			
			String actorgname=cip.getActualOrgInfo().getText();
			if(actorgname.equals(actorgname))
			{
				System.out.println(orgname+ " information is verified==PASS");
			}
			else
			{
				System.out.println(orgname+ " information not is verified==FAIL");
			}
			
			
			
			//logout
			Thread.sleep(3000);
			op.logout();
			driver.quit();
			
			
			
		}


	}


