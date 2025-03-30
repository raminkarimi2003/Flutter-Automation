
package utility;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.airplaneModePage;
import pageObject.iPhoneSettingsPage;
import resources.BaseIOSTest;

public class isSimCardErrorDialogPresent extends BaseIOSTest{

	private static IOSDriver<WebElement> driver;   // declare local driver
	public isSimCardErrorDialogPresent(IOSDriver<WebElement> driver)
	{
		isSimCardErrorDialogPresent.driver=driver;   // assigned the driver to local driver of the class
	}
	
	
	public static void check() throws InterruptedException
	{
		
		
		airplaneModePage ap=new airplaneModePage(driver);
	    boolean status=ap.sim.size()>0;  // check if alert dialog present
	    if (status){
	    	 String OKText=ap.OK.getText();
	    	 new Coordinates(driver); // get the. coordinate of text
	    	 Coordinates.Permission(OKText); // dismiss the dialog by the help of coordinate
	    }        
    	
    }
}	
	