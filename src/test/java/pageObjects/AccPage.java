package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccPage extends BasePage {
	
	public AccPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement loggedin;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement logout;
	
	
	public boolean myAccVisible() {
		try{
			return (loggedin.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	 }
	public void logout() {
		logout.click();
	 }
	public String getHeading() {
		// TODO Auto-generated method stub
		try{
			return (loggedin.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	

}
