package net.thucydides.showcase.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.cucumber.pages.UserCreationPage;
import net.thucydides.showcase.supportLibraries.ExcelHandling;
import net.thucydides.showcase.supportLibraries.ExcelHandling.status;

public class Usercreationsteps  extends ScenarioSteps{

	UserCreationPage userCreationPage;
	ExcelHandling report = new ExcelHandling();
	
	@Step
	public void manageAdministratorPage(){
		userCreationPage.AdminstratorPage();
		report.resultstatus("Administration Page Verification","Administration is dispalyed", status.Pass);
	}
	
	@Step
	public void manageUserCreationPage(){
		userCreationPage.CreationOfAdministrtators();
		report.resultstatus("Identification of Create Administrator ","Create Administrator is clicked", status.Pass);
	}
	
	@Step
	public void manageFieldEntries(String Username, String FirstName,String LastName,String EmailAddress,String Password){
		userCreationPage.FieldEntries(Username,FirstName,LastName,EmailAddress,Password);
	}
	
	@Step
	public void manageSubmitPage(){
		userCreationPage.CreateNewAdmin();
	}
}
