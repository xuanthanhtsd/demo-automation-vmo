package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.Const.Configurations;

public class WebDriverManager {
	private DesiredCapabilities capabillities;
	private WebDriver driver;
	String browserName;
	FirefoxOptions firefoxOptions;
	ChromeOptions chromeOptions;

	/**
	 * @return web driver.
	 */
	public WebDriver initDriver(String browser) {
		browserName = browser;
		try {
			initializeGrid();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	// Initialize selenium grid.
	private void initializeGrid() throws MalformedURLException {
		System.out.println("Grid hub: " + Configurations.GRID_HUB);
		switch (browserName) {
		case "chrome":
			Logger.log("Initialize chrome");
			capabillities = DesiredCapabilities.chrome();
			break;
		case "firefox":
			Logger.log("Initialize firefox");
			capabillities = DesiredCapabilities.firefox();

			break;
		default:
			Report.error("The browser parameter is not correct.");
			break;
		}
		driver = new RemoteWebDriver(new URL(Configurations.GRID_HUB), capabillities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
