package testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.ManagePagesPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ManagePagesTest extends Base {
	
	@Test
	public void verifyUserIsAbleToAddPages()  {
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		String titleField = ExcelUtility.getString(1, 0,"ManagePages" );
		String pageField = ExcelUtility.getString(1, 1,"ManagePages" );
        LoginPage loginPage = new LoginPage(driver);
		loginPage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(username, password);
		ManagePagesPage managePagesPage = new ManagePagesPage(driver);
		managePagesPage.clickOnManageContent().clickOnManagePages().clickOnTheNewButtonOnTheListPage().enterTitleOnTitleField(titleField).enterPageNameOnPageField(pageField).clickOnChooseFileButton().moveToElement();
		managePagesPage.waitForTheSaveButtonToBeVisible().clickOnSaveButton();
		boolean isPageCreatedSuccessfullyAlertPopupDisplayed = managePagesPage.isPageCreatedSuccessfullyAlertPopupDisplayed();
		assertTrue(isPageCreatedSuccessfullyAlertPopupDisplayed, "User is not able to add Pages");
		
		}

}



