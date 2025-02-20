package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newAdminUserbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypedropdownfield;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-success btncss']")
	WebElement lockstatusicon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchAdminUserbutton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchusernamefield;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchAdminusertypefield;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchbutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement displaysearchedtable;

	public AdminUserPage clickOnNewAdminUserButton() {
		newAdminUserbutton.click();
		return this;
	}

	public AdminUserPage addAdminUserDetails() {
		usernamefield.clear();
		String username = fakerutility.generateName();
		usernamefield.sendKeys(username);
		passwordfield.clear();
		passwordfield.sendKeys(fakerutility.generatePassword());
		pageutility.selectDropDownWithVisibleText(usertypedropdownfield, "Admin");
		savebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}

	public AdminUserPage clickOnStatuslockIcon() {
		pageutility.clickJavaScriptExecutor(lockstatusicon, driver);
		return this;

	}

	public boolean isStatusAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}

	public AdminUserPage searchAdminUserInfo() {
		searchAdminUserbutton.click();
		return this;
	}

	public AdminUserPage searchUserNameandPasswordField() {
		searchusernamefield.sendKeys("Alec Watsica");
		pageutility.selectDropDownWithVisibleText(searchAdminusertypefield, "Admin");
		return this;

	}

	public AdminUserPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public boolean isSearchedTableDisplayed() {
		return displaysearchedtable.isDisplayed();
	}

}
