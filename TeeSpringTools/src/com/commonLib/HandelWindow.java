package com.commonLib;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class HandelWindow {
	 /*this class is to handel the window*/
	
	public static void hadelMultiplewindow(WebDriver driver,String title){
		String windowid=driver.getWindowHandle();
		Set<String> windowids=driver.getWindowHandles();
		for(String ids:windowids){
			if(!ids.equals(windowid)){
				driver.switchTo().window(ids);
				String titleOfThePage=driver.getTitle();
				
				if(titleOfThePage.equals(title)){
					driver.switchTo().window(ids);
					System.out.println("your title of the pag is "+ titleOfThePage);
				}
			}
		}
	}

}
