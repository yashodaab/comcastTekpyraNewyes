package com.comcast.crm.objrctrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productsimgbtn;
	
	public WebElement getproductsimgbtn()
	{
		return productsimgbtn;
	}

}
