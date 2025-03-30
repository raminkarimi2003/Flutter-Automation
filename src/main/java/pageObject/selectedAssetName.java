package pageObject;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class selectedAssetName {
	//private  final String Asset = null;

	public selectedAssetName(AppiumDriver<?> driver, String asset)
	{
		PageFactory.initElements(driver, this);
	}
   
     String Asset="asset";
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='asset']") 
	public List<WebElement> settings;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Settings']")
    public WebElement backArrow;
}
