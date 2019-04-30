package testmavenwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleAutoSearch {
	WebDriver driver;
	@Test
	public void search() {
		driver =DriverUtility.getDriver("chrome");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();	
		driver.findElement(By.name("q")).sendKeys("sagarjsr1");
		driver.findElement(By.xpath("//div[2]/div/div[3]/center/input[1]")).click();
		driver.findElement(By.partialLinkText("(@sagarjsr)")).click();
	}

}
