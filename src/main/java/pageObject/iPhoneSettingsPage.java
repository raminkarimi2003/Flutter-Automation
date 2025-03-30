package pageObject;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class iPhoneSettingsPage {
	public iPhoneSettingsPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   

	@FindBy(xpath="//XCUIElementTypeStaticText[@label='Settings']")  // Settings menu
	public List<WebElement> settings;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='Language & Region']")  //'Language and Region ' menu
	public List<WebElement> language;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Settings']")  // use it for back button in 'General' menu
    public WebElement backArrow;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='General']")  // use it for back button in 'language and Region' menu
    public WebElement back;
	
}
