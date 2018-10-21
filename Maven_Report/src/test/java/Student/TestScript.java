package Student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestScript {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		extent=ExtentManager.GetExtent();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckGoogle() {
		try {
			driver.get("https://www.google.co.in");
			test=extent.createTest("Google","Verify Homepage");
			String title=driver.getTitle();
			if(title.contains("Google"))
			{
				test.pass("Contains Title as Google");
			}
			else {
				test.log(Status.FAIL, "doesn't contain Title as Google");
			}
			
		}
		catch(Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
}
