This is a BDD Framework utilizing Java, Selenium, and Cucumber. 
This application automates the testing of an e-commerce web application. 
I have the testing environment configured in the yml file.
The tests will be done on headless Chrome Browser. 
We have implemented log4J to log and keep track of our test as they execute.
I am utilizing the Page Object Model POM design pattern.
The benefit of this design pattern is that for each webpage of a webapplication
we can create a java class (POM class) that coresponds to that paricular page, and using the
power of our Selenium WebDriver we can interact with the WebElements that are associated with 
POM class. 
For example the HomePage class will contain locators associated with with the home page of 
the website.
This allows us to change or update our locators for that specifc page much more readily and easily.
Another benefit is that it allows for a cleaner organization. 
To initzialize our POM classes, I have implemented the POMFactory class. In this class we create 
a reference to our POM class using a singleton design pattern
public class POMFactory extends BaseSetup{

private SomePomClass somePomClass;

public POMFactory(){
return this.somePomClas = new SomePomClass();
}

public SomePomClass getSomePomClas(){
return this.somePomClass;
}

when an object of POMFactory is created in the step defintions class
the construcor of POMFactory will initialize an object of our POM class.

When a new object of a POM class is created, inside of its constructor a static call is made  
public class SomePomClas extends BaseSetup{

public SomePomClass(){
PageFactory.initElements(getDriver(), this);
}

This will make sure that all WebElement locators associated with this page are initialized, which 
allows Selenium WebDriver to interact with the elements on a page. 

A common utility class contians all of the common methods that will be used when interacting with webelements. 

Still working to update my framework. 
