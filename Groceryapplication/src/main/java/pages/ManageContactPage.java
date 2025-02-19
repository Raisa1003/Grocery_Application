package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();
	FakerUtility fakerutility = new FakerUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editmanagecontacticon;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonenumberfield;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement addressfield;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliverytimefield;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverychargelimitfield;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageContactPage clickOnManageContactIcon() {
		editmanagecontacticon.click();
		return this;
	}

	public ManageContactPage enterContactDetailsToUpdate() {
		waitutility.waitUntilElementisClickable(driver, updatebutton);
		phonenumberfield.clear();
		String phonenumber = fakerutility.generatePhoneNumber();
		phonenumberfield.sendKeys(phonenumber);
		emailfield.clear();
		String email = fakerutility.generateEmailAddress();
		emailfield.sendKeys(email);
		addressfield.clear();
		String address = fakerutility.generateAddress();
		addressfield.sendKeys(address);
		deliverytimefield.clear();
		deliverytimefield.sendKeys("80");
		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys("100");
		pageutility.actions(updatebutton, driver);
		return this;
	}

	public ManageContactPage clickOnUpdateIcon() {

		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}

}
