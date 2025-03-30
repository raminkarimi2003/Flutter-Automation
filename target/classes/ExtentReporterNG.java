package resources;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
 
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


 
public class ExtentReporterNG {
   static ExtentReports extent;
    
 
    public static ExtentReports generateReport() {
    	
        String path=System.getProperty("user.dir")+"/Reports/index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);    // class responsible  to configure the report
        reporter.config().setReportName("Mobile Automation");
        reporter.config().setDocumentTitle("Test Result");
        
       extent = new ExtentReports();  //  class responsible to run the report
        
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ramin Karimi");
		return extent;
       
    }
}