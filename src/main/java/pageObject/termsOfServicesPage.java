package pageObject;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class termsOfServicesPage {
	public termsOfServicesPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
	//resources.irdeto.com, secure and validated connection
	
	@FindBy(xpath="//XCUIElementTypeOther[contains(@value,'resources.irdeto.com')]")
	public List<WebElement> resources;
	public List<WebElement> Resources()
	{
		return resources;
	}
   
	@FindBy(xpath="//XCUIElementTypeOther[contains(@label,'Keystone')]")
	public List<WebElement> keystone;
	public List<WebElement> Keystone()
	{
		return keystone;
	}
	
	
}
