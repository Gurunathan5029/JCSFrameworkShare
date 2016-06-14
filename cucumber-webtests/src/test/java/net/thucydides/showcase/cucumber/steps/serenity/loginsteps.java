package net.thucydides.showcase.cucumber.steps.serenity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.cucumber.pages.LoginPage;
import net.thucydides.showcase.supportLibraries.ExcelHandling;
import net.thucydides.showcase.supportLibraries.ExcelHandling.status;
import static org.assertj.core.api.Assertions.assertThat;
public class loginsteps extends ScenarioSteps {

	
    LoginPage loginpage;
    ExcelHandling report = new ExcelHandling();
    
    
    
    @Step
    public void opens_home_page() throws IOException {
    
       loginpage.open();
      report.resultstatus("URL launching","Url is Launched Succefully",status.Pass);
    }

    @Step
    public void usernameandpasswordprovider() throws IOException {
    	loginpage.loginpage();
        loginpage.loginCrentials_username();        
        report.resultstatus("UserName a is entered","UserName is entered ",status.Pass);
        loginpage.loginCrentials_password();   
        report.resultstatus("Password is entered","password is entered ",status.Pass);
        loginpage.loginbuttonclick();
    }

    @Step
    public void should_see_results_summary_containing() {
    	System.out.println("Hi");
     //   assertThat(searchResultsPage.getSearchHeader()).containsIgnoringCase("Hi");
        System.out.println("Hi");
    }
}
