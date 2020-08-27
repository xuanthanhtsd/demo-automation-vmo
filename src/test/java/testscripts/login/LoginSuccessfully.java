package testscripts.login;

import org.testng.annotations.Test;

import common.Const.Configurations;
import common.Const.Expectations;
import common.Const.Inputs;
import common.Report;
import pages.CommonPage;
import pages.HomePage;
import pages.LoginPage;
import testscripts.TestScriptBase;

public class LoginSuccessfully extends TestScriptBase {

	@Override
	public void setUp() {
		commonPage = new CommonPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * Verify login page title as 
	 */
	@Test(priority=0)
	public void verifyLoginSuccessfully(){
		
		Report.step("Step 1: Go to login page");
		loginPage.goToLoginPage(Configurations.PATH);

		Report.verify("Login screen is displayed");
		loginPage.verifyLoginScreen(Expectations.LOGIN_TITLE);
		
		Report.step("Step 2: Enter user name");
		loginPage.enterUserName(Inputs.USER_NAME);
		
		Report.step("Step 3: Enter password");
		loginPage.enterPassword(Inputs.PASSWORD);
		
		Report.step("Step 4: Click Signin button");
		loginPage.clickSignInButton();
		
		Report.verify("Verify home page title");
		homePage.verifyHomePageTitle(Expectations.HOME_PAGE_TITLE);
	}

	@Override
	public void cleanUp() {
		//Clean data
		//logout function
		
	}
	
	
}
