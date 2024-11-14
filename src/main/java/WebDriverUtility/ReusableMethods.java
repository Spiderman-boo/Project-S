package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

	public void ExplacitVisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void invisibleVisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void visiblityOfElement(WebDriver driver, List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public void elementclick(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// Click element with wait
	/*public void clickElement(WebDriver driver, WebElement element) {
		waitForElementToBeClickable(driver, element);
		element.click();
	}*/

	// Switch to alert and accept it
	public void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	// Switch to alert and dismiss it
	public void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();
	}

	// Send text to alert
	public void sendTextToAlert(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(text);
		alert.accept();
	}

	// Switch to a specific window by title
	public void switchToWindowByTitle(WebDriver driver, String windowTitle) {
		String originalWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(windowTitle)) {
				return;
			}
		}
		driver.switchTo().window(originalWindow); // Switch back if not found
	}

	// Switch to frame by index
	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// Switch to frame by name or ID
	public void switchToFrameByNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Switch to frame by WebElement
	public void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Switch back to the default content from a frame
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Select an option from dropdown by visible text
	public void selectDropdownByText(WebElement dropdownElement, String text) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(text);
	}

	// Select an option from dropdown by value
	public void selectDropdownByValue(WebElement dropdownElement, String value) {
		Select select = new Select(dropdownElement);
		select.selectByValue(value);
	}

	// Select an option from dropdown by index
	public void selectDropdownByIndex(WebElement dropdownElement, int index) {
		Select select = new Select(dropdownElement);
		select.selectByIndex(index);
	}

	// Scroll to an element
	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Scroll by pixel value
	public void scrollByPixels(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ");");
	}

	// Wait until title contains specific text
	public void waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(title));
	}

	// Wait for URL to contain specific text
	public void waitForUrlContains(WebDriver driver, String urlFragment) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains(urlFragment));
	}

	// Capture a screenshot and save to specified path
	public void captureScreenshot(WebDriver driver, String filePath) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Check if an element is displayed
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
