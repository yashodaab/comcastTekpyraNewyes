package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement contactdetail;
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfodetail;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement ActualOrgInfo;
	
	
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement detailStartDate;
	
	
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement detailEndDate;
	
	public WebElement getdetailStartDate()
	{
		return detailStartDate;
	}
	
	public WebElement getdetailEndDate()
	{
		return detailEndDate;
	}
	
	
	public WebElement getActualOrgInfo()
	{
		return ActualOrgInfo;
	}
	
	public WebElement getcontactdetail()
	{
		return contactdetail;
	}
	
	public WebElement getcontactInfodetail()
	{
		return contactInfodetail;
	}

}
