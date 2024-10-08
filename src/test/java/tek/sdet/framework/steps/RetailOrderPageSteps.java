package tek.sdet.framework.steps;

import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderPageSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();

	@And("User click on Orders section")
	public void userClickOnOrdersSection() {

		click(factory.getRetailHomePage().orderLink);
		logger.info("User clicked on \"Orders\" link");
	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		for (int i = 0; i < factory.getRetailOrderPage().showDetailsBtn.size(); i++) {
			if (factory.getRetailOrderPage().showDetailsBtn.get(i).getText().equals("Show Details")) {
				click(factory.getRetailOrderPage().showDetailsBtn.get(i));
			}
		}
		assertTrue(isElementDisplayed(factory.getRetailOrderPage().cancelTheOrderBtn));
		logger.info("User is on first order in list");
	}

	@And("User click on Cancel The Order button")
	public void UesrClickOnCancelTheOrderButton() {

		click(factory.getRetailOrderPage().cancelTheOrderBtn);
		logger.info("User clicked on \"Cancel The Order\" button");
	}

	@And("User select the cancelation Reason {string}")
	public void UserSelectTheCancelationReason(String reason) {
		selectByVisibleText(factory.getRetailOrderPage().reasonInput, reason);
		logger.info("User selected " + reason + " as cancelation reason");
	}

	@And("User click on Cancel Order button")
	public void UserClickOnCancelOrderButoon() {
		click(factory.getRetailOrderPage().cancelOrderBtn);
		logger.info("User clicked on \"Cancel Order\" button");
	}

	@Then("A message should be displayed for canceled order {string}")
	public void aMessageShouldBeDisplayedForCanceledOrder(String cancelText) {
		String actualText = getText(factory.getRetailOrderPage().cancelText);
		String expectedText = cancelText;
		assertEquals(expectedText, actualText);
		logger.info("The confirmation text :" + expectedText + " is displayed");
	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(waitTillClickable(factory.getRetailOrderPage().returnItemBtn));
		logger.info("User clicked on \"Return Item\" button");
	}

	@And("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) {
		selectByVisibleText(factory.getRetailOrderPage().reasonInput, reason);
		logger.info("User selected " + reason + " for return reason.");
	}

	@And("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropOff) {
		selectByVisibleText(factory.getRetailOrderPage().dropOffInput, dropOff);
		logger.info("User selected " + dropOff + " as their drop off location");
	}

	@And("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		if(!(isElementSelected(factory.getRetailOrderPage().checkBox))){
			click(factory.getRetailOrderPage().checkBox);
		}
		click(factory.getRetailOrderPage().returnOrderBtn);
		logger.info("User clicked \"Return Order\" button");
	}

	@Then("Message for return order should be displayed {string}")
	public void messageForReturnOrderShouldBeDisplayed(String confirmText) {
		String actualText = getText(factory.getRetailOrderPage().returnConfirmText);
		String expectedText = confirmText;
		assertEquals(expectedText, actualText);
		logger.info("Confirmation for return is displayed");
	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.getRetailOrderPage().reviewBtn);
		logger.info("User clicked on review button");

	}

	@And("User write Review headline {string} and review text {string}")
	public void userWriteReviewHeadlineHeadlineValueAndReviewText(String headLine, String reviewText) {
		sendText(factory.getRetailOrderPage().headlineInput, headLine);
		sendText(factory.getRetailOrderPage().descriptionInput, reviewText);
		logger.info("User has written their review in the review form");

	}

	@And("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.getRetailOrderPage().reviewSubmitBtn);
		logger.info("User has clicked on \"Add Your Review\" button");
	}

	@Then("review message should be displayed {string}")
	public void reviewMessageShouldBeDisplayed(String reviewConfirm) {
		String actualText = getText(waitTillPresence(factory.getRetailOrderPage().reviewConfirmation));
		String expectedText = reviewConfirm;
		assertEquals(expectedText, actualText);
		logger.info("The message " + actualText + " is displyed");
	}
}
