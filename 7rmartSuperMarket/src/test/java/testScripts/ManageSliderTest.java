package testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.ExcelUtility;

	public class ManageSliderTest extends Base{
		
		@Test(retryAnalyzer=retry.Retry.class,description="verifyThatUserIsAbleToAddSlider")
		public void verifyThatUserIsAbleToAddSlider() {
			
			String userName=ExcelUtility.getString(1, 0, "LoginPage");
		    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
		    String linkText=ExcelUtility.getString(1, 0, "ManageSlider");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
			ManageSliderPage managesliderpage = new ManageSliderPage(driver);
            managesliderpage.clickOnManageSliderTile().clickNewButtonOnListSliders().chooseImageButtonOnEnterSliderInformations();
            managesliderpage.enterLinkOnLinkTextField(linkText).scrollToElementAndWaitForElementToBeVisible().clickOnSaveButton();
		    boolean isSuccessfullAlertisplayed = managesliderpage.isSuccessfullAlertPopupDisplayed();
			assertTrue(isSuccessfullAlertisplayed, "User is unable to add slider");	
		}

	}



