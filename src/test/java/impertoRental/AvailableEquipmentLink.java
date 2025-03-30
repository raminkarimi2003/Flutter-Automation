package impertoRental;
import io.appium.java_client.ios.IOSDriver;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.util.StopWatch;

import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.helloPage;
import pageObject.logoPage;
import pageObject.projectPage;
import resources.BaseIOSTest;
import utility.Bluetooth;
import utility.Coordinates;
import utility.IsBlutoothDialogPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login; 
import utility.Logout;
import utility.Notification;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.SelectAsset;
import utility.availableEquipmentLink;
import utility.loginSteps;

@Listeners(resources.Listeners.class)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The purpose of this test case is to assert that available Equipment list will be retrieved in the app and can
// be selected for equipments.
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class AvailableEquipmentLink extends BaseIOSTest{

	@Test(groups={"TestGroup1"})
	public void availableEquipmentLink_Reset() throws InterruptedException, IOException 
	{	
	    service=startServer();  // start server
	    BaseIOSTest.Credential();  // invoke method to access username and/or password properties 
	    resources.Listeners.setTestCaseBooking(false);  // set the booking flag to false
		// TODO Auto-generated method stub.
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method and assign it driver object
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
		new availableEquipmentLink(driver);
        availableEquipmentLink.verify("BACKHOE"); // verify the link URL by selecting the desired asset(asset=CAT 301.8) from asset pool
        Logout.App(driver);
		stopServer(); 
	}	
}
