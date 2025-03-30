package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;


public class CalendarDate {
	public int newDate;
	public int lastDayOfMonth;
	public String actual;
	public String [] expected;  // array of string
	public int monthInc=0;
	private static IOSDriver<WebElement> driver;   // declare local driver
	public CalendarDate(IOSDriver<WebElement> driver)
	{
		CalendarDate.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public void set() throws InterruptedException
	{
		
		CurrentDate cd=new CurrentDate(driver);
		int currentDay=cd.day();
		lastDayOfMonth=cd.lastDayOfMonth();
		//int monthInc=0;
		if(lastDayOfMonth-currentDay==0) // if current day is last day of the month
		{
			newDate=1;			// Set the date to first day of the next month
			monthInc++;
		}
		else
			newDate=currentDay+1;  // Set the date to rent until next day
	
		equipmentPage eq=new equipmentPage(driver);
		eq.EquipmentPageChangeEndDate.click(); // click on the main calendar
		actual=driver.findElementByAccessibilityId(Integer.toString(newDate)).getText();
		if(lastDayOfMonth-currentDay==0)
			ScrollToElement.scrollRL(driver);  // scroll horizontally
		driver.findElementByAccessibilityId(Integer.toString(newDate)).click();  // click on the new date
		String Calendar=eq.CalendarChangeEndDate.getText(); // dismiss calendar
		Coordinates.EndDate(Calendar);
		System.out.println("Month increment is "+monthInc);
		String currentSetMonth=cd.month(monthInc);
		String expectedMonth=driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,'"+currentSetMonth+"')]").getText();  // get the text of web element containing  the month
		expected=expectedMonth.split(" "); // split the text
	   	
	}	
	
	public void change(int newDate,int lastDayOfMonth) throws InterruptedException
	{
		equipmentDetailsPage details=new equipmentDetailsPage(driver);
		details.ChangeEndDate.click();

		if(lastDayOfMonth-newDate==0)   // if new date is last day of the month
		{
			ScrollToElement.scrollRL(driver);
			newDate=1;   // Set the new date on the first day of the next month
			monthInc++;
			
		}	
		else
		    newDate=newDate+1; // set the next day
		    
		
		actual=driver.findElementByAccessibilityId(Integer.toString(newDate)).getText();
		System.out.println("actual new date after change is "+actual);
		driver.findElementByAccessibilityId(Integer.toString(newDate)).click();
		equipmentPage eq=new equipmentPage(driver);
		String detailsCalendar=eq.CalendarChangeEndDate.getText(); // dismiss calendar
		Coordinates.EndDate(detailsCalendar);
		CurrentDate cd=new CurrentDate(driver);
		String currentSetMonth=cd.month(monthInc);  //java month in  Integer starts from 0-11, so current month is month(+1)
		String expectedDateMonth=null;
		expectedDateMonth=driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,'"+currentSetMonth+"')]").getText();
		System.out.println("Expected date is "+expectedDateMonth);
		expected=expectedDateMonth.split(" ");
		 
		
	}	
	public static void setRentalDate(IOSDriver<WebElement>driver,int RentalPeriod) throws InterruptedException
	{
		
		LocalDate today=LocalDate.now(); // get todays local date
		System.out.println("Today date is "+today);   // eg. 2022-07-13
		String RentalDate=(today.plusDays(RentalPeriod-1)).format(DateTimeFormatter.ISO_DATE); // Rental date is: RentalPeriod + today (eg. 2022-09-11)
		System.out.println("Rental is untill "+RentalDate);
		String []arraySplit=RentalDate.split("-"); // remove the hyphens and place it in array
		String Month=arraySplit[1].replaceFirst("^0","");    // replace the first occurrence of 0 with ""
		String Day=arraySplit[2].replaceFirst("^0","");
		int selectedMonth=Integer.parseInt(Month);  // convert Month to Integer from original string
		String calendarMonth=null; //declare
		
		// Month always start from 0
		String [] MonthInCalendar= {"","January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i=1;i<MonthInCalendar.length;i++)
		{
			if (i==selectedMonth)
				 calendarMonth=MonthInCalendar[i];   // assign to selected month in the array to variable
		}
		System.out.println("Calendar Month for this rental period is "+calendarMonth); // Extract the desired month in integer format
		equipmentDetailsPage details=new equipmentDetailsPage(driver);
		details.ChangeEndDate.click(); // open the calendar in equipment detail page
		LocalDate currentdate=LocalDate.now();
		// get current month
		Month CurrentMonth=currentdate.getMonth();    // get the month for the current date(integer)
		String currentMonth=String.valueOf(CurrentMonth); // convert object to string
		System.out.println("Current Month is "+currentMonth);
		int j=0;
		String NextMonth=null;
		boolean flag=true;	
		

		if(!calendarMonth.equalsIgnoreCase(currentMonth))
		{		
		  while(flag)
		   {
			  j++;
			  ScrollToElement.scrollRL(driver); // scroll horizontally to locate the month
			  Calendar Currentmonth=Calendar.getInstance();   //get the calendar using current time zone
			  SimpleDateFormat dateformat=new SimpleDateFormat("MMMM"); // format month (ie "JUL")
			  Currentmonth.add(Calendar.MONTH,j); // get the future incremental months from current month(get the next calendar month +1)
			  NextMonth=dateformat.format(Currentmonth.getTime());  // what is the currentMonth when it is increased and assign it as next Month
			  System.out.println("Next month is "+NextMonth);
			  if(NextMonth.equalsIgnoreCase(calendarMonth)) // compare next month now with CalendarMonth(desired month)
				  flag=false;
		   }  		   
		}
		List<WebElement> element=driver.findElementsByXPath("//XCUIElementTypeButton[@name='"+Day+"']"); // select the date
		System.out.println("Day is "+Day);
		System.out.println("Day size is "+element.size());
		if(element.size()>0)     // if at least one element is present
	       element.get(0).click();    // click on index of 0 (first element)
		else                          // if there are more than one element size()>1
			if(element.size()>1)
			element.get(1).click();
		
		equipmentDetailsPage eqd=new equipmentDetailsPage(driver);
		eqd.ChangeEndDateClose.click();   // dismiss the calendar
	}			
}
