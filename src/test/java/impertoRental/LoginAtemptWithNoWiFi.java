package impertoRental;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.helloPage;

import pageObject.loginPage;
import pageObject.logoPage;
import pageObject.projectPage;
import resources.BaseIOSTest;
import resources.BaseIOSTest_NoReset;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.EnableWiFi;
import utility.EndRental;
import utility.Finish;
import utility.IsBlutoothDialogPresent;
import utility.IsCameraPermissionDialogPresent;
import utility.IsConditionEquipmentDialogPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login;
import utility.Logout;
import utility.Notification;
import utility.Orientation;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.SelectAsset;
import utility.SelectAssetForRent;
import utility.StartRental;
import utility.TakePhoto;
import utility.UseEquipment;
import utility.isiPhonsettingsMainPagePresent;
import utility.loginSteps;


@Listeners(resources.Listeners.class)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The purpose of this test case is to demonstrate the the app will gracefully handle login with no WiFi and after 
// Turning on wiFi, The App continue its normal operation.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class LoginAtemptWithNoWiFi extends BaseIOSTest{
 
	@Test
	public void AttemptloginWithNoWifi_NOReset() throws InterruptedException, IOException
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
		helloPage hl=new helloPage(driver);
		  // launch iPhone setting
        HashMap<String,Object>args=new HashMap<>();
		args.put("bundleId","com.apple.Preferences");
		driver.executeScript("mobile: launchApp", args);
		
		new isiPhonsettingsMainPagePresent(driver);
		isiPhonsettingsMainPagePresent.check();     //check to see if you are on main settings(Phone)
		new EnableWiFi(driver);
		EnableWiFi.enable(false);   // switch WiFi Off
		Thread.sleep(2000);
        driver.closeApp();   
        
        driver.launchApp();
		Assert.assertTrue(hl.offline.isDisplayed(),"Element is changed or you are not offline");   // asset that offline statement is displayed
	    Thread.sleep(2000);
		driver.closeApp();
		
		driver.launchApp();
        driver.activateApp("com.apple.Preferences");
        new isiPhonsettingsMainPagePresent(driver);
		isiPhonsettingsMainPagePresent.check();     //check to see if you are on main settings(Phone)
        new EnableWiFi(driver);
	    EnableWiFi.enable(true);   // switch WiFi ON
	    driver.closeApp();
	    
	    driver.launchApp();
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
        IsCameraPermissionDialogPresent.Check(driver);       // check to see if camera permission available and if it exist permit it
        Orientation.set(driver, "portrait");                 // set the orientation for photo to portrait
        TakePhoto.photo(driver,"BACKHOE");
        new CheckBox(driver);
        CheckBox.check();    // tick the check list
        IsConditionEquipmentDialogPresent.Check(driver);     // confirm pre-check submission
		drivePage drive=new drivePage(driver);
	    drive.locked.click(); // lock the equipment    
	    EndRental.end(driver);
        TakePhoto.photo(driver,"BACKHOE");
        CheckBox.check();
        Thread.sleep(7000);
        Finish.verify(driver);
        Logout.App(driver); 
		stopServer(); 
	}	
}
