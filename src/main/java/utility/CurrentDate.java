package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

public class CurrentDate {
	private static IOSDriver<?> driver;   // declare local driver
	public CurrentDate(IOSDriver<?> driver)
	{
		CurrentDate.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public int day()
	{
		DateFormat dateFormat=new SimpleDateFormat("dd");
		java.util.Date date= new java.util.Date();
		String currentDate=dateFormat.format(date);
		int formattedDate;
		System.out.println("The current date is "+currentDate);
		formattedDate=Integer.parseInt(currentDate);
		return formattedDate;		
	}	
	
	public String month(int i)
	{
		// create instance of calendar
		Calendar cal=Calendar.getInstance();
		DateFormat dateFormat=new SimpleDateFormat("MMM");
		cal.add(Calendar.MONTH, i); // display the selected calendar moth by increasing current  by specific amount
        System.out.println("Selected month now is "+cal.getTime());
		String currentMonth=dateFormat.format(cal.getTime());  // get the month in string format
		System.out.println("Current month in string format is "+currentMonth);
		currentMonth=currentMonth.substring(0, 3); // get rid of . (at the end)
		System.out.println("The selected set month is "+currentMonth);
		return currentMonth;		
	}	
	
	public int lastDayOfMonth()
	{
		// create instance of calendar
		Calendar cal=Calendar.getInstance();
		// get the last day of the month
		int LastDay=cal.getActualMaximum(Calendar.DATE);
		return LastDay;
	}	
	
} 