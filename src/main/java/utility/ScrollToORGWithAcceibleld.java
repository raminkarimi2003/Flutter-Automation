package utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import resources.BaseIOSTest;


public class ScrollToORGWithAcceibleld extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public ScrollToORGWithAcceibleld(IOSDriver<WebElement> driver)
	{
		ScrollToORGWithAcceibleld.driver=driver;   // assigned the driver to local driver
	}
	

	public static void scroll(String text) throws InterruptedException
	{
		 
		boolean textSelected=false;
		String []splitArray=text.split("\n");
		
		while(!textSelected)
		{	
			do {
				if(driver.findElementByAccessibilityId(text).isDisplayed()) {   // if the selected text exist
					System.out.println(splitArray[2]+ " for "+splitArray[1]+" is selected from "+splitArray[0]+" Org" );
					driver.findElementByAccessibilityId(text).click();   // tab on the selected text
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



