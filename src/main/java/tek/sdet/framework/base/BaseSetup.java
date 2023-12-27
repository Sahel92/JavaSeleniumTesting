package tek.sdet.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
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

// Loads environment configurations
	public BaseSetup() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4JPath = System.getProperty("user.dir") + "/src/main/resources/log4j.xml";

		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			System.out
					.println("Failed to load environment configurations. Check to make sure your directory is correct");
			throw new RuntimeException("Failed to Load environment context with message " + e.getMessage());
		}
		logger = (Logger) LogManager.getLogger("logger_File");
		System.setProperty("log4j.configurationFile", log4JPath);
	}

	
	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		@SuppressWarnings("rawtypes")

		HashMap uiProperties = environmentVariables.getYamlProperty("ui");

		System.out.println(uiProperties);

		String url = uiProperties.get("url").toString();

		Browser browser;
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperties.get("headless")) {
				browser = new ChromeHeadless();
			} else {
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

	public void quitBrowser() {
		if (webDriver != null)
			webDriver.quit();
	}

}
