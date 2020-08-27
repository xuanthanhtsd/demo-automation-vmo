package testscripts.login;

import org.testng.annotations.Test;

import common.Const.Configurations;
import common.Const.Expectations;
import common.Const.Inputs;
import common.Report;
import common.Utils;
import pages.CommonPage;
import pages.HomePage;
import pages.LoginPage;
import testscripts.TestScriptBase;

public class LoginUnSuccessfully extends TestScriptBase {

	CommonPage commonPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Override
	public void setUp() {
		commonPage = new CommonPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * Verify login with blank data.
	 */
	@Test(priority=0)
	public void verifyLoginWithBlankData(){
		
		Report.step("Step 1: Go to login page");
		loginPage.goToLoginPage(Configurations.PATH);

		Report.verify("Login screen is displayed");
		loginPage.verifyLoginScreen(Expectations.LOGIN_TITLE);
		
		Report.step("Step 2: Enter blank user name");
		loginPage.enterUserName(Inputs.BLANK_VALUE);
		
		Report.step("Step 3: Enter blank password");
		loginPage.enterPassword(Inputs.BLANK_VALUE);
		
		Report.step("Step 4: Click Signin button");
		loginPage.clickSignInButton();
		Utils.sleep(2);
		
		Report.verify("Verify required user name message");
		loginPage.verifyRequiredUserNameMessage(Expectations.REQUIRED_USER_NAME);
		
		Report.verify("Verify required password message");
		loginPage.verifyRequiredPasswordMessage(Expectations.REQUIRED_PASSWORD);
	}
	

	/**
	 * Verify login page with wrong user name or password.
	 */
	@Test(priority=1)
	public void verifyWrongUserNameOrPassword(){
		
		Report.step("Step 1: Go to login page");
		loginPage.goToLoginPage(Configurations.PATH);

		Report.verify("Login screen is displayed");
		loginPage.verifyLoginScreen(Expectations.LOGIN_TITLE);
		
		Report.step("Step 2: Enter wrong user name");
		loginPage.enterUserName(Inputs.WRONG_USER_PASS);
		
		Report.step("Step 3: Enter wrong password");
		loginPage.enterPassword(Inputs.WRONG_USER_PASS);
		
		Report.step("Step 4: Click Signin button");
		loginPage.clickSignInButton();
		Utils.sleep(2);
		
		Report.verify("Verify required user name message");
		loginPage.verifyWrongUserNameOrPassword(Expectations.WRONG_USER_PASS);
	}
	

	/**
	 * Verify login page with special characters into user name or password.
	 */
	@Test(priority=2)
	public void verifyLoginWithSpecialCharacters(){
		
		Report.step("Step 1: Go to login page");
		loginPage.goToLoginPage(Configurations.PATH);
		
		Report.verify("Login screen is displayed");
		loginPage.verifyLoginScreen(Expectations.LOGIN_TITLE);
		
		Report.step("Step 2: Enter special characters into user name field");
		loginPage.enterUserName(Inputs.SPECIAL_CHARACTER);
		
		Report.step("Step 3: Enter special characters into password field");
		loginPage.enterPassword(Inputs.SPECIAL_CHARACTER);
		
		Report.step("Step 4: Click Signin button");
		loginPage.clickSignInButton();
		Utils.sleep(2);
		
		Report.verify("Verify required user name message");
		loginPage.verifyWrongUserNameOrPassword(Expectations.WRONG_USER_PASS);
	}

	@Override
	public void cleanUp() {
		
	}


	
}
