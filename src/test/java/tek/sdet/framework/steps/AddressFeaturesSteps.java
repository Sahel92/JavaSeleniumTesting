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

public class AddressFeaturesSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.getRetailAccountPage().addAddress);
		logger.info("User clicked on Add Address");
	}

	@When("user fill new address form with below information")
	public void user_fill_new_address_form_with_below_information(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);

		selectByValue(factory.getRetailAccountPage().countryDropdown, addressInfo.get(0).get("country"));
		sendText(factory.getRetailAccountPage().fullNameInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("fullName")));
		sendText(factory.getRetailAccountPage().phoneNumberInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("phoneNumber")));
		sendText(factory.getRetailAccountPage().streetInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("streetAddress")));
		sendText(factory.getRetailAccountPage().apartmentInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("apt")));
		sendText(factory.getRetailAccountPage().cityInput, DataGeneratorUtility.data(addressInfo.get(0).get("city")));
		selectByValue(factory.getRetailAccountPage().state, DataGeneratorUtility.data(addressInfo.get(0).get("state")));
		sendText(factory.getRetailAccountPage().zipCodeInput,
				DataGeneratorUtility.data(addressInfo.get(0).get("zipCode")));
		logger.info("User has filled the address form");

	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.getRetailAccountPage().AddAddressBtn);
		logger.info("user clicked on Add Your Address button");
	}

	@Then("a message should be displayed address added {string}")
	public void a_message_should_be_displayed_address_added(String string) {
		String actualText = getText(waitTillPresence(factory.getRetailAccountPage().addressAddedText));
		String expectedText = string;
		assertEquals(expectedText, actualText);
		logger.info("Actual:" + actualText + " matches Expected " + expectedText);
	}

	@When("User click on edit address option")
	public void user_click_on_edit_address_option() {
		click(factory.getRetailAccountPage().editAddressBtn);
		logger.info("User clicked on Edit button for the address");

	}

	@When("User edits address form with below information")
	public void user_edits_address_form_with_below_information(DataTable dataTable) {
		List<Map<String, String>> editedAddress = dataTable.asMaps(String.class, String.class);
		selectByValue(factory.getRetailAccountPage().countryDropdown, editedAddress.get(0).get("country"));
		clearTextWithJS(factory.getRetailAccountPage().fullNameInput);
		sendText(factory.getRetailAccountPage().fullNameInput,
				DataGeneratorUtility.data(editedAddress.get(0).get("fullName")));
		clearTextUsingSendKeys(factory.getRetailAccountPage().phoneNumberInput);
		sendText(factory.getRetailAccountPage().phoneNumberInput,
				DataGeneratorUtility.data(editedAddress.get(0).get("phoneNumber")));
		clearTextUsingSendKeys(factory.getRetailAccountPage().streetInput);
		sendText(factory.getRetailAccountPage().streetInput,
				DataGeneratorUtility.data(editedAddress.get(0).get("streetAddress")));
		clearTextUsingSendKeys(factory.getRetailAccountPage().apartmentInput);
		sendText(factory.getRetailAccountPage().apartmentInput,
				DataGeneratorUtility.data(editedAddress.get(0).get("apt")));
		clearTextUsingSendKeys(factory.getRetailAccountPage().cityInput);
		sendText(factory.getRetailAccountPage().cityInput, DataGeneratorUtility.data(editedAddress.get(0).get("city")));
		selectByValue(factory.getRetailAccountPage().state,
				DataGeneratorUtility.data(editedAddress.get(0).get("state")));
		clearTextUsingSendKeys(factory.getRetailAccountPage().zipCodeInput);
		sendText(factory.getRetailAccountPage().zipCodeInput,
				DataGeneratorUtility.data(editedAddress.get(0).get("zipCode")));
		logger.info("User has updated their address with new information successfully.");
	}

	@When("User click update Your Address button")
	public void user_click_update_your_address_button() {
		click(factory.getRetailAccountPage().updateAddressBtn);
		logger.info("User clicked on \"Update Your Address\" btn");
	}

	@Then("A confirmation message should be displayed {string}")
	public void aConfirmationMessageShouldBeDisplayed(String string) {
		String actualText = getText(waitTillPresence(factory.getRetailAccountPage().updateAddressConfirm));
		String expectedText = string;
		assertEquals(expectedText, actualText);
	}

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.getRetailAccountPage().removeBtn);
		logger.info("User clicked on remove button for their second address");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		assertFalse(!isElementDisplayed(factory.getRetailAccountPage().removeBtn));
		logger.info("Users second address has been removed");
	}

}
