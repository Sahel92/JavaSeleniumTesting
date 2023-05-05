package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css = "#cancelBtn")
	public WebElement cancelTheOrderBtn;
	
	@FindBy(css = "#returnBtn")
	public WebElement returnItemBtn;
	
	@FindBy(css = "#buyAgainBtn")
	public WebElement buyAgainBtn;
	
	@FindBy(css = "#reviewBtn")
	public WebElement reviewBtn;
	
	@FindBy(css = "#reasonInput")
	public WebElement reasonInput;
	
	@FindBy(css = "#orderSubmitBtn")
	public WebElement cancelOrderBtn;
	
	@FindBy(xpath ="//p[contains(text(),'Your Order Has Been Cancelled')]")
	public WebElement cancelText;
	
	@FindBy(css = "#dropOffInput")
	public WebElement dropOffInput;
	
	@FindBy(className = "order__cancel-submit")
	public WebElement returnOrderBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Return was successfull')]")
	public WebElement returnConfirmText;
	
	@FindBy(css = "#headlineInput")
	public WebElement headlineInput;
	
	@FindBy(css = "#descriptionInput")
	public WebElement descriptionInput;
	
	@FindBy(css = "#reviewSubmitBtn")
	public WebElement reviewSubmitBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Your review was added successfully')]")
	public WebElement reviewConfirmation;
	
	@FindBy(xpath = "//p[@class = 'order__header-btn']")
	public List<WebElement> showDetailsBtn;
	
//	@FindBy(xpath = "//p[contains(text(), 'Show Details')]")
//	public WebElement detailsBtn;
	
	@FindBy(css = "#cancelBtn")
	public List<WebElement> cancelBtns;
}
