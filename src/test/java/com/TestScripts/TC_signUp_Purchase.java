package com.TestScripts;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Pages.AccountPage;
import com.Pages.AddressPage;
import com.Pages.HomePage;
import com.Pages.OrderHistoryPages;
import com.Pages.PaymentPage;
import com.Pages.ShippingPage;
import com.Pages.SummaryPage;
import com.TestBase.Test_Base;
import com.Util.Util;
import com.relevantcodes.extentreports.LogStatus;

public class TC_signUp_Purchase extends Test_Base {
	
	
	
	Util util = new Util();
	AccountPage accountpg = new AccountPage();
	PaymentPage paymentpg = new PaymentPage();
	HomePage homepg = new HomePage();
	SummaryPage Summarypg = new SummaryPage();
	AddressPage addresspg = new AddressPage();
	ShippingPage shippingpg = new ShippingPage();
	OrderHistoryPages orderHistpg = new OrderHistoryPages();

	@Test
	public void Testcase_signUp_Purchase() throws IOException, InterruptedException {

		init();
		navigatetoTestUrl();
		accountpg.clickSign_menu();
		accountpg.signUp();
		homepg.click_WomenMenu();
		homepg.click_ProductQuickview();
		homepg.AddQuantity_inCart();
		

		// Price After add Cart		
		String LeftGridTotalProducts =homepg.Get_LeftGridTotalProducts_Price();
		String CartTotalProducts =homepg.Get_CartTotalProducts_Price();
		String CartFinalTotalPrds =homepg.Get_CartFinalTotalPrdsPrice();
		
		//Assert.assertEquals();
		util.VerifyValue(CartTotalProducts,LeftGridTotalProducts);
		homepg.click_Proceedcheckout();
		
		
		String SummaryTotalProducts =Summarypg.Get_SummaryTotalProducts();
		String SummaryTotalwithoutTax_Price = Summarypg.Get_SummaryTotalwithoutTax_Price();
		String SummaryAllTotalProducts_Price= Summarypg.Get_SummaryAllTotalProducts_Price();
		
		//Comparison price with cart and summary
	
		util.VerifyValue(CartTotalProducts,SummaryTotalProducts);
		util.VerifyValue(CartFinalTotalPrds,SummaryAllTotalProducts_Price);
		Summarypg.click_SummaryProceedcheckout();

		addresspg.click_AddressProceedcheckout();
		
		shippingpg.click_ShippingProceedcheckout();
		
		paymentpg.click_PayByCheck();
		paymentpg.click_ConfirmMyOrder();

		// navigate back to order
		paymentpg.click_BacktoOrder();
		String HistoryPrice=orderHistpg.Get_ProductPrice();
		
		util.VerifyValue(SummaryAllTotalProducts_Price,HistoryPrice);
		test.log(LogStatus.INFO, " Test case End : SignUp");
	}

	
	 @AfterTest 
	 public void driverquit(){
	 
	 driver.quit();
	 test.log(LogStatus.INFO, "Driver Quit : SignUp");
	 
	 }
	 

}
