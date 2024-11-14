package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.ReusableMethods;

public class HomePage {
	ReusableMethods re = new ReusableMethods();
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="b")
	WebElement product1;
	
	@FindBy(css=".toast-message")
	WebElement msge;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	@FindBy(css=".card-body button:last-of-type")
	WebElement cartbtn;
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement addcart;
	
	@FindBy(css="[routerlink*='myorder']")
	WebElement myorder;

	
	String ProductName = "IPHONE 13 PRO";
	
	
	
	public void getProductList(WebDriver driver) 
	{
		
		re.visiblityOfElement(driver, products);
		for (WebElement product : products) 
		{
			String productname = product.findElement(By.cssSelector(".card-body h5 b")).getText();
			System.out.println(productname);
			if (productname.equalsIgnoreCase(ProductName)) 
			{
				product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				re.ExplacitVisible(driver, msge);
				re.invisibleVisible(driver, animation);
			}
		}

	}
	
	public void goToCart(WebDriver driver)
	{
		addcart.click();
		//myorder.click();
	}
	

}
