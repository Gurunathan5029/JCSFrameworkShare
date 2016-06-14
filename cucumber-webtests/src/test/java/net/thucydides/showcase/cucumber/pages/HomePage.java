package net.thucydides.showcase.cucumber.pages;

import com.google.common.base.Function;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://lngsead-4144884.legal.regn.net")
public class HomePage extends PageObject {

    @FindBy(css="button[value='Search']")
    WebElementFacade searchButton;
    
    @FindBy(name="UserName")
    WebElement search;

    private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'%s')]";

    public void loginpage()
    {
    	search.sendKeys("Guru");    	
    
    }
   
   

    
}
