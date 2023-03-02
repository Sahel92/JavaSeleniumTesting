package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class AddPaymentSteps extends CommonUtility  {

	private POMFactory factory = new POMFactory();


@When("User click on Add a payment method link")
public void userClickOnAddAPaymentMethodLink() {
    Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().addPaymentLink));
    logger.info("Add a payment link is displayed");
    click(factory.getRetailAccountPage().addPaymentLink);
    logger.info("User clicked on add a payment link");
}

@When("User fills debit or credit card information")
public void userFillsDebitOrCreditCardInformation(DataTable dataTable) {
    List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
    sendText(factory.getRetailAccountPage().cardNumberInput,DataGeneratorUtility.data(cardInfo.get(0).get("cardNumber")));
    sendText(factory.getRetailAccountPage().nameOnCardInput, DataGeneratorUtility.data(cardInfo.get(0).get("nameOnCard")));
    selectByValue(factory.getRetailAccountPage().expirationMonthInput, cardInfo.get(0).get("expirationMonth"));
    selectByValue(factory.getRetailAccountPage().expirationYearInput, cardInfo.get(0).get("expirationYear"));
    clearTextUsingSendKeys(factory.getRetailAccountPage().securityCodeInput);
    sendText(factory.getRetailAccountPage().securityCodeInput, DataGeneratorUtility.data(cardInfo.get(0).get("securityCode")));
    logger.info("User has filled out the add debit or credit card form.");
}

@When("User click on Add your card button")
public void userClickOnAddYourCardButton() {
    clickElementWithJS(waitTillClickable(factory.getRetailAccountPage().paymentSubmitBtn));
    logger.info("User clicked on Add Your card button");
}

@Then("a message should be displayed {string}")
public void aMessageShouldBeDisplayed(String string) {
    String actualMessage = getText(waitTillPresence(factory.getRetailAccountPage().paymentAddedSuccess));
    String expectedMessage = string;
    Assert.assertEquals(expectedMessage, actualMessage);
    logger.info("Actual:" + actualMessage + " matches Expected " + expectedMessage );
}

}