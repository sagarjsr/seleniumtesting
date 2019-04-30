package testmavenwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyMovement {
	WebDriver driver;
	@BeforeClass
	public void beforeclass() {
		driver =DriverUtility.getDriver("ie");
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();	
	}
	@AfterClass
	public void afterclass(){
		//driver.close();
	}
	@Test
	public void testKey() throws InterruptedException {
		WebElement search=driver.findElement(By.id("myInput"));
		Actions act1= new Actions(driver);
		act1.keyDown(search,Keys.SHIFT).perform();
		act1.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
		//		act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div[1]"))).click().perform();
		act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(), 'Hand bag')]"))).click().perform();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		Thread.sleep(3000);
		String text=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[1]/center[1]/h4")).getText();
		System.out.println(text);
		Assert.assertTrue(text.contentEquals("Hand bag"));
		//Assert.assertTrue(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div/div[1]/center[1]/h4")).getText().contains("Hand bag"));
		//WebElement findtxt=driver.findElement(By.cssSelector("center['p']"));
		//Assert.assertEquals(("s"), "Hand bag");
		//Assert.assertEquals(findtxt.getText(), "Hand bag");

	}
}




