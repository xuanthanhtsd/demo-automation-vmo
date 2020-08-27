package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Assertion;
import common.Report;
import common.Utils;


public class LoginPage {

	/**
	 * -------------- ELEMENTS ---------------------------
	 */
	WebDriver driver;
	CommonPage common;
	
	@FindBy(xpath = "//img[@class='logo']")
	WebElement imgLogo;
	
	@FindBy(xpath = "//input[@formcontrolname='username']")
	WebElement txtUserName;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//title")
	WebElement loginTitle;
	
	@FindBy(xpath = "//button[contains(@class, 'btn-login')]")
	WebElement btnLogin;
	
	@FindBy(xpath = "(//small)[1]")
	WebElement lblRequiredUser;
	
	@FindBy(xpath = "(//small)[2]")
	WebElement lblRequiredPass;
	
	@FindBy(xpath = "//p[contains(@class,'login-error')]")
	WebElement lblWrongUserOrPass;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		common = new CommonPage(driver);
	}
	
	
	/**
	 * -------------- ACTIONS ---------------------------
	 */
	
	public void goToLoginPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	//Set user name in textbox
	/**
	 * @param value: use to enter to user name field .
	 */
	public void enterUserName(String value){
		Utils.enterToElement(txtUserName, value);
		Utils.sleep(1);
		
	}
	
	/**
	 * @param value: use to enter to password field .
	 */
	public void enterPassword(String value){
		Utils.enterToElement(txtPassword, value);
		Utils.sleep(1);
	}
	
	/**
	 * Click on signin button.
	 */
	public void clickSignInButton(){
		btnLogin.click();
	}
	
	/**
	 * @return login screen title.
	 */
	public String getLoginTitle(){
		Utils.waitElementDisplayed(driver, txtUserName, 20);
		return	driver.getTitle();
	}
	/**
	 * Combine all of steps to login action. 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void login(String strUserName,String strPasword){
		//Fill user name
		this.enterUserName(strUserName);
		//Fill password
		this.enterPassword(strPasword);
		//Click Login button
		this.clickSignInButton();
				
	}
	
	/**
	 * @return Required user name message
	 */
	public String getRequiredUserName() {
		return lblRequiredUser.getText().trim();
	}
	
	/**
	 * @return required password message.
	 */
	public String getRequiredPassword() {
		return lblRequiredPass.getText().trim();
	}
	
	/**
	 * @return required password message.
	 */
	public String getWrongUserNameOrPasswordMessage() {
		return lblWrongUserOrPass.getText().trim();
	}
	
	/**
	 * -------------- VERIFY FUNCTIONS ---------------------------
	 */
	
	/**
	 * @param expected: Login title.
	 */
	public void verifyLoginScreen(String title) {
		Report.verify("Verify title is correct");
		verifyLoginScreenTitle(title);
		Report.verify("Verify Elements are displayed: logo, input fields, button.");
		Assertion.AssertTrue(Utils.isElementDisplayed(imgLogo), "Logo is not displayed!");
		Assertion.AssertTrue(Utils.isElementDisplayed(txtUserName), "User name field is not displayed!");
		Assertion.AssertTrue(Utils.isElementDisplayed(txtPassword), "Password field is not displayed!");
		Assertion.AssertTrue(Utils.isElementDisplayed(btnLogin), "login button is not displayed!");
	}
	
	/**
	 * @param expected: Login title.
	 */
	public void verifyLoginScreenTitle(String expected) {
		Utils.waitElementDisplayed(driver, btnLogin, 20);
		common.verifyTitle(expected);
	}
	
	/**
	 * @param expected: Required user name/Password message.
	 */
	public void verifyRequiredUserNameMessage(String expected) {
		Assertion.AssertEqual(getRequiredUserName(), expected, "Required user name/password message is not match!");
	}	
	
	/**
	 * @param expected: Required user name/Password message.
	 */
	public void verifyRequiredPasswordMessage(String expected) {
		Assertion.AssertEqual(getRequiredPassword(), expected, "Required user name/password message is not match!");
	}	
	
	/**
	 * @param expected: Required user name/Password message.
	 */
	public void verifyWrongUserNameOrPassword(String expected) {
		Assertion.AssertEqual(getWrongUserNameOrPasswordMessage(), expected, "User name or password is not match!");
	}	
	
	
}
