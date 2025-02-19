package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports(); //class ,creating instance-extendreport
	public synchronized static ExtentReports createExtentReports()
	{   
			ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //class used generate-create and configure html file
			reporter.config().setReportName("GroceryApplication"); //report name                                        //filepath to save report	
			extentReports.attachReporter(reporter);//to attach the extends path configuration
			extentReports.setSystemInfo("Organization", "Obsqura"); //to give sysytem level information
			extentReports.setSystemInfo("Name", "Raisa");
			return extentReports;//returning and will be called in listeners class  
		}

	
}
