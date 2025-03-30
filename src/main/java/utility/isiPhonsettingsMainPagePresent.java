
package utility;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.iPhoneSettingsPage;
import resources.BaseIOSTest;

public class isiPhonsettingsMainPagePresent extends BaseIOSTest{

	private static IOSDriver<WebElement> driver;   // declare local driver
	public isiPhonsettingsMainPagePresent(IOSDriver<WebElement> driver)
	{
		isiPhonsettingsMainPagePresent.driver=driver;   // assigned the driver to local driver of the class
	}
	
	
    public static void check() throws InterruptedException 
    {
    	iPhoneSettingsPage set=new iPhoneSettingsPage(driver);
        
        
    	while(!(set.settings.size()>0))  // while 'Setting' page does not exist
    	{
    		boolean elementExist=set.language.size()>0;  // determine if the language page exist
    		if(elementExist)
    			set.back.click();
    		Thread.sleep(2000);
    		ScrollToElement.scroll(driver,END_X,END_Y,START_X,START_Y); // scroll to the starting position
    		Thread.sleep(1000);
        	set.backArrow.click();
        	ScrollToElement.scroll(driver,END_X,END_Y,START_X,START_Y); // scroll to the starting position
    	}
    }
    	
}