package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement activestatuslink;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newcategorybutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement entercategoryfield;
	@FindBy(xpath = "//span[text()='discount']")
	WebElement discountfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageuploadfield;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement radiobuttontopmenu;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	WebElement radiobuttonleftmenu;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteicon;

	public CategoryPage clickOnActiveCategoryStatus() {
		pageutility.actions(activestatuslink, driver);
		waitutility.waitUntilElementisClickable(driver, activestatuslink);
		pageutility.clickJavaScriptExecutor(activestatuslink, driver);

		return this;
	}

	public boolean isAlertDisplayed() {
		return alertmessage.isDisplayed();
	}

	public CategoryPage clickOnNewCategoryButton() {
		newcategorybutton.click();
		return this;
	}

	public CategoryPage enterCategoryField() {
		entercategoryfield.sendKeys("Red Fruits" + pageutility.generateCurrentDateAndTime());
		return this;
	}

	public CategoryPage selectDiscountField() {
		waitutility.waitUntilElementisClickable(driver, discountfield);
		discountfield.click();
		return this;
	}

	public CategoryPage clickOnImageUpload() {
		fileupload.fileuploadusingsendkeys(imageuploadfield, Constants.TEST_DATA_IMAGE_POMEGRANATE);
		return this;
	}

	public CategoryPage clickOnRadioTopMenu() {
		waitutility.waitUntilElementisClickable(driver, radiobuttontopmenu);
		pageutility.groupradiobutton(radiobuttontopmenu);
		return this;
	}

	public CategoryPage clickOnRadioLeftMenu() {
		waitutility.waitUntilElementisClickable(driver, radiobuttonleftmenu);
		pageutility.groupradiobutton(radiobuttonleftmenu);
		return this;
	}

	public CategoryPage saveButton() {
		pageutility.clickJavaScriptExecutor(savebutton, driver);
		return this;
	}

	public CategoryPage deleteCategory() throws InterruptedException {
		pageutility.actions(deleteicon, driver);
		waitutility.waitUntilElementisClickable(driver, deleteicon);
		pageutility.clickJavaScriptExecutor(deleteicon, driver);
		Thread.sleep(2000);
		pageutility.alerthandling(deleteicon, driver);
		return this;

	}
}
