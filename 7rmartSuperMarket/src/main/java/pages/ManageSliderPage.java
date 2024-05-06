package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageSliderPage {
public WebDriver driver;
public ManageSliderPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
       }
       
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider' and text()='More info ']") WebElement manageSliderTile;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']") WebElement newButton;
@FindBy(xpath = "//input[@type='file']") WebElement uploadButton;
@FindBy(xpath = "//input[@type='text']") WebElement linkTextField;
@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
@FindBy(xpath = "//div[@class='col-sm-12']") WebElement successfullAlert;
		
		public ManageSliderPage clickOnManageSliderTile() {
			manageSliderTile.click();
			return this;
		}

		public ManageSliderPage clickNewButtonOnListSliders() {
			newButton.click();
			return this;
		}

		public ManageSliderPage chooseImageButtonOnEnterSliderInformations() {
            FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(driver, uploadButton, Constants.MANAGECONTENT);
			return this;
		}

		public ManageSliderPage enterLinkOnLinkTextField(String linkText) {
			linkTextField.sendKeys(linkText);
			return this;
		}
		public ManageSliderPage scrollToElementAndWaitForElementToBeVisible() {
			PageUtility pageutilities = new PageUtility();
			pageutilities.scrollToaParticularElement(driver,saveButton);
		    WaitUtility waitUtility = new WaitUtility();	
			waitUtility.explicitWaitForElementToBevisible(driver, saveButton);
			return this;
		}
		public ManageSliderPage clickOnSaveButton() {
			saveButton.click();
			return this;
			}

		public boolean isSuccessfullAlertPopupDisplayed() {
			return successfullAlert.isDisplayed();
		}

	}



