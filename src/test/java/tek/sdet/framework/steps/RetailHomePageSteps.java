package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailHomePageSteps extends CommonUtility {
	private POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void user_click_on_all_section() {
		click(factory.getRetailHomePage().allBtn);
		logger.info("User clicked on all buton");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void below_options_are_present_in_shop_by_department_sidebar(DataTable dataTable) {
		List<List<String>> expectedOptions = dataTable.asLists(String.class);
		List<WebElement> actualOptions = factory.getRetailHomePage().sidebarOptions;

		for (int i = 0; i < expectedOptions.size(); i++) {
			Assert.assertEquals(actualOptions.get(i).getText(), expectedOptions.get(0).get(i));
			logger.info(actualOptions.get(i).getTagName() + " is equal to " + expectedOptions.get(0).get(i));
		}
	}

	@When("User on {string}")
	public void user_on_department(String department) {
		List<WebElement> sidebarDepts = factory.getRetailHomePage().sidebarOptions;
		for (WebElement dept : sidebarDepts) {
			if (dept.getText().equals(department)) {
				click(dept);
				try {
					logger.info(dept.getText() + " is present");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}
	}

	@Then("below options are present in department")
	public void below_options_are_present_in_department(DataTable dataTable) {
		
		List<List<String>> expectedDeptOptions = dataTable.asLists(String.class);
		List<WebElement> actualDeptOptions = factory.getRetailHomePage().deptSubOptions;
		
		for(int i = 0; i < expectedDeptOptions.size(); i++) {
			for(WebElement subOption : actualDeptOptions) {
				if(subOption.getText().equals(expectedDeptOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(subOption));
					logger.info(subOption.getText() + " is present");
				}
			}
		}
		
		
		
		
		
		
		
	}

}
