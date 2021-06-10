package com.miro.signup.steps;

import java.util.List;

import com.miro.signup.objects.SignupPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * Step Definitions for Existing user sign up
 */

public class ExisitingUserSignupDef {

	private SignupPage signupObject;

	public ExisitingUserSignupDef() {
		signupObject = new SignupPage();
	}


@Then("i should see the notification as email already signup")
public void i_should_see_the_notification_as_email_already_signup() {
	signupObject.existingWorkMailNotification();
}

@Then("i click the sign in button on the page")
public void i_click_the_sign_in_button_on_the_page() throws Exception {
	signupObject.signIn();
	Thread.sleep(1000);

}

@Then("i am redirected to {string}")
public void i_am_redirected_to (String string) throws Exception {
	signupObject.signInPageVerification();
	Thread.sleep(1000);
}

@Then("i login with following details")
public void i_login_with_following_details(DataTable data) throws Exception {
	List<String> userDetails = data.asList();

	signupObject.signInexistingWorkMail(userDetails.get(0), userDetails.get(1));

	Thread.sleep(3000);
}

@And("i should see the dashboard page")
public void i_should_see_the_dashboard_page() throws Exception {
	signupObject.dashboardConfirmationPage();

	Thread.sleep(9000);
	}
}
