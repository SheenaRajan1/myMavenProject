package testScripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base{
	@Test
	
	public void verifyUserIsAbleToAddOfferCodePage() throws AWTException{
	    String userName=ExcelUtility.getString(1, 0, "LoginPage");
	    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
	    String offerCodeField = ExcelUtility.getString(1, 0,"ManageOfferCode" );
	    LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		ManageOfferCodePage manageoffercodePage=new ManageOfferCodePage(driver);
		manageoffercodePage.clickOnManageOfferCodeTile().clickOnNewButton().enterValueOnMobileOfferCodeField(offerCodeField).clickOnRadioButton().scrollToBottom();
		manageoffercodePage.clickOnChooseFileButton().waitForElementToBePresent().clickOnSaveButton();
	    boolean alertTextIsDisplayed=manageoffercodePage.verifyAlertMessage();
		assertTrue (alertTextIsDisplayed,"User is not able to add OfferCodePage");
		}
	
	@Test
	
	public void verifyUserIsAbleToSearchAndEditTheOfferCode() {
		String userName=ExcelUtility.getString(1, 0, "LoginPage");
	    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
	    String searchValue = ExcelUtility.getString(1, 1,"ManageOfferCode" );
	    String editOfferCodeValue = ExcelUtility.getString(1, 2,"ManageOfferCode" );
	    LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
		ManageOfferCodePage manageoffercodePage=new ManageOfferCodePage(driver);
		manageoffercodePage.clickOnManageOfferCodeTile().ClickOnTheSearchButtonOnTheListofferCodes().enterOfferCodeValueForSearch(searchValue).clickOnSearchAfterEnterSearchValue();
		manageoffercodePage.scrollToBottom().clickOnEditButton().enterValueOnMobileOfferCodeFieldForEdit(editOfferCodeValue).clickOnRadioButton().moveToElement();
		manageoffercodePage.updateButton().verifyAlertMessage();
        boolean alertTextIsDisplayed=manageoffercodePage.verifyAlertMessage();
		assertTrue (alertTextIsDisplayed,"User is not able to search and edit the offercode");

	}

}
