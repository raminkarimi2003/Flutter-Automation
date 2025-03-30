package pageObject;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class accountPage {
	public accountPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//XCUIElementTypeStaticText[@naame='Account Informatio']")
	public List<WebElement> accountInformation;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Log Out']")
	public WebElement LogOut;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement ConfirmLogOut;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement logoutVerify;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name=\"To amend your details please contact helpline\"]")
	public WebElement CallForHelpLink;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='2064227082']")
	public WebElement CallNumber;
	
	@FindBy(xpath="//XCUIElementTypeButton[@label='OK']")
	public WebElement ConfirmCallDlg;
	
	@FindBy(id="English\n(Phone's Language)")
	public WebElement englishLanguage;
	
	@FindBy(id="Norsk")
	public WebElement SwitchToNorwiegen;
	
	@FindBy(xpath="//XCUIElementTypeButton")
	public List<WebElement> list;
	
	List<WebElement> List()
	{
		return list;
	}
	
}
