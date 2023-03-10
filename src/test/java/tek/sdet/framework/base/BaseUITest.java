package tek.sdet.framework.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.sdet.framework.utilities.CommonUtility;

public class BaseUITest extends CommonUtility {

	@Before
	public void setupTests() {
		super.setupBrowser();
	}

// NOT EFFICIENT TO TAKE SCREENSHOT AFTER EVERY STEP. Good for debugging purposes
//	@AfterStep
//	public void takeScreenshot(Scenario scenario) {
//		byte[] screenshot = takeScreenShotAsBytes();
//
//	scenario.attach(screenshot, "image/png", "Screenshot");
//	}
//


	@After
	public void closeTests(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName() + " scenario Failed");
		}

		super.quitBrowser();
	}

}
