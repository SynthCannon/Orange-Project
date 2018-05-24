package com.assess.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asses.main.Constants;
import com.asses.main.SitePOM;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AssessmentSteps {
	
	private WebDriver driver;
	private SitePOM sitePom;
	private Actions action;
	private WebDriverWait wait;
	private ExtentTest test;
	private static ExtentReports report = new ExtentReports(Constants.PATH +"Report.html", true);
	

	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws Throwable {

	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() throws Throwable {

	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() throws Throwable {

	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws Throwable {

	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {

	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() throws Throwable {

	}

}
