package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	
public WebDriver driver;
public PageUtility pageUtility;
	
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and text()='More info ']")private WebElement manageLocationTile;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") private WebElement countrySelectField;
	@FindBy(xpath = "//select[@id='st_id']") private WebElement stateSelectField;
	@FindBy(xpath = "//input[@id='location']") private WebElement locationInputField;
	@FindBy(xpath = "//input[@id='delivery']") private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@type='submit']")  private WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div") private WebElement alertCreatedSuccesfully;
	@FindBy(xpath = "//a[contains(@class,'btn btn-default btn-fix')]") private WebElement cancelButton;
	@FindBy(xpath = "//*[@class='table table-bordered table-hover table-sm']/tbody/tr[1]//*[contains(@href,'delete')]") private WebElement deleteButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissible')]") private WebElement deleteAlert;
	
	public ManageLocationPage clickOnmanageLocationTile() {
		manageLocationTile.click();
		return this;
		}
	public ManageLocationPage clickOnNewButton() {
		newButton.click();
		return this;
		}
	public ManageLocationPage selectCountryValueFromDropDown(String countryName) {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByvisibleText(countrySelectField, countryName);
		return this;
			}
    public ManageLocationPage selectStateValueFromDropDown(String stateName) {
    	PageUtility pageutility = new PageUtility();
		pageutility.selectByvisibleText(stateSelectField, stateName);
		return this;
		}
	
	public ManageLocationPage enterLocationInLocationInputField(String location) {
		locationInputField.sendKeys(location);
		return this;
	}
	
	public ManageLocationPage enterChargeInDeliveryChargeField(String deliveryCharge) {
		deliveryChargeField.sendKeys(deliveryCharge);
		return this;
	}
	public ManageLocationPage clickOnSaveButton( ) {
		saveButton.click();
		return this;
	}
	
	public boolean isSuccessfullAlertDisplayed() {
		return alertCreatedSuccesfully.isDisplayed();
	}

	public ManageLocationPage moveTocancelButton() {
		PageUtility pageutility=new PageUtility();
		pageutility.moveToElement(cancelButton, driver);
		cancelButton.click();
		return this;
		}
	public ManageLocationPage deleteTheAddedLocation() {
		deleteButton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.acceptAlert(driver);
		return this;
	}

	public boolean isDeleteAlertDisplayed() {
		return deleteAlert.isDisplayed();
	}

}


