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
	/*
	 * Will be creating and storing common methods that will be used throughout
	 * automation This will reduce code duplication Makes it organized and
	 * maintainable why work hard when can work smart?? our overloaded methods are
	 * used many times in various methods defined below
	 *
	 */

	/**
	 * explicit wait that returns instance of WebDriverWait class
	 */
	public WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30));
	}

	/**
	 * waits until an element is clickable before we can take action on it Useful
	 * for dom objects that are slow to load and are clickable
	 */
	public WebElement waitTillClickable(WebElement element) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * overloaded waitTillClickable(WebElement element), instead uses (By by)
	 * 
	 */
	public WebElement waitTillClickable(By by) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(by));

	}

	/**
	 * waits until the presence of specified element WebElement as parameter
	 */

	public WebElement waitTillPresence(WebElement element) {
		return this.getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * overloading previous method takes parameter By
	 */
	public WebElement waitTillPresence(By by) {
		return this.getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * method that clicks on an element as soon as it is clickable
	 */
	public void click(WebElement element) {
		this.waitTillClickable(element).click();
	}

	/**
	 * method that sends text
	 */
	public void sendText(WebElement element, String value) {
		this.waitTillPresence(element).sendKeys(value);
	}

	/**
	 * get visible text of an element (not hidden by CSS) if element has long load
	 * time, use this method
	 */
	public String getElementText(WebElement element) {
		return this.waitTillPresence(element).getText();
	}

	/**
	 * returns byte[] screenshot with output bytes
	 */
	public byte[] takeScreenShotAsBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	/*
	 * click on an element as soon as it can be clicked on using By locator
	 */
	public void click(By by) {
		waitTillClickable(by).click();
	}

	/**
	 * sends text to some element can take an input of chars uses By locator and
	 * some value passed as string as its parameters
	 */
	public void sendText(By by, String value) {
		this.waitTillPresence(by).sendKeys(value);
	}

	/**
	 * overloaded method gets text of an element using By locator after waiting for
	 * the element to be present
	 */

	public String getElmentTextString(By by) {
		return this.waitTillPresence(by).getText();
	}

	/**
	 * gets and returns the title of the current page
	 * 
	 * @return
	 */

	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}

	/**
	 * sends a value using JavascriptExecutor takes WebElement and String as
	 * 
	 * @param element
	 * @param value
	 */

	public void sendValueUsingJS(WebElement element, String value) {
		JavascriptExecutor executor = ((JavascriptExecutor) getDriver());
		executor.executeScript("arguments[0].value='" + value + "';", element);
	}

	/**
	 * selects all then presses delete
	 * 
	 * @param toClear
	 */

	public void clearTextUsingSendKeys(WebElement toClear) {
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
	}

	/*
	 * selects an element from a dropdown using its index number Takes WebElement
	 * and int as its parameter
	 */
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * select action to select an element from a dropdown by specified value
	 * 
	 * @param element
	 * @param value
	 */

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * select action to select an element from a dropdown by visible text
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * select action to deselect an element from a dropdown by index
	 * 
	 * @param element
	 * @param index
	 */
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * select action to deselect an element from a dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * select action to deselect an element from a dropdown by visible text
	 * 
	 * @param element
	 * @param visibleText
	 */

	public void deselectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}

	/**
	 * returns the attribute of a webElement
	 * 
	 * @param element
	 * @param value
	 * @return
	 */
	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	/**
	 * returns the tag name of specified WebElement
	 * 
	 * @param element
	 * @return
	 */
	public String getTagName(WebElement element) {
		return element.getTagName();
	}

	/**
	 * return the visible text of specified element
	 * 
	 * @param element
	 * @return
	 */

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * highlights given element using JavascriptExecutor
	 * 
	 * @param element
	 */

	public void HighlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		js.executeScript("arguments[0].style.border= '1px white'", element);
	}

	/**
	 * drag and drop using Actions class, by passing current WebDriver instance
	 * drags an element to from its origin to target drop location
	 * 
	 * @param dragLocation
	 * @param dropLocation
	 */

	public void dragAndDropAction(WebElement dragLocation, WebElement dropLocation) {
		Actions action = new Actions(getDriver());
		action.dragAndDrop(dragLocation, dropLocation);
	}

	/**
	 * returns boolean if element is displayed or not
	 * 
	 * @param element
	 * @return
	 */

	public boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else
			return false;
	}

	/**
	 * returns boolean if element is enabled or not
	 * 
	 * @param element
	 * @return boolean = true if element enabled, else false
	 */

	public boolean isElementEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else
			return false;
	}

	/**
	 * returns boolean if element is selected or not
	 * 
	 * @param element
	 * @return
	 */

	public boolean isElementSelected(WebElement element) {
		if (element.isSelected()) {
			return true;
		} else
			return false;
	}

	/**
	 * moves the mouse cursor to an element
	 * 
	 * @param element
	 */

	public void moveToElementAction(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(element);
		actions.build().perform();
	}

	/**
	 * method that waits fluently for specified WebElement
	 * 
	 * @param element
	 * @param timeoutSec
	 * @param pollingSec
	 * @return
	 */

	public WebElement fluentWaitForElement(WebElement element, int timeoutSec, int pollingSec) {
		FluentWait<WebDriver> fWait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(timeoutSec))
				.pollingEvery(Duration.ofSeconds(pollingSec)).ignoring(NoSuchElementException.class, TimeoutException.class)
				.ignoring(StaleElementReferenceException.class);
		for (int i = 0; i < 5; i++)
			fWait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	/**
	 * Switches to specified window using pageTtitle as parameter
	 * 
	 * @param pageTitle
	 */

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

	/**
	 * select calendar date using JS
	 * 
	 * @param date
	 * @param element
	 */

	public void selectCalendarDateWithJS(String date, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
	}

	/**
	 * click on an element using JS
	 * 
	 * @param element
	 */

	public void clickElementWithJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * scroll a down page using JS
	 */

	public void scrollPageDownWithJS() {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * clear text using JS
	 * 
	 * @param element
	 */

	public void clearTextWithJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].value = '';", element);
	}

	/**
	 * clear and send text with JavaScript
	 * 
	 * @param element to clear
	 * @param value   to send
	 */
	public void clearAndSendWithJs(WebElement element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].value= '';", element);
		element.sendKeys(value);
	}

	/**
	 * refreshes the webpage
	 *
	 * @param
	 */

	public void refreshPage() {
		getDriver().navigate().refresh();
	}

	/**
	 * presses enter key
	 * 
	 * @param searchBox
	 */
	public void enterKey(WebElement enterKey) {
		enterKey.sendKeys(Keys.ENTER);
	}

}
