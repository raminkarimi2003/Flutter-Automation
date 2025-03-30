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
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObject.accountPage;
import pageObject.bluetoothPage;
import pageObject.checkEquipmentPage;
import pageObject.connectToEquipmentPage;
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
import pageObject.rentedEquipmentPage;
import resources.BaseIOSTest;
import resources.BaseIOSTest_Bluetooth;
import utility.BLEConnection;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.EnableBluetooth;
import utility.EndRental;
import utility.Finish;
import utility.IsActionFailedAlertPresent;
import utility.IsBLEConnectionErrorDialogPresent;
import utility.IsBlutoothDialogPresent;
import utility.IsCameraPermissionDialogPresent;
import utility.IsCheckEquipmentPagePresent;
import utility.IsConditionEquipmentDialogPresent;
import utility.IsEquipmentDetailsPagePresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login;
import utility.Logout;
import utility.Notification;
import utility.Orientation;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.TakePhoto;
import utility.UseEquipment;
import utility.getAssetLocation;
import utility.isiPhonsettingsMainPagePresent;
import utility.loginSteps;
import utility.SelectAsset;
import utility.SelectAssetForRent;
import utility.StartRental;
import resources.BaseIOSTest_NoReset;

@Listeners(resources.Listeners.class)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This test case will assert that the app can gracefully handle the BLE disruption during pre-check and can
// complete its renting process, after BLE restoration.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class BLEDisruptionDuringPrecheck extends BaseIOSTest{
 
	@Test(groups={"TestGroup1"})
	public void BLEInteruptPrecheck_NoReset() throws InterruptedException, IOException
	{		
		service=startServer();  // start server
		BaseIOSTest.Credential();  // invoke method to access username and/or password properties
		IOSDriver<WebElement> standard_driver= BaseIOSTest.DesiredCapabilities("ImpertoApp"); // install app and reset cached data(through standard driver)
		IsNotificationDialogPresent.Check(standard_driver);
		IsBlutoothDialogPresent.Check(standard_driver);  // check to see if there is bluetooth dialog, and if there is OK that
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method(with No_Reset driver) and assign it driver object
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
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
		equipmentPage eq=new equipmentPage(driver);
		eq.AvailableForRent().click();  // click on 'Available for Rent'
		Thread.sleep(5000);
		SelectAssetForRent.ScrollDownTo(driver,"BACKHOE"); // scroll down to asset ("BACKHOE") and rent it
		new ScrollToText(driver);
		ScrollToText.scroll("Start Rental");   // scroll to rental button
        StartRental.rent(driver,"Start Rental");  // rent
        ScrollToText.scroll("Use Equipment");   // scroll to "Use Equipment" button
        UseEquipment.use(driver, "Use Equipment"); 
        driver.closeApp();
        driver.launchApp();
        HashMap<String,Object>args=new HashMap<>();
		args.put("bundleId","com.apple.Preferences");
		driver.executeScript("mobile: launchApp", args); // launch iPhone setting
		new isiPhonsettingsMainPagePresent(driver);   
		isiPhonsettingsMainPagePresent.check();   //check to see if you are on main settings(Phone)
		new EnableBluetooth(driver);
		EnableBluetooth.enable(false);   // switch Blue tooth Off
		Thread.sleep(1000);
        driver.closeApp();
		
        driver.launchApp();  // launch the first app from where it was left off
		Thread.sleep(1000);
		driver.activateApp("com.apple.Preferences");   // activate iPhone setting
        new EnableBluetooth(driver);
		EnableBluetooth.enable(true);   // switch blue tooth ON
		Thread.sleep(2000);
		driver.closeApp();
	
		driver.launchApp();
		Thread.sleep(2000);
		equipmentPage eqn=new equipmentPage(driver);
		eqn.RentedEquipment().click();
		UseEquipment.use(driver, "Use Equipment"); 
		IsCameraPermissionDialogPresent.Check(driver);       // check to see if camera permission available and if it exist permit it
        Orientation.set(driver, "portrait");                 // set the orientation for photo to portrait
        TakePhoto.photo(driver,"BACKHOE");
        new CheckBox(driver);
        CheckBox.check();    // tick the check list
        IsConditionEquipmentDialogPresent.Check(driver);     // confirm pre-check submissio
        drivePage drive=new drivePage(driver);
		drive.locked.click(); // lock the equipment    
        EndRental.end(driver);
        TakePhoto.photo(driver,"BACKHOE");
        CheckBox.check();
        Thread.sleep(7000);
        Finish.verify(driver);
	    //eq.account.click();      // click on Account tab
        Logout.App(driver);       
		stopServer();		
	}	
} 
