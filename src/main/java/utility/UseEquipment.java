package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;

public class UseEquipment {

	private static IOSDriver<?> driver;   // declare local driver
	public UseEquipment(IOSDriver<?> driver)
	{
		UseEquipment.driver=driver;   // assigned the driver to local driver of the class
	}
	
	
    public static void use(IOSDriver<WebElement>driver,String text) throws InterruptedException 
    {
      driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
      WebElement element=driver.findElementByXPath("//XCUIElementTypeButton[@name='"+text+"']");
      Action.DouleClick(driver, element);// connect to equipment
        	
    }
    	
}