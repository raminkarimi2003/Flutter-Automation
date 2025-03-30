package impertoRental;
import io.appium.java_client.touch.WaitOptions;

import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.util.StopWatch;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageObject.accountPage;
import pageObject.bluetoothPage;
import pageObject.callPage;
import pageObject.checkEquipmentPage;
import pageObject.contactEquipmentPage;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.finishPage;
import pageObject.helloPage;
import pageObject.locationAlert;
import pageObject.loginPage;
import pageObject.logoPage;
import pageObject.notificationPage;
import pageObject.projectPage;
import resources.BaseIOSTest;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.IsBlutoothDialogPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login; 
import utility.Logout;
import utility.Notification;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.TakePhoto;
import utility.getAssetLocation;
import utility.loginSteps;
import utility.SelectAsset;

@Listeners(resources.Listeners.class)
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// The purpose of this test case is to assert that the telephone No. in Call Tab line is correct
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////
public class CallTabLinkVerification extends BaseIOSTest{

	@Test(groups={"TestGroup2"})
	public void CallTabLink_Reset() throws InterruptedException, IOException
	{	
	    service=startServer();  // start server
	    BaseIOSTest.Credential();  // invoke method to access username and/or password properties 
		// TODO Auto-generated method stub
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method(with No_Reset driver) and assign it driver object
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		IsNotificationDialogPresent.Check(driver);
		IsBlutoothDialogPresent.Check(driver);  // check to see if there is bluetooth dialog, and if there is OK that
		logoPage lp=new logoPage(driver);
		lp.Skip.click();
		if(!BaseIOSTest.crash)   // check to see if there were previous crash in the previous test case run
	    {
		  new loginSteps(driver);
		  loginSteps.steps();   // this method will perform logging steps to fill in user name Email and password
	    }  
	    new ScrollToORG(driver);
        Thread.sleep(1000);
	    ScrollToORG.scroll("TEST(COM.IMPERTO.RAMISHARE)/FlutterAutomationCustomer/Booking Supervisor"); // Scroll and select your ORG
	    projectPage pp=new projectPage(driver);
		pp.Done.click();   // login to your selected project
		IsLocationAlertPagePresent.Check(driver);
		Thread.sleep(1000);
        equipmentPage cal=new equipmentPage(driver);
        cal.call.click(); // click on the call tab
        callPage mc=new callPage(driver);
		mc.makeCall.click(); // click on "Make a call" 
		Assert.assertEquals(mc.CallHelpLines.getText(),"2064227082");
		mc.ok.click();	
		Thread.sleep(1000);
		Logout.App(driver);
		stopServer(); 
	}	
}

	
