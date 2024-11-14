package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.ReusableMethods;

public class CartPage {
	ReusableMethods re = new ReusableMethods();

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;

	String ProductName = "IPHONE 13 PRO";

	public void cartproduct(WebDriver driver) {
		for (WebElement product : cartProducts) {
			String productNameInCart = product.getText();
			if (productNameInCart.equalsIgnoreCase(ProductName)) {
				System.out.println("Product found in cart: " + productNameInCart);
				re.elementclick(driver, checkout);
				checkout.click();

			}
		}

	}

}
