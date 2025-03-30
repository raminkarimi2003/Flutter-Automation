package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class loginPage {

	public loginPage(AppiumDriver<?> driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// log in with user email & password
	@FindBy(xpath="//XCUIElementTypeOther[@name='Signin']/XCUIElementTypeTextField")
	public WebElement username;
	
	@FindBy(xpath="//XCUIElementTypeOther[@name='Signin']/XCUIElementTypeSecureTextField")
	public WebElement password;	
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='submit']")
	public WebElement SignIn;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Forgot your password?']")
	public WebElement forgotPassword;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Enter your Email below and we will send a message to reset your password']")
	public List<WebElement> passwordNotice;
	
	@FindBy(id="close")
	public WebElement close;
	
	//@FindBy(xpath="//XCUIElementTypeButton[@name='tos_checkbox']")
	//public WebElement checkbox;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='login_button']")   // click the login button
	public WebElement logIn;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Incorrect username or password.']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='No Internet Connection']")
	public WebElement noInternetConnection;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement OK;
	
	@FindBy(xpath="//XCUIElementTypeAlert[contains(@name,'Forgot')]")
	public List<WebElement> ForgotAlert;
	
	public List<WebElement> ForgotUserPassAlert()
	{
	   return ForgotAlert;
		
	}
	
	@FindBy(id="forgot_credentials") // id for the link
	public WebElement forgotUserPass;

	public WebElement ForgotUserPass()
	{
		return forgotUserPass;
	}
	
	@FindBy(xpath="//XCUIElementTypeLink[@name='Terms of Service']")
	public WebElement terms;
	
	public WebElement TermsOfService()
	{
		return terms;
	}
	
	
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Cancel']")
	public WebElement cancelLabel;
	
	public WebElement Cancelabel()
	{
		return cancelLabel;
	}

	
	private HidesKeyboard driver;  // declare local driver
	
	public WebElement getuserName()
	{
		return username;
	}
	
	public void hideKeyboard()
	{
	   ((HidesKeyboard) driver).hideKeyboard();
	}

}
