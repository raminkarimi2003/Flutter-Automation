package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class iPhoneLanguagePage {
	public iPhoneLanguagePage(AppiumDriver<WebElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Chang to')]") // Referring to language change
	public WebElement change;
	

}