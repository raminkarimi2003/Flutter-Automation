package utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import resources.BaseIOSTest;


public class ScrollToText extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public ScrollToText(IOSDriver<WebElement> driver)
	{
		ScrollToText.driver=driver;   // assigned the driver to local driver
	}
	

	public static void scroll(String text) throws InterruptedException
	{
		 
		String[]splitArray=text.split("/");  // declare string array and split it by "/"
		boolean textSelected=false;
		for(int i=0;i<splitArray.length;i++)  // calculate size of array
		{	
		
		Thread.sleep(2000);
		
			do {
				if(driver.findElementByAccessibilityId(splitArray[i]).isDisplayed()) {   // if the selected text exist
					String element=driver.findElementByAccessibilityId(splitArray[i]).getText();
					System.out.println(element);
				    textSelected=true;	
				    break;
				     }
				    else
				     {	
				    	ScrollToElement.scroll(driver);
				    	textSelected=false;
				   
				     }	
				
			  }	
			  while(!textSelected);
			
		
		}
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}	
}



