package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class SignUpSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();

	@When("User clicks on Create New Accout button")
	public void user_click_on_create_new_accout_button() {
		click(factory.getRetailSignInPage().createAccountBtn);
		Assert.assertTrue(isElementDisplayed(factory.getSignUpPage().signUpForm));
		logger.info("Sign up form is displayed");
		Assert.assertTrue(isElementDisplayed(factory.getRetailSignInPage().emailLabel));
		logger.info("Email label is displayed");
		Assert.assertTrue(isElementDisplayed(factory.getSignUpPage().confirmPasswordLabel));
		logger.info("Confirm password label is displayed");

	}

	@And("User fills the signUp form with below data")
	public void userFillsTheSignUpFormWithBelowData(DataTable dataTable) {
		List<Map<String, String>> signUpInfo = dataTable.asMaps(String.class, String.class);
		//sendText(factory.getSignUpPage().nameInput, signUpInfo.get(0).get("name"));
		sendText(factory.getSignUpPage().nameInput,DataGeneratorUtility.data(signUpInfo.get(0).get("name")));
		sendText(factory.getSignUpPage().emailInput,DataGeneratorUtility.data(signUpInfo.get(0).get("email")));
		sendText(factory.getSignUpPage().passwordInput, signUpInfo.get(0).get("password"));
		sendText(factory.getSignUpPage().confirmPasswordInput, signUpInfo.get(0).get("confirmPassword"));
		logger.info("User has filled out the sign up form");
	}

	@When("User click on SignUp button")
	public void user_click_on_sign_up_button() {
		Assert.assertTrue(isElementEnabled(factory.getSignUpPage().signupBtn));
		logger.info("Sign Up button is enabled");
		click(factory.getSignUpPage().signupBtn);
		logger.info("User clicked Sign Up button");
	}

	@Then("User should be logged into account page")
	public void user_should_be_logged_into_account_page() {
		Assert.assertTrue(isElementDisplayed(factory.getRetailHomePage().orderLink));
		Assert.assertTrue(isElementDisplayed(factory.getRetailHomePage().logoutBtn));
		logger.info("Order link is displayed");
		logger.info("Log out button is displayed");
	}

}
