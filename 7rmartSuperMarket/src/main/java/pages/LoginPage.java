package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")private WebElement passWordField;
	@FindBy(xpath = "//button[text()='Sign In']")private WebElement signInButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")private WebElement alertTextWhileClickOnSignInButton;
	@FindBy(xpath = "//p[text()='Manage Pages']//parent::div")private WebElement managePagesText;
	
	
	public void enterTheUserNameOnUserNameFieldAndEnterThePasswordOnPasswordFieldAndClickOnSignInButton(String userName,String passWord){
	userNameField.sendKeys(userName);
	passWordField.sendKeys(passWord);
	signInButton.click();
    }
	
	public boolean recievedAlertWhileClickOnSignInButton() {
	boolean alertRecivedWhileClickOnSignInButton=alertTextWhileClickOnSignInButton.isDisplayed();
	return alertRecivedWhileClickOnSignInButton;
	}
	
    public boolean verifyUserIsAbleToNavigateOnDashBoard() {
    boolean managePagesTextIsDisplayed = managePagesText.isDisplayed();
	return managePagesTextIsDisplayed;
    }

}
