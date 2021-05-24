package com.miro.signup.steps;

import java.util.List;

import com.miro.signup.objects.SignupPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step Definitions for the New user sign up
 */

public class NewUserSignupDef {

	private SignupPage signupObject;

	public NewUserSignupDef() {
		signupObject = new SignupPage();
	}

	/**
	 * Steps for the New user sign up
	 */

	@Given("i open signup page")
	public void i_open_signup_page() throws Exception {

		signupObject.signupPage();
		Thread.sleep(1000);
	}

	@When("i am on {string}")
	public void i_am_on(String string) throws Exception {

		signupObject.signupPageVerification();
		Thread.sleep(1000);
	}

	@Then("i signup with following details")
	public void i_signup_with_following_details(DataTable data) throws Exception {

		List<String> userDetails = data.asList();

		signupObject.signupInformation(userDetails.get(0), userDetails.get(1), userDetails.get(2));

		Thread.sleep(2000);
	}

	@Then("i check the Terms and Agreement")
	public void i_check_the_Terms_and_Agreement() {

		signupObject.termsOfServices();
	}

	@Then("i click the Get started now button on the page")
	public void i_click_the_Get_started_now_button_on_the_page() {

		signupObject.getStartNow();
	}

	@And("i should see the confirmation page")
	public void i_should_see_the_confirmation_page() throws Exception {

		signupObject.signedUp();
		Thread.sleep(1000);

		signupObject.signupConfirmationPage();
		Thread.sleep(2000);

	}
}
