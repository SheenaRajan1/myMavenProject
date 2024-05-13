package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	
	WebDriver driver;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and text()='More info ']")private WebElement manageDeliveryBoyTile;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-danger')]")private WebElement newButton;
	@FindBy(xpath = "//input[@name='name']")private WebElement nameField;
	@FindBy(xpath = "//input[@name='email']")private WebElement emailField;
	@FindBy(xpath = "//input[@name='phone']")private WebElement phoneField;
	@FindBy(xpath = "//textarea[@id='address']")private WebElement addressField;
	@FindBy(xpath = "//input[@name='username']")private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissible')]")private WebElement succesfullAlert;


public ManageDeliveryBoyPage clickOnManageDeliveryBoyTile() {
	manageDeliveryBoyTile.click();
	return this;
	}
public ManageDeliveryBoyPage clickTheNewButtonOnTheListDeiveryBoyPage() {
	newButton.click();
	return this;
}
public ManageDeliveryBoyPage enterNameOnNameField(String name) {
	nameField.sendKeys(name);
	return this;
}

public ManageDeliveryBoyPage enterEmailOnEmailField(String email) {
	emailField.sendKeys(email);
	return this;
}
public ManageDeliveryBoyPage enterThePhoneNumberOnPhoneNumberField(String number) {
	phoneField.sendKeys(number);
	return this;
}
public ManageDeliveryBoyPage enterTheAddressOnAddressField(String address) {
	addressField.sendKeys(address);
	return this;
}
public ManageDeliveryBoyPage enterTheUserNameOnUserNameField(String username) {
	userNameField.sendKeys(username);
	return this;
}
public ManageDeliveryBoyPage enterThePasswordOnPasswordField(String password) {
	passwordField.sendKeys(password);
	return this;
}

public ManageDeliveryBoyPage clickOnSaveButton() {
	PageUtility pageutility=new PageUtility();
	pageutility.scrollToAnParticularAndClick(driver, saveButton);
	return this;
	
}
public boolean isSuccessfullAlertDisplayed() {
	return succesfullAlert.isDisplayed();
}


}