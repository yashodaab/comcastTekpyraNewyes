package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrg;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchOrg;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchOrgDB;
	
	
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	
	
	public WebElement getcreateNewOrg()
	{
		return createNewOrg;
	}
	public WebElement getsearchbtn()
	{
		return searchbtn;
	}
	
	public WebElement getsearchOrg()
	{
		return searchOrg;
	}
	
	public WebElement getsearchOrgDB()
	{
		return searchOrgDB;
	}
	
	
	
	

}
