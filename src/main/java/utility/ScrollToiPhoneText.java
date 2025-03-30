package utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import resources.BaseIOSTest;


public class ScrollToiPhoneText extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public ScrollToiPhoneText(IOSDriver<WebElement> driver)
	{
		ScrollToiPhoneText.driver=driver;   // assigned the driver to local driver
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
					System.out.println("text selected");
					driver.findElementByAccessibilityId(splitArray[i]).click();   // tab on the selected text
				    	textSelected=true;			    					    
				     }
				    else
				     {	
				    	ScrollToElement.scroll(driver);
				    	textSelected=false;
				   
				     }	
				
			  }	
			  while(!textSelected);
			
		
		}
	}	
}



