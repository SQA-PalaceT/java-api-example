package mavenpackage.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.Status;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import mavenpackage.bases.BaseObjects;
public class ListenersImplementation extends BaseObjects implements ITestListener{
	
	@Override
    public void onTestStart(ITestResult result){
        //before each test case
        test = extentreport.createTest(result.getMethod().getMethodName());
    }
	
	@Override
    public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+" es Exitoso.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " es Fallido.");
		test.log(Status.FAIL, result.getThrowable());
		
		//add screenshot for failed test.
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String screenshotPath = "./src/test/java/mavenpackage/reports/screenshots/Failed"+result.getMethod().getMethodName()+"/"+actualDate+".jpg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
            test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		//SetUp ExtentReport
		try {
			extentreport = ExtentSetup.setUpExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		//close extentReport
		extentreport.flush();
	}

    
}
