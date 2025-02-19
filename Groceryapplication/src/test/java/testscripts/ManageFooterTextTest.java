package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;

public class ManageFooterTextTest extends BaseClass {

	LoginPage login;
	HomePage home;
	ManageFooterTextPage managefooter;

	@Test
	public void verifyUserCanUpdateAdminFooterDetails() throws IOException {

		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		managefooter = home.clickOnAdminUserManageFooterText().clickOnAdminUserupdateIcon().enterFooterTextDetails()
				.clickOnupdateIcon();
		boolean isalertpresent = managefooter.isAlertDisplayed();
		Assert.assertTrue(isalertpresent,Constants.MF_verifyUserCanUpdateAdminFooterDetails );
	}
}
