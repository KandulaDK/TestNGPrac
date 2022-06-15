package TestNGBasic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.com.testBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {

	public WebDriver driver;
	public int i = 0;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		i++;
		System.out.println("Failed " + i + result.getMethod());
//		testBase tb = new testBase();
//		try {
//			driver = tb.webDriverManager();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		TakesScreenshot tss = ((TakesScreenshot) driver);
//		File src = tss.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\org.TestNGHYR\\target/iffailed.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
