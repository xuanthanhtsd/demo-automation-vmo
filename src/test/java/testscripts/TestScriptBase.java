package testscripts;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import common.Const.Configurations;
import common.Logger;
import pages.CommonPage;
import pages.HomePage;
import pages.LoginPage;

public abstract class TestScriptBase {
	
	public WebDriver driver;
	protected CommonPage commonPage;
	protected LoginPage loginPage;
	protected HomePage homePage;
	
	@BeforeSuite
	public void beforeSuite() {
		
	}
	
	@BeforeClass
	public void initialize() {
		this.initDriver();
		this.setUp();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		Logger.start(method.getName());
	}
	
	@AfterMethod
	public void afterMethod() {
		Logger.drawLine();
	}
	
	@AfterTest
	public void dispose() {
		this.cleanUp();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
	public abstract void setUp();
	
	public abstract void cleanUp();
	

	private void initDriver() {
		switch (Configurations.browser) {
		case CHROME:
			this.initChrome();
			break;
		case FIREFOX:
			this.initFireFox();
			break;
		default:
			break;
		}
		
	}
	
	private void initChrome() {
		System.setProperty("webdriver.chrome.driver", Configurations.CHROME_PATH);
		ChromeOptions options = new ChromeOptions();
		if (Configurations.HEADLESS) {
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
		}
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private void initFireFox() {
		System.setProperty("webdriver.gecko.driver", Configurations.FIREFOX_PATH);
		FirefoxOptions options = new FirefoxOptions();
		if (Configurations.HEADLESS) {
			options.addArguments("-headless");
			options.addArguments("window-size=1200x600");
		}
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
