package pageObject;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class impertoLoginPage {
	public impertoLoginPage(WebDriver seleniumdriver)
	{
		PageFactory.initElements(seleniumdriver, this);
	}
   
	@FindBy(xpath="//button[contains(text(),'Login / Register')]")
	public WebElement impertoRegister;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")
    public WebElement impertoSignIn;
	
	@FindBy(xpath="(//input[@id='signInFormUsername'])[2]")
	public WebElement impertoEmail;
	
	@FindBy(xpath="(//input[@id='signInFormPassword'])[2]")
	public WebElement impertoPasswd;
	
	@FindBy(xpath="(//input[@name='signInSubmitButton'])[2]")
	public WebElement impertoSubmit;
	
	@FindBy(xpath="//*[@class='my-auto']")
	public WebElement impertoRoot;
	
	//@FindBy(xpath="//ul[contains(@class,'p-slidemenu-rootlist')]/li")
	//public List<WebElement> impertoItemSelect;
	
	@FindBy(xpath="//div[@class='flex w-full flex-col px-4']//*")
	public List<WebElement> impertoItemSelect;
}
