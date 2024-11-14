package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.OrderConfirm;
import PageObjects.Payment;
import TestComponent.BaseTest;
import TestComponent.iRetryListener;

public class ErrorValidation extends BaseTest {

	@Test(groups = "errorhandling", retryAnalyzer=iRetryListener.class)
	public void LoginError() throws IOException {
		// Adding comments
		// Now you can call loginApplication on the land object
		land.loginApplication("spiderman@marvel.com", "Firstone@21122");
		Assert.assertEquals("Incorrect email or password.", land.error(driver));

	}

	@Test
	public void ProductError() throws IOException {

		// Now you can call loginApplication on the land object
		land.loginApplication("spiderman@marvel.com", "Firstone@1122");
		// Continue with the rest of the workflow
		HomePage ho = new HomePage(driver);
		ho.getProductList(driver);
		ho.goToCart(driver);
		CartPage cart = new CartPage(driver);
		cart.cartproduct(driver);
		Payment py = new Payment(driver);
		py.payments(driver);
		OrderConfirm order = new OrderConfirm(driver);
		order.meassage(driver);
	}
}
