package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.internetAlertPage;
import pageObject.locationAlert;

public class IsInternetConnectionAlertPresent  {
		
	
	public static void Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);  		// implicit time out
        internetAlertPage ia=new internetAlertPage(driver);         // Initialize the class with driver and  create instance of it
        boolean flag=ia.NoInternetAlert().size()>0; // check if the Internet alert dialog is present
        if(flag) 
        	ia.OK().click();
	}
}  