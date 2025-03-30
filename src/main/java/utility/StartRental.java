package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;

public class StartRental {

	private static IOSDriver<?> driver;   // declare local driver
	public StartRental(IOSDriver<?> driver)
	{
		StartRental.driver=driver;   // assigned the driver to local driver of the class
	}
	
	
    public static void rent(IOSDriver<WebElement>driver,String text1,String text2) throws InterruptedException 
    {
      driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
      WebElement element=driver.findElementByXPath("//XCUIElementTypeButton[@name='"+text1+"']");
      Action.DouleClick(driver, element);// start rental    	
      driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
    }
    
    public static void rent(IOSDriver<WebElement>driver,String text) throws InterruptedException 
    {
      driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
      //equipmentDetailsPage details=new equipmentDetailsPage(driver);
      WebElement element=driver.findElementByXPath("//XCUIElementTypeButton[@name='"+text+"']");
      Action.DouleClick(driver, element);// start rental   
      equipmentDetailsPage eqd=new equipmentDetailsPage(driver);
      eqd.confirmRental.click();
      equipmentPage eq=new equipmentPage(driver);
      eq.equipmetRentConfirmed.click(); 
      driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
    }
    	
}