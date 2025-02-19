package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterTextPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1' and @class='btn btn-sm btn btn-primary btncss']")
	WebElement editadminusericon;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement enteraddressfield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumberfield;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateadminuserbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageFooterTextPage clickOnAdminUserupdateIcon() {
		editadminusericon.click();
		return this;
	}

	public ManageFooterTextPage enterFooterTextDetails() {
		waitutility.waitUntilElementisClickable(driver, updateadminuserbutton);
		enteraddressfield.clear();
		String address = fakerutility.generateAddress();
		enteraddressfield.sendKeys(address);
		emailfield.clear();
		String email = fakerutility.generateEmailAddress();
		emailfield.sendKeys(email);
		phonenumberfield.clear();
		String phonenumber = fakerutility.generatePhoneNumber();
		phonenumberfield.sendKeys(phonenumber);
		pageutility.actions(updateadminuserbutton, driver);
		return this;

	}

	public ManageFooterTextPage clickOnupdateIcon() {

		updateadminuserbutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}
}
