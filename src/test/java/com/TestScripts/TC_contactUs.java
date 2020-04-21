package com.TestScripts;


	import java.io.IOException;

	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;

	import com.Pages.AccountPage;
	import com.Pages.AddressPage;
import com.Pages.ContactUsPage;
import com.Pages.HomePage;
	import com.Pages.OrderHistoryPages;
	import com.Pages.PaymentPage;
	import com.Pages.ShippingPage;
	import com.Pages.SummaryPage;
	import com.TestBase.Test_Base;
	import com.Util.Util;
import com.relevantcodes.extentreports.LogStatus;

	public class TC_contactUs extends Test_Base {		
		
		
		Util util = new Util();
		AccountPage accountpg = new AccountPage();
		PaymentPage paymentpg = new PaymentPage();
		HomePage homepg = new HomePage();
		ContactUsPage contactuspg = new ContactUsPage();
		

		@Test
		public void Test_contactUs() throws IOException, InterruptedException {

			init();
			navigatetoTestUrl();
			accountpg.clickSign_menu();
			accountpg.signUp();
			homepg.click_contactUs();
			contactuspg.SelectSubjectHeading();			
			contactuspg.enterEmailAddress();
			contactuspg.enterMessage();
			contactuspg.clickSendButton();
			test.log(LogStatus.INFO, " Test case End : Contact Us");
			
		}

		
		 @AfterTest 
		 public void driverquit(){
		 
		 driver.quit();
		 test.log(LogStatus.INFO, "Driver Quit : Contact Us");
		 
		 }
	 
}
