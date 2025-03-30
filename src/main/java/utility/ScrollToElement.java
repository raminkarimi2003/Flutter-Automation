package utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;



public class ScrollToElement {

	private static IOSDriver<?> driver; //  declare local driver of type IOS
	public ScrollToElement (IOSDriver<?> driver) {
		ScrollToElement.driver=driver;
	}


	//Swipe by elements
    public void swipeByElements (WebElement startElement, WebElement endElement) {
        int startX = startElement.getLocation().getX();
        int startY = startElement.getLocation().getY();
        int endX = endElement.getLocation().getX();
        int endY = endElement.getLocation().getY();
        new IOSTouchAction(driver)
            .press(point(startX,startY))
           .waitAction(waitOptions(ofMillis(160)))
            .moveTo(point(endX, endY))
            .release().perform();
    }
    
   public static void scrollUp()throws InterruptedException{
	    
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		//scrollObject.put("label", "NoElement"); // Only for ‘scroll in element’
		scrollObject.put("direction", "up");
		driver.executeScript("mobile:scroll", scrollObject);
	
	}


	
   public static void scrollUp(String elementName) throws InterruptedException{
	    
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("label", elementName); // Only for ‘scroll in element’
		scrollObject.put("direction", "up");
		driver.executeScript("mobile:scroll", scrollObject);
	
	}
   
   
   public static void scrollDown(String elementName) throws InterruptedException{
	    
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("label", elementName); // Only for ‘scroll in element’
		scrollObject.put("direction", "down");
		driver.executeScript("mobile:scroll", scrollObject);
	
	}
   
   
	public static void scrollToText(WebElement ele) throws InterruptedException{

		HashMap<String,Object> scrollObject = new HashMap<>();
		scrollObject.put("element",((RemoteWebElement)ele).getId());// Only for ‘scroll in element’
		scrollObject.put("direction", "down");
		driver.executeScript("mobile:scroll", scrollObject);
	
	}
	
	public static void scroll(IOSDriver<WebElement> driver,double start_xd,double start_yd,double end_xd,double end_yd) throws InterruptedException {
		
 		Dimension dimension=driver.manage().window().getSize();
 		
 		int start_x=(int)(dimension.width*start_xd);
 		int start_y=(int)(dimension.height*start_yd);
 		
 		int end_x=(int)(dimension.width*end_xd);
 		int end_y=(int)(dimension.height*end_yd);
 		TouchAction<?> touch =new TouchAction(driver);
 		touch.press(PointOption.point(start_x, start_y))
         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
         .moveTo(PointOption.point(end_x, end_y)).release().perform();
 		
 	}
	 
	 public static void scroll(IOSDriver<WebElement> driver) throws InterruptedException {
			// scroll down(swipe upward)
	 		Dimension dimension=driver.manage().window().getSize();
	 		
	 		int start_x=(int)(dimension.width*0.5);
	 		int start_y=(int)(dimension.height*0.6);
	 		
	 		int end_x=(int)(dimension.width*0.5);
	 		int end_y=(int)(dimension.height*0.1);
	 		TouchAction<?> touch =new TouchAction(driver);
	 		touch.press(PointOption.point(start_x, start_y))
	         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	         .moveTo(PointOption.point(end_x, end_y)).release().perform();
	 		
	 	}	 
	 
	 public static void scrollUP(IOSDriver<WebElement> driver) throws InterruptedException {
			// scroll down(swipe upward)
	 		Dimension dimension=driver.manage().window().getSize();
	 		
	 		int start_x=(int)(dimension.width*0.5);
	 		int start_y=(int)(dimension.height*0.23);
	 		
	 		int end_x=(int)(dimension.width*0.5);
	 		int end_y=(int)(dimension.height*0.23);
	 		TouchAction<?> touch =new TouchAction(driver);
	 		touch.press(PointOption.point(start_x, start_y))
	         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	         .moveTo(PointOption.point(end_x, end_y)).release().perform();
	 		
	 	}	 
	 
	 public static void scrollRL(IOSDriver<WebElement> driver) throws InterruptedException { //scroll right to left
		 Dimension dimension=driver.manage().window().getSize();
		 
		 int start_x=(int)(dimension.width*0.70);
		 int start_y=(int)(dimension.height*0.70);
		 
		 int end_x=(int)(dimension.width*0.20);
		 int end_y=(int)(dimension.height*0.70);
		 
		 TouchAction<?> touch=new TouchAction(driver);
		 touch.press(PointOption.point(start_x,start_y))
		 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		 .moveTo(PointOption.point(end_x,end_y)).release().perform();
		 Thread.sleep(1000); 
		 
	 }
	
}	

