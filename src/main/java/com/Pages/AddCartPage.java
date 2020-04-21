package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TestBase.Test_Base;
import com.Util.Util;

public class AddCartPage extends Test_Base {
	
	//remove cart funtion
	Util util = new Util();
	public String productname="Faded Short Sleeve T-shirts";
	
	public void moveOverCartProducts(){
		
		
		WebElement ele=driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		util.wait_elementClickable("//a[@title='View my shopping cart']", driver, 5);
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	
	public void removeProductinCart(){
		
		driver.findElement(By.xpath("//a[@title='"+productname+"' and @class='cart-images']//parent::dt//span[@class='remove_link']")).click();
	
	}

}
