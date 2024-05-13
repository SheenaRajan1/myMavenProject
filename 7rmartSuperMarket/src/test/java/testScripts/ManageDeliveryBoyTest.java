package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
	
	
	@Test
	public void verifyUserIsAbleToAddADeliveryBoyDetails() {
		String userName=ExcelUtility.getString(1, 0, "LoginPage");
	    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
	    String name = ExcelUtility.getString(1, 0, "ManageDeliveryBoy");
	    String email = ExcelUtility.getString(1, 1, "ManageDeliveryBoy");
	    String phoneNumber = ExcelUtility.getString(1, 2, "ManageDeliveryBoy");
	    String address = ExcelUtility.getString(1, 3, "ManageDeliveryBoy");
	    String username = ExcelUtility.getString(1, 4, "ManageDeliveryBoy");
	    String password = ExcelUtility.getString(1, 5, "ManageDeliveryBoy");
	    LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		ManageDeliveryBoyPage managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickOnManageDeliveryBoyTile().clickTheNewButtonOnTheListDeiveryBoyPage().enterNameOnNameField(name).enterEmailOnEmailField(email).enterThePhoneNumberOnPhoneNumberField(phoneNumber).enterTheAddressOnAddressField(address).enterTheUserNameOnUserNameField(username);
		managedeliveryboypage.enterThePasswordOnPasswordField(password).clickOnSaveButton();
		boolean isSuccessfullAlertDisplayed = managedeliveryboypage.isSuccessfullAlertDisplayed();
		assertTrue(isSuccessfullAlertDisplayed, "User is not able to delivery boy details");	
		
		
	}

}
