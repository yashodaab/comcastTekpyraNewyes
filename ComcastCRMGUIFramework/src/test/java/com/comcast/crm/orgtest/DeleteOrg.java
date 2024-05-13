package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.comcast.crm.objrctrepositoryutility.OrganizationPage;

public class DeleteOrg {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib = new FileUtility();

		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		String orgname = elib.getDataFromExcel("org",10,2) + jlib.getRandomNumber();

		// at compile time driver is null based on user input it goes this is runtime
		// polymorphism
		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.waitForPageToLoad(driver);
		// Step 1:Login to APP
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		
		// sTEP2: NAVIGATE TO ORGANIZATION
		HomePage op= new HomePage(driver);
		op.getorglink().click();
		
		
		// sTEP 3:cREATE ORGANIZATION

		OrganizationPage og= new OrganizationPage(driver);
		og.getcreateNewOrg().click();
		

		// step enter all details and create organization
		
		
		CreateNewOrganizationPage cnp= new CreateNewOrganizationPage(driver);
		cnp.CreateOrg(orgname);
		
		

		// verify the header msg expected result
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String headerinfo=oip.getheaderMsg().getText();
		if (headerinfo.contains(orgname)) {
			System.out.println(orgname + "is created==PASS");
		} else {
			System.out.println(orgname + "is not created==FAIL");
		}

		// verify the header organization info msg expected result
		String actualorgname = oip.getdetailorgName().getText();
		if (actualorgname.equals(orgname)) {
			System.out.println(actualorgname + "is created==PASS");
		} else {
			System.out.println(actualorgname + "is not created==FAIL");
		}
		
		//go back to organization
		
		op.getorglink().click();
		og.getsearchOrg().sendKeys(orgname);
		wlib.selectBasedOnValue(og.getsearchOrgDB(), "Organization Name");
		og.getsearchbtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		wlib.switchTOAlertAndAccept(driver);
		
		System.out.println(orgname+" got deleted Sucessfully");

		// logout
		Thread.sleep(5000);
		op.logout();
		driver.quit();

	}

}
