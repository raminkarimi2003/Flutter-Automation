package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class commentPage {
	public commentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//XCUIElementTypeTextView") 
	public WebElement comment;
	
	public WebElement Comment()
	{
		return comment;
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Done']")
	public WebElement done;
	
	public void Done()
	{
		done.click();
	}
	
}
