package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newsbutton;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editIcon;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newstextarea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	public ManageNewsPage clickonNewManageNewsButton() {

		newsbutton.click();
		newstextarea.sendKeys("Summer season offers in selected items");
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}

	public ManageNewsPage clickOnManageNewsEditIcon() {

		waitutility.waitUntilElementisClickable(driver, editIcon);
		editIcon.click();
		return this;

	}

	public ManageNewsPage enterNewstoUpdate() {

		newstextarea.clear();
		newstextarea.sendKeys("50% discount on all garments ");
		waitutility.waitUntilElementisClickable(driver, updatebutton);
		pageutility.actions(updatebutton, driver);
		updatebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}
}
