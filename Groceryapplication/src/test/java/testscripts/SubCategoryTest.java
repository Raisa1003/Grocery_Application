package testscripts;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;

public class SubCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	SubCategoryPage subcategory;

	@Test
	public void verifyAddNewSubcategorywithValidDetails() throws IOException, AWTException, InterruptedException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		subcategory = home.clickOnSubcategory().clickOnNewSubCategoryButton().clickOnCategoryDropDown()
				.enterSubCategoryField().clickonChooseFileButton().clickOnSaveButton();
		boolean isalertpresent = subcategory.isAlertDisplayed();
		Assert.assertTrue(isalertpresent,Constants.SC_verifyAddNewSubcategorywithValidDetails );

	}

	@Test
	public void verifySubCategoryIsDeleted() throws IOException, AWTException, InterruptedException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		subcategory = home.clickOnSubcategory().deleteSubCategory();
		boolean isalertpresent = subcategory.isAlertDisplayed();
		Assert.assertTrue(isalertpresent,Constants.SC_verifySubCategoryIsDeleted );
	}

	@Test
	public void verifySearchSubCategory() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		home.clickOnSubcategory();
		subcategory = home.clickOnSubcategory().clickOnSearchButton().searchSubCategory();
		boolean iselementfound = subcategory.displaySearchedElement();
		Assert.assertTrue(iselementfound,Constants.SC_verifySearchSubCategory);
	}
}
