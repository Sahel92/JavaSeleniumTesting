package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		assertEquals(expectedTitle, actualTitle);
		logger.info("Actual Title: " + actualTitle + " Expected Title: " + expectedTitle);
		assertTrue(isElementDisplayed(factory.getRetailHomePage().tekSchoolLogo));
		logger.info("TEKSCHOOL logo is displayed on upper left of website");
		assertTrue(isElementDisplayed(factory.getRetailHomePage().signInLink));
		logger.info("Sign In option is displayed on upper right of website ");
	}
	
	@When("User clicks on Sign in option")
	public void userClicksSignInLink() {
		click(factory.getRetailHomePage().signInLink);
		logger.info("User clicked on Sign in option");
	}

	
	@When("User enters {string} and {string}")
	public void userEntersAnd(String string, String string2) {

		assertTrue(isElementDisplayed(factory.getRetailSignInPage().loginForm));
		logger.info("Login form is displayed");
		sendText(factory.getRetailSignInPage().emailField, string);
		logger.info("Email field has been filled");
		sendText(factory.getRetailSignInPage().passWrdField, string2);
		logger.info("Password field has been filled");

	}
	
	@And("User clicks on login button")
	public void userClicksOnLoginButton() {
		assertTrue(isElementDisplayed(factory.getRetailSignInPage().loginBtn));
		logger.info("Login button is displayed");
		click(factory.getRetailSignInPage().loginBtn);
		logger.info("User clicked login button");
	}
	
	@Then("User should be logged into their account")
	public void userShouldBeLoggedInToTheirAccount() {
		assertTrue(isElementDisplayed(factory.getRetailHomePage().logoutBtn));
		assertTrue(isElementDisplayed(factory.getRetailHomePage().orderLink));
		logger.info("Log out button is present");
		logger.info("Orders link is displayed at the top of page");
	}

	
	/*
	 * This method used in feature files that require being logged into an account
	 * I put it here, because it is relevant for login functionality.
	 */
	
	@When("User enters following login credentials")
	public void userEntersFollowingLoginCredentials(DataTable credentials) {
	
		List<Map<String, String>> loginInfo = credentials.asMaps(String.class, String.class);
		String email = loginInfo.get(0).get("Email");
		String password = loginInfo.get(0).get("Password");
		sendText(factory.getRetailSignInPage().emailField, email);
		sendText(factory.getRetailSignInPage().passWrdField, password);
			
	}
	
	


}
