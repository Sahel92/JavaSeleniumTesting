package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadless implements Browser {

	/*
	 * overriding the openBrowser method
	 * this will return an instance
	 * of a headless ChromeDriver
	 *
	 * this is done using chrome options object
	 * using addArgugment method of ChromeOptions
	 *
	 */
	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		return driver;
	}

}
