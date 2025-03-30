package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.checkEquipmentPage;
import resources.BaseIOSTest;

public class TakePhoto extends BaseIOSTest{
   
 public static void photo(IOSDriver<WebElement>driver,String assetLabel) throws InterruptedException{

Thread.sleep(4000);
 driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Imperto BETA\"]/XCUIElementTypeWindow/"
 		+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/"
 		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/"
		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[2]").click();

Thread.sleep(5000);
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();

 Thread.sleep(5000);
 driver.findElementByXPath("//XCUIElementTypeButton[3]").click();
Thread.sleep(4000);
   

new ScrollToElement(driver);
ScrollToElement.scrollDown("Right photo comment");
Thread.sleep(4000);
driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Imperto BETA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/"
		+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/"
		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]").click();

Thread.sleep(5000);      
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();

Thread.sleep(5000);
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();

ScrollToText.scroll("Back photo comment");

Thread.sleep(4000);
driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Imperto BETA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/"
    		+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
     		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/"
     		+ "XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]").click();


Thread.sleep(5000);      
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();

Thread.sleep(5000);
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();


ScrollToElement.scrollDown("Left photo comment");
Thread.sleep(4000);
driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Imperto BETA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]").click();

Thread.sleep(5000);      
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();

Thread.sleep(5000);
driver.findElementByXPath("//XCUIElementTypeButton[3]").click();

checkEquipmentPage ce=new checkEquipmentPage(driver);
ce.Continue.click();
 }
}
