package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class ChangePasswordSteps extends CommonUtility {

	private POMFactory factory = new POMFactory();
	
	@And("User enters {string} {string} {string}")
	public void user_enters(String string, String string2, String string3) {
	    Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().previousPasswordInput));
	    logger.info("Previous password text is present");
	    sendText(factory.getRetailAccountPage().previousPasswordInput, string);
	    sendText(factory.getRetailAccountPage().newPasswordInput, string2);
	    sendText(factory.getSignUpPage().confirmPasswordInput, string3);
	    logger.info("previous password is entered");
	    logger.info("New password is entered");
	    logger.info("Confirm password is entered");
	    
	    
	}

	@When("User click on Change Password button")
	public void user_click_on_change_password_button() {
	    Assert.assertTrue(isElementDisplayed(factory.getRetailAccountPage().changePasswordBtn));
	    click(factory.getRetailAccountPage().changePasswordBtn);
	    logger.info("User has entered new password and clicked change password button");
	}

	@Then("A message should be displayed {string}")
	public void a_message_should_be_displayed(String string) {
	    String actualMessage = getText(waitTillPresence(factory.getRetailAccountPage().passwordUpdatedSuccessfully));
	    String expectedMessage = string;
	    Assert.assertEquals(actualMessage, expectedMessage);
	    logger.info("Password updated successfully");
	}
	
}
