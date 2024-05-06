package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class MobileSliderPage  {
	
 WebDriver driver;

	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']")private WebElement mobileSliderTile;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-danger')]")private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")private WebElement dropDownValue;
	@FindBy(xpath = "//input[@id='main_img']")private WebElement clickOnChooseFile;
	@FindBy(xpath = "//input[@id='main_img']")private WebElement verifyTextAfterChooseFile;
	@FindBy(xpath = "//button[@name='create']")private WebElement SaveButton;
	@FindBy(xpath = "//a[contains(@class,'btn btn-default btn-fix')]")private WebElement clickOnCancelButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissible')]")private WebElement alertText;
	@FindBy(xpath = "//li[contains(@class,'breadcrumb-item active')]")private WebElement listMobileSlidersText;
	
	
	public MobileSliderPage clickOnTheMobileSliderTileOnTheDashboard() {
		 mobileSliderTile.click();
		 return this;
		}
	
	public MobileSliderPage ClickTheNewButtonOnTheListMobileSliderPage() {
		newButton.click();
		return this;
	    }
	
    public MobileSliderPage selectACategoryValueFromDropDown() {
    	dropDownValue.click();
    	PageUtility pageutility=new PageUtility();
    	pageutility.selectDropdownValue(dropDownValue, ExcelUtility.getString(1, 0, "MobileSliderPage"));
    	return this;
        }
    
     public MobileSliderPage clickOnChooseFileButton(String clickOnChooseFile) throws AWTException {
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingRobotClass(clickOnChooseFile);
		return this;
		}
     
    public MobileSliderPage clickOnSaveButtonOnTheListMobileSliderPage() {
    	SaveButton.click();
    	return this;
        }
    
    public boolean verifyAlertMessageAfterEnteringTheDetailsOnTheMobileSliderPage() {
    	boolean alertTextIsDisplayed = clickOnChooseFile.isDisplayed();
        return alertTextIsDisplayed;
    }
    	
  
    
    	
   
}
