package com.miro.signup.utils;

/**
 * Defining the required URL/Error message display on the page for various
 * action performed in the scenario.
 */

public class SignupConstants {
	
	private SignupConstants() {
		
	}

	public static String SIGNUP_URL = "https://miro.com/signup/";
	public static String SIGNUP_HEADER = "Get started free today";
	public static String EXPECTED_URL = "https://miro.com/email-confirm/";
	public static String EXPECTED_TITLE = "Check your email";
	public static String EXPECTED_ERROR = "Sorry, this email is already registered";
	public static String SIGNIN_URL = "https://miro.com/login/";
	public static String DASHBOARD_URL = "https://miro.com/app/dashboard/";
	public static String EXPECTED_ERROR_WORKMAIL = "This doesn’t look like an email address. Please check it for typos and try again.";
	public static String EXPECTED_ERROR_INVALIDPASSWD = "Please use 8+ characters for secure password";
	public static String NULL_NAME_NOTIFICATION = "Please enter your name.";
	public static String NULL_WORKMAIL_NOTIFICATION = "Please enter your email address.";
	public static String NULL_PASSWORD_NOTIFICATION = "Please enter your password.";
	public static String NULL_TERMS_AGREEMENT_NOTIFICATION = "Please agree with the Terms to sign up.";
	public static String BLANK = "[blank]";
}
