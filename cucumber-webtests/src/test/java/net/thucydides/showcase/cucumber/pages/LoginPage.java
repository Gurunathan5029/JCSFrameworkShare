package net.thucydides.showcase.cucumber.pages;

import com.google.common.base.Function;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.AssertTrue;

@DefaultUrl("http://lngsead-4144884.legal.regn.net")
public class LoginPage extends PageObject {

    @FindBy(css="button[value='Search']")
    WebElementFacade searchButton;
    
    @FindBy(name="UserName")
    WebElement username;
    
    @FindBy(name="Password")
    WebElement password;

    @FindBy(id="btn-logon-submit")
    WebElement login;
    
    private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'%s')]";

    public void loginpage()
    {
    	try {
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_ALT );
			ro.keyPress(KeyEvent.VK_SPACE);
			ro.keyPress(KeyEvent.VK_X);
			ro.keyPress(KeyEvent.VK_X);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
   public void loginCrentials_username(){
	   username.sendKeys("sjxlx");
    	Assert.assertTrue(username.isDisplayed());   	
    	
   }
   
   public void loginCrentials_password()
   {
	password.sendKeys("Pass@word1");
   	Assert.assertTrue(password.isDisplayed());
   }
   
   public void loginbuttonclick()
   {
	   login.click();
   }
      
}
