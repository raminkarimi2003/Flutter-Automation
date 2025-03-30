package pageObject;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class airplaneModePage {
	public airplaneModePage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	
	@FindBy(xpath="//XCUIElementTypeAlert[contains(@name,'No SIM')]")
	public  List<WebElement> sim;
	
    @FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
    public WebElement OK;
}
