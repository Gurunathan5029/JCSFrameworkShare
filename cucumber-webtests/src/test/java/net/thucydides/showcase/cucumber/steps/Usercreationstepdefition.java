package net.thucydides.showcase.cucumber.steps;

import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.steps.serenity.Usercreationsteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Usercreationstepdefition {
	
	@Steps
	Usercreationsteps userCreation;
	
	@Given("^Manage Administrator Page is displayed$")
	public void manage_Administrator_Page_is_displayed() throws Throwable {
	  userCreation.manageAdministratorPage();
	}

	@Given("^I navigate to Create Administrator Page$")
	public void i_navigate_to_Create_Administrator_Page() throws Throwable {
	   userCreation.manageUserCreationPage();
	}

	@When("^I provide valid Administrator \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_provide_valid_Administrator_and(String Username, String FirstName, String LastName, String EmailAddress, String Password) throws Throwable {
	 
		userCreation.manageFieldEntries(Username,FirstName,LastName,EmailAddress,Password);
	}

	@When("^clicking on Create Administrator button$")
	public void clicking_on_Create_Administrator_button() throws Throwable {
	   userCreation.manageSubmitPage();
	}

	@Then("^User Successfully created message should be displayed$")
	public void user_Successfully_created_message_should_be_displayed() throws Throwable {
	  
	}
}
