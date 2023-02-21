package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;

public interface Browser {

	/*
	 * This interface is will have
	 * an abstract method
	 * openBrowser that will be implemented
	 * by the browser classes (ChromeBroser, FireFoxBrowser, etc)
	 * returns instance of WebDriver
	 */

	WebDriver openBrowser(String url);
}
