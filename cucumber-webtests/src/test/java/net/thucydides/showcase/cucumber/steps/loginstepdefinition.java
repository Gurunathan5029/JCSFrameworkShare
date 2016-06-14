package net.thucydides.showcase.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.Inflector;
import net.thucydides.showcase.cucumber.steps.serenity.loginsteps;

import java.text.ParseException;

public class loginstepdefinition {
    @Steps
    loginsteps login;

    @Given("^I navigate to EDA Login Page$")
	public void I_navigate_to_EDA_Login_Page() throws Throwable {
        login.opens_home_page();
    }

    @When("^I provide Username and Password$")
	public void I_provide_Username_and_Password() throws Throwable {
        login.usernameandpasswordprovider();
    }

    @When("^I Click on Login button$")
	public void I_Click_on_Login_button() throws Throwable {
        login.should_see_results_summary_containing();
    }
    
    @Then("^Home Page should be Displayed$")
    public void home_Page_should_be_Displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	login.should_see_results_summary_containing();
    }

}


