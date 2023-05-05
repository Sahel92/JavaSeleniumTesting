package tek.sdet.framework.steps;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class UpdateProfileSteps extends CommonUtility {
	private POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void user_click_on_account_option() {
		assertTrue(isElementDisplayed(factory.getRetailHomePage().accountLink));
		click(factory.getRetailHomePage().accountLink);
		logger.info("Account link is present");
		logger.info("User clicked on Account link");
	}

	@When("User update Name and Phone")
	public void user_update_name_and_phone(DataTable dataTable) {
		List<Map<String, String>> newInfo = dataTable.asMaps(String.class, String.class);

		assertTrue(isElementDisplayed(factory.getRetailAccountPage().yourProfileHeader));
		logger.info("Your profile header is displayed");
		clearTextUsingSendKeys(factory.getSignUpPage().nameInput);
		sendText(factory.getSignUpPage().nameInput, DataGeneratorUtility.data(newInfo.get(0).get("name")));
		clearTextUsingSendKeys(factory.getRetailAccountPage().phoneNumber);
		sendText(factory.getRetailAccountPage().phoneNumber,
				DataGeneratorUtility.data(newInfo.get(0).get("phoneNumber")));
		logger.info("New name has been entered");
		logger.info("New phone number has been entered");

	}

	@And("user click on update button")
	public void userClickOnUpdateButton() {
		assertTrue(isElementDisplayed(factory.getRetailAccountPage().personalUpdateBtn));
		logger.info("Update button is displayed");
		click(factory.getRetailAccountPage().personalUpdateBtn);
	}

	@Then("user profile information should be updated")
	public void user_profile_information_should_be_updated() {
		waitTillPresence(factory.getRetailAccountPage().updatedSuccessfully);
		assertTrue(isElementDisplayed(factory.getRetailAccountPage().updatedSuccessfully));
		logger.info("Update success message displayed");
	}

}
