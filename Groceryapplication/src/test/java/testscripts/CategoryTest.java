package testscripts;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass {

	LoginPage login;
	HomePage home;
	CategoryPage category;

	@Test(priority=1)
	public void verifyCategoryIsDeleted() throws IOException, AWTException, InterruptedException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.clickOnCategory().deleteCategory();
		boolean isalertpresent = category.isAlertDisplayed();
		Assert.assertTrue(isalertpresent, Constants.CA_verifyCategoryIsDeleted);
	}

	@Test
	public void validateUserCanChangeActiveCategoryStatus() throws IOException {

		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.clickOnCategory().clickOnActiveCategoryStatus();
		boolean isalertpresent = category.isAlertDisplayed();
		Assert.assertTrue(isalertpresent, Constants.CA_validateUserCanChangeActiveCategoryStatus);

	}

	@Test(priority=2)
	public void verifyUserCanAddNewCategory() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.clickOnCategory().clickOnNewCategoryButton().enterCategoryField().selectDiscountField()
				.clickOnImageUpload().clickOnRadioTopMenu().clickOnRadioLeftMenu().saveButton();
		boolean isalertpresent = category.isAlertDisplayed();
		Assert.assertTrue(isalertpresent, Constants.CA_verifyUserCanAddNewCategory);

	}

}
