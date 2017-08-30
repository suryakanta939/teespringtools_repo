package com.mailer.Testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MailerTest {
	 WebDriver driver;
	 String baseURL="https://teespringtools.com";
	 String un="ashwini";
	 String pwd="reset123";
	 String xpath1="//tr[td[contains(text(),'";
	 String Xpath2="')]]//td[3]/form/a";
	 boolean flag=false;
	 boolean flag1=true;
	 String infringingUrl="https://teespring.com/shop/red-white-and-brew-may-2017?aid=marketplace&tsmac=marketplace&tsmic=category#pid=369&cid=6513&sid=front";
  
  @BeforeClass
  public void beforeClass() {
	  /*open the driver and hit the URL*/
	  driver=new FirefoxDriver();
	  driver.get(baseURL);
	  driver.manage().window().maximize();
	  /*login to the site*/
	  driver.findElement(By.id("username")).sendKeys(un);
	  driver.findElement(By.id("password")).sendKeys(pwd);
	  driver.findElement(By.id("login")).click();
  }
  
  @Test(priority=1)
  public void mailerGetImage() {
	 
	  /*click on the mailer*/
	  WebDriverWait wait=new WebDriverWait(driver,5000);
	 // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy());
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[contains(text(),'Teespring Template Mailer')]]//td[3]/form/a")));
	  driver.findElement(By.xpath("//tr[td[contains(text(),'Teespring Template Mailer')]]//td[3]/form/a")).click();
//	  WebDriverWait wait1=new WebDriverWait(driver,20);
//	  wait1.until(ExpectedConditions.urlMatches("https://mailer.teespringtools.com/site/dashboard"));
	 /*write the function for the window handel*/
	 String pid=driver.getWindowHandle();
	 Set<String> windowid=driver.getWindowHandles();
	  System.out.println("getting the window id");
	 for(String id :windowid){
		 if(!id.equals(pid)){
			 driver.switchTo().window(id);
			 String pagetitle=driver.getTitle();
			 System.out.println(pagetitle);
			 if(pagetitle.equals("Teespring-Mailer")){
				 driver.switchTo().window(id);
				 /*call the function*/
				this.mailerfun(pagetitle);
				 System.out.println("now we are in correct window");
				 driver.close();
				 /*switch to the parent window*/
				 driver.switchTo().window(pid);
				 
			 }
			 
			 else{
				 System.out.println("window not found");
			 }
			 
		 }
	 }
	 
	}
	@Test(priority=2)
	public void dmcaimage(){
		
//		  WebDriverWait wait=new WebDriverWait(driver,5000);
//		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tr[td[contains(text(),'Teespring DMCA Mailer')]]//td[3]/form/a")));
		  driver.findElement(By.xpath("//tr[td[contains(text(),'Teespring DMCA Mailer')]]//td[3]/form/a")).click();
		  String pid=driver.getWindowHandle();
			 Set<String> windowid=driver.getWindowHandles();
			  System.out.println("getting the window id");
			 for(String id :windowid){
				 if(!id.equals(pid)){
					 driver.switchTo().window(id);
					 String pagetitle=driver.getTitle();
					 System.out.println(pagetitle);
					 if(pagetitle.equals("DMCA Complaint")){
						 driver.switchTo().window(id);
					 }
		  WebElement selbox=driver.findElement(By.name("setdomain"));
		  Select sel=new Select(selbox);
		  sel.selectByVisibleText("Teespring");
		  /*enter the infringing url*/
		  driver.findElement(By.id("setbadURL1")).sendKeys(infringingUrl);
		  driver.findElement(By.xpath("//button[text()='Get Infringing Source Image']")).click();
		  WebDriverWait waitForbadImage=new WebDriverWait(driver,40);
		  waitForbadImage.until(ExpectedConditions.
		  visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='mail_bomb_result_bad']//img"))));
		  List<WebElement> imgs2=driver.findElements(By.xpath("//div[@id='mail_bomb_result_bad']//img"));
		  System.out.println("images are showing");
		  /*check all images are there*/
		  boolean imageResult2=imgs2.isEmpty();
		  System.out.println(imageResult2);
		  Assert.assertEquals(imageResult2, flag, "images are not present");
		  /*get the good image*/
		  driver.findElement(By.id("getgoodURL")).sendKeys("https://teespring.com/shop/wear-american-flag");
		  driver.findElement(By.id("getgoodImg")).click();
		  WebDriverWait waitForImage=new WebDriverWait(driver,30);
		  waitForImage.until(ExpectedConditions.
		  visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='mail_bomb_result_good']//img"))));
		  List<WebElement> imgs1=driver.findElements(By.xpath("//div[@id='mail_bomb_result_good']//img"));
		  System.out.println("images are showing");
		  /*check all images are there*/
		  boolean imageResult1=imgs1.isEmpty();
		  System.out.println(imageResult1);
		  Assert.assertEquals(imageResult1, flag, "images are present");
				 }
				 
				 
			 }
		  
		 
	}
 

  @AfterClass
  public void afterClass() {
	//  driver.quit();
  }
  
  public void mailerfun(String titleOfThePage){
	  
	  
		  System.out.println("enter your URL");
		  Scanner scn=new Scanner(System.in);
		  String url=scn.nextLine();
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='getURL']")).sendKeys(url);
	  /*get the image*/
	  driver.findElement(By.xpath("//button[text()='Get the Image']")).click();
	  WebDriverWait waitForImage=new WebDriverWait(driver,20);
	  waitForImage.until(ExpectedConditions.
	visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='mail_bomb_result']//img"))));
	  List<WebElement> imgs=driver.findElements(By.xpath("//div[@id='mail_bomb_result']//img"));
	  System.out.println("images are showing");
	  /*check all images are there*/
	  boolean imageResult=imgs.isEmpty();
	  System.out.println(imageResult);
	  Assert.assertEquals(imageResult, flag, "images are present");
	  /*clear the fields*/
	  driver.findElement(By.xpath("//input[@id='getURL']")).clear();
	  driver.navigate().refresh();
	  
	  
  }

}
