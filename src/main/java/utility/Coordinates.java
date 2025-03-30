package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

public class Coordinates {
	private static IOSDriver<?> driver;   // declare local driver
	public Coordinates(IOSDriver<?> driver)
	{
		Coordinates.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public static void RentEquipment(String elementName,int offsetX,int offsetY)
	{
		WebElement element=driver.findElementByXPath("//*[contains(normalize-space(@name),'"+elementName+"')]");
		
		Point pointX=element.getLocation(); // get element location using Point class
		int getx=pointX.getX();            // get x coordinate from that location
	System.out.println("X cord is "+getx);
		Point pointY=element.getLocation(); // get element location using Point class
		int gety=pointY.getY();             // get y coordinate from that location
		System.out.println("Y cord is "+gety);	
		int x=getx+offsetX;
	    int y=gety+offsetY;
		new IOSTouchAction(driver).tap(point(x,y)).perform();
		
		
	}
	public static void UseEquipment(String elementName,int offsetX,int offsetY)
	{
		WebElement element=driver.findElementByAccessibilityId(elementName);
		
		Point pointX=element.getLocation(); // get element location using Point class
		int getx=pointX.getX();            // get x coordinate from that location
		
		Point pointY=element.getLocation(); // get element location using Point class
		int gety=pointY.getY();             // get y coordinate from that location
		
		int x=getx+offsetX;
	    int y=gety+offsetY;
		new IOSTouchAction(driver).tap(point(x,y)).perform();
		
		
	}

	public static void Permission(String elementName) throws InterruptedException
    {
        WebElement element=driver.findElementByAccessibilityId(elementName);
		
		Point pointX=element.getLocation(); // get element location using Point class
		int x=pointX.getX()+70;
 		
		Point pointY=element.getLocation(); // get element location using Point class
		int y=pointY.getY()+30;
		new IOSTouchAction(driver).tap(point(x,y)).perform(); // tap on the element by dynamic offset
    }
	
	public static void EndDate(String elementName) throws InterruptedException
    {
        WebElement element=driver.findElementByAccessibilityId(elementName);
		
		Point pointX=element.getLocation(); // get element location using Point class
		int x=pointX.getX()+70;
 		
		Point pointY=element.getLocation(); // get element location using Point class
		int y=pointY.getY()+30;
		new IOSTouchAction(driver).tap(point(x,y)).perform(); // tap on the element by dynamic offset
    }
	
	
	public static void EnterPin(String elementName) throws InterruptedException

    {
		int offsetX=250;
		int offsetY=1150;
    
		
		//androidx.viewpager.widget.ViewPager
        WebElement element=driver.findElementByClassName("androidx.viewpager.widget.ViewPager");
        Point pointX=element.getLocation(); // get element location using Point class
        Point pointY=element.getLocation(); // get element location using Point class
		for(int i=0;i<2;i++)
		 for(int j=0;j<3;j++)
		  {
		
		   int x=pointX.getX()+offsetX;
		   int y=pointY.getY()+offsetY;
		   new IOSTouchAction(driver).tap(point(x,y)).perform(); // tap on the element by dynamic offset
		}
    }
	
}