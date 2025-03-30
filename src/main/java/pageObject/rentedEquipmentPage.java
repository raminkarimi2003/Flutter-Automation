package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import resources.BaseIOSTest;


public class rentedEquipmentPage {
	public rentedEquipmentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   

	@FindBy(id="BACKHOE 4WD 18' EXT")    // Expected rented Asset under rented equipment
	public WebElement rentedAsset;
	
	public WebElement RentedAsset()
	{
		return rentedAsset;
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='USE EQUIPMENT']")
	public WebElement useEquipment;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Dismiss']")
	public WebElement dismiss;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Ready to use']")
	public WebElement activatedStatus;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Check required']")
	public WebElement preCheckStatus;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Details']")
	public WebElement details;
	
}
