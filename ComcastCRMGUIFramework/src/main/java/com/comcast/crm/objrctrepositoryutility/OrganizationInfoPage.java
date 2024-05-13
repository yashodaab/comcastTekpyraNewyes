package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement detailorgName;
	
	
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industrydetail;
	
	
	
	@FindBy(id = "dtlview_Type")
	private WebElement Typedetail;
	
	
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phonedetail;
	
	
	public WebElement getheaderMsg() {
		return headerMsg;
	}
	
	public WebElement getdetailorgName() {
		return detailorgName;
	}
	
	public WebElement getindustrydetail() {
		return industrydetail;
	}
	
	public WebElement getTypedetail() {
		return Typedetail;
	}
	
	public WebElement getphonedetail() {
		return phonedetail;
	}


}
