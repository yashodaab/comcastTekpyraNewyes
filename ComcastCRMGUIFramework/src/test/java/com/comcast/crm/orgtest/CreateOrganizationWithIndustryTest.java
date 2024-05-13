package com.comcast.crm.orgtest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import com.comcast.crm.generic.fileytility.ExcelUtility;
import com.comcast.crm.generic.fileytility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objrctrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objrctrepositoryutility.HomePage;
import com.comcast.crm.objrctrepositoryutility.LoginPage;
import com.comcast.crm.objrctrepositoryutility.OrganizationInfoPage;

public class CreateOrganizationWithIndustryTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib = new FileUtility();

		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		// read data from excel

		String orgname = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();

		String Industries = elib.getDataFromExcel("org", 4, 3);
		String Type = elib.getDataFromExcel("org", 4, 4);

		// at compile time driver is null based on user input it goes this is runtime
		// polymorphism
		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.waitForPageToLoad(driver);

		// Step 1:Login to APP
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		Thread.sleep(5000);

		// sTEP2: NAVIGATE TO ORGANIZATION

		HomePage op = new HomePage(driver);
		op.getorglink().click();

		Thread.sleep(5000);

		// sTEP 3:cREATE ORGANIZATION
		CreateNewOrganizationPage cog = new CreateNewOrganizationPage(driver);
		cog.CreateOrg(orgname, Industries, Type);
		
		//verify

		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actualindustry = oip.getindustrydetail().getText();

		if (actualindustry.contains(Industries)) {
			System.out.println(Industries + " is verified==PASS");
		} else {
			System.out.println(Industries + " is not verified==FAIL");
		}
		
		String actualType = oip.getTypedetail().getText();
		if (actualType.contains(Type)) {
			System.out.println(Type + "is verified==PASS");
		} else {
			System.out.println(Type + "is not verified==FAIL");
		}

		// logout
		Thread.sleep(3000);
		op.logout();
		driver.quit();
	}

}
