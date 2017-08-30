package com.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {
public static WebElement element=null;
static WebDriver driver=null;

public LogIn(WebDriver driver){
	this.driver=driver;
}
/*get the xpath of all the element in login page*/

public static WebElement userName(){
	element=driver.findElement(By.id("username"));
	return element;
}
public static WebElement password(){
	element=driver.findElement(By.id("password"));
	return element;
}

public static WebElement logInBtn(){
	element=driver.findElement(By.id("login"));
	return element;
}
 /*write the function for login*/
public static void loginToTheTeeSpring(String usrname,String password){
	userName().sendKeys(usrname);
	password().sendKeys(password);
	logInBtn().click();
	
}
}
