package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	/*
	 * Access modifier public because we will use
	 * POMFactory constructor to instantiate single instance
	 * of this class.
	 * With public modifier can use this webElement
	 * in many different test cases
	 * For example if testing the RetailSignInPage and if I want to verify that
	 * that the signInBtn is present I can use the bellow element
	 * without having to create the same method in a different POM class.
	 * Thank You ENCAPSULATION!!!
	 */

	@FindBy(id ="signinLink")
	public WebElement signInLink;

	@FindBy(tagName = "React App")
	public WebElement title;

	@FindBy(xpath = "//a[text() = 'TEKSCHOOL']")
	public WebElement tekSchoolLogo;
	
	@FindBy(id = "logoutBtn")
	public WebElement logoutBtn;
	
	@FindBy(id = "orderLink")
	public WebElement orderLink;
	
	@FindBy(id = "accountLink")
	public WebElement accountLink;
}
