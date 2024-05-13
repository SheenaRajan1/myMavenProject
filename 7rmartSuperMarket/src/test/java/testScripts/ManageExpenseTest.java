package testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageExpensePage;
import utilities.ExcelUtility;

	public class ManageExpenseTest extends Base {

		@Test
		public void verifyUserIsAbleToAddNewAddExpense() throws InterruptedException {
			String userName=ExcelUtility.getString(1, 0, "LoginPage");
		    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
			String visibleTextOfUserId = ExcelUtility.getString(1, 0, "ManageExpense");
			String visibleTextOfCategory = ExcelUtility.getString(1, 1, "ManageExpense");
			String visibleTextOfOrderId=ExcelUtility.getString(1, 5, "ManageExpense");
			String visibleTextOfPurchaseId=ExcelUtility.getString(1, 6, "ManageExpense");
            String visibleTextOfExpenseType = ExcelUtility.getString(1, 2, "ManageExpense");
			String amount = ExcelUtility.getString(1, 7, "ManageExpense");
			String remarks = ExcelUtility.getString(1, 4, "ManageExpense");

			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
			ManageExpensePage manageexpensepage = new ManageExpensePage(driver);
			manageexpensepage.scrollToManageExpenseTileAndClick().clickOnNewButton().selectAUserValueFromDropDown(visibleTextOfUserId).selectACategoryValueFromDropDown(visibleTextOfCategory).selectAOrderIdValueFromDropDown(visibleTextOfOrderId);
			manageexpensepage.selectAPurchaseIdValueFromDropDown(visibleTextOfPurchaseId).selectExpenseTypeValueFromDropDown(visibleTextOfExpenseType).enterAmountInTheAmountField(amount).enterRemarksInTheRemarksField(remarks).uploadFile().moveToSaveButton().clickOnSaveButton();
            boolean isSuccessfullAlertDisplayed = manageexpensepage.isSuccessfullAlertDisplayed();
			assertTrue(isSuccessfullAlertDisplayed, "User is not able to add new add expense");	
		}

	}


