package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class notificationPage {
    private AppiumDriver<WebElement> driver;
	public notificationPage(AppiumDriver<WebElement> driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeAlert[@name=\"“Imperto BETA” Would Like to Send You Notifications\"]")
	public List<WebElement> push;
	
	public List<WebElement>Push()
	{
		return push;
	}

	@FindBy(xpath="//XCUIElementTypeButton[@label='Allow']") // allow the button 
	public WebElement allow;
	
	public WebElement Allow()
	{
		return allow;
	}
	
	
}
