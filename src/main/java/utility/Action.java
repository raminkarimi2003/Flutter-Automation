package utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

import resources.BaseIOSTest;

public class Action extends BaseIOSTest {
	//private static IOSDriver<WebElement> driver;   // declare local driver
	public Action(IOSDriver<WebElement> driver)
	{
	  Action.driver=(IOSDriver<WebElement>) driver;   // assigned the driver to local driver
	}
	
		
	
	public static void DouleClick(IOSDriver<WebElement>driver,WebElement element) throws InterruptedException
	{
     driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
     TouchAction<?> action=new TouchAction<>(driver);
     action.tap(ElementOption.element(element))
     .waitAction(WaitOptions.waitOptions(Duration.ofMillis(20))) // Short pause
     .tap(ElementOption.element(element)).perform();
	}
}