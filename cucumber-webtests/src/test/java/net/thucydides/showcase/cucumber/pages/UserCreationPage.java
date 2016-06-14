package net.thucydides.showcase.cucumber.pages;



import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import net.thucydides.core.pages.PageObject;


public class UserCreationPage extends PageObject {

	@FindBy(linkText = "Administration")
	WebElement Administration;
	
	@FindBy(linkText = "Administrators")
	WebElement Administrator;
	
	@FindBy(id = "a-create-user-top")
	WebElement createAdminstrator;
	
	@FindBy(id = "UserName")
	WebElement username;
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(css ="#btn-submit-create-users")
	WebElement createUser;

	
	
	public void AdminstratorPage(){
		Administration.click();
		Administrator.click();
		Assert.assertTrue(createAdminstrator.isDisplayed()); 
	}
	
	public void CreationOfAdministrtators(){
		createAdminstrator.click();
		}
	
	public void FieldEntries(String Username, String FirstName,String LastName,String EmailAddress,String Password){
		Assert.assertTrue(username.isDisplayed()); 
		username.sendKeys(Username);
		Assert.assertTrue(firstName.isDisplayed()); 
		firstName.sendKeys(FirstName);
		Assert.assertTrue(lastName.isDisplayed()); 
		lastName.sendKeys(LastName);
		Assert.assertTrue(email.isDisplayed()); 
		email.sendKeys(EmailAddress);
		Assert.assertTrue(password.isDisplayed()); 
		password.sendKeys(Password);
		Assert.assertTrue(ConfirmPassword.isDisplayed()); 
		ConfirmPassword.sendKeys(Password);
	}
	public void CreateNewAdmin(){
		try {Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN );		
		Assert.assertTrue(createAdminstrator.isDisplayed()); 		
		ro.keyPress(KeyEvent.VK_DOWN );
			Thread.sleep(5000);
			ro.keyPress(KeyEvent.VK_DOWN );
			ro.keyPress(KeyEvent.VK_DOWN );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		createUser.click();
	}
}
