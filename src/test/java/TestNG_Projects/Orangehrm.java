package TestNG_Projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Orangehrm {
	WebDriver driver;
	@BeforeClass
	void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	@Test(priority=1)
	void testLogo()
	{
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status,true);
	}
	
	@Test(priority=2)
	void appUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=3,dependsOnMethods= {"appUrl"})
	void homepageTitle()
	{
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
}
