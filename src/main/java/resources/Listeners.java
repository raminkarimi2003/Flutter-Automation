package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners  implements ITestListener{
	BaseIOSTest Resetbase=new BaseIOSTest();
	BaseIOSTest NoResetbase=new BaseIOSTest();
	
 
	public static ExtentReports extent=ExtentReporterNG.generateReport();  // call the object for extent report
	ExtentTest test;
	private static ThreadLocal<Boolean> isTestCaseLogging = new ThreadLocal<>();
	private static ThreadLocal<Boolean> isTestCaseBooking= new ThreadLocal<>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		 BaseIOSTest.appInstalled=false;    // app should be installed fresh at the start
		 isTestCaseLogging.set(false); // Initialize to false for each test
	     if (!isTestCaseLogging.get()) {
		  test=extent.createTest(result.getMethod().getMethodName());    // create test report by calling every method one by one by getting
	     // Method and its name
	     }
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test is passed");    // log if test passed
		 BaseIOSTest.crash = false; // Reset crash status
		 if(isTestCaseBooking.get()) {     // if booking flag is true
		 ITestContext context=result.getTestContext();
		 String bookingID=(String) context.getAttribute("bookingID");
		 System.out.println("booking ID is"+bookingID);
		 }
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    test.fail(result.getThrowable());
	    System.out.print("the name of method is "+result.getName());
	   

	    try {
	        
	            if (BaseIOSTest.driver == null) {
	                System.err.println("Driver is null in onTestFailure. Cannot capture screenshot.");
	            } else {
	                test.addScreenCaptureFromPath(BaseIOSTest.getScreenShot(result.getMethod().getMethodName()));
	                BaseIOSTest.crash=true; // set the crash to true
	                System.out.print("crash status is "+BaseIOSTest.crash);
	            }
	            //Resetbase.stopServer();

	    } catch (IOException e) {   // catch  any exception without cashing the Application
	        e.printStackTrace();
	    }
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush(); // stop run for extent reporting
	}
	
	 public static void setTestCaseLogging(boolean value) {
	        isTestCaseLogging.set(value);
	    }
	 
	 public static void setTestCaseBooking(boolean value) {
		    isTestCaseBooking.set(value);
	     
	 }

}
