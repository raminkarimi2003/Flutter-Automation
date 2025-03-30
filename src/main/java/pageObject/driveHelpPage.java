package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class driveHelpPage {
	public driveHelpPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	@FindBy(id="Find out how to connect and manage your equipment access in 4 simple steps. See below for guidance.")
	public WebElement helpString;
      	
	@FindBy(id="Back")
	public WebElement backArrow;
}