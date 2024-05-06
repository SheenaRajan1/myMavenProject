package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageOrdersPage {
WebDriver driver;
public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']") private WebElement manageOrderTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchMenuButton;
	@FindBy(xpath="//input[@id='od']") private WebElement orderIdField;
	@FindBy(xpath="//*[text()=' Search']") private WebElement searchButton;
	@FindBy(xpath="//button[@name='Search']") private WebElement searchButtonOnSearchListOrders;
	@FindBy(xpath="//*[text()='Assign Delivery Boy']") private WebElement assignDeliveryBoy;
	@FindBy(xpath="//select[@id='delivery_boy_id']") private WebElement assignDeliveryBoyDropDown;
	@FindBy(xpath="//button[@name='assign_del']") private WebElement updateButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]") private WebElement alertText;
	
	public ManageOrdersPage clickOnManageOrderTile()
	{
    	manageOrderTile.click();
    	return this;
		}
	public ManageOrdersPage searchMenuButtonClick()
	{
		searchMenuButton.click();
		return this;
	}
	
	public ManageOrdersPage enterOrderIdOnOrderIdField(String Orderid) {
		orderIdField.sendKeys(Orderid);
		return this;
	}
   public ManageOrdersPage searchButtonClickOnListOrders()
   {
	   searchButton.click();
	   return this;
   }
   public ManageOrdersPage searchButtonClickOnMobileListOrders()
   {
	   searchButtonOnSearchListOrders.click();
	   return this;
   }
   
   public ManageOrdersPage scrollToElementAndClick() {
	   PageUtility pageutility = new PageUtility();
	   pageutility.scrollToElementAndClick(driver);	 
	   return this;
        }
   public ManageOrdersPage moveToElement() {
		PageUtility pageutility=new PageUtility();
		pageutility.moveToElement(assignDeliveryBoy, driver);
		return this;
	}
	  
   public ManageOrdersPage clickOnAssignDeliveryBoy() {
	   assignDeliveryBoy.click();
	   return this;
   }
  
   public ManageOrdersPage selectDeliveryBoyNameFromDropDownList(String deliveryBoyName)
	{
		PageUtility pageutility = new PageUtility();
		pageutility.selectByvisibleText(assignDeliveryBoyDropDown, deliveryBoyName);
		return this;
	
	}
   public ManageOrdersPage updateButtonClick()
   {
	   updateButton.click();
	   return this;
   }
   
   public boolean verifyAlertAfterAssignDeliveryBoy() {
	  return alertText.isDisplayed();
	}



}
