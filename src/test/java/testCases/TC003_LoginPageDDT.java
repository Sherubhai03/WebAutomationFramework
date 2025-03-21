package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.AccPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginPageDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void testLogin(String user, String pass, String exp) {
		logger.info(".....Login DD Test Started......");
		
		 HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin();
			logger.info(".....clicked login......");
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginPage lg = new LoginPage(driver);
		lg.SetUser(user);
		lg.SetPass(pass);
		lg.Logbutton();
		logger.info(".....Login Button Clicked......");
		
		AccPage ap = new AccPage(driver);
		boolean accpage = ap.myAccVisible();
		
		String s = "My Account";
		
		//ap.logout();
		
		
		if(accpage==true) {
			logger.info(".....Head Verified......");
			if(exp.equalsIgnoreCase("Valid")) {
				logger.info(".....Login with Valid data......");
				Assert.assertTrue(true);
				ap.logout();
			}else {
				logger.info(".....Login with InValid data......");
				ap.logout();
				Assert.fail();
			}
		}else {
			if(exp.equalsIgnoreCase("Valid")) {
				logger.info(".....Login Failed with Valid data......");
			Assert.fail();
			}else {
				logger.info(".....Login Failed with InValid data......");
				Assert.assertTrue(true);
			}
		}

		
	}
	
	
	
}
