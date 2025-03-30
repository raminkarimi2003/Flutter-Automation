package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.finishPage;
import pageObject.locationAlert;

public class Finish  {
		
	
	public static void verify(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);  		// implicit time out
        finishPage fin=new finishPage(driver);         // Initialize the class with driver and  create instance of it
        fin.finish.click();        // click on FINISH button on Finish page
        Thread.sleep(2000);
	}
}   