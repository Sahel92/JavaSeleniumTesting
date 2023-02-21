package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
// Profile fields User able to edit (name, phoneNum, email, password)
	
	@FindBy(id = "personalPhoneInput")
	public WebElement phoneNumber;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement personalUpdateBtn;
	
	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordInput;
	
	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordInput;
	// End of Your Profile fields
	
	
	// Identifiers to confirm User on correct page
	@FindBy(xpath = "//h1[text() = 'Your Profile']")
	public WebElement yourProfileHeader;
	
	@FindBy(xpath = "//img[@alt = 'profile pic']")
	public WebElement profilePic;
	
	
	
	@FindBy(xpath = "//h1[text() = 'Wallet']")
	public WebElement walletHeader;
	// End of Identifiers.
	
	
	
	// Confirmation messages when User adds/updates some form
	@FindBy(xpath = "//div[text() = 'Personal Information Updated Successfully']")
	public WebElement updatedSuccessfully;
	
	@FindBy(xpath = "//div[text() = 'Password Updated Successfully']")
	public WebElement passwordUpdatedSuccessfully;
	
	@FindBy(xpath = "//div[contains(text(), 'Payment Method updated Successfully']")
	public WebElement paymentAddedSuccess;
	
	@FindBy(xpath ="//*[text() ='Payment Method updated Successfully']")
	public WebElement paymentUpdatedText;
	//End of Confirmation messages.
	
	
	/*
	 * Clicking on this webElement will present the 
	 * Card form.
	*/
	
	@FindBy(xpath = "//p[text() = 'Add a payment method']")
	public WebElement addPaymentLink;
	
	
	
	 // Fields for Card form	 
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInput;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardInput;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInput;
	
	@FindBy(id="expirationYearInput")
	public WebElement expirationYearInput;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInput;
	 //End of Fields for Card form
	 

	// WebElements related to Buttons
	// (update, change password, edit, etc) buttons
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(xpath = "//button[text() ='Edit']")
	public WebElement editCardBtn;
	
	@FindBy(xpath = "//button[text() ='remove']")
	public WebElement removeCardBtn;
	
	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changePasswordBtn;
	
	//This element when clicked on will present the options to edit or remove card.
		@FindBy(className = "account__payment-sub")
		public WebElement cardOptions;
	
	// End buttons
}
