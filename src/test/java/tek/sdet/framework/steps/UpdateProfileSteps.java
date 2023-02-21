package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class UpdateProfileSteps extends CommonUtility {
	private POMFactory factory = new POMFactory();


	@When("User click on Account option")
	public void user_click_on_account_option() {
		Assert.assertTrue(isElementDisplayed(factory.getRetailHomePage().accountLink));
		click(factory.getRetailHomePage().accountLink);
		logger.info("Account link is present");
		logger.info("User clicked on Account link");
	}

	@When("User update Name {string} and Phone {string}")
	public void user_update_name_and_phone(String string, String string2) {
		Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().yourProfileHeader));
		logger.info("Your profile header is displayed");
		clearTextUsingSendKeys(factory.getSignUpPage().nameInput);
		sendText(factory.getSignUpPage().nameInput, string);
		clearTextUsingSendKeys(factory.getRetailAccountPage().phoneNumber);
		sendText(factory.getRetailAccountPage().phoneNumber, string2);
		logger.info("New name has been entered");
		logger.info("New phone number has been entered");

	}

	@When("user click on update button")
	public void user_click_on_update_button() {
		Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().personalUpdateBtn));
		logger.info("Update button is displayed");
		click(factory.getRetailAccountPage().personalUpdateBtn);
	}

	@Then("user profile information should be updated")
	public void user_profile_information_should_be_updated() {
		waitTillPresence(factory.getRetailAccountPage().updatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().updatedSuccessfully));
		logger.info("Update success message displayed");
	}

}
