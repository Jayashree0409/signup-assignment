package com.miro.signup.objects;

import static com.miro.signup.utils.SignupConstants.*;
import static org.testng.Assert.assertNotNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.miro.signup.steps.Hooks;

/**
 * 
 * @author Jayashree Eswaran Class refer to all the Page objects and Open the
 *         Selenium Webdriver to perform the Sign up actions for the SIGN IN
 *         Page
 *
 */

public class SignupPage {

	private static Logger Log = Logger.getLogger(SignupPage.class.getName());

	public SignupPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	/**
	 * Identifying the WebElement in the Sign Up page /Confirmation page/Sign In
	 * page
	 */

	@FindBy(how = How.XPATH, using = "//h1")
	private WebElement pageHeader;

	@FindBy(how = How.ID, using = "name")
	private WebElement name;

	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.CLASS_NAME, using = "mr-checkbox-1__icon")
	private WebElement termsOfServices;

	@FindBy(how = How.CLASS_NAME, using = "signup__submit")
	private WebElement signup;

	@FindBy(how = How.XPATH, using = "//h1")
	private WebElement path;

	@FindBy(how = How.CLASS_NAME, using = "signup__error-item")
	private WebElement actualErrorMessge;

	@FindBy(how = How.CLASS_NAME, using = "overlay-signup__btn-container")
	private WebElement signIn;

	@FindBy(how = How.CLASS_NAME, using = "signup__input-hint-text")
	private WebElement invalidPasswordMessage;

	@FindBy(how = How.CLASS_NAME, using = "signup__error-item")
	private WebElement nullPasswordCheck;


	/**
	 * Calling the Selenium Webdriver and hit the Sign up URL and confirming whether
	 * it land into the sign up URL
	 */

	public void signupPage() {
		Hooks.getDriver().get(SIGNUP_URL);
		Hooks.getDriver().manage().window().maximize();
		Hooks.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
		Log.info("Cookies accepeted sucussfully");

	}

	/**
	 * Verify whether the SignIn page landed properly
	 */

	public void signupPageVerification() {
		String signupPage = pageHeader.getText();
		Assert.assertEquals(signupPage, SIGNUP_HEADER);
		Log.info("User on Miro Signup page");
	}

	/**
	 * Enter the information required to signup for the page
	 */

	public void signupInformation(String userName, String workmail, String userPassword) {

		assertNotNull(userName, "userName should not be null");		
		assertNotNull(workmail, "email should not be null");
		assertNotNull(userPassword, "password should not be null");

		name.sendKeys(userName);
		email.sendKeys(workmail);
		password.sendKeys(userPassword);

	}

	/**
	 * Check the Terms and Agreement box in the page
	 */

	public void termsOfServices() {
		termsOfServices.click();

	}

	/**
	 * Verify whether redirected to confirmation page upon successful signup
	 */

	public void getStartNow() {

		signup.click();
	}

	/**
	 * Verify whether redirected to confirmation page upon successful signup
	 */

	public void signedUp() {
		Assert.assertEquals(Hooks.getDriver().getCurrentUrl(), EXPECTED_URL);
	}

	/**
	 * Verify notification displayed to provide the verification code receive in the
	 * mail.
	 */

	public void signupConfirmationPage() {

		Assert.assertEquals(path.getText(), EXPECTED_TITLE);

		Log.info("User successfully signed up");
	}

	/**
	 * Verify notification displayed as work mail already signed up.
	 */

	public void existingWorkMailNotification() {

		String actualErrorMsg = actualErrorMessge.getText();
		Assert.assertEquals(actualErrorMsg, EXPECTED_ERROR);
	}

	/**
	 * Click on the SignIn button on the page
	 */

	public void signIn() {

		signIn.click();
	}

	/**
	 * Verify whether redirection happen to SignIn page
	 */

	public void signInPageVerification() {

		Assert.assertEquals(Hooks.getDriver().getCurrentUrl(), SIGNIN_URL);

	}

	/**
	 * Enter sign in with existing work mail and password to land on dashboard page
	 */

	public void signInexistingWorkMail(String userworkmail, String userpswd) {

		assertNotNull(userworkmail, "email should not be null");
		assertNotNull(userpswd, "password should not be null");

		email.sendKeys(userworkmail);
		password.sendKeys(userpswd);
	}

	/**
	 * Confirmation check whether the dashboard page displayed
	 */

	public void dashboardConfirmationPage() throws Exception{

		signup.click();
		Thread.sleep(7000);
		Assert.assertEquals(Hooks.getDriver().getCurrentUrl(), DASHBOARD_URL);
	}

	/**
	 * Signup with a invalid work mail
	 */

	public void invalidWorkMailSignup() {

		String actualErrorworkmail = actualErrorMessge.getText();
		Assert.assertEquals(actualErrorworkmail, EXPECTED_ERROR_WORKMAIL);
	}

	/**
	 * Signup with a invalid password
	 */

	public void invalidPasswordSignup() {

		String actualinvalidpassword = invalidPasswordMessage.getText();
		Assert.assertEquals(actualinvalidpassword, EXPECTED_ERROR_INVALIDPASSWD);
	}

	/**
	 * Enter signup details with null value for username or work mail or password
	 */

	public void nullSignup(String userName, String workmail, String userPassword) {

		String usrName = userName.equals(BLANK) ? StringUtils.EMPTY : userName;
		String usrWorkEmail = workmail.equals(BLANK) ? StringUtils.EMPTY : workmail;
		String usrPassword = userPassword.equals(BLANK) ? StringUtils.EMPTY : userPassword;

		name.sendKeys(usrName);
		email.sendKeys(usrWorkEmail);
		password.sendKeys(usrPassword);

	}

	/**
	 * To verify whether the notification display to enter the name
	 */

	public void nullNameCheck() {

		String nullnamecheck = actualErrorMessge.getText();
		Assert.assertEquals(nullnamecheck, NULL_NAME_NOTIFICATION);
	}

	/**
	 * To verify whether the notification display to enter the work mail
	 */

	public void nullWorkMailCheck() {

		String nullworkmailcheck = actualErrorMessge.getText();
		Assert.assertEquals(nullworkmailcheck, NULL_WORKMAIL_NOTIFICATION);

	}

	/**
	 * To verify whether the notification display to enter the password
	 */

	public void nullPassWordCheck() {

		String nullpswdcheck = nullPasswordCheck.getText();
		Assert.assertEquals(nullpswdcheck, NULL_PASSWORD_NOTIFICATION);

	}

	/**
	 * To verify whether the notification display to check Terms and Agreement box
	 */
	public void nullCheckAgreement() {

		String nullagreecheck = actualErrorMessge.getText();
		Assert.assertEquals(nullagreecheck, NULL_TERMS_AGREEMENT_NOTIFICATION);

	}	


}
