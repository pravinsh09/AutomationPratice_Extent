package com.TestScripts;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Pages.AccountPage;
import com.Pages.AddCartPage;
import com.Pages.AddressPage;
import com.Pages.HomePage;
import com.Pages.OrderHistoryPages;
import com.Pages.PaymentPage;
import com.Pages.ShippingPage;
import com.Pages.SummaryPage;
import com.TestBase.Test_Base;
import com.Util.Util;
import com.relevantcodes.extentreports.LogStatus;

public class TC_cart  extends Test_Base {
	
	
	Util util = new Util();
	AccountPage accountpg = new AccountPage();
	PaymentPage paymentpg = new PaymentPage();
	HomePage homepg = new HomePage();
	AddCartPage cartpg = new AddCartPage();
	
	
	@Test
	public void Test_cart() throws IOException, InterruptedException {

		init();
		navigatetoTestUrl();
		accountpg.clickSign_menu();
		Thread.sleep(3000);
		accountpg.signUp();
		homepg.click_WomenMenu();
		homepg.click_ProductQuickview();
		homepg.AddQuantity_inCart();
		
		homepg.click_Proceedcheckout();
		
		cartpg.moveOverCartProducts();
		cartpg.removeProductinCart();
		
		test.log(LogStatus.INFO, " Test case End : Cart");
	}

	
	@AfterTest 
	 public void driverquit(){
	 
	 driver.quit();
	 test.log(LogStatus.INFO, "Driver Quit : CART");
	 
	 }

}
