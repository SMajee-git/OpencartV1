package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends TestBase {

	@Test(groups = { "Sanity", "Master" })
	public void verify_account_registration() {

		logger.info("************Starting TC001_AccountRegistrationTest*******************");
		logger.debug("This is a debug log message");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount");

			hp.clickRegister();
			logger.info("Clicked on Register");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing the User details");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

//		regpage.setFirstName("ABC");
//		regpage.setLastName("LAST");
//		regpage.setEmail("nhui@gmail.com");
//		regpage.setTelephone("1593578524");
//		
//		String password = "abh@1234";
//		regpage.setPassword(password);
//		regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			logger.info("Checked the PrivacyPolicy");
			regpage.clickContinue();

			logger.info("Validating expected message..");
			String org_regmmsg = regpage.getConfirmationMsg();
			// String exp_regmmsg = "Your Account Has Been Created!";

			if (org_regmmsg.equals("Your Account Has Been Created!")) {

				Assert.assertTrue(true);
				logger.debug("Test passed...");
			}
			// Assert.assertEquals(org_regmmsg, "Your Account Has Been Created!");
			else {
				logger.error("Test failed: ");
				logger.debug("Test debug: ");
				Assert.assertTrue(false);
			}
		}

		catch (Exception e) {

			Assert.fail("Test failed: " + e.getMessage());
		}

		finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}
}