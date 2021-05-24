package com.miro.signup.steps;

import com.miro.signup.objects.SignupPage;

import io.cucumber.java.en.And;

/**
 * Step Definitions with Invalid user sign up
 */

public class InvalidUserSignupDef {

	private SignupPage signupObject;

	public InvalidUserSignupDef() {
		signupObject = new SignupPage();
	}

	@And("i should see the notification to enter the valid work mail")
	public void i_should_see_the_notification_to_enter_the_valid_work_mail() throws Exception {
		signupObject.invalidWorkMailSignup();
		Thread.sleep(3000);
	}

	@And("i should see the notification to enter the valid password")
	public void i_should_see_the_notification_to_enter_the_valid_password() throws Exception {
		signupObject.invalidPasswordSignup();
		Thread.sleep(3000);
	}

}
