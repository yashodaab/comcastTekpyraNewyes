package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
/**
 * @author Preethi
 * conatins LoginPage elements and business libararies like login()
 */
public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Rule1: create a seperate ajava class
	// Rule 2 Object Creation
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;

	@FindBy(id="submitButton")
	private WebElement loginbtn;
	//Rule 3: object Intialization
	//Rule 4:Object encapsulation
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	/**
	 * login to application based on username ,password, url arguments
	 * @param url 
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String url,String username, String password)
	{
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginbtn.click();
	}
	
	
	
	
	
	
	

}
