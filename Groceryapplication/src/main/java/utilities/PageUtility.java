package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public WebDriver driver;

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropDownWithVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedelement = select.getFirstSelectedOption();
		return selectedelement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void clickJavaScriptExecutorByScroll(WebDriver driver, List<WebElement> elements, int index) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
	}

	public void clickJavaScriptExecutorByScrollbyWindow(WebDriver driver, WebElement element) {
		JavascriptExecutor javaex = (JavascriptExecutor) driver;
		javaex.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void actions(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void alerthandling(WebElement element, WebDriver driver) throws InterruptedException {

		driver.switchTo().alert().accept();
	}

	public void groupradiobutton(WebElement element) {

		if (!element.isSelected()) {
			element.click();
		}
	}

	public void iframehandling() {

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent(); // leave frame and switch to default content
	}

	public int random(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

}
