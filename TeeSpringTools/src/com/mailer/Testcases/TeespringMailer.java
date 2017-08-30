package com.mailer.Testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.commonLib.ExtentFactory;
import com.commonLib.HandelWindow;
import com.commonLib.ScreenShot;
import com.pageclasses.DmcaMailer;
import com.pageclasses.LogIn;
import com.pageclasses.Mailer;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TeespringMailer {
//	public static final String USERNAME = "davidding2";
//	  public static final String AUTOMATE_KEY = "jT7ix3GsnYAnApd1RdNy";
//	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 WebDriver driver;
	 String baseURL="https://teespringtools.com";
	 String un="ashwini";
	 String pwd="reset123";
	 String teespringUrl="https://teespring.com/IDrinkBeerIKnowThings-023-085";
	 boolean actualres=true;
	 ExtentReports report;
	 ExtentTest test;
	 LogIn ln;
	 Mailer ml;
	
   
  @BeforeClass
  public void beforeClass() throws InterruptedException, MalformedURLException {
//	  DesiredCapabilities caps = DesiredCapabilities.firefox();
//	    caps.setCapability("browser_version", "47.0");
//	    caps.setCapability("os", "Windows");
//	    caps.setCapability("os_version", "XP");
//	    caps.setCapability("browserstack.debug", "true");
//	    driver = new RemoteWebDriver(new URL(URL), caps);
	  report=ExtentFactory.getinstance();
	  test=report.startTest("TeespringMailer testcase");
	
	  /*open the driver and hit the URL*/
	  driver=new FirefoxDriver();
	  test.log(LogStatus.INFO,"browserstarted");
	  ln=new LogIn(driver);
	  ml=new Mailer(driver,test);
	  
	  /*declare the report*/
	 
	  
	  driver.get(baseURL);
	  test.log(LogStatus.INFO,"url entered");
	  driver.manage().window().maximize();
	  test.log(LogStatus.INFO,"window is maximizses");
	  LogIn.loginToTheTeeSpring(un, pwd);
	  test.log(LogStatus.INFO,"sucesfully logged into the tee spring");
	  Thread.sleep(3000);
  }
 
  
  @Test
  public void mailerGetImage() {
	 
	  ml.getTheteespringImage(teespringUrl,"Teespring-Mailer");
	  test.log(LogStatus.INFO,"ran the imagegetter function and got all the images");
	  boolean expcted=ml.chekPresentOfImages();
	  Assert.assertEquals(actualres, expcted, "images are not showing");
	  test.log(LogStatus.INFO, "got all the images "+expcted);
  }


  @AfterMethod
  public void tearDown(ITestResult result) throws IOException {
	  if(result.getStatus()==result.FAILURE){
		  String impath=ScreenShot.takeScreenshot(driver,result.getName());
		  String pathset=test.addScreenCapture(impath);
		  test.log(LogStatus.FAIL, "screen shot is attatched sucessfully",pathset);
	  }
	  else{
		    System.out.println("test case got pass");
	  }
	  report.endTest(test);
	  report.flush();
	  driver.quit();
  }

}
