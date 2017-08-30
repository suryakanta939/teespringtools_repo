package com.commonLib;

import com.relevantcodes.extentreports.ExtentReports;
/*this function is to append the multiple report in single report*/
public class ExtentFactory {
	
	public static ExtentReports getinstance(){
		ExtentReports extent;
		extent=new ExtentReports("E:\\SELENIUM_PROGRAM\\TeeSpringTools\\Reports\\demo.html",false);
		return extent;
	}

}
