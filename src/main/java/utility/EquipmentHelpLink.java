package utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.ios.IOSDriver;
import pageObject.driveHelpPage;
import pageObject.drivePage;


public class EquipmentHelpLink  {
		
	
	public static void Validate(IOSDriver<WebElement>driver) throws InterruptedException
	{
		 new ScrollToText(driver);
		 ScrollToText.scroll("Get help with your equipment"); 
		 drivePage drive=new drivePage(driver);
		 drive.EquipmentHelp().click(); //click on the link
		 Thread.sleep(1000);
		 driveHelpPage drh=new driveHelpPage(driver);
	     String expected="Find out how to connect and manage your equipment access in 4 simple steps. See below for guidance.";
	     String actual=drh.helpString.getText();   // representing the above element in extracted string format
	     Assert.assertEquals(actual, expected);
         drh.backArrow.click();  // back arrow the page
	} 
}