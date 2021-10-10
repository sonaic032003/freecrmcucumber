package com.qa.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.qa.factory.TestBase;

public class CommonFunctions extends TestBase {

	public boolean visibilityelement(WebElement ele)
	{boolean flag=false;
		wait.until(ExpectedConditions.visibilityOf(ele));
		try {
			if(ele.isDisplayed()||ele.isEnabled())
				flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	public void waitandclick(WebElement ele)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();;
		
	}
	
	public void waitandsendkey(WebElement ele,String input)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		ele.sendKeys(input);
		
	}
	
	public void switchtolatestframe(String frameName)
	{
		int noframe = driver.findElements(By.tagName("frame")).size();
		System.out.println("number of frames are" +noframe);
		driver.switchTo().frame(frameName);
	}
	
	public void switchtolatestframe()
	{
		int noframe = driver.findElements(By.tagName("frame")).size();
		System.out.println("number of frames are" +noframe);
		driver.switchTo().frame(noframe-1);
	}
	
	public void waitandselectbyvalue(WebElement ele,String type, String value)
	{
		
		Select sel = new Select(ele);
		//sel.selectByVisibleText(value);
	switch(type.toLowerCase()) {
		case "text":
		sel.selectByVisibleText(value);
		break;
		
		case "value":
			sel.selectByValue(value);
			break;
			
		case "index":
			sel.selectByIndex(Integer.parseInt(value));
			break;
				}
		
	//wait.until(ExpectedConditions.elementToBeSelected(ele));
	}
	
	
	
	public void handleAlerts(String Answer)
	{
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		
		
		switch (Answer.toLowerCase())
		{
		
		case "yes":
			
			alert.accept();
			break;
		
		case "no":
			
			alert.dismiss();
		
	}
	
	
}
}