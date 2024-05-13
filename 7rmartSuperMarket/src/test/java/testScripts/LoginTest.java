package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(groups= {"Regression"})

	public void verifyWheatherTheUserIsAbleToLoginWithValidUserNameAndValidPassword() {
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String passWord = ExcelUtility.getString(1, 1, "LoginPage");
        LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		Boolean manageTileRecieved = loginpage.verifyUserIsAbleToNavigateOnDashBoard();
        assertTrue (manageTileRecieved,"User is not able to login with valid username and valid password");
	}
	@Test(groups= {"Regression"})
	public void verifyWheatherTheUserIsAbleToLoginWithInValidUserNameAndInValidPassword() {
		String userName = ExcelUtility.getString(2, 0, "LoginPage");
		String passWord = ExcelUtility.getString(2, 1, "LoginPage");
        LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		boolean alertTextIsDisplayed=loginpage.recievedAlertWhileClickOnSignInButton();
		assertTrue (alertTextIsDisplayed,"User is able to login with Invalid username and Invalid password");
	}
	@Test(groups= {"Smoke"})
	public void verifyWheatherTheUserIsAbleToLoginWithInValidUserNameAndValidPassword() {
		String userName = ExcelUtility.getString(3, 0, "LoginPage");
		String passWord = ExcelUtility.getString(3, 1, "LoginPage");
        LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		boolean alertTextIsDisplayed=loginpage.recievedAlertWhileClickOnSignInButton();
		assertTrue (alertTextIsDisplayed,"User is able to login with Invalid username and valid password");
	}
	@Test(groups= {"login"})
	public void verifyWheatherTheUserIsAbleToLoginWithValidUserNameAndInValidPassword() {
		String userName = ExcelUtility.getString(4, 0, "LoginPage");
		String passWord = ExcelUtility.getString(4, 1, "LoginPage");
        LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		boolean alertTextIsDisplayed=loginpage.recievedAlertWhileClickOnSignInButton();
		assertTrue (alertTextIsDisplayed,"User is able to login with valid username and Invalid password");
	}

}
