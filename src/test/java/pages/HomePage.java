package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Utils;

public class HomePage {

	WebDriver driver;
	CommonPage common; 
	
	@FindBy(xpath = "//img[@class='logo']")
	WebElement imgLogo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		common = new CommonPage(driver);
	}

	// Get the User name from Home Page
	public String getHomePageTitle() {
		Utils.waitElementDisplayed(driver, imgLogo, 20);
		return driver.getTitle();
	}

	/**
	 * -------------- VERIFY FUNCTIONS ---------------------------
	 */

	public void verifyHomePageTitle(String expected) {
		Utils.waitElementDisplayed(driver, imgLogo, 50);
		common.verifyTitle(expected);
	}

}
