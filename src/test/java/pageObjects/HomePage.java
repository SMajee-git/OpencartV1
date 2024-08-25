package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy (xpath = "//a[@class = 'dropdown-toggle']//span[@class=\"hidden-xs hidden-sm hidden-md\"]")
	WebElement lnkMyAccount;
	
	@FindBy (xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//a[contains(text(),'Register')]")
	WebElement lnkRegister;
	
	@FindBy (xpath = "//ul[@class = 'dropdown-menu dropdown-menu-right']//a[contains(text(),'Login')]")
	WebElement lnkLogin;
	
	
	
	public void clickMyAccount() {
		lnkMyAccount.click();	
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
		
	}
}
