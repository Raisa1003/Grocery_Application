package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver)// constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// initElements=initialise all web elements

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinbutton;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmessage;

	public void enterUsernameinUsernameField(String username) throws IOException {
		
		usernamefield.sendKeys(username);

	}

	public void enterPasswordinPasswordField(String password) throws IOException {
		
		passwordfield.sendKeys(password);

	}

	public HomePage loginUsingExcelData() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		usernamefield.sendKeys(username);
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new HomePage(driver);
	}

	public HomePage clickonLoginButton() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageisLoaded() {
		return homepage.isDisplayed();
	}

	public boolean getAlertMessage() {
		return alertmessage.isDisplayed();
	}
}
