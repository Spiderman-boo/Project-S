package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage land;

	public WebDriver initializeDrivers() throws IOException {
		// Properties class
		Properties po = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/Resources/GlobalData.properties");
		po.load(fis);
		String browsername = po.getProperty("browser");

		switch (browsername.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser type not supported");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDrivers();
		land = new LandingPage(driver);
		land.GoTo(driver);
		return land; // Returning the instance of LandingPage
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}

	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destin = new File(System.getProperty("user.dir") + "/reports/" + testcasename + ".png");
		FileUtils.copyFile(source, destin);
		return System.getProperty("user.dir") + "/reports/" + testcasename + ".png";
	}
}
