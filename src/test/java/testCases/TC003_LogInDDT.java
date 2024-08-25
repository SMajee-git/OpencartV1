package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LogInDDT extends TestBase {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataProvider")
	public void verify_login(String email, String pwd, String exp) { // exp= expected result

		logger.info("************Starting TC002_LogInDDT*******************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LogInPage lp = new LogInPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			Boolean targetPage = macc.isMyAccountPageExists();

			/*
			 * Data is valid - login success - test pass - logout Data is valid -- login
			 * failed - test fail
			 * 
			 * Data is invalid - login success - test fail - logout Data is invalid -- login
			 * failed - test pass
			 */

			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {

			Assert.fail();
		}

		logger.info("************Ending TC002_LogInDDT*******************");

	}

}