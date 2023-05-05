package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;

public interface Browser {

	/*
	 * openBrowser that will be implemented
	 * by the browser classes (ChromeBrowser, FireFoxBrowser, etc)
	 * returns instance of WebDriver
	 */

	WebDriver openBrowser(String url);
}
