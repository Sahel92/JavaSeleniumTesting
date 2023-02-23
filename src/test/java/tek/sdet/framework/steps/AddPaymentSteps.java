package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class AddPaymentSteps extends CommonUtility  {
	
	private POMFactory factory = new POMFactory();
	
	
@When("User click on Add a payment method link")
public void user_click_on_add_a_payment_method_link() {
    Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().addPaymentLink));
    logger.info("Add a payment link is displayed");
    click(factory.getRetailAccountPage().addPaymentLink);
    logger.info("User clicked on add a payment link");
}

@When("User fills debit or credit card information {string} {string} {string} {string} {string}")
public void user_fills_debit_or_credit_card_information(String string, String string2, String string3, String string4, String string5) {
    Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().cardNumberInput));
    Assert.assertTrue(isElementEnabled(factory.getRetailAccountPage().expirationMonthInput));
    logger.info("Card number field is present");
    logger.info("Expiration month input is enabled");
    sendText(factory.getRetailAccountPage().cardNumberInput, string);
    sendText(factory.getRetailAccountPage().nameOnCardInput, string2);
    selectByValue(factory.getRetailAccountPage().expirationMonthInput, string3);
    selectByValue(factory.getRetailAccountPage().expirationYearInput, string4);
    clearTextUsingSendKeys(factory.getRetailAccountPage().securityCodeInput);
    sendText(factory.getRetailAccountPage().securityCodeInput, string5);
    logger.info("User has filled out the add debit or credit card form.");
}

@When("User click on Add your card button")
public void user_click_on_add_your_card_button() {
    Assert.assertTrue(isElementEnabled(factory.getRetailAccountPage().paymentSubmitBtn));
    logger.info("Add your card button is enabled");
    click(factory.getRetailAccountPage().paymentSubmitBtn);
    logger.info("User clicked on Add Your card button");
}

@Then("a message should be displayed {string}")
public void a_message_should_be_displayed(String string) {
    String actualMessage = getText(waitTillPresence(factory.getRetailAccountPage().paymentAddedSuccess));
    String expectedMessage = string;
    Assert.assertEquals(expectedMessage, actualMessage);
    logger.info("Actual:" + actualMessage + " matches Expected " + expectedMessage );    
}

}