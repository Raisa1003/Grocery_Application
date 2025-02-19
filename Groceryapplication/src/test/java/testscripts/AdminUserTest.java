package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.AdminUserPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserTest extends BaseClass {

	LoginPage login;
	HomePage home;
	CategoryPage category;
	AdminUserPage adminuser;

	@Test
	public void verifyUserCanAddNewAdminDetails() throws IOException {

		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuser = home.clickOnAdminUserFooterMoreInfo().clickOnNewAdminUserButton().addAdminUserDetails();
		boolean isalertdisplayed = adminuser.isAlertMessageDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.AU_verifyUserCanAddNewAdminDetails);
	}

	@Test
	public void VerifyUserCanChangeStatusOfAdminDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuser = home.clickOnAdminUserFooterMoreInfo().clickOnNewAdminUserButton().clickOnStatuslockIcon();
		boolean isstatusalertdisplayed = adminuser.isAlertMessageDisplayed();
		Assert.assertTrue(isstatusalertdisplayed, Constants.AU_VerifyUserCanChangeStatusOfAdminDetails);
	}

	@Test
	public void VerifyUserCanSearchAdminUserInfo() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		adminuser = home.clickOnAdminUserFooterMoreInfo().searchAdminUserInfo().searchUserNameandPasswordField()
				.clickOnSearchButton();
		boolean issearchedtabledisplayed = adminuser.isSearchedTableDisplayed();
		Assert.assertTrue(issearchedtabledisplayed, Constants.AU_VerifyUserCanSearchAdminUserInfo);
	}

}
