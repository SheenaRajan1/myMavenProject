package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePagesPage {
public WebDriver driver;
public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(text(), 'Manage Content')]/i[@class='fas fa-angle-left right']") private WebElement manageContent;
	@FindBy(xpath="//p[contains(text(), 'Manage Pages')]//parent::a")private WebElement managePages;
	@FindBy(xpath="//a[contains(text(), 'New') and @class='btn btn-rounded btn-danger']")private WebElement newButton;
	@FindBy(xpath="//input[@type='file' and @id='main_img']")private WebElement imageUploadButton;
	@FindBy(xpath="//input[@name='title']")private WebElement titleField;
	@FindBy(xpath="//input[@name='page']")private WebElement pageField;
	@FindBy(xpath="//button[@name='create']")private WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div")private WebElement pageCreatedSuccessfullyAlertPopup;


	public ManagePagesPage clickOnManageContent() {
		manageContent.click();
		return this;
	}
	
	public ManagePagesPage clickOnManagePages() {
		managePages.click();
		return this;
		}
		
	public ManagePagesPage clickOnTheNewButtonOnTheListPage() {
		newButton.click();
		return this;
	}
		
	public ManagePagesPage enterTitleOnTitleField(String title) {
		titleField.sendKeys(title);
		return this;
		}
	
	public ManagePagesPage enterPageNameOnPageField(String page) {
		pageField.sendKeys(page);
		return this;
		
	   }
	public ManagePagesPage clickOnChooseFileButton() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageUploadButton, Constants.MANAGECONTENT);
		return this;
	    }
	
	public ManagePagesPage moveToElement() {
		PageUtility pageutility=new PageUtility();
		pageutility.moveToElement(saveButton, driver);
		return this;
	}
	
	public ManagePagesPage waitForTheSaveButtonToBeVisible() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitForElementToBevisible(driver, imageUploadButton);
		return this;
	   }
	
	public ManagePagesPage clickOnSaveButton() {
		saveButton.click();
		return this;
	   }
	
	public boolean isPageCreatedSuccessfullyAlertPopupDisplayed() {
		return pageCreatedSuccessfullyAlertPopup.isDisplayed();
	}
	
}

	
	
	
	


