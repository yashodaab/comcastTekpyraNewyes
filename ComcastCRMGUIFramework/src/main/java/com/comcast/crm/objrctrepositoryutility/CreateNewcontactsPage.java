package com.comcast.crm.objrctrepositoryutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewcontactsPage {
	
	WebDriver driver;
	public CreateNewcontactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "support_start_date")
	private WebElement StartDateInContact;
	

	@FindBy(name = "support_end_date")
	private WebElement EndDateInContact;
	

	public WebElement getStartDateInContact()
	{
		return StartDateInContact;
	}
	
	public WebElement getEndDateInContact()
	{
		return EndDateInContact;
	}
	
	public void start_endDate(String startdate, String enddate)
	{
//		ContactsPage cp= new ContactsPage(driver);
//		cp.getlastname().sendKeys(lastname);
		StartDateInContact.clear();
		EndDateInContact.clear();
		StartDateInContact.sendKeys(startdate);
		
		EndDateInContact.sendKeys(enddate);
		
	}

}
