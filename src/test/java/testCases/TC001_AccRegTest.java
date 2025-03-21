package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pageObjects.AccRegPage;
import pageObjects.HomePage;

public class TC001_AccRegTest extends BaseClass {
	
	
	
	@Test(groups={"Sanity","Master"})
	public void VerifyAccReg() {
		try {
		logger.info(".....Reg Test Started......");
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAcc();
		logger.info(".....clickedMyAcc......");
		hp.clickRegister();
		logger.info(".....clickedRegister......");
		
		AccRegPage ap = new AccRegPage(driver);
		logger.info(".....filling Form......");
		ap.FirstName(randomString().toUpperCase());
		ap.lastName(randomString().toUpperCase());
		ap.EmailId(randomString()+"@gmail.com");
		ap.TelNo(randomNumber());
		
		String psss = randomAlphaNumber();
		
		ap.InPass(psss);
		ap.ConPass(psss);
		ap.NewsLetterRadio();
		ap.PolicyCheckBox();
		logger.info(".....filling Filled......");
		ap.ClickButton();
		logger.info(".....ClickedButton......");
		Assert.assertEquals("Your Account Has Been Created!",ap.ConfirmMessage());
		logger.info(".....Assert done......");
	}catch(Exception e) {
		logger.info("..........Test Failed.......");
		logger.error(".....Failed......");
		logger.debug(".....Debug log.....");
		Assert.fail();
	}
	
	}
	
	
}
