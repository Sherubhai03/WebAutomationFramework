package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	 
	 @FindBy(xpath="//a[@title='My Account']") WebElement linkMyAcc;
	 @FindBy(xpath="//div[@id='top-links']//a[contains(text(),'Register')]") WebElement linkRegister;
	 @FindBy(xpath="//div[@id='top-links']//a[contains(text(),'Login')]") WebElement linkLogin;
	 
	 public void clickMyAcc() {
		 linkMyAcc.click();
	 }
	 
	 public void clickRegister() {
		 linkRegister.click();
	 }
	 public void clickLogin() {
		 linkLogin.click();
	 }

}
