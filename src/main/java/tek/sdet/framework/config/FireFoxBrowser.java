package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxBrowser implements Browser{

	/*
	 * returning an instance of WebDriver opening in
	 *  FireFox browser
	 */
	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		return null;
	}

}
