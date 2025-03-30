package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import resources.BaseIOSTest;

public class SelectAsset extends BaseIOSTest {
	//private static IOSDriver<?> driver;   // declare local driver
	public SelectAsset(IOSDriver<?> driver)
	{
		//SelectAsset.driver=(IOSDriver<?>) driver;   // assigned the driver to local driver
	}
	
		
	
	public static void ScrollDownTo(IOSDriver<WebElement>driver,String asset) throws InterruptedException
	{
		
		boolean assetSelected=false;

		System.out.println("Asset is "+asset);
			do {
				if(driver.findElementByXPath("//*[contains(normalize-space(@name),'"+asset+"')]").isDisplayed()){   // if the selected asset exist
					new getAssetLocation(driver);
					int gety=getAssetLocation.YCoordinate(asset); // get Y coordinate of the asset relative to the top of screen 
					System.out.println("Y coordinate of the displayed Asset is "+gety);
				    if(gety<250)
				     {
				    	assetSelected=true;			    					    
				     }
				    else
				     {	
				    	ScrollToElement.scroll(driver);
				    	break;
				     }	
				} 
				 else
					ScrollToElement.scroll( driver); 	    	
				
			  }	
			  while(!assetSelected);
			  System.out.println(assetSelected); 
		 }
	
	
	
	public static void ScrollDownTo(IOSDriver<WebElement>driver,String asset,String ID) throws InterruptedException
	{
		
		boolean assetSelected=false;
		Thread.sleep(2000);
		System.out.println("Asset is "+asset);
			do {
				if(driver.findElementByAccessibilityId("ID "+ID).isDisplayed()) {
						System.out.println("ID "+ID+" is found.");
					    new getAssetLocation(driver);
					    int gety=getAssetLocation.YCoordinate("ID "+ID); // get Y coordinate of the asset 
					    System.out.println("Y coordinate of the displayed Asset is "+gety);
				        
					       if(gety<250)
				            {
				        	 assetSelected=true;			    					    
				            }
				           else
				            {	
				    	     ScrollToElement.scroll(driver);
				    	     gety=getAssetLocation.YCoordinate("ID "+ID);
				    	     System.out.println("Y coordinate of the displayed Asset is "+gety);
				    	    }	
				          					
				}	// end of if asset is displayed
				else
					ScrollToElement.scroll( driver); 	    	
				
			  }	
			  while(!assetSelected);
			  System.out.println(assetSelected); 
			}
	
	public static void ScrollUpTo(IOSDriver<WebElement>driver,String asset) throws InterruptedException
	{
		
		boolean assetSelected=false;
		Thread.sleep(2000);	
		System.out.println("Asset is "+asset);
			do {
				if(driver.findElementByAccessibilityId(asset).isDisplayed()) {   // if the selected asset exist on page
					new getAssetLocation(driver);
					int gety=getAssetLocation.YCoordinate(asset); // get Y coordinate of the asset 
					System.out.println("Y coordinate of the displayed Asset is "+gety);
				    if(gety<250)
				     {
				    	assetSelected=true;			    					    
				     }
				    else
				     {	
				    	ScrollToElement.scrollUP(driver);  // scroll up to asset
				    	break;
				     }	
				} 
				 else
					ScrollToElement.scrollUP(driver); 	 // asset does not exist on page
				
			  }	
			  while(!assetSelected);
			  System.out.println(assetSelected); 
			}
	}
