package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class conditionEquipmentPage {

	public conditionEquipmentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public List<WebElement> condition;
	
	public List<WebElement>Condition()
	{
		return condition;
	}

	@FindBy(xpath="//XCUIElementTypeButton[@name='AGREE']") // allow the button 
	public WebElement agree;
	
	public WebElement Agree()
	{
		return agree;
	}
	
	
}
