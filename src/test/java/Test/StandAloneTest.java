package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String username = "spiderman@marvel.com";
		String password = "Firstone@1122";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");

		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		for (WebElement product : products) {
			String productname = product.findElement(By.cssSelector(".card-body h5 b")).getText();
			System.out.println(productname);

			//product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		// cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		// Checkout Button
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		// Payment method
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

		String ConfirmMeassage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(ConfirmMeassage.equalsIgnoreCase("Thankyou for the order."));

	}

}
