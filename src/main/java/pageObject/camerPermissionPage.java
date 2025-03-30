package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class camerPermissionPage {
    private AppiumDriver<WebElement> driver;
	public camerPermissionPage(AppiumDriver<WebElement> driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeAlert[@name=\"“Imperto BETA” Would Like to Access the Camera\"]")
	public List<WebElement> access;
	
	public List<WebElement>Access()
	{
		return access;
	}

	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']") // allow the button 
	public WebElement ok;
	
	public WebElement OK()
	{
		return ok;
	}
	
	
}
