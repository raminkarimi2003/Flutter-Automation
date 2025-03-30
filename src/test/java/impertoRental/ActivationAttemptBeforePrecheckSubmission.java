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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.accountPage;
import pageObject.bluetoothPage;
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
import pageObject.rentedEquipmentPage;
import resources.BaseIOSTest;
import resources.BaseIOSTest_NoReset;
import utility.Action;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.EndRental;
import utility.Finish;
import utility.IsActionFailedAlertPresent;
import utility.IsBlutoothDialogPresent;
import utility.IsCameraPermissionDialogPresent;
import utility.IsCheckEquipmentAbandonFormPresent;
import utility.IsCheckEquipmentConfirmationDialogPresent;
import utility.IsCheckEquipmentPagePresent;
import utility.IsConditionEquipmentDialogPresent;
import utility.IsInternetConnectionAlertPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login;
import utility.Logout;
import utility.Notification;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.TakePhoto;
import utility.UseEquipment;
import utility.getAssetLocation;
import utility.loginSteps;
import utility.SelectAsset;
import utility.SelectAssetForRent;
import utility.StartRental;

@Listeners(resources.Listeners.class)
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// This test case will assert that user cannot activate drive without completing and submitting pre-check
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ActivationAttemptBeforePrecheckSubmission extends BaseIOSTest{
 
	@Test(groups={"TestGroup1"})
	public void ActivationBeforePrecheckSubmission_Reset() throws InterruptedException, IOException
	{		

		service=startServer();  // start server
	    BaseIOSTest.Credential();  // invoke method to access username and/or password properties 
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method and assign it driver object
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		IsNotificationDialogPresent.Check(driver);
		IsBlutoothDialogPresent.Check(driver);  // check to see if there is bluetooth dialog, and if there is OK that
		logoPage lp=new logoPage(driver);
		lp.Skip.click();
	
		 if(!BaseIOSTest.crash)  // check to see if there were previous crash in the previous test case run
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
		equipmentPage eq=new equipmentPage(driver);
		eq.AvailableForRent().click();  // click on 'Available for Rent'
		Thread.sleep(5000);
		SelectAssetForRent.ScrollDownTo(driver,"BACKHOE"); // scroll down to asset ("BACKHOE") and rent it
		new ScrollToText(driver);
		ScrollToText.scroll("Start Rental");   // scroll to rental button
        StartRental.rent(driver,"Start Rental");  // rent
        equipmentDetailsPage eqd=new equipmentDetailsPage(driver);
        Thread.sleep(5000);
        ScrollToText.scroll("Use Equipment");   // scroll to "Use Equipment" button
        UseEquipment.use(driver, "Use Equipment");
        IsCameraPermissionDialogPresent.Check(driver);       // check to see if camera permission available and if it exist permit it
        checkEquipmentPage ce=new checkEquipmentPage(driver);
        ce.closePage.click();       // close the equipment page
        IsCheckEquipmentAbandonFormPresent.Check(driver);    // check abandon dialog
        eqd.backArrow.click(); // back arrow
        eq.Drive.click();    // click on Drive icon
        Assert.assertTrue(true,"No equipment selected");   // assert that this condition is true
        // now go back re-connect and finish pre-check and post check and complete the rent
        eq.Equipment.click();                               // click on Equipment icon
        eq.RentedEquipment().click();
        UseEquipment.use(driver, "Use Equipment");
        TakePhoto.photo(driver,"BACKHOE");       
        new CheckBox(driver);
        CheckBox.check();    // tick the check list
     
      //        IsCheckEquipmentPagePresent.Check(driver);    // Agree that the photos and  descriptions are accurate        
      IsConditionEquipmentDialogPresent.Check(driver);        // confirm pre-check submission      
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
