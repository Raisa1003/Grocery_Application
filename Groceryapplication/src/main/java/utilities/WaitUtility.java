package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static int implicitwaitDuration = 5;
	public static int explicitwaitDuration = 10;
	public static int fluentwaitDuration = 5;

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(fluentwaitDuration)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void fluentWaitElementsAlert(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(fluentwaitDuration)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementisVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementisClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilAllElementsVisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitUntilAttributeContains(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.attributeContains(element, "attribute", "attributeValue"));
	}

	public void waitUntilElementSelectionState(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwaitDuration));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwaitDuration));
	}

}
