package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.drivePage;

public class EndRental  {
		
	
	public static void end(IOSDriver<WebElement>driver) throws InterruptedException
	{
		 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		 new ScrollToElement(driver); // initialize constructor with driver
		 ScrollToElement.scrollDown("End rental");
		 drivePage drive=new drivePage(driver);
		 Thread.sleep(1000);
         drive.endRental.click();  // end rental
         IsEndRentalConfirmationDialogPresent.Check(driver);   // if the confirmation dialog present then confirm 'END RENTAL'
	}
} 