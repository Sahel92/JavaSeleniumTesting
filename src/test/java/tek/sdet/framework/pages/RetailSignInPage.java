package tek.sdet.framework.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

/*
 * Our Page Object Model class(POM) page factory for the SignIn page of Tek
 * Retail site. We will use @FindBy annotation to find and initialize the
 * WebElements of current page using PageFactory.initElements() method Page
 * Factory is an optimized version of POM and it is provided in Selenium
 *
 * These methods will help in maintaining our code and WebElements in an
 * organized manner which makes it easier to update the code as needed.
 *
 * Makes code reusable, if an element is required in a different test case we
 * can just use the one we have defined in here. we can define a method for any
 * WebElement associated with this page.
 *
 * Gives the reader an idea of the actions to be performed on UI elements of
 * this page. This design pattern improves the readability and summarization of
 * the code.
 *
 *
 */

public class RetailSignInPage extends BaseSetup {

	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}

@FindBy(className = "login__title")
public WebElement loginTitle;
/*
 * login form portion form email field to login btn
 */
@FindBy(id = "loginForm")
public WebElement loginForm;

// the form labels have the same xpath for (this page and SignUp page)
@FindBy(xpath = "//label[text() ='Email']")
public WebElement emailLabel;

@FindBy(xpath = "//label[text() ='Password']")
public WebElement passWrdLabel;

/*
 * sign in form layout
 */
@FindBy(className = "login__layout")
public WebElement loginLayout;

@FindBy(id = "email")
public WebElement emailField;

@FindBy(id = "password")
public WebElement passWrdField;

@FindBy(id = "loginBtn")
public WebElement loginBtn;

@FindBy(className ="login__account-btn")
public WebElement createAccountBtn;

@FindBy(id = "newCompanyAccount")
public WebElement newCompanyAccount;





}
