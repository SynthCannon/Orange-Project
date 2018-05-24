package com.asses.main;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SitePOM {
	
	/////////////////////////// Attributes ///////////////////////////
	
	@FindBy (xpath = "//*[@id=\"txtUsername\"]")
	private WebElement adminUser;
	
	@FindBy (xpath = "//*[@id=\"txtPassword\"]")
	private WebElement adminPass;
	
	@FindBy (xpath = "//*[@id=\"btnLogin\"]")
	private WebElement adminSubmit;
	
	@FindBy (xpath = "//*[@id=\"menu_pim_viewPimModule\"]/b")
	private WebElement pimTab;
	
	@FindBy (xpath = "//*[@id=\"menu_pim_addEmployee\"]")
	private WebElement addTab;
	
	@FindBy (xpath = "//*[@id=\"firstName\"]")
	private WebElement firstNameField;
	
	@FindBy (xpath = "//*[@id=\"employeeId\"]")
	private WebElement employeeIDField;
	
	@FindBy (xpath = "//*[@id=\"lastName\"]")
	private WebElement lastNameField;
	
	@FindBy (xpath = "//*[@id=\"chkLogin\"]")
	private WebElement checkBox;
	
	@FindBy (xpath = "//*[@id=\"user_name\"]")
	private WebElement usernameField;
	
	@FindBy (xpath = "//*[@id=\"user_password\"]")
	private WebElement passwordField;
	
	@FindBy (xpath = "//*[@id=\"re_password\"]")
	private WebElement confirmField;

	@FindBy (xpath = "//*[@id=\"btnSave\"]")
	private WebElement saveBtn;
	
	
	/////////////////////////// Methods ///////////////////////////
	
	public void adminLogin (Actions action, WebDriverWait wait) throws TimeoutException{
		wait.until(ExpectedConditions.urlContains(Constants.ADMIN_LOGIN_URL));
		
		action.click(adminUser).sendKeys("Admin").click(adminPass).sendKeys("admin").click(adminSubmit).perform();
		
		wait.until(ExpectedConditions.urlContains(Constants.DASHBOARD_URL));
	}
	
	public void toUserInput(Actions action, WebDriverWait wait) throws TimeoutException{
		action.click(pimTab).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")));

		addTab.click();
	}
	
	public String getID() {
		return employeeIDField.getText();
	}
	
	public void addUser() {
		firstNameField.sendKeys("HereComes");

		lastNameField.sendKeys("DatBoi");
	}
	
	public void selectLogin(Actions action) {
		action.click(checkBox).perform();
	}
	
	public void fillLogin(Actions action, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_name\"]")));
		
		usernameField.sendKeys("DatBoi");
		passwordField.sendKeys("Whaaat?");
		confirmField.sendKeys("Whaaat?");
	}
	
	public void save(Actions action) {
		action.click(saveBtn).perform();
	}
	
	public void userExists(WebDriverWait wait, String employeeID) throws TimeoutException{
		wait.until(ExpectedConditions.urlContains(Constants.EMPLOYEE_URL + employeeID));
	}
}
