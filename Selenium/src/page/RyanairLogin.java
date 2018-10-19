package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RyanairLogin {
	@FindBy(xpath="(//span[text()='Log in'])[2]")
	private WebElement loginBTN;
	
	@FindBy(xpath="(//input[contains(@id,'email')])[2]")
	private WebElement emailFLD;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement pwdFLD;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginbtn1;
	
	public RyanairLogin(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	public void initiateLogin() {
		loginBTN.click();
		}
	public void setUsername(String un) {
		emailFLD.sendKeys(un);
	}
	public void setPassword(String pw) {
		pwdFLD.sendKeys(pw);
		
	}
	public void clickLogin() {
		loginbtn1.click();
		
	}

	
	
	
	
	
	

}
