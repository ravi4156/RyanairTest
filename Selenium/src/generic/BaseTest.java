package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(FIREFOX_KEY,FIREFOX_VALUE);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void openApplication(){
		System.out.println("Executing before method");
		String appURL=AutoUtil.getProperty(CONFIG_PATH,"URL");
		String strITO=AutoUtil.getProperty(CONFIG_PATH,"ITO");
		long ITO=Long.parseLong(strITO);
		driver=new FirefoxDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult test) {
		System.out.println("Executing After method");
		String name=test.getName();
		int status=test.getStatus();
		if(status==1) {
			Reporter.log(name+"is PASSED",true);
		}
		else {
			Reporter.log(name+"is FAILED",true);
			AutoUtil.getPhoto(driver, IMG_PATH, name);
		}
		driver.quit();
	
	}
	
	

}
