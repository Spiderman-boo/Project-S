package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.OrderConfirm;
import PageObjects.Payment;
import TestComponent.BaseTest;

public class FrameW extends BaseTest {

	@Test
	public void FrameW() throws IOException {

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
