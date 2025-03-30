package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class connectToEquipmentPage {
	public connectToEquipmentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
		
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Equipment not connected']")
	public WebElement notConnected;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Connect to equipment']")
	public List<WebElement> connect;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='back button icon']")
	public WebElement backArrow;
	
	@FindBy(xpath="//XCUIElementTypeAlert[@name='Action failed']")
	public List<WebElement> actionFailed;
	
	public List<WebElement> Actionfailed()
	{
	   return actionFailed;
		
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement oK;
	
	public WebElement OK()
	{
	   return oK;
	}

	
}
