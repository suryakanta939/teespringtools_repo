package com.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.commonLib.ExplicityWebdrivrWait;
import com.commonLib.HandelWindow;
import com.commonLib.SelectFunctions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DmcaMailer {
	
	public static WebElement element=null;
	ExtentTest test;
	static WebDriver driver=null;
	
	public DmcaMailer(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	/*get the dmca xpath*/
	public static WebElement dmca(){
		
		element=driver.findElement(By.xpath("//tr[td[contains(text(),'Teespring DMCA Mailer')]]//td[3]/form/a"));
		return element;
		
		
	}
	
	/*getting the selectsite xpath*/
public static WebElement selectsite(){
		
		element=driver.findElement(By.name("setdomain"));
		return element;
	}
	
public static WebElement getinfringingUrl(){
	
	element=driver.findElement(By.id("setbadURL1"));
	return element;
}
public static WebElement getinfringingBtn(){
	
	element=driver.findElement(By.xpath("//button[text()='Get Infringing Source Image']"));
	return element;
}
public static WebElement getTeespringUrl(){
	
	element=driver.findElement(By.id("getgoodURL"));
	return element;
}

public static WebElement getTeespringbtn(){
	
	element=driver.findElement(By.id("getgoodImg"));
	return element;
}

public static List<WebElement> infringinImages(){
	List<WebElement> badimages=driver.findElements(By.xpath("//div[@id='mail_bomb_result_bad']//img"));
	return badimages;
	
}
public static List<WebElement> teespringImages(){
	List<WebElement> goodimages=driver.findElements(By.xpath("//div[@id='mail_bomb_result_good']//img"));
	return goodimages;
	
}
/*here is the function to get the images*/
public void getDmcaImages() throws InterruptedException{
	dmca().click();
	test.log(LogStatus.INFO, "clicked on the Dmca Rocket");
	
	HandelWindow.hadelMultiplewindow(driver, "DMCA Complaint");
	test.log(LogStatus.INFO, "sucessfully handeled the window");
	
	SelectFunctions.selectByText(selectsite(), "Teespring");
	test.log(LogStatus.INFO, "selected the teespring site from the selectbox");
	
	getinfringingUrl().sendKeys("https://teespring.com/shop/pizzapocket");
	test.log(LogStatus.INFO, "entered the infringing url");
	
	getinfringingBtn().click();
	test.log(LogStatus.INFO, "clicked on the infringinig button");
	
	Thread.sleep(2000);
	int totalimages=infringinImages().size();
	System.out.println("no of images present "+totalimages);
	test.log(LogStatus.INFO, "found the total no of images present");
	ExplicityWebdrivrWait.waitforallelement(driver,30, infringinImages());
	
	getTeespringUrl().sendKeys("https://teespring.com/shop/nottodayfam_women");
	test.log(LogStatus.INFO, "enterd the tee spring url");
	
	getTeespringbtn().click();
	test.log(LogStatus.INFO, "clicked on the tee spring button");
	Thread.sleep(2000);
	ExplicityWebdrivrWait.waitforallelement(driver,10, teespringImages());
	test.log(LogStatus.INFO, "waited for the images to be shown");
}

}
