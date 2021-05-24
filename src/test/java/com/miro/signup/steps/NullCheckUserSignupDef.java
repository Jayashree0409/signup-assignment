package com.miro.signup.steps;

import java.util.List;

import com.miro.signup.objects.SignupPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * Step Definitions with Null check by user while sign up
 */

public class NullCheckUserSignupDef {

	private SignupPage signupObject;

	public NullCheckUserSignupDef() {
		signupObject = new SignupPage();
	}

	@Then("i signup null value with following details")
	public void i_signup_null_value_with_following_details(DataTable data) throws Exception {

		List<String> userDetails = data.asList();

		signupObject.nullSignup(userDetails.get(0), userDetails.get(1), userDetails.get(2));

		Thread.sleep(2000);
	}

	@And("i should see the notification to enter the name")
	public void i_should_see_the_notification_to_enter_the_name() throws Exception {
		signupObject.nullNameCheck();
		Thread.sleep(2000);
	}

	@And("i should see the notification to enter the work mail")
	public void i_should_see_the_notification_to_enter_the_work_mail() throws Exception {
		signupObject.nullWorkMailCheck();
		Thread.sleep(2000);
	}

	@And("i should see the notification to enter the password")
	public void i_should_see_the_notification_to_enter_the_password() throws Exception {
		signupObject.nullPassWordCheck();
		Thread.sleep(2000);
	}

	@And("i should see the notification to check the terms and agreement")
	public void i_should_see_the_notification_to_check_the_terms_and_agreement() throws Exception {
		signupObject.nullCheckAgreement();
		Thread.sleep(2000);
	}

}
