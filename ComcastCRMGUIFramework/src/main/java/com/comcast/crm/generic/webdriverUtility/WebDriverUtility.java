package com.comcast.crm.generic.webdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element)); 
	}
	public void switchToTabOnURL(WebDriver driver, String partialurl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> intera = set.iterator();
		while(intera.hasNext())
		{
			String windowID=intera.next();
			driver.switchTo().window(windowID);
			
			String acturl=driver.getCurrentUrl();
			if(acturl.contains(partialurl))
			{
				break;
			}
		}	
	} 
	
	public void switchToTabOnTitle(WebDriver driver, String partialurlTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> intera = set.iterator();
		while(intera.hasNext())
		{
			String windowID=intera.next();
			driver.switchTo().window(windowID);
			
			String acturl=driver.getCurrentUrl();
			if(acturl.contains(partialurlTitle))
			{
				break;
			}
		}	
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	//Alert
	public void switchTOAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchTOAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	//dropdown
	
	public void selectBasedOnText(WebElement element,String text)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectBasedOnValue(WebElement element,String value)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public void selectBasedOnIndex(WebElement element,int Index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(Index);
	}
	
	//Mouse
	public void mouseMoveTOElement(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void screeshot(WebDriver driver) throws IOException
	{
		TakesScreenshot tks= (TakesScreenshot)driver;
		File scr=tks.getScreenshotAs(OutputType.FILE);
		File dst= new File("./screenshots/sns.png");
		FileHandler.copy(scr, dst);
	}
	
	public void ScrollView(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoview();", ele);
	}
	
	

}
