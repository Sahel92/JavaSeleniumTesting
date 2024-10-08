package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

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
			assertEquals(actualOptions.get(i).getText(), expectedOptions.get(0).get(i));
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
					assertTrue(isElementDisplayed(subOption));
					logger.info(subOption.getText() + " is present");
				}
			}
		}

	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		selectByVisibleText(factory.getRetailHomePage().deptSelect, category);

		logger.info("User changed search category to " + category);
	}

	@And("User search for an item {string}")
	public void userSearchForAnItem(String itemName) {
		waitTillClickable(factory.getRetailHomePage().searchBox);
		clearTextUsingSendKeys(factory.getRetailHomePage().searchBox);
		click(factory.getRetailHomePage().searchBox);
		sendText(factory.getRetailHomePage().searchBox, itemName);
		getWait();
		logger.info("User entered " + itemName + " into search box");
	}

	@And("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(waitTillClickable((factory.getRetailHomePage().searchBtn)));
		moveToElementAction(factory.getRetailHomePage().searchBtn);
		click(factory.getRetailHomePage().searchBtn);
		logger.info("User clicked on search button");
	}

	@And("User click on item")
	public void userClickOnItem() throws InterruptedException {

		Thread.sleep(500);
		waitTillPresence(factory.getRetailHomePage().itemImg);
		fluentWaitForElement(factory.getRetailHomePage().itemImg, 60, 5);

		click(waitTillClickable(factory.getRetailHomePage().itemImg));
		logger.info("User clicked on the item");
	}

	@And("User select quantity {string}")
	public void userSelectQuantity(String quantitySelect) {
		selectByVisibleText(factory.getRetailHomePage().quantitySelection, quantitySelect);
		logger.info("User changed quatity to " + quantitySelect);
	}

	@And("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(waitTillClickable(factory.getRetailHomePage().addToCartBtn));
		logger.info("User added items to cart");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String cartQuantity) {
		assertEquals(cartQuantity, getText(waitTillPresence(factory.getRetailHomePage().cartQnty)));
		logger.info("actual quantity in cart: " + cartQuantity);
	}

	@When("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.getRetailHomePage().cartBtn);
		logger.info("User clicked on cart button");
	}

	@And("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.getRetailHomePage().proceedBtn);
		logger.info("User clicked on Proceed to Checkout button");
	}

	@And("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.getRetailHomePage().addAddressBtn);
		logger.info("User clicked on Add a new address at checkout");
	}

	@And("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		clickElementWithJS(factory.getRetailHomePage().addPaymentBtn);
		logger.info("User clicked on Add a Credit or Debit Card at checkout");
	}

	@And("User fills debit or credit card information during checkout")
	public void userFillsDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		clearAndSendWithJs(factory.getRetailAccountPage().cardNumberInput,
				DataGeneratorUtility.data(cardInfo.get(0).get("cardNumber")));
		clearAndSendWithJs(factory.getRetailAccountPage().nameOnCardInput,
				DataGeneratorUtility.data(cardInfo.get(0).get("nameOnCard")));
		selectByValue(factory.getRetailAccountPage().expirationYearInput, cardInfo.get(0).get("expirationYear"));
		selectByValue(factory.getRetailAccountPage().expirationMonthInput, cardInfo.get(0).get("expirationMonth"));
		clearAndSendWithJs(factory.getRetailAccountPage().securityCodeInput,
				DataGeneratorUtility.data(cardInfo.get(0).get("securityCode")));

		click(waitTillClickable(factory.getRetailHomePage().AddCardBtn));
		logger.info("User filled out new card payment form at during checkout.");
	}

	@And("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		waitTillClickable(factory.getRetailHomePage().placeOrderBtn);

		click(factory.getRetailHomePage().placeOrderBtn);
		logger.info("User clicked on Place Your Order");
	}

	@Then("Order placed message should be displayed {string}")
	public void aMessageShouldBeDisplayedOrderPlacedThanks(String orderConfirm) {
		String actualText = getText(waitTillPresence(factory.getRetailHomePage().orderPlaced));
		String expectedText = orderConfirm;
		assertEquals(actualText, expectedText);
		logger.info("Order Placed Successfully is displayed");
	}

	@And("user fill new address form during checkout")
	public void user_fill_new_address_form_with_below_information(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByValue(factory.getRetailAccountPage().countryDropdown, addressInfo.get(0).get("country"));
		sendText(factory.getRetailAccountPage().fullNameInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("fullName")));
		sendText(factory.getRetailAccountPage().phoneNumberInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("phoneNumber")));
		sendText(factory.getRetailAccountPage().streetInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("address")));
		sendText(factory.getRetailAccountPage().apartmentInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("apt")));
		sendText(factory.getRetailAccountPage().cityInput, DataGeneratorUtility.data(addressInfo.get(0).get("city")));
		selectByValue(factory.getRetailAccountPage().state, DataGeneratorUtility.data(addressInfo.get(0).get("state")));
		sendText(factory.getRetailAccountPage().zipCodeInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("zipCode")));
		logger.info("User has filled the address form");

	}

}
