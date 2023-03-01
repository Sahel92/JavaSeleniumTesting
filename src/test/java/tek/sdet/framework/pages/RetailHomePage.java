package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	/*
	 * Access modifier public because we will use POMFactory constructor to
	 * instantiate single instance of this class. With public modifier can use this
	 * webElement in many different test cases For example if testing the
	 * RetailSignInPage and if I want to verify that that the signInBtn is present I
	 * can use the bellow element without having to create the same method in a
	 * different POM class. Thank You ENCAPSULATION!!!
	 */

	@FindBy(id = "signinLink")
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

	@FindBy(css = "#hamburgerBtn")
	public WebElement allBtn;

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	public WebElement electronicsDept;

	@FindBy(xpath = "//span[contains(text(),'ers')]")
	public WebElement computersDept;

	@FindBy(xpath = "//span[contains(text(),'Smart Home')]")
	public WebElement smartHome;

	@FindBy(xpath = "//div[@class ='sidebar_content-item']/span")
	public List<WebElement> sidebarOptions;

	@FindBy(xpath = "//div[@class ='sidebar_content-item']/span")
	public List<WebElement> deptSubOptions;

	@FindBy(xpath = "//select[@id='search']")
	public WebElement deptSelect;

	@FindBy(id = "searchInput")
	public WebElement searchBox;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(xpath = "//img[@class='image']")
	public WebElement itemImg;

	@FindBy(xpath = "//select[@class = 'product__select']")
	public WebElement quantitySelection;

	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBtn;

	@FindBy(id = "cartBtn")
	public WebElement cartBtn;

	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartQnty;

	@FindBy(xpath = "//option[contains(text(),'Smart Home')]")
	public WebElement smartHomeDept;

	@FindBy(id = "proceedBtn")
	public WebElement proceedBtn;

	@FindBy(css = "#addAddressBtn")
	public WebElement addAddressBtn;

	@FindBy(id = "addPaymentBtn")
	public WebElement addPaymentBtn;

	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBtn;

	@FindBy(xpath = "//div[contains(text(),'Order Placed Successfully')]")
	public WebElement   orderSucessfullText;
	
@FindBy(xpath = "//p[contains(text(),'Order Placed, Thanks')]")
public WebElement orderPlaced;

//@FindBy(xpath = "//div[contains(text(),'You have a card with this number. please use anoth')]")
//public WebElement 
//	
	
	
}
