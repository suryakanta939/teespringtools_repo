package com.commonLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
	
	public static String takeScreenshot(WebDriver driver,String filename) throws IOException
	{
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcfile=eDriver.getScreenshotAs(OutputType.FILE);
		File dstfile=new File("E:\\SELENIUM_PROGRAM\\TeeSpringTools\\Screenshot\\ "+filename +".png");
		FileUtils.copyFile(srcfile, dstfile);
		
		String destination="E:\\SELENIUM_PROGRAM\\TeeSpringTools\\Screenshot\\ "+filename+".png";
		return destination;
		
	}

}
