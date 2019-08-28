import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestJava 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void hi()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		System.out.println("hi");
		
		ExtentHtmlReporter report=new ExtentHtmlReporter(new File("C:\\Users\\User\\Desktop\\ty\\new.html"));
		
		ExtentReports extent=new ExtentReports();
		
		ExtentTest test = extent.createTest("praveen");
		
		String title=driver.getTitle();
		
		if (title.equalsIgnoreCase("gmail"))
		{
			test.log(Status.PASS, "title is match");
		}
		else
		{
			test.log(Status.FAIL, "title is not matched");
		}
		extent.flush();
	}
}
