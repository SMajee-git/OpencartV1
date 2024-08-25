package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends TestBase{
	
	@Test (groups = {"Regression" , "Master"})
	public void verify_login() {
		
		logger.info("************Starting TC002_LoginTest*******************");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LogInPage lp = new LogInPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		Boolean targetPage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true, "Login failed");
		}
		
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("************Ending TC002_LoginTest*******************");
	}
	

}
