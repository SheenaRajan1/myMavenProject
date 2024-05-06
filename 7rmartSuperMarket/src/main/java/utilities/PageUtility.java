package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	
	public void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
		}
	
    public void mouseOverOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		}
		
	public void rightClickOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		}
	
	public void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		}

	public void doubleClickOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	    }
	
	public void dragAndDrop(WebElement element,WebElement element1, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element,element1 ).perform();
		}
	
	public void selectValue(WebElement element, String dropDownValue) {
		Select select = new Select(element);
		select.selectByValue(dropDownValue);
		}
	
	public void selectDropdownValue(WebElement dropDown,String dropDownvalue) {
		Select selectsingledropdowntext=new Select(dropDown);
		selectsingledropdowntext.selectByVisibleText(dropDownvalue);
	}
	
	public void selectByvisibleText(WebElement element,String dropDownValue) {
		Select select = new Select(element);
		select.selectByVisibleText(dropDownValue);
		}
	
	public void selectValueByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		}
	
	public void fileUpload() throws AWTException {
		StringSelection stringSelection = new StringSelection("File Path");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
	    robot.delay(250);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	public void scrollByDownwardDirection(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		}
	
	public void scrollByUpWardDirection(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		}
	
	public void scrollToaParticularElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		}
	
	public void scrollToAnParticularAndClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		}
	
	public void scrollToElementAndClick(WebDriver driver) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 }
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void getTextUsingAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public void sendKeysUsingAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	}
		
	
		  
	
	
	
	
	
	
