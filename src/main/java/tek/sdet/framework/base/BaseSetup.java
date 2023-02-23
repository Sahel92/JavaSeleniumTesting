package tek.sdet.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.sdet.framework.config.Browser;
import tek.sdet.framework.config.ChromeBrowser;
import tek.sdet.framework.config.ChromeHeadless;
import tek.sdet.framework.config.EdgeBrowser;
import tek.sdet.framework.config.FireFoxBrowser;
import tek.sdet.framework.utilities.ReadYamlFiles;

public class BaseSetup {
	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static Logger logger;

	/*
	 * BaseSetup constructor stores the path of the env_config and log4j files into
	 * two separate String objects
	 *
	 * environmentVariables refers to the instance of the yaml File object
	 * surrounded by try and catch with FileNotFoundException (unchecked exception
	 * (runtime exception)) printing a message to console and throwing new
	 * RuntimeException plus e.getMessage() for the throwable
	 *
	 * Outside of the try/catch block we are retrieving a logger named logger_file
	 *
	 * Finally the last method configures the properties of the log4JPath file
	 */
	@SuppressWarnings("static-access")
	public BaseSetup() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4JPath = System.getProperty("user.dir") + "/srs/main/resources/log4j.properties";

		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Failed for load environment context. Check possible file path errors");
			throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());
		}
		logger = Logger.getLogger("logger_File");
		PropertyConfigurator.configure(log4JPath);
	}

	// returns an instance reference to WebDriver
	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		@SuppressWarnings("rawtypes")
		/*
		 * returns the key : value pair of our yml File object by using
		 * getYamlProperty
		 * method of environmentVariables
		 */
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
		// printing the hashmap to console
		System.out.println(uiProperties);
		// Retrieving the key "url" and returning it a a String
		// The url defined in the yml file is being referred
		// by  url String object
		String url = uiProperties.get("url").toString();
		// creating an instance of WebDriver
		// using swtich statement to select the type of
		// browser we will use for the automation
		// the value of  browser set in yml file
		//  will be executed if there is a corresponding case that matches its value.
		// if browser = Edge
		// An Edge browser with a reference to WebDriver will be instantiated.
		// We will create a case for each Browser class created
		Browser browser;
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if((boolean)uiProperties.get("headless")) {
				browser = new ChromeHeadless();
			}else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;

		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
		default:
			throw new RuntimeException("Unknown Browser check environment properties");
			}
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
			webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		}

	// method for quitting the WebDriver instance
	// quits all browser instances
	public void quitBrowser() {
		if(webDriver != null)
			webDriver.quit();
	}


	}

