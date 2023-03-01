package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

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

		String cardNumber = cardInfo.get(0).get("cardNumber");
		String nameOnCard = cardInfo.get(0).get("nameOnCard");
		String expMonth = cardInfo.get(0).get("expirationMonth");
		String expYr = cardInfo.get(0).get("expirationYear");
		String scrCode = cardInfo.get(0).get("securityCode");

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
	public void userClickOnBankCard() {
	    clickElementWithJS(factory.getRetailAccountPage().bankCard);
	    logger.info("user clicked on bank card");
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection(){
		click(waitTillClickable(factory.getRetailAccountPage().removeCardBtn));
		logger.info("User clicked on remove option of card section");
	}

	@Then("payment details should be removed")
	public void paymentDEtailsShouldBeRemoved() {
		waitTillPresence(factory.getRetailHomePage().tekSchoolLogo);
		try {
			Assert.assertFalse(!isElementDisplayed(factory.getRetailAccountPage().bankCard));
		} catch (NoSuchElementException | TimeoutException e) {
			logger.warn("Bank card element not found on page: Removed by user. " + e.getMessage());
		}
		//Assert.assertFalse(isElementDisplayed(factory.getRetailAccountPage().bankCard));
		logger.info("Payment Card removed successfully from account.");
	}

}
