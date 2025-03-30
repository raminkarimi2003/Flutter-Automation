package utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import resources.BaseIOSTest;


public class ScrollToORG extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public ScrollToORG(IOSDriver<WebElement> driver)
	{
		ScrollToORG.driver=driver;   // assigned the driver to local driver
	}
	

	public static void scroll(String text) throws InterruptedException
	{
		 
		boolean textSelected=false;
		String []splitArray=text.split("/");
		
		while(!textSelected)
		{	
			do {
				if(driver.findElementByXPath("//*[contains(normalize-space(@name),'"+splitArray[1]+ " "+splitArray[2]+"')]").isDisplayed()) {   // if the selected text exist
					System.out.println(splitArray[2]+ " role of "+splitArray[1]+" is selected from Organization "+splitArray[0] );
					driver.findElementByXPath("//*[contains(normalize-space(@name),'"+splitArray[1]+ " "+splitArray[2]+"')]").click();  // tab on the selected text
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



