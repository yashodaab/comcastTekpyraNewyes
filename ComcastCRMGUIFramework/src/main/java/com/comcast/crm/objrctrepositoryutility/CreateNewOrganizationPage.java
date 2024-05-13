package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateNewOrganizationPage {
	WebDriverUtility wlib= new WebDriverUtility();
	
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(name = "accountname")
	private WebElement orgnameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDB;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement clickOnPlus;
	
	@FindBy(name = "accounttype")
	private WebElement typeDB;
	
	@FindBy(id = "phone")
	private WebElement phonenumedit;
	
	
	public WebElement getorgname()
	{
		return orgnameEdit;
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	public WebElement getclickOnPlus()
	{
		return clickOnPlus;
	}
	
	public WebElement getindustryDB()
	{
		return industryDB;
	}
	
	public WebElement gettypeDB()
	{
		return typeDB;
	}
	
	public WebElement gephonenumedit()
	{
		return phonenumedit;
	}
	
	
	
	public void CreateOrg(String orgname)
	{
		clickOnPlus.click();
		orgnameEdit.sendKeys(orgname);
		saveBtn.click();

	}
	
	public void CreateOrg(String orgname, String industry,String type)
	{
		clickOnPlus.click();
		orgnameEdit.sendKeys(orgname);
		wlib.selectBasedOnValue(industryDB, industry);
		wlib.selectBasedOnValue(typeDB, type);
		saveBtn.click();
	}
	
	public void CreateOrgPhone(String orgname, String phonenum)
	{
		clickOnPlus.click();
		orgnameEdit.sendKeys(orgname);
		phonenumedit.sendKeys(phonenum);
		saveBtn.click();
	}

}
