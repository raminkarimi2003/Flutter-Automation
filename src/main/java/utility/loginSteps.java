package utility;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.helloPage;
import resources.BaseIOSTest;


public class loginSteps extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public loginSteps(IOSDriver<WebElement> driver)
	{
		loginSteps.driver=driver;   // assigned the driver to local driver
	}
	

	// This method will bypass email and password entry for the new test in case of crash in the previous test case
	public static void steps() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		helloPage hl=new helloPage(driver);
		hl.Continue.click();
        new Login(driver);
        Login.App(op_username,password);   // this method login to the app (through Email & password)
	}	
}