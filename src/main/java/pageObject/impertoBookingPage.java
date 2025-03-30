package pageObject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class impertoBookingPage {
	public impertoBookingPage(WebDriver seleniumdriver)
	{
		PageFactory.initElements(seleniumdriver, this);
	}
   

	@FindBy(xpath="//*[text()='Bookings']")
	public WebElement impertoBookingButton;
	
	@FindBy(xpath="//input[@placeholder='Keyword Search']")
	public WebElement impertoCustomerSearch;
	
	@FindBy(xpath="//td[contains(text(),'BACKHOE 4WD 18' EXT')]")
	public WebElement impertoCustomer;
	
	@FindBy(xpath="//span[text()='Delete']")
	public WebElement impertoBookingDelete;

	@FindBy(xpath="//div[@class='flex flex-col space-y-2']/b[1]")
	public WebElement impertoDeleteConfirmationID;
	
	@FindBy(xpath="//input[@name='confirm']")
	public WebElement impertoConfirmation;
	
	@FindBy(xpath="//span[text()='Confirm']")
	public WebElement impertoConfirmationButton;
}
