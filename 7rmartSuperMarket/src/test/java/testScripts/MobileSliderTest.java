package testScripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.Constants;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base {
	
	 @Test(retryAnalyzer=retry.Retry.class,description="verifyUserIsAbleToAddMobileSliderPage")
	   public void verifyUserIsAbleToAddMobileSliderPage() throws AWTException {
		    String userName=ExcelUtility.getString(1, 0, "LoginPage");
		    String passWord=ExcelUtility.getString(1, 1, "LoginPage");
		    String uploadImage=Constants.IMAGEPATHONMOBILESLIDER;
		    LoginPage loginpage = new LoginPage(driver);
			loginpage.enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(userName, passWord);
			MobileSliderPage mobilesliderpage=new MobileSliderPage(driver);
			mobilesliderpage.clickOnTheMobileSliderTileOnTheDashboard().ClickTheNewButtonOnTheListMobileSliderPage().selectACategoryValueFromDropDown().clickOnChooseFileButton(uploadImage).clickOnSaveButtonOnTheListMobileSliderPage();
		    boolean alertTextIsDisplayed=mobilesliderpage.verifyAlertMessageAfterEnteringTheDetailsOnTheMobileSliderPage();
			assertTrue (alertTextIsDisplayed,"User is not able to add mobile slider page");
		    }
	 

	
}
