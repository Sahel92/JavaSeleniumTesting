package tek.sdet.framework.utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tek.sdet.framework.base.BaseSetup;

public class CommonUtility extends BaseSetup {
	
// Common methods library
	
	public WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30));
	}

	
	public WebElement waitTillClickable(WebElement element) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public WebElement waitTillClickable(By by) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(by));

	}

	

	public WebElement waitTillPresence(WebElement element) {
		return this.getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitTillPresence(By by) {
		return this.getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void click(WebElement element) {
		this.waitTillClickable(element).click();
	}

	
	public void sendText(WebElement element, String value) {
		this.waitTillPresence(element).sendKeys(value);
	}

	public String getElementText(WebElement element) {
		return this.waitTillPresence(element).getText();
	}

	public byte[] takeScreenShotAsBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public void click(By by) {
		waitTillClickable(by).click();
	}

	
	public void sendText(By by, String value) {
		this.waitTillPresence(by).sendKeys(value);
	}

	public String getElmentTextString(By by) {
		return this.waitTillPresence(by).getText();
	}

	

	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}

	

	public void sendValueUsingJS(WebElement element, String value) {
		JavascriptExecutor executor = ((JavascriptExecutor) getDriver());
		executor.executeScript("arguments[0].value='" + value + "';", element);
	}


	public void clearTextUsingSendKeys(WebElement toClear) {
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}


	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}


	public void deselectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}

	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	public String getTagName(WebElement element) {
		return element.getTagName();
	}

	

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}


	public void HighlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		js.executeScript("arguments[0].style.border= '1px white'", element);
	}


	public void dragAndDropAction(WebElement dragLocation, WebElement dropLocation) {
		Actions action = new Actions(getDriver());
		action.dragAndDrop(dragLocation, dropLocation);
	}


	public boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else
			return false;
	}

	
	public boolean isElementEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else
			return false;
	}


	public boolean isElementSelected(WebElement element) {
		if (element.isSelected()) {
			return true;
		} else
			return false;
	}


	public void moveToElementAction(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(element);
		actions.build().perform();
	}


	public WebElement fluentWaitForElement(WebElement element, int timeoutSec, int pollingSec) {
		FluentWait<WebDriver> fWait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeoutSec))
				.pollingEvery(Duration.ofSeconds(pollingSec)).ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		for (int i = 0; i < 5; i++)
			fWait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}


	public void switchWindow(String pageTitle) {
		String currentWindow = getDriver().getWindowHandle();
		Set<String> handles = getDriver().getWindowHandles();
		for (String winHandle : handles) {
			String currentWindowTitle = getDriver().switchTo().window(winHandle).getTitle();
			if (currentWindowTitle.equals(pageTitle)) {
				break;
			} else {
				getDriver().switchTo().window(currentWindow);
			}
		}
	}


	public void selectCalendarDateWithJS(String date, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
	}


	public void clickElementWithJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollPageDownWithJS() {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}


	public void clearTextWithJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].value = '';", element);
	}

	public void clearAndSendWithJs(WebElement element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].value= '';", element);
		element.sendKeys(value);
	}

	public void refreshPage() {
		getDriver().navigate().refresh();
	}

	public void enterKey(WebElement enterKey) {
		enterKey.sendKeys(Keys.ENTER);
	}

}
