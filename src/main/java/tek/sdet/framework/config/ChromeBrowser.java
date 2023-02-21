package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser implements Browser {

	/*
	 * overriding the openBrowser method
	 * this will return an instance
	 * of ChromeDriver that will open
	 * the chrome browser
	 *
	 */

	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		return driver;
	}

}
