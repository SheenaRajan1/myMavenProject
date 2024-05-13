package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageExpensePage {
WebDriver driver;
public PageUtility pageutility;
public FileUploadUtility fileuploadutility;
public WaitUtility waitutility;
			
			public ManageExpensePage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense' and text()='More info ']")private WebElement manageExpenseTile;
			@FindBy(xpath = "//i[contains(@class,'fas fa-bars')]//following::a[text()=' New']")private WebElement newButton;
			@FindBy(xpath = "//select[@name='user_id']") private WebElement userIdSelectField;
			@FindBy(xpath = "//select[@name='ex_cat']") private WebElement categorySelectField;
			@FindBy(xpath = "//select[@name='order_id']") private  WebElement orderIdSelectField;
			@FindBy(xpath = "//select[@name='purchase_id']") private WebElement purchaseIdSelectField;
			@FindBy(xpath = "//select[@name='ex_type']") private WebElement expenseTypeSelectField;
			@FindBy(xpath = "//input[@id='amount']") private WebElement amountInputField;
			@FindBy(xpath = "//textarea[@id='content']")private WebElement remarksInputField;
			@FindBy(xpath = "//input[@name='userfile']") private WebElement chooseFileButton;
			@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
			@FindBy(xpath = "//div[@class='col-sm-12']//child::div") private WebElement successfullAlert;
			
			public ManageExpensePage scrollToManageExpenseTileAndClick() {
				PageUtility pageutility=new PageUtility();
				pageutility.scrollToAnParticularAndClick(driver, manageExpenseTile);
				return this;
				}
			
			public ManageExpensePage clickOnNewButton() {
				PageUtility pageutility=new PageUtility();
				pageutility.scrollToAnParticularAndClick(driver, newButton);
				return this;
				}
				
			public ManageExpensePage selectAUserValueFromDropDown(String visibleTextOfUserId) {
				pageutility = new PageUtility();
				pageutility.selectByvisibleText(userIdSelectField, visibleTextOfUserId);
				return this;
			}
			
			public ManageExpensePage selectACategoryValueFromDropDown(String visibleTextOfCategory) {
				pageutility = new PageUtility();
				pageutility.selectByvisibleText(categorySelectField, visibleTextOfCategory);
				return this;
				}
			
			public ManageExpensePage selectAOrderIdValueFromDropDown(String visibleTextOfOrderId) {
				pageutility = new PageUtility();
				pageutility.selectByvisibleText(orderIdSelectField, visibleTextOfOrderId);
				return this;
				}
			
			public ManageExpensePage selectAPurchaseIdValueFromDropDown(String visibleTextOfPurchaseId) {
				pageutility = new PageUtility();
				pageutility.selectByvisibleText(purchaseIdSelectField, visibleTextOfPurchaseId);
				return this;
				}
			
			public ManageExpensePage selectExpenseTypeValueFromDropDown(String visibleTextOfExpenseType) {
				pageutility = new PageUtility();
				pageutility.selectByvisibleText(expenseTypeSelectField, visibleTextOfExpenseType);
				return this;
				}
			
			public ManageExpensePage enterAmountInTheAmountField(String amount) {
				amountInputField.sendKeys(amount);
				return this;
			}
			
			public ManageExpensePage enterRemarksInTheRemarksField(String remarks) {
				remarksInputField.sendKeys(remarks);
				return this;
			}
			
			public ManageExpensePage uploadFile() {
				FileUploadUtility fileuploadutility = new FileUploadUtility();
				fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileButton, Constants.MANAGECONTENT);
				return this;
			}

			public ManageExpensePage moveToSaveButton() {
				PageUtility pageutility=new PageUtility();
				pageutility.moveToElement(saveButton, driver);
				return this;
			}
			
			public ManageExpensePage clickOnSaveButton() {
				saveButton.click();
				return this;
				}
			
			public boolean isSuccessfullAlertDisplayed() {
				return successfullAlert.isDisplayed();
			}
			
	}
	


