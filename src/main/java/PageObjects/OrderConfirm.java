package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirm {
	
	public OrderConfirm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirm;
	
	public void meassage(WebDriver driver)
	{
		System.out.println(confirm.getText());
	}

}
