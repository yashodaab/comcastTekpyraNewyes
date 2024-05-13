package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;



public class HomePage {
	WebDriverUtility wlib= new WebDriverUtility();
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//created object
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Products")
	private WebElement productlink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signout;
	
	public WebElement getadminimg()
	{
		return adminimg;
	}
	public WebElement getproductlink()
	{
		return productlink;
	}
	
	public WebElement getsignout()
	{
		return signout;
	}
	
	
	public WebElement getorglink()
	{
		return orglink;
	}
	
	public WebElement getcontactlink()
	{
		return contactlink;
	}
	
	public WebElement getCampaignlink()
	{
		return campaignlink;
	}
	
	public void navigateToCampaignPage()
	{
		wlib.mouseMoveTOElement(driver, morelink);
		campaignlink.click();
	}
	public void logout()
	{
		wlib.mouseMoveTOElement(driver, adminimg);
		signout.click();
	}

}
