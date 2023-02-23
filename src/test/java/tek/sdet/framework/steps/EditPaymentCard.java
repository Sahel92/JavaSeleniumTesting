package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class EditPaymentCard extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User clicks on Edit option of card section")
	public void userClicksOnEditOptionOfCardSection() {
		click(factory.getRetailAccountPage().visaCard);
		logger.info("User opened Card options. Edit card form displayed");
		click((factory.getRetailAccountPage().editCardBtn));
		logger.info("User clicked on edit button");
		
	}

	@When("User edits card information")
	public void userEditsInformationWithBelowData(DataTable cardUpdate) {
		
		List<Map<String, String>> cardInfo = cardUpdate.asMaps(String.class, String.class);

		String cardNumber = cardInfo.get(0).get("cardNumber");
		String nameOnCard = cardInfo.get(0).get("nameOnCard");
		String expMonth = cardInfo.get(0).get("expirationMonth");
		String expYr = cardInfo.get(0).get("expirationYear");
		String scrCode = cardInfo.get(0).get("securityCode");

		clearTextUsingSendKeys(waitTillPresence(factory.getRetailAccountPage().cardNumberInput));
		sendText(factory.getRetailAccountPage().cardNumberInput, cardNumber);
		logger.info("Card number has been edited.");

		clearTextUsingSendKeys(factory.getRetailAccountPage().nameOnCardInput);
		sendText(factory.getRetailAccountPage().nameOnCardInput, nameOnCard);
		logger.info("Card name has been edited.");
		selectByValue(factory.getRetailAccountPage().expirationMonthInput, expMonth);
		logger.info("Expiration month updated");
		selectByValue(factory.getRetailAccountPage().expirationYearInput, expYr);
		logger.info("Expiration year updated");
		clearTextUsingSendKeys(factory.getRetailAccountPage().securityCodeInput);
		sendText(factory.getRetailAccountPage().securityCodeInput, scrCode);
		logger.info("CCV security has been chaged");

	}

	@When("User clicks on Update Your Card button")
	public void uSerClicksOnUpdateYourCardButton() {
		Assert.assertTrue(isElementEnabled(factory.getRetailAccountPage().paymentSubmitBtn));
		logger.info("Update Your Card button is enabled");
		click(waitTillClickable(factory.getRetailAccountPage().paymentSubmitBtn));
		logger.info("User clicked update card button");

	}

	@Then("Update successfull message should be displayed {string}")
	public void aMessageShouldBe(String string) {
		String actualMessage = getText(waitTillPresence(factory.getRetailAccountPage().paymentUpdatedText));
		String expectedMessage = string;
		Assert.assertEquals(actualMessage, expectedMessage);
		logger.info("Expected message: " + expectedMessage + " Actual message: " + actualMessage);
	}
	@When("User click on bank card")
	public void user_click_on_bank_card() {
	    clickElementWithJS(factory.getRetailAccountPage().visaCard);
	    logger.info("user clicked on visa card");
	}
	
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection(){

		click(factory.getRetailAccountPage().removeCardBtn);
		logger.info("User clicked on remove option of card section");
	}
		
	@Then("payment details should be removed")
	public void paymentDEtailsShouldBeRemoved() {
		Assert.assertFalse(!isElementDisplayed(factory.getRetailAccountPage().visaCard));
		logger.info("payment details was removed");
	}
	
}
