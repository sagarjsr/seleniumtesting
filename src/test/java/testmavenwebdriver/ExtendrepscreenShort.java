package testmavenwebdriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendrepscreenShort {
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	@BeforeClass
	public void brforeclass() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String path = System.getProperty("user.dir")+"/extent-reports/"+ sdf.format(new Date())+".html";
		htmlreporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("userName", "Sagar kumar");
		reports.setSystemInfo("host", "LocalHost");
		htmlreporter.config().setReportName("Test Me App Report");
		htmlreporter.config().setTheme(Theme.STANDARD);

		driver =DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();	

	}

	@Test
	public void passTest() {
		logger=reports.createTest("passTest");
		logger.log(Status.INFO, "pass is started");
		Assert.assertTrue(true);
	}
	@Test
	public void failTest() {
		driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		logger=reports.createTest("failTest");
		logger.log(Status.INFO, "fail is started");
		driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
		driver.findElement(By.id("pass")).sendKeys("askmail@email.com");
		//Assert.assertTrue(false);

	}
	@Test
	public void skipTest() {
		logger=reports.createTest("skipTest");
		logger.log(Status.INFO, "skip is started");
		//		Assert.assertTrue("SKIP");
		throw new SkipException("SKIP");


	}
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, "The Test is fail");
			TakesScreenshot ts =(TakesScreenshot) driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			String imagePath=System.getProperty
					("user.dir")+"/extent-reports/images/"+result.getMethod().getMethodName()+".png" ;
			try {
				FileUtils.copyFile(srcFile, new File(imagePath));
				logger.log(Status.INFO, result.getThrowable());
				logger.addScreenCaptureFromPath(imagePath, "fail test image");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}

		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.PASS, "The Test is pass");
			logger.log(Status.INFO, MarkupHelper.createLabel("the Test is pass", ExtentColor.GREEN));
		}

		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(Status.SKIP, "The Test is skip");

		}
	}
	@AfterClass
	public void afterclass() {
		reports.flush();
	}
}


