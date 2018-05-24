package com.asses.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SitePOM {
	@FindBy (xpath = "//*[@id=\"menu_pim_viewPimModule\"]/b")
	private WebElement pimTab;
	
	@FindBy (xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]")
	private WebElement addTab;
	
	@FindBy (xpath = "<input class=\"formInputText\" maxlength=\"30\" type=\"text\" name=\"firstName\" id=\"firstName\">")
	private WebElement firstNameField;
	
	@FindBy (xpath = "//*[@id=\"employeeId\"]")
	private WebElement employeeID;
	
	@FindBy (xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]")
	private WebElement lastNameField;
	
	@FindBy (xpath = "//*[@id=\"chkLogin\"]")
	private WebElement checkBox;
	
	@FindBy (xpath = "//*[@id=\"user_name\"]")
	private WebElement usernameField;
	
	@FindBy (xpath = "//*[@id=\"user_password\"]")
	private WebElement passwordField;
	
	@FindBy (xpath = "//*[@id=\"re_password\"]")
	private WebElement confirmField;

	
	
}
