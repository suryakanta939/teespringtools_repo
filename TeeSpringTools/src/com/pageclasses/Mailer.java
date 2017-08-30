package com.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.commonLib.ExplicityWebdrivrWait;
import com.commonLib.HandelWindow;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Mailer  {
	public static WebElement element=null;
	public static boolean flag;
	static WebDriver driver=null;
	ExtentTest test;
	public Mailer(WebDriver driver,ExtentTest test){
		this .driver=driver;
		this.test=test;
	}
	
	public static WebElement teespringMailer(){
		element=driver.findElement(By.xpath("//tr[td[contains(text(),'Teespring Template Mailer')]]//td[3]/form/a"));
		return element;
	}
	/*click on the mailerapp*/
	
	public static void clickOnMailer(){
		teespringMailer().click();
	}
	
	public static WebElement getUrlBox(){
		element=driver.findElement(By.xpath("//input[@id='getURL']"));
		return element;
	}
	
	public static WebElement getImageBtn(){
		element=driver.findElement(By.xpath("//button[text()='Get the Image']"));
		return element;
	}
	/*this function will help to get the image*/
	public void getTheteespringImage(String URL,String siteTitle){
		
		//ExplicityWebdrivrWait.waitfortheelementClickAble(driver, 10, teespringMailer(driver));
		clickOnMailer();
		test.log(LogStatus.INFO,"clicked on the teespring mailer icon");
		
		HandelWindow.hadelMultiplewindow(driver, "Teespring-mailer");
		test.log(LogStatus.INFO,"sucessfully passed the driver control to the teespring window");
		
		getUrlBox().sendKeys(URL);
		test.log(LogStatus.INFO,"entered the teesprign url to the text box");
		
		getImageBtn().click();
		test.log(LogStatus.INFO,"clicked on the image button");
		
		ExplicityWebdrivrWait.waitForelementVisible(driver,60,"//div[@id='mail_bomb_result']//img");
		test.log(LogStatus.INFO,"waiting for the element to be visible");
		
	}
	public  boolean chekPresentOfImages(){
		/*check the images are present or not*/
		List<WebElement> images=driver.findElements(By.xpath("//div[@id='mail_bomb_result']//img"));
		boolean res=images.isEmpty();
		if(res==flag){
			System.out.println("images are present");
			return true;
		}else{
			return false;
		}
	}
	
}
