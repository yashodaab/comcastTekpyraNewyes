package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;
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
import com.comcast.crm.objrctrepositoryutility.CreateNewcontactsPage;
import com.comcast.crm.objrctrepositoryutility.HomePage;
import com.comcast.crm.objrctrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest extends BaseClass {
	public static void main(String[] args) throws InterruptedException, IOException {
		
FileUtility flib= new FileUtility();
		
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();

			
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
			
			//read data from excel
			
			
			
			String lastname=elib.getDataFromExcel("contact", 4, 2)+jlib.getRandomNumber();
			

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
			
			driver.findElement(By.linkText("Contacts")).click();
			//sTEP 3:cREATE ORGANIZATION
			
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			//step enter all details and create new organization
			
			String startdate=jlib.getSystemDateYYYYMMDD();
			String enddate = jlib.getRequiredDateYYYYDDMM(30);
			ContactsPage cp= new ContactsPage(driver);
			cp.getlastname().sendKeys(lastname);
			Thread.sleep(2000);
			CreateNewcontactsPage cnp= new CreateNewcontactsPage(driver);
			cnp.start_endDate(startdate, enddate);
		//step enter all details and create organization
			cp.getsaveBtn().click();
			
			
			
						
			//verify the header organization info msg expected result
			
			ContactInfoPage cip= new ContactInfoPage(driver);
			String actualastartdate=cip.getdetailStartDate().getText();
			if(actualastartdate.equals(startdate))
			{
				System.out.println(startdate+"is created==PASS");
			}
			else
			{
				System.out.println(startdate+"is not created==FAIL");
			}
			
			String actualaenddate=cip.getdetailEndDate().getText();
			if(actualaenddate.equals(enddate))
			{
				System.out.println(enddate+"is created==PASS");
			}
			else
			{
				System.out.println(enddate+"is not created==FAIL");
			}
			
			
			
			//logout
			Thread.sleep(3000);
			HomePage hp= new HomePage(driver);
			hp.logout();
			driver.quit();
			
			
		}


	}


