package impertoRental;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
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
import resources.BaseIOSTest;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.IsBlutoothDialogPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login;
import utility.Notification;
import utility.ScrollToElement;
import utility.TakePhoto;
import utility.getAssetLocation;

@Listeners(resources.Listeners.class)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The purpose of this test case is to demonstrate that the link "Forgot Your password work correctly
// by navigating to a page which empower the user to reset it.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ForgotUserPassword extends BaseIOSTest{
 
	@Test(groups={"TestGroup3"})
	public void ForgotUserPass_Reset() throws InterruptedException, IOException
	{
		service=startServer();  // start server
	    BaseIOSTest.Credential();  // invoke method to access username and/or password properties
		// TODO Auto-generated method stub
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method and assign it driver object
		IsNotificationDialogPresent.Check(driver);
		IsBlutoothDialogPresent.Check(driver);  // check to see if there is bluetooth dialog, and if there is OK that
		logoPage lp=new logoPage(driver);
		lp.Skip.click();
	    helloPage hl=new helloPage(driver);
		hl.Continue.click();
        loginPage logp=new loginPage(driver);
        logp.forgotPassword.click();     // click on forgot password link
        Boolean forgot=logp.passwordNotice.size()>0;  // check if Forgot password statement is present
        System.out.println("Condition is "+forgot);
        if(forgot)
         logp.close.click();    // close the page  
        else Assert.assertTrue(false); // assert false
        stopServer(); 
	}
}
