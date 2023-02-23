package tek.sdet.framework.runner;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ("classpath:features"), 
		glue = "tek.sdet.framework",
		dryRun = false,
		plugin = { "pretty",
		"html:target/htmlReports/cucumber-pretty.html",
		"json:target/jsonReports/cucumber.json" },
		snippets = CAMELCASE, 
		monochrome = true
		
)

public class TestRunner {

	/*
	 * Runner class that acts as a link between our step definition class (glue) and
	 * feature files (features). We provide the pathway for both the step def class
	 * and feature files. Uses the JUnit runner class to run said files.
	 */
}
