package utility;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

public class LongPress {
	private static IOSDriver<?> driver;   // declare local driver
	public LongPress(IOSDriver<?> driver)
	{
		LongPress.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public void longPress(String firstElement, String secondElement)
	{

		IOSTouchAction l=new IOSTouchAction(driver);
		WebElement first=driver.findElementByXPath("//XCUIElementTypeStaticText[@name='"+firstElement+"']");
		WebElement second=driver.findElementByXPath("//XCUIElementTypeStaticText[@name='"+secondElement+"']");
		Point pointX=second.getLocation(); // get element location using Point class
		int x=pointX.getX();
 		
		Point pointY=second.getLocation(); // get element location using Point class
		int y=pointY.getY();
		l.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(4))).moveTo(point(x, y)).release().perform();	
		
	}
	
	
}