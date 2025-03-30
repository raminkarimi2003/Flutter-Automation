package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class checkEquipmentAbandonFormPage {
    private AppiumDriver<WebElement> driver;
	public checkEquipmentAbandonFormPage(AppiumDriver<WebElement> driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public List<WebElement> abandonDialog;
	
	public List<WebElement>AbandonDialog()
	{
		return abandonDialog;
	}

	@FindBy(xpath="//XCUIElementTypeButton[@name='ABANDON']") // allow the button 
	public WebElement abandon;
	
	public WebElement Abandon()
	{
		return abandon;
	}
	
	
}
