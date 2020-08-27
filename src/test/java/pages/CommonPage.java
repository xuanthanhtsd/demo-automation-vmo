package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Assertion;

public class CommonPage {

	WebDriver driver;
	@FindBy(xpath = "//img[@class='logo']")
	WebElement imgLogo;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Get the User name from Home Page
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * -------------- VERIFY FUNCTIONS ---------------------------
	 */

	public void verifyTitle(String expected) {
		Assertion.AssertEqual(getPageTitle(), expected, "Title not match");
	}

}
