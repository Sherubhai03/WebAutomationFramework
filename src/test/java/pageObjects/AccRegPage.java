package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegPage extends BasePage {

	public AccRegPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement emailId;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telNo;
	@FindBy(xpath="//input[@id='input-password']") WebElement inPass;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement conPass;
	@FindBy(xpath="//input[@value='0']") WebElement newsLetterRadio;
	@FindBy(xpath="//input[@name='agree']") WebElement policyCheckBox;
	@FindBy(xpath="//input[@type='submit']") WebElement clickButton;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement confmsg;
	
	public void FirstName(String fname) {
		firstName.sendKeys(fname);
	 }
	 
	public void lastName(String lname) {
		lastName.sendKeys(lname);
	 }
	public void EmailId(String email) {
		emailId.sendKeys(email);
	 }
	public void TelNo(String telno) {
		telNo.sendKeys(telno);
	 }
	public void InPass(String inpass) {
		inPass.sendKeys(inpass);
	 }
	public void ConPass(String cpass) {
		conPass.sendKeys(cpass);
	 }
	public void NewsLetterRadio() {
		newsLetterRadio.click();
	 }
	public void PolicyCheckBox() {
		policyCheckBox.click();
	 }
	public void ClickButton() {
		clickButton.click();
	 }
	public String ConfirmMessage() {
		try{
			return (confmsg.getText());
		}catch(Exception e){
			return (e.getMessage());
		}
		
	 }
	
	
}
