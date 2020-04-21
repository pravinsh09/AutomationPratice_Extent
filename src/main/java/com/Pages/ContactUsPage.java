package com.Pages;

import org.openqa.selenium.By;

import com.TestBase.Test_Base;

public class ContactUsPage extends Test_Base {
	
	public void enterEmailAddress() {
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testtg12@test.com");
	}
	
	public void SelectSubjectHeading() {

		driver.findElement(By.xpath("//select[@id='id_contact']")).sendKeys("Customer service");
	}
	
	public void enterMessage() {

		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Testing message");
	}
	
	public void clickSendButton() {

		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();;
	}
	
	
	
	

}
