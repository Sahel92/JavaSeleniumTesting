package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailHomePageSteps extends CommonUtility {
	private POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.getRetailHomePage().allBtn);
		logger.info("User clicked on all buton");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedOptions = dataTable.asLists(String.class);
		List<WebElement> actualOptions = factory.getRetailHomePage().sidebarOptions;

		for (int i = 0; i < expectedOptions.size(); i++) {
			Assert.assertEquals(actualOptions.get(i).getText(), expectedOptions.get(0).get(i));
			logger.info(actualOptions.get(i).getTagName() + " is equal to " + expectedOptions.get(0).get(i));
		}
	}

	@When("User on {string}")
	public void userOnDepartment(String department) {
		List<WebElement> sidebarDepts = factory.getRetailHomePage().sidebarOptions;
		for (WebElement dept : sidebarDepts) {
			if (dept.getText().equals(department)) {
				click(dept);
				try {
					logger.info(dept.getText() + " is present");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> expectedDeptOptions = dataTable.asLists(String.class);
		List<WebElement> actualDeptOptions = factory.getRetailHomePage().deptSubOptions;

		for (int i = 0; i < expectedDeptOptions.size(); i++) {
			for (WebElement subOption : actualDeptOptions) {
				if (subOption.getText().equals(expectedDeptOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(subOption));
					logger.info(subOption.getText() + " is present");
				}
			}
		}

	}

	@Then("User change the category to Smart Home")
	public void userChangeTheCategoryTo() {
		click(factory.getRetailHomePage().smartHomeDept);
		logger.info("User changed search category to Smart Home");
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String string) {
		clearTextUsingSendKeys(factory.getRetailHomePage().searchBox);
		sendText(factory.getRetailHomePage().searchBox, string);
		logger.info("User searched for " + string);

	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.getRetailHomePage().searchBtn);
		logger.info("User clicked on search button");
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.getRetailHomePage().kasaPlug);
		logger.info("User clicked on the item Kasa Plug");
	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		selectByValue(factory.getRetailHomePage().quantitySelection, quantity);
		logger.info("User changed quatity to " + quantity);
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.getRetailHomePage().addToCartBtn);
		logger.info("User added items to cart");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String cartQuantity) {
		String actualQty = getText(factory.getRetailHomePage().cartQnty);
		String expectedQty = cartQuantity;
		Assert.assertEquals(actualQty, expectedQty);
		logger.info("actual quantity in cart " + actualQty + " matches expected quantity in cart: " + expectedQty);
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.getRetailHomePage().cartBtn);
		logger.info("User clicked on cart button");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.getRetailHomePage().proceedBtn);
		logger.info("User clicked on Proceed to Checkout button");
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.getRetailHomePage().addAddressBtn);
		logger.info("User clicked on Add a new address at checkout");
	}

	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		clickElementWithJS(factory.getRetailHomePage().addPaymentBtn);
		logger.info("User clicked on Add a Credit or Debit Card at checkout");
	}
	
	@Then("User fills debit or credit card information")
	public void userFillsDebitOrCreditCardInformation(DataTable dataTable)  {
	    List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
	    clearAndSendWithJs(factory.getRetailAccountPage().cardNumberInput, cardInfo.get(0).get("cardNumber"));
	    clearAndSendWithJs(factory.getRetailAccountPage().nameOnCardInput, cardInfo.get(0).get("nameOnCard"));
	    selectByValue(factory.getRetailAccountPage().expirationMonthInput, cardInfo.get(0).get("expirationMonth"));
	    selectByValue(factory.getRetailAccountPage().expirationYearInput, cardInfo.get(0).get("expirationYear"));
	    clearAndSendWithJs(factory.getRetailAccountPage().securityCodeInput, cardInfo.get(0).get("securityCode"));
	    click(factory.getRetailAccountPage().paymentSubmitBtn);
	    logger.info("User filled out card payment form at during checkout.");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.getRetailHomePage().placeOrderBtn);
		logger.info("User clicked on Place Your Order");
	}

	@Then("Order has been placed message should be displayed {string}")
	public void aMessageShouldBeDisplayedOrderPlacedThanks(String orderConfirm)  {
		
		String actualText = getText(waitTillPresence(factory.getRetailHomePage().orderPlacedText));
		String expectedText = orderConfirm;
		Assert.assertEquals(actualText, expectedText);
		
		logger.info("Order Placed Successfully is displayed");
	}

	
	
	
	
	
	
}
