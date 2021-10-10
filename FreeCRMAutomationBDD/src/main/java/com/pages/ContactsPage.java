package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.factory.TestBase;
import com.qa.util.CommonFunctions;

public class ContactsPage extends TestBase {
	
	CommonFunctions cf = new CommonFunctions();
	
	@FindBy (xpath = "//input[@value='New Contact']")
	private WebElement NewContactBtn;
	
	@FindBy (xpath = "//legend[text() = 'Contact Information']")
	private WebElement ContactInfoHeader;
	
	@FindBy (id = "first_name")
	private WebElement firstNameField;
	
	@FindBy (id = "surname")
	private WebElement lastNameField;
	
	@FindBy (name = "status")
	private WebElement statusdd;
	
	@FindBy (xpath = "//select[@name = 'status']/option")
	private WebElement statusddlist;
	
	@FindBy (xpath = "//input[@value = 'Save']")
	private WebElement savebtn;
	
	@FindBy(xpath ="//a[@title = 'Contacts']")
	private WebElement Contactbtnhome;
	
	List<WebElement> tablerow;
	
public ContactsPage() {
		
		PageFactory.initElements(driver, this);
}

public boolean createNewContact()
{
	cf.waitandclick(NewContactBtn);
	boolean flag = cf.visibilityelement(ContactInfoHeader);
	return flag;
	
}

public void addrecord(String firstName,String lastName, String Status)
{
	cf.waitandsendkey(firstNameField, firstName);
	cf.waitandsendkey(lastNameField, lastName);
	cf.waitandclick(statusdd);
	cf.waitandselectbyvalue(statusdd, "text", Status);
	//wait.until(ExpectedConditions.elementToBeSelected(statusdd));

	
}
public void saveRecord()
{
	cf.waitandclick(savebtn);
	Contactbtnhome.click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public boolean validateRecordbyName(String FirstName,String LastName)
{
	boolean flag = true;
	String FullName = "//a[text() = '"+FirstName+" "+LastName+"']/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@name='contact_id' and @type = 'checkbox']";
	try {
		flag = cf.visibilityelement(driver.findElement(By.xpath(FullName)));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("exception message is " +e.toString())	;
		flag = false;
	}
	return flag;
	
}
	
public boolean deleteRecord(String FirstName,String LastName)
{
	boolean flag = true;
	String fullname = FirstName +" "+ LastName;
	String fullpathcheckbox = "//a[text() = '"+fullname+"']/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@type='checkbox']";
	try {
		cf.waitandclick(driver.findElement(By.xpath(fullpathcheckbox)));
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String fullPath = "//a[text() = '"+fullname+"']/parent::td[@class='datalistrow']/following-sibling::td[@class='datalistrow']/a/i[@title='Delete']";
	try {
		cf.waitandclick(driver.findElement(By.xpath(fullPath)));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	System.out.println("exception message is " +e.toString())	;
	}
	try {
		
		cf.handleAlerts("yes");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	int[] tablearray = getcontactcolumnnum("Name");
	 flag = checkelementpresentintable(fullname,tablearray[0],tablearray[1]);
	
return flag;
	
	
}

public int[] getcontactcolumnnum(String columnname)
{
	 tablerow = driver.findElements(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/tbody/tr"));
	//int n = table.size();
		int row = 0;
		int column = 0;
	System.out.println("Size of the table is "+tablerow.size());
for (int i =0; i<tablerow.size();i++)
{
	String fullpathcolumn = "//form[@id='vContactsForm']/table[@class='datacard']/tbody/tr["+i+"]/td/strong";
	List<WebElement> tablecolumns = driver.findElements(By.xpath(fullpathcolumn));
	for (int j=0;j<tablecolumns.size();j++)
	{
	String text = tablecolumns.get(j).getText();
	System.out.println("text value is "+text);
	if (text.equals(columnname))
	{
		row =i+1;
		column = j+1;
		break;
	}
	}
}
System.out.println("row number for the given column is "+row);
System.out.println("column number for the given column is "+column);
int[]  ia = {row,column};
return ia;

}
 public boolean checkelementpresentintable(String value,int startrow, int column)
 {boolean flag = false;
	 for (int i =startrow; i<tablerow.size();i++)
	 {
	 	String fullpath = "//form[@id='vContactsForm']/table[@class='datacard']/tbody/tr["+i+"]/td["+(column+1)+"]/a";
	 	String getColumnValue = driver.findElement(By.xpath(fullpath)).getText();
	 	if(getColumnValue.equalsIgnoreCase(value))
	 	{
	 		flag = true;
	 		break;
	 	}
	 	
	 }
	 
	return flag;
	 
 }

	
	
}
