package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class helloPage {

	public helloPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@iOSXCUITFindBy(accessibility="Continue")
	public WebElement Continue;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='You are offline']")
	public WebElement offline;
	
	@FindBy(id="English\n(Phone's Language)")
	public WebElement englishLanguage;
	
	@FindBy(id="Deutsch")
	public WebElement deutschLanguage;

}
