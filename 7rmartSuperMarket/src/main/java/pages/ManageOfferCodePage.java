package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOfferCodePage {
	WebDriver driver;

	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']")private WebElement manageOfferCodeTile;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-danger')]")private WebElement newButton;
	@FindBy(xpath = "//input[@name='offer_code']")private WebElement offerCodeTextField;
	@FindBy(xpath = "//input[@value='yes']")private WebElement radioButton;
	@FindBy(xpath = "//input[@value='yes']")private WebElement percentageField;
	@FindBy(xpath = "//input[@placeholder='Amount']")private WebElement amountField;
	@FindBy(xpath = "//div[@role='textbox']")private WebElement descriptionField;
	@FindBy(xpath = "//input[@name='main_img']")private WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']")private WebElement saveButton;
	@FindBy(xpath = "//i[contains(@class,'icon fas fa-check')]")private WebElement alert;
	@FindBy(xpath = "//li[contains(@class,'breadcrumb-item active')]")private WebElement cancelButton;
	@FindBy(xpath = "//div[contains(@class,'card-body table-responsive p-0')]")private WebElement table;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-primary')]")private WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Offer Code']")private WebElement offerCodeField;
	@FindBy(xpath = "//input[@placeholder='Offer Code']")private WebElement searchButtonOnSearchListOffercodes;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/edit?edit=450&page_ad=1']")private WebElement editButton;
	@FindBy(xpath = "//button[@name='update']")private WebElement updateButton;
	@FindBy(xpath = "//button[@name='update']")private WebElement alertAfterUpdate;
	
	public ManageOfferCodePage clickOnManageOfferCodeTile() {
		manageOfferCodeTile.click();
		return this;
		}
	public ManageOfferCodePage clickOnNewButton() {
		newButton.click();
		return this;
	    }
	public ManageOfferCodePage enterValueOnMobileOfferCodeField(String offerCode) {
		offerCodeTextField.sendKeys(offerCode);
		return this;
		}
	public ManageOfferCodePage clickOnRadioButton() {
		radioButton.click();
		return this;
	}
	public ManageOfferCodePage scrollToBottom() {
		PageUtility pageutility=new PageUtility();
		pageutility.scrollByDownwardDirection(driver);
		return this;
	}

	public ManageOfferCodePage moveToElement() {
		PageUtility pageutility=new PageUtility();
		pageutility.moveToElement(updateButton, driver);
		return this;
	}
	
	public ManageOfferCodePage clickOnChooseFileButton() {
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, Constants.OFFERCODE);
		return this;
		}

	public ManageOfferCodePage waitForElementToBePresent() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitForElementToBeClickable(driver,saveButton);
		return this;
	}
	
	public ManageOfferCodePage clickOnSaveButton() {
		saveButton.click();
		return this;
		}
	
	public boolean verifyAlertMessage() {
		boolean alertTextIsDisplayed = alert.isDisplayed();
        return alertTextIsDisplayed;
		
	}
	public ManageOfferCodePage ClickOnTheSearchButtonOnTheListofferCodes() {
		searchButton.click();
		return this;
		}
	public ManageOfferCodePage enterOfferCodeValueForSearch(String searchValue) {
		offerCodeField.sendKeys(searchValue);
		return this;
	}
	public ManageOfferCodePage clickOnSearchAfterEnterSearchValue() {
		searchButtonOnSearchListOffercodes.click();
		return this;
		
	}
	public ManageOfferCodePage scrollToElementAndClick() {
		   PageUtility pageutility = new PageUtility();
		   pageutility.scrollToElementAndClick(driver);	
		   return this;
	        }
	public ManageOfferCodePage clickOnEditButton() {
		editButton.click();
		return this;
		}
	public ManageOfferCodePage enterValueOnMobileOfferCodeFieldForEdit(String editOfferCodeValue) {
		offerCodeTextField.sendKeys(editOfferCodeValue);
		return this;
		}
	public ManageOfferCodePage updateButton() {
		updateButton.click();
		return this;
		}
	public boolean alertTextDisplayedAfterUpdate() {
		boolean alertTextIsDisplayedAfterUpdate=alertAfterUpdate.isDisplayed();
		return alertTextIsDisplayedAfterUpdate;
	}
	
	
	
	
}
