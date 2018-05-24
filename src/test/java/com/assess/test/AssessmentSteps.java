package com.assess.test;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.asses.main.Constants;
import com.asses.main.SitePOM;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AssessmentSteps {
	
	/////////////////////////// Attributes ///////////////////////////
	
	private WebDriver driver;
	private SitePOM sitePom;
	private Actions action;
	private WebDriverWait wait;
	private ExtentTest test;
	private static ExtentReports report = new ExtentReports(Constants.PATH +"Report.html", true);
	private String employeeID;
	
	/////////////////////////// Surrounding-the-test methods ///////////////////////////
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.PATH + "Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window();
		
		sitePom = PageFactory.initElements(driver, SitePOM.class);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 6);
	}
	
	@After
	public void teardown() {
		report.flush();
		driver.quit();
	}
	
	/////////////////////////// Tests ///////////////////////////
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab(){
		test = report.startTest("Testing can add user to site");
		
		 driver.get(Constants.DASHBOARD_URL);
		 
		sitePom.adminLogin(action, wait);
		
		try{
			sitePom.toUserInput(action, wait);
		} catch (TimeoutException e) {
			test.log(LogStatus.FAIL, "Cannot navigate to add user area");
			return;
		}
		
		test.log(LogStatus.PASS, "Navigation passed");
	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {
		employeeID = sitePom.getID();
		sitePom.addUser();

		test.log(LogStatus.PASS, "Employee details filled");
	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
		sitePom.selectLogin(action);

		test.log(LogStatus.PASS, "Selected add login details");
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() {
		sitePom.fillLogin(action, wait);
		
		test.log(LogStatus.PASS, "Login details filled");
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() {
		sitePom.save(action);
		
		test.log(LogStatus.PASS, "Save button clicked");
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() {
		try{
			sitePom.userExists(wait, employeeID);
		} catch (TimeoutException e) {
			test.log(LogStatus.FAIL, "Employee not added");
			return;
		}
		
		test.log(LogStatus.PASS, "User has been added");
	}

}
