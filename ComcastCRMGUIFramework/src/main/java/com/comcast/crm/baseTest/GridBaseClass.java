package com.comcast.crm.baseTest;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseUtility.DatabaseUtility;
import com.comcast.crm.generic.fileytility.ExcelUtility;
import com.comcast.crm.generic.fileytility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objrctrepositoryutility.HomePage;
import com.comcast.crm.objrctrepositoryutility.LoginPage;

public class GridBaseClass {
	
	
	public ExcelUtility elib= new ExcelUtility();
	public JavaUtility jlib= new JavaUtility();
	public WebDriverUtility  wlib= new WebDriverUtility();
	public DatabaseUtility dblib= new DatabaseUtility();
	public FileUtility flib= new FileUtility();
	public WebDriver driver= null;
//	public static RemoteDriver= null;
	public static WebDriver griddriver= null;

	//because we use in after method we have to make it global
	@BeforeSuite(groups= {"smokeTest","RegreesionTest"})
	public void configbeforesuit() throws SQLException
	{
		System.out.println("===Connect to DB, Report config==");
		dblib.getDbConnection();
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","RegreesionTest"})
	
	public void configbeforeclass(String browser) throws IOException
	
	{
		System.out.println("===Launch the browser===");
		String BROWSER =browser;
				//flib.getDataFromPropertiesFile("browser");
		
		
		 URL url = new URL("http://192.168.137.1:4444");
		 DesiredCapabilities dc= new DesiredCapabilities();
		 
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 dc.setBrowserName("Chrome");
			 dc.setPlatform(Platform.WINDOWS);
			 
		 }else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 dc.setBrowserName("firefox");
			 dc.setPlatform(Platform.WINDOWS);
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 dc.setBrowserName("edge");
			 dc.setPlatform(Platform.WINDOWS);
		 }
		 driver= new RemoteWebDriver(url, dc);
		 griddriver=driver;

	}
	
	@BeforeMethod(groups= {"smokeTest","RegreesionTest"})
	public void beforeMethod() throws IOException
	{
		System.out.println("===Login to application===");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
	
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		
		
		
		
	}
	@AfterMethod(groups= {"smokeTest","RegreesionTest"})
	public void afterMethod()
	{
		System.out.println("===Logout====");
		HomePage hp= new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups= {"smokeTest","RegreesionTest"})
	public void Afterclass() 
	{
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	@AfterSuite(groups= {"smokeTest","RegreesionTest"})
	public void aftersuit() throws SQLException
	{
		System.out.println("Close DB , Report Backup");
		dblib.closeDbconnection();
		
	}

}
