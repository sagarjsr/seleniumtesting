package testmavenwebdriver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiOpen {
	WebDriver driver;
	@BeforeMethod 
	public void beforemethod()
	{
		driver =DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();	
	}
	@AfterMethod
	public void aftermethod()
	{
		driver.close(); 
	}

	@Test
	public void testGoogle() {
		driver.get("http://www.google.com");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");

	}
	@Test
	public void testwebshop() {
		driver.get("http://demowebshop.tricentis.com/");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");

	}

}
