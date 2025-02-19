package pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newsubcategorybutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement categorysearchbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefilebutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody/tr")
	List<WebElement> tableselect;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteicon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement searchcategorydropdown;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchsubcategoryfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement elementsearchbutton;

	public SubCategoryPage clickOnNewSubCategoryButton() {
		newsubcategorybutton.click();
		return this;
	}

	public SubCategoryPage clickOnCategoryDropDown() {

		pageutility.selectDropDownWithVisibleText(categorydropdown, "Toys");
		return this;
	}

	public SubCategoryPage enterSubCategoryField() {
		String subcategoryname = "Bunny" + pageutility.generateCurrentDateAndTime();

		subcategoryfield.sendKeys(subcategoryname);
		return this;
	}

	public SubCategoryPage clickonChooseFileButton()

	{
		pageutility.clickJavaScriptExecutor(choosefilebutton, driver);
		fileupload.fileuploadusingsendkeys(choosefilebutton, Constants.TEST_DATA_IMAGE);
		waitutility.waitUntilElementisVisible(driver, choosefilebutton);
		return this;

	}

	public SubCategoryPage clickOnSaveButton() {
		savebutton.click();
		return this;

	}

	public SubCategoryPage deleteSubCategory() throws InterruptedException {
		pageutility.actions(deleteicon, driver);
		waitutility.waitUntilElementisClickable(driver, deleteicon);
		pageutility.clickJavaScriptExecutor(deleteicon, driver);
		Thread.sleep(2000);
		pageutility.alerthandling(deleteicon, driver);
		return this;

	}

	public boolean isAlertDisplayed() {

		return alertmessage.isDisplayed();

	}

	public SubCategoryPage clickOnSearchButton() {

		categorysearchbutton.click();
		return this;
	}

	public SubCategoryPage searchSubCategory() {
		waitutility.waitUntilElementisClickable(driver, searchcategorydropdown);
		pageutility.selectDropDownWithVisibleText(searchcategorydropdown, "Toys");
		searchsubcategoryfield.sendKeys("Teddy");
		elementsearchbutton.click();
		return this;
	}

	public boolean displaySearchedElement() {

		waitutility.waitUntilAllElementsVisible(driver, tableselect);

		for (WebElement row : tableselect) {
			List<WebElement> columns = row.findElements(By.tagName("td"));

			if (columns.size() >= 2) {
				String subCategoryName = columns.get(0).getText();
				String categoryName = columns.get(1).getText();

				if (categoryName.equals("Toys") && subCategoryName.contains("Teddy")) {
					System.out.println("Subcategory: " + subCategoryName + ", Category: " + categoryName);
					System.out.println("Element found");
					return true;
				}
			}
		}

		System.out.println("Element not found");
		return false;
	}
}
