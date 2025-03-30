package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class projectPage {
	public projectPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@iOSXCUITFindBy(accessibility="Done")
	public WebElement Done;

	
	
}
