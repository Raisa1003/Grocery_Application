package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.SubCategoryPage;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage home;
	SubCategoryPage sc;
	ManageContactPage managecontact;

	@Test
	public void verifyUserCanUpdateContactDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		managecontact = home.clickOnManageContact().clickOnManageContactIcon().enterContactDetailsToUpdate()
				.clickOnUpdateIcon();
		Boolean isalertdisplayed = managecontact.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.MC_verifyUserCanUpdateContactDetails);
	}
}
