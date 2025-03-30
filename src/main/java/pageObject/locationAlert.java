package pageObject;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class locationAlert {
	public locationAlert(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//XCUIElementTypeAlert[@name=\"Allow “Imperto BETA” to use your location?\"]")
	public List<WebElement> alertPresent;
	
	public List<WebElement> AlertPresent()
	{
	   return alertPresent;
		
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Allow While Using App']")
	public WebElement allowUsing;
	
	public WebElement AllowUsing()
	{
	   return allowUsing;
	}
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Allow “Rental (IG)” to also use your location even when you are not using the app?']")
	public List<WebElement> allowRental;
	
	public List<WebElement> AllowRental()
	{
		return allowRental;
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Change to Always Allow']")
	public WebElement changeToAllow;
	
	public WebElement ChangeToAllow()
	{
		return changeToAllow;
	}	
	
	
}
