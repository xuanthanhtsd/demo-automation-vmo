package testscripts;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import common.Logger;
import common.WebDriverManager;
import pages.CommonPage;
import pages.HomePage;
import pages.LoginPage;


public abstract class TestScriptBase {
	
	public WebDriver driver;
	protected CommonPage commonPage;
	protected LoginPage loginPage;
	protected HomePage homePage;
	public WebDriverManager manager = new WebDriverManager();
	@BeforeTest
	@Parameters({"browser"})
	public void initialize(@Optional("") String browser) {
		driver = manager.initDriver(browser);
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
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
	public abstract void setUp();
	
	public abstract void cleanUp();
	
		
	}
	
	
