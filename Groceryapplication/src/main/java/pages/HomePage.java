package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {

	WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public HomePage(WebDriver driver)// constructor
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver = driver;
		PageFactory.initElements(driver, this);// initElements=initialise all web elements

	}

	@FindBy(xpath = "//li//p[text()='Sub Category']")
	WebElement subcategory;
	@FindBy(xpath = "//li//p[text()='Manage Contact']")
	WebElement managecontact;
	@FindBy(xpath = "//li//p[text()='Manage Footer Text']")
	WebElement managefootertext;
	@FindBy(xpath = "//li//p[text()='Manage Category']")
	WebElement category;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUserMoreInfoFooter;
	@FindBy(xpath = "//li//p[text()='Manage News']")
	WebElement managenews;

	public SubCategoryPage clickOnSubcategory() {
		subcategory.click();
		return new SubCategoryPage(driver);
	}

	public ManageContactPage clickOnManageContact() {
		managecontact.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage clickOnAdminUserManageFooterText() {
		managefootertext.click();
		return new ManageFooterTextPage(driver);
	}

	public CategoryPage clickOnCategory() {
		category.click();
		return new CategoryPage(driver);
	}

	public AdminUserPage clickOnAdminUserFooterMoreInfo() {
		adminUserMoreInfoFooter.click();
		return new AdminUserPage(driver);

	}

	public ManageNewsPage clickOnManageNews() {
		
		waitutility.waitUntilElementisClickable(driver, managenews);
		managenews.click();
		return new ManageNewsPage(driver);

	}
}
