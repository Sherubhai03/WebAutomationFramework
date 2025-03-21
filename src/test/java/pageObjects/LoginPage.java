package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement setUser;
	@FindBy(xpath="//input[@id='input-password']") WebElement setPass;
	@FindBy(xpath="//input[@type='submit']") WebElement logbutton;
	
	public void SetUser(String user) {
		setUser.sendKeys(user);
	 }
	public void SetPass(String pass) {
		setPass.sendKeys(pass);
	 }
	public void Logbutton() {
		logbutton.click();
	 }
	

}
