package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class checkEquipmentConfirmationPage {
    private AppiumDriver<WebElement> driver;
	public checkEquipmentConfirmationPage(AppiumDriver<WebElement> driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public List<WebElement> confirmDialog;
	
	public List<WebElement>ConfirmDialog()
	{
		return confirmDialog;
	}

	@FindBy(xpath="//XCUIElementTypeButton[@name='AGREE']") // allow the button 
	public WebElement agree;
	
	public WebElement Agree()
	{
		return agree;
	}
	
	
}
