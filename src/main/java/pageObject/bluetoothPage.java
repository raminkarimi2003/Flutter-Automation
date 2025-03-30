package pageObject;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class bluetoothPage {
	public bluetoothPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	

	@FindBy(xpath="//XCUIElementTypeAlert[@name=\"“Imperto BETA” Would Like to Use Bluetooth\"]")
	public List<WebElement> permission;
	
	public List<WebElement> Permission()
	{  
		return permission;
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement ok;
	
	
	
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='ALLOW']") 
	public WebElement bluetooth;
	
	@FindBy(xpath="//XCUIElementTypeAlert[contains(@name,'Bluetooth aktivieren')]")
	public List<WebElement>  blaktivieren;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Schließen']")
	public WebElement schliBen;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Close']")
	public WebElement Close;
	
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Cancel']")
	public WebElement Cancel;
	
	//@FindBy(xpath="//XCUIElementTypeAlert[@name='Error']/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]")
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement Ok;
	
	//@FindBy(xpath="//XCUIElementTypeButton[@name='Innstillinger']")
	//public WebElement Close;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement accept;
	
	public WebElement Accept()
	{
	   return accept;
	}
	
	@FindBy(xpath="//XCUIElementTypeCell[@visible='true' and  @name='Bluetooth']")
    public WebElement BluetoothTab;
	
	@FindBy(xpath="//XCUIElementTypeSwitch[@visible='true' and @name=Bluetooh']")
	public WebElement BluetoothBtn;
	
}

