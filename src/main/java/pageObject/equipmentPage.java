package pageObject;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class equipmentPage {
	public equipmentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(id="Available for Rent")
	public WebElement rent;
	
	public WebElement AvailableForRent()
	{
	   return rent;
	}
	
	@FindBy(id="Rented Equipment")
	public WebElement rented;
	
	public WebElement RentedEquipment()
	{
		return rented;
	}
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='You have no rented equipment']")
	public WebElement noEquipment;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='View catalogue']")
	public WebElement  catalouge;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='CHANGE END DATE']")
	public WebElement EquipmentPageChangeEndDate;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='CHANGE END DATE']")
	public WebElement CalendarChangeEndDate;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@value='‎clr-static-artifacts-us.s3.amazonaws.com, secure']")
	public List<WebElement> url;
	
	public List<WebElement> URL()
	{
		return url;
	}
	

	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'ID')]")
	public WebElement RentedID;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='CONTINUE']")
	public WebElement equipmetRentConfirmed;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Rented Equipment']")
	public WebElement RentedEquipment;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Account\nTab 5 of 5']")
	public WebElement account;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='My team\nTab 4 of 5']")
	public WebElement myTeam;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Drive\nTab 3 of 5']")    // refer to DRIVE tab
	public WebElement Drive;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Equipment\nTab 2 of 5']") // refer to equipment tab
	public WebElement Equipment;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Call\nTab 1 of 5']") // refer to equipment tab
	public WebElement call;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='See equipment available for rent']")
	public WebElement equipmentLink;
	
	@FindBy(id="Search equipment")
	public List<WebElement> searchEquipment;
}
