package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;
/*
 * POM factory class for the sign up page (Account Creation)
 */
public class SignUpPage extends BaseSetup{
	
	public SignUpPage() {
		PageFactory.initElements(getDriver(), this);
	}
	/*
	 * same WebElement will be used in Retail Account Page
	 * (nameInput)
	 */
@FindBy(id = "nameInput")
public WebElement nameInput;

@FindBy(id = "emailInput")
public WebElement emailInput;

@FindBy(id = "passwordInput")
public WebElement passwordInput;

/*
 * can use this for RetailAccount Page tests
	
 */
@FindBy(id = "confirmPasswordInput")
public WebElement confirmPasswordInput;

@FindBy(id = "signupBtn")
public WebElement signupBtn;

@FindBy(id = "signUpForm")
public WebElement signUpForm;

@FindBy(xpath ="//label[text() = 'Confirm Password']")
public WebElement confirmPasswordLabel;











}
