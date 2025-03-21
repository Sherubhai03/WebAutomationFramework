package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.AccPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_LoginPage extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void testLogin() {
		logger.info(".....Login Test Started......");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin();
		logger.info(".....clicked login......");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		LoginPage lg = new LoginPage(driver);
		lg.SetUser(p.getProperty("username"));
		lg.SetPass(p.getProperty("password"));
		lg.Logbutton();
		logger.info(".....Logged in......");
		
		AccPage ap = new AccPage(driver);
		//ap.logout();
		logger.info(".....Logout Clicked......");
		String s = "My Account";
		if(s.equalsIgnoreCase(ap.getHeading())) {
			logger.info(".....Head Verified......");
			ap.logout();
		}else {
			Assert.fail();
		}

		
	}
	
	
	
}
