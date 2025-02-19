package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationcore.BaseClass;
import constants.Constants;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(groups = "smoke")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = "Raisa";
		String password = "admin";
		login.enterUsernameinUsernameField(username);
		login.enterPasswordinPasswordField(password);
		login.clickonLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constants.lp_verifyLoginWithInvalidCrendials);
	}

	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = "admin";
		String password = "admin52";
		login.enterUsernameinUsernameField(username);
		login.enterPasswordinPasswordField(password);
		login.clickonLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constants.lp_verifyLoginWithInvalidCrendials);
	}

	@Test(dataProvider = "dataprovider1")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password)
			throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameinUsernameField(username);
		login.enterPasswordinPasswordField(password);
		login.clickonLoginButton();
		boolean expectedResult = login.getAlertMessage();
		Assert.assertTrue(expectedResult, Constants.lp_verifyLoginWithInvalidCrendials);
	}

	@DataProvider(name = "dataprovider1")
	public Object[][] dpmethod1() {
		return new Object[][] { { "abc", "123" }, { "def", "def23" }, { "feh", "feh234" }, { "ght", "dh4h3" } };
	}

	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.loginUsingExcelData();
		boolean expectedResult = true;
		boolean actualResult = login.isHomePageisLoaded();
		Assert.assertEquals(actualResult, expectedResult, Constants.lp_verifyLoginWithValidCredentials);

	}

}
