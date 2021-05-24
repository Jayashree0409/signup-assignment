package com.miro.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Runner class to glue all the relevant feature / step definition to be run
 */

@RunWith(Cucumber.class)
@CucumberOptions ( features = {"src/test/java/com/miro/signup/features"},
	glue = { "com.miro.signup.steps" }, 
	tags = {"@signup"},
	plugin = { "pretty", "html:test-output", "json:target/cucumber.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 	
	dryRun = false,
	monochrome = true
	)
public class SignupRunner {

}
