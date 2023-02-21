package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;
/*
 * declaring private reference to our POM classes
 * when an object of this class is instantiated
 * then it's constructor will 
 * instantiate a single object of our POM classes
 * this method is great for memory management
 * because then we wont have multiple instances of the
 * same object. We also dont have to do manual garbage collection.
 * 
 * 
 */
public class POMFactory extends BaseSetup {
	private RetailSignInPage retailSignInPage;
	private RetailHomePage retailHomePage;
	private SignUpPage signUpPage;
	private RetailAccountPage retailAccountPage;



	public POMFactory() {
		this.retailSignInPage = new RetailSignInPage();
		this.retailHomePage = new RetailHomePage();
		this.signUpPage = new SignUpPage();
		this.retailAccountPage = new RetailAccountPage();
	}	
	/*
	 * return methods for our instantiated POM classes
	 * 
	 */
	public RetailSignInPage getRetailSignInPage() {
		return this.retailSignInPage;
	}
	public RetailHomePage getRetailHomePage() {
		return this.retailHomePage;
	}
	public SignUpPage getSignUpPage() {
		return signUpPage;
	}
	public RetailAccountPage getRetailAccountPage() {
		return retailAccountPage;
	}
}
