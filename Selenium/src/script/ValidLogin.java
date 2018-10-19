package script;



import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.RyanairLogin;

public class ValidLogin extends BaseTest {
	
	@Test(invocationCount=4)
	public void testValidLogin() {
		System.out.println("Executing test method");
		String un=Excel.getValue(XL_PATH,"ValidLogin",1,0);
		String pw=Excel.getValue(XL_PATH, "ValidLogin",1,1);
		String eTitle=Excel.getValue(XL_PATH,"ValidLogin",1,2);
		RyanairLogin l=new RyanairLogin(driver);
		l.initiateLogin();
		//Enter Valid UN
		l.setUsername(un);
		//Enter Valid pw
		l.setPassword(pw);
		//Click login
		l.clickLogin();
		//verify home page....
		//EnterPage e=new EnterPage(driver);
		//e.verifyHomePageIsDisplayed(driver, eTitle);
		
	}
	
		
	
	


}
