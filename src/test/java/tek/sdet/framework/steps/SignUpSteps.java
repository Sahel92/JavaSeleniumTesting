package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

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

	@And("User fills the signUp form with {string} {string} {string} {string}")
	public void user_fills_the_sign_up_form_with(String string, String string2, String string3, String string4) {
	    sendText(factory.getSignUpPage().nameInput, string);
	    logger.info("Name entered");
	    sendText(factory.getSignUpPage().emailInput, string2);
	    logger.info("Email entered");
	    sendText(factory.getSignUpPage().passwordInput, string3);
	    logger.info("Password entered");
	    sendText(factory.getSignUpPage().confirmPasswordInput, string4);
	    logger.info("Confirm Password entered");

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
