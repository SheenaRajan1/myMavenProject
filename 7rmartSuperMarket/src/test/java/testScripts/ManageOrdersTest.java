package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrdersPage;
import utilities.ExcelUtility;

public class ManageOrdersTest extends Base{
	
	
	@Test(retryAnalyzer=retry.Retry.class,description="verifyUserIsAbleToSearchAnOrderedItemAndAssignDeliveryBoy")
	public void verifyUserIsAbleToSearchAnOrderedItemAndAssignDeliveryBoy()
	{
		String inputUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String inputPassword = ExcelUtility.getString(1, 1, "LoginPage");
	    String inputOrderId=ExcelUtility.getString(1, 0, "ManagerOrderPage");
		String deliveryBoyName = ExcelUtility.getString(1, 1, "ManagerOrderPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(inputUsername, inputPassword);
		ManageOrdersPage managerorderspage=new ManageOrdersPage(driver);
		managerorderspage.clickOnManageOrderTile().searchButtonClickOnListOrders().enterOrderIdOnOrderIdField(inputOrderId).searchButtonClickOnMobileListOrders();
		managerorderspage.moveToElement().clickOnAssignDeliveryBoy().selectDeliveryBoyNameFromDropDownList(deliveryBoyName).updateButtonClick();
	    boolean isCurrentDeliveryStatusDisplayed=managerorderspage.verifyAlertAfterAssignDeliveryBoy();
		assertTrue(isCurrentDeliveryStatusDisplayed, "user is not able to search ordered item and assign a deliveryBoy");
		
	}


}
