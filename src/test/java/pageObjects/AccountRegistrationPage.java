package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	//constructor
	public  AccountRegistrationPage (WebDriver driver) {
		super(driver);
	}
	
	
	//Locator
	@FindBy (xpath= "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy (xpath= "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy (xpath= "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy (xpath= "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy (xpath= "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy (xpath= "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy (xpath = "//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy (xpath = "//input[@class='btn btn-primary']")
	WebElement btnContinue;
	
	@FindBy (xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement msgConfirmation;
	
	
	//Action Method
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}
	
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());
	}
	}
	
	
}
