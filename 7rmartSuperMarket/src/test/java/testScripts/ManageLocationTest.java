package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;

import pages.ManageLocationPage;
import utilities.ExcelUtility;


public class ManageLocationTest extends Base {
	
	@Test
	public void verifyUserIsAbleToAddLocationAndDeleteThatLocation() {
		String userName=ExcelUtility.getString(1, 0, "LoginPage");
	    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
	    String countryName=ExcelUtility.getString(1, 0, "ManageLocation");
	    String stateName=ExcelUtility.getString(1, 1, "ManageLocation");
	    String locationField=ExcelUtility.getString(1, 2, "ManageLocation");
	    String deliveryCharge=ExcelUtility.getString(1, 3, "ManageLocation");
	    LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnmanageLocationTile().clickOnNewButton().selectCountryValueFromDropDown(countryName).selectStateValueFromDropDown(stateName).enterLocationInLocationInputField(locationField).enterChargeInDeliveryChargeField(deliveryCharge).clickOnSaveButton();
		boolean isSuccessfullAlertDisplayed = managelocationpage.isSuccessfullAlertDisplayed();
		assertTrue(isSuccessfullAlertDisplayed, "User is not able to add and delete that location");
		managelocationpage.moveTocancelButton().deleteTheAddedLocation();
		boolean isDeleteAlertDisplayed = managelocationpage.isSuccessfullAlertDisplayed();
		assertTrue(isDeleteAlertDisplayed, "User is not able to add and delete that location");
		
		
}
}
