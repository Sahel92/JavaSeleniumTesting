package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}



	@FindBy(id = "personalPhoneInput")
	public WebElement phoneNumber;

	@FindBy(id = "personalUpdateBtn")
	public WebElement personalUpdateBtn;

	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordInput;

	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordInput;
	

	
	@FindBy(xpath = "//h1[text() = 'Your Profile']")
	public WebElement yourProfileHeader;

	@FindBy(xpath = "//img[@alt = 'profile pic']")
	public WebElement profilePic;

	@FindBy(xpath = "//h1[text() = 'Wallet']")
	public WebElement walletHeader;
	

	
	@FindBy(xpath = "//div[text() = 'Personal Information Updated Successfully']")
	public WebElement updatedSuccessfully;

	@FindBy(xpath = "//div[text() = 'Password Updated Successfully']")
	public WebElement passwordUpdatedSuccessfully;

	@FindBy(xpath = "//div[text() = 'Payment Method added sucessfully']")
	public WebElement paymentAddedSuccess;

	@FindBy(xpath = "//*[text() ='Payment Method updated Successfully']")
	public WebElement paymentUpdatedText;
	

	

	@FindBy(xpath = "//p[text() = 'Add a payment method']")
	public WebElement addPaymentLink;


	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInput;

	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardInput;

	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInput;

	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearInput;

	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInput;
	

	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;

	@FindBy(xpath = "//button[text() ='Edit']")
	public WebElement editCardBtn;

	@FindBy(xpath = "//button[contains(text(),'remove')]")
	public WebElement removeCardBtn;

	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changePasswordBtn;

	@FindBy(xpath = "//div[@class='account__payment-sub']")
	public List<WebElement> listOfPaymentCards;
	
	@FindBy(xpath = "//div[contains(@class, 'false account__payment-item')][1]")
	public WebElement firstPaymentCard;
	
	@FindBy(xpath = "//div[@class='account__payment-selected account__payment-item']")
	public WebElement firstSelectedCard;

	@FindBy(className = "account__payments-wrapper")
	public WebElement cardsOnAccount;

	@FindBy(xpath = "//img[@alt = 'Master Card']")
	public WebElement bankCard;

	@FindBy(xpath = "//p[contains(text() , 'Add Address')]")
	public WebElement addAddress;

	@FindBy(css = "#newForm")
	public WebElement newAddressForm;

	@FindBy(css = "#countryDropdown")
	public WebElement countryDropdown;

	@FindBy(css = "#fullNameInput")
	public WebElement fullNameInput;

	@FindBy(css = "#phoneNumberInput")
	public WebElement phoneNumberInput;

	@FindBy(css = "#streetInput")
	public WebElement streetInput;

	@FindBy(css = "#apartmentInput")
	public WebElement apartmentInput;

	@FindBy(css = "#cityInput")
	public WebElement cityInput;

	@FindBy(xpath = "//select[@name = 'state']")
	public WebElement state;

	@FindBy(css = "#zipCodeInput")
	public WebElement zipCodeInput;

	@FindBy(xpath = "//div[contains(text(),'Address Updated Successfully')]")
	public WebElement updateAddressConfirm;

	@FindBy(css = "#addressBtn")
	public WebElement AddAddressBtn;

	@FindBy(xpath = "//div[contains(text() , 'Address Added Successfully')]")
	public WebElement addressAddedText;

	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	public WebElement editAddressBtn;

	@FindBy(id = "addressBtn")
	public WebElement updateAddressBtn;

	@FindBy(xpath = "//button[contains(text(), 'Remove')]")
	public WebElement removeBtn;

}
