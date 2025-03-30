package pageObject;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class checkEquipmentPage {
	public checkEquipmentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='Check equipment']")
	
	public List<WebElement> checkEquipment;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Continue']")  //by pass pre-check photo by agreeing to continue
	public WebElement Continue;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='BACK']")
	public WebElement Back;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Submit']")
	public WebElement Submit;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='checkbox outline']")
	public WebElement checkbox;
	
	@FindBy(xpath="//XCUIElementTypeButton[1]")
	public WebElement closePage;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Check equipment']")
	public List<WebElement> check;
	
	public List<WebElement> Check()
	{
		return check;
	}		
}
