package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.ReusableMethods;

public class LandingPage  {
	ReusableMethods re= new ReusableMethods();

	// WebDriver driver;

	public LandingPage(WebDriver driver) {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void GoTo(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	// driver.findElement(By.id("userEmail")).sendKeys(username);
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwd;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsge;
	

	public String error(WebDriver driver)
	{
		re.ExplacitVisible(driver, errormsge);
		return errormsge.getText();
	}
	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwd.sendKeys(password);
		submit.click();

	}

}
