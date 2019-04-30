package testmavenwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMeAppReg {
	WebDriver driver;
	@BeforeClass
	public void beforeclass() {
		driver =DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();	
	}
	@AfterClass
	public void afterclass(){
		//		driver.close();
	}

	@Test
	public void testReg() {
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("admin1232");
		driver.findElement(By.id("firstName")).sendKeys("sagar");
		driver.findElement(By.id("lastName")).sendKeys("kumar");
		driver.findElement(By.id("password")).sendKeys("Admin124");
		driver.findElement(By.id("pass_confirmation")).sendKeys("Admin124");
		driver.findElement(By.cssSelector("Input[value='Male']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("sagar@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("9122394109");
		driver.findElement(By.cssSelector("img[src='images/calendar.png']")).click();
		Select regmonths = new Select(driver.findElement(By.className("ui-datepicker-month")));
		regmonths.selectByVisibleText("Jul");
		Select regYear = new Select(driver.findElement(By.className( "ui-datepicker-year")));
		regYear.selectByVisibleText("1995");

		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7]/a")).click();
		driver.findElement(By.id("address")).sendKeys("banglore india");
		driver.findElement(By.id("securityQuestion")).click();
		//		.selectByVisibleText("What is your Birth Place? ");
		driver.findElement(By.id("answer")).sendKeys("banglore");
		//driver.findElement(By.name("Submit")).click();
	}
}