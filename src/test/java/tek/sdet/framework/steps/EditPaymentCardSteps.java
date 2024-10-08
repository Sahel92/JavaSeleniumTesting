package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class EditPaymentCardSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User clicks on Edit option of card section")
	public void userClicksOnEditOptionOfCardSection() {
		click(factory.getRetailAccountPage().bankCard);
		logger.info("User opened Card options. Edit card form displayed");
		click((factory.getRetailAccountPage().editCardBtn));
		logger.info("User clicked on edit button");

	}

	@When("User edits card information")
	public void userEditsInformationWithBelowData(DataTable cardUpdate) {

		List<Map<String, String>> cardInfo = cardUpdate.asMaps(String.class, String.class);

		String cardNumber = DataGeneratorUtility.data(cardInfo.get(0).get("cardNumber"));
		String nameOnCard = DataGeneratorUtility.data(cardInfo.get(0).get("nameOnCard"));
		String expMonth = cardInfo.get(0).get("expirationMonth");
		String expYr = cardInfo.get(0).get("expirationYear");
		String scrCode = DataGeneratorUtility.data(cardInfo.get(0).get("securityCode"));

		clearTextUsingSendKeys(waitTillPresence(factory.getRetailAccountPage().cardNumberInput));
		sendText(factory.getRetailAccountPage().cardNumberInput, cardNumber);

		clearTextUsingSendKeys(factory.getRetailAccountPage().nameOnCardInput);
		sendText(factory.getRetailAccountPage().nameOnCardInput, nameOnCard);

		selectByValue(factory.getRetailAccountPage().expirationMonthInput, expMonth);

		selectByValue(factory.getRetailAccountPage().expirationYearInput, expYr);

		clearTextUsingSendKeys(factory.getRetailAccountPage().securityCodeInput);
		sendText(factory.getRetailAccountPage().securityCodeInput, scrCode);
		logger.info("User has edited and updated their payment method");

	}

	@When("User clicks on Update Your Card button")
	public void uSerClicksOnUpdateYourCardButton() {
		assertTrue(isElementEnabled(factory.getRetailAccountPage().paymentSubmitBtn));
		logger.info("Update Your Card button is enabled");
		click(waitTillClickable(factory.getRetailAccountPage().paymentSubmitBtn));
		logger.info("User clicked update card button");

	}

	@Then("Update successfull message should be displayed {string}")
	public void aMessageShouldBe(String string) {
		String actualMessage = getText(waitTillPresence(factory.getRetailAccountPage().paymentUpdatedText));
		String expectedMessage = string;
		assertEquals(actualMessage, expectedMessage);
		logger.info("Expected message: " + expectedMessage + " Actual message: " + actualMessage);
	}

	
	public static int cardListSize;

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(waitTillClickable(factory.getRetailAccountPage().firstPaymentCard));
		cardListSize = factory.getRetailAccountPage().listOfPaymentCards.size();
		click(factory.getRetailAccountPage().removeCardBtn);
		logger.info("User clicked on remove option of card section");
	}

	@Then("payment details should be removed")
	public void paymentDtailsShouldBeRemoved() {
		assertNotEquals(factory.getRetailAccountPage().listOfPaymentCards.size(), cardListSize-1);
		logger.info("Payment Card removed successfully from account.");
	}

}
