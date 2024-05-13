package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontact;
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement OrgniContact;
	
	@FindBy(id = "search_txt")
	private WebElement SearchtextinChildwin;
	
	@FindBy(name = "search")
	private WebElement searchbtnChildWind;
	
	public WebElement getSearchtextinChildwin()
	{
		return SearchtextinChildwin;
	}
	
	public WebElement getsearchbtnChildWind()
	{
		return searchbtnChildWind;
	}
	
	
	
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	public WebElement getlastname()
	{
		return lastnameEdit;
	}
	
	public WebElement getcreatecontact()
	{
		return createcontact;
	}
	
	public WebElement getOrgniContact()
	{
		return OrgniContact;
	}
	
	
	
	public void createContact(String lastname)
	{
		
		HomePage hp= new HomePage(driver);
		hp.getcontactlink().click();
		createcontact.click();
		lastnameEdit.sendKeys(lastname);
		saveBtn.click();
		
		
	}
	
	public void createContactWithOrg(String lastname)
	{
		createcontact.click();
		lastnameEdit.sendKeys(lastname);
		OrgniContact.click();
		
		
	}

}
