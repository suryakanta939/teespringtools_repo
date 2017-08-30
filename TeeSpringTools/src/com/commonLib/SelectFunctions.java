package com.commonLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
	static WebDriver driver=null;
	public SelectFunctions(WebDriver driver){
		this.driver=driver;
	}
	
	public static void selectByText(WebElement selectbox,String textName){
		Select sel=new Select(selectbox);
		sel.selectByVisibleText(textName);
	}


}
