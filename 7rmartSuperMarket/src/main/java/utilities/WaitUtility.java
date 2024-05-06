package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		}
	
	public void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public void explicitWaitForElementToBeClickable(WebDriver driver,WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
		}
	public void explicitWaitForElementToBePresent(WebDriver driver,WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, null));
		}
	public void explicitWaitForElementToBevisible(WebDriver driver,WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		System.out.print("2");
		wait.until(ExpectedConditions.visibilityOf(target));
		System.out.print("3");
		}
	public void waitForTitleContains(String text,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.titleContains(text));
        }
	public void waitForAlertToBePresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.alertIsPresent());
	   }
	
	public void fluentWait(WebDriver driver,WebElement target){
		     Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(EXPLICIT_WAIT))
			.pollingEvery(Duration.ofSeconds(EXPLICIT_WAIT))
			.ignoring(NoSuchElementException.class);
		     fluentWait.until(ExpectedConditions.visibilityOf(target));
	}
	public void fluentWaitForElementToBeClickable(WebDriver driver,WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(EXPLICIT_WAIT))
				.pollingEvery(Duration.ofSeconds(EXPLICIT_WAIT))
				.ignoring(NoSuchElementException.class);
			     fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	
	}
	public void fluentWaitForElementToBePresent(WebDriver driver,WebElement target,String locateXpath) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(EXPLICIT_WAIT))
				.pollingEvery(Duration.ofSeconds(EXPLICIT_WAIT))
				.ignoring(NoSuchElementException.class);
			     fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locateXpath)));
	}
	public void fluentWaitForTextToAppearInAnAlert(WebDriver driver,WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(EXPLICIT_WAIT))
				.pollingEvery(Duration.ofSeconds(EXPLICIT_WAIT))
				.ignoring(NoAlertPresentException.class);
		         Alert alert =fluentWait.until(ExpectedConditions.alertIsPresent());
		         String text = alert.getText();
}
}
