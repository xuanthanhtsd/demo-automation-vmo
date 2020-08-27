package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	//--------General functions------------------
	/**
	 * Sleep.
	 * @param second
	 */
	public static void sleep(int second) {
		try {
			int mlSecond = second * 1000;
			Thread.sleep(mlSecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//----------Web element functions---------
	
	public static void waitElementDisplayed(WebDriver driver, WebElement element, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.visibilityOf(element));
		sleep(2);
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public static void enterToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
}
