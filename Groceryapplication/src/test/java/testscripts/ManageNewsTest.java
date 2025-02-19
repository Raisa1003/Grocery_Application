package testscripts;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageNewsPage manageNewsPage;

	@Test
	public void verifyAdminUserCanAddNews() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		manageNewsPage = home.clickOnManageNews().clickonNewManageNewsButton().clickOnSaveButton();
		boolean isAlertPresent = manageNewsPage.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.MN_verifyAdminUserCanAddNews);
	}

	@Test
	public void verifyAdminUserCanManageAndEditNews() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		manageNewsPage = home.clickOnManageNews().clickOnManageNewsEditIcon().enterNewstoUpdate();
		boolean isAlertPresent = manageNewsPage.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constants.MN_verifyAdminUserCanManageAndEditNews);
	}

}
