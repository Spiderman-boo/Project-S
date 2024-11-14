package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.ReusableMethods;

public class Payment {
	ReusableMethods re = new ReusableMethods();

	public Payment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement enterCountry;

	@FindBy(css = ".ta-results")
	WebElement list;

	@FindBy(xpath = "//body//app-root//button[2]")
	WebElement selectCountry;

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrder;

	public void payments(WebDriver driver) {
		enterCountry.sendKeys("india");
		re.ExplacitVisible(driver, enterCountry);
		re.elementclick(driver, selectCountry);
		selectCountry.click();
		placeOrder.click();

	}

}
