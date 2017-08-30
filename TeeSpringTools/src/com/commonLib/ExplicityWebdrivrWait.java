package com.commonLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicityWebdrivrWait {
	
	public static void waitForelementVisible(WebDriver driver,int timeinseconds,String elementxpath){
		WebDriverWait wait=new WebDriverWait(driver,timeinseconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementxpath)));
	}
	
	public static void waitforallelement(WebDriver driver,int timeinseconds,List<WebElement> elementtocheck){
		WebDriverWait wait=new WebDriverWait(driver,timeinseconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(elementtocheck));
	}
	
	public static void waitfortheelementClickAble(WebDriver driver,int timeinsec,WebElement clickablelement){
		WebDriverWait wait=new WebDriverWait(driver, timeinsec);
		wait.until(ExpectedConditions.elementToBeClickable(clickablelement));
	}

}
