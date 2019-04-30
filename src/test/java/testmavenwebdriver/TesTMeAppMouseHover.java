package testmavenwebdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TesTMeAppMouseHover {
	WebDriver driver;
	@BeforeClass
	public void beforeclass() {
		driver =DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();	
	}
	@AfterClass
	public void afterclass(){
		//driver.close();
		//		driver.quit();
	}
	@Test
	public void hoverTest() throws InterruptedException {
		driver.findElement(By.partialLinkText("SignIn")).click();

		driver.findElement(By.id("userName")).sendKeys("data4250");
		driver.findElement(By.id("password")).sendKeys("Admin124");
		driver.findElement(By.name("Login")).click();
		Actions act2 = new Actions(driver);
		act2.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
		act2.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).click().perform();
		Thread.sleep(1000);
		act2.moveToElement(driver.findElement(By.partialLinkText("Head Phone"))).click().perform();
		driver.findElement(By.cssSelector("a[class='btn btn-success btn-product']")).click();
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.findElement(By.partialLinkText("Checkout")).click();
		driver.findElement(By.cssSelector("input[value='Proceed to Pay']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id=\"swit\"]/div[1]/div/label")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.name("username")).sendKeys("123456");  
		driver.findElement(By.name("password")).sendKeys("Pass@456");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		driver.findElement(By.cssSelector("input[value='PayNow']")).click();
		String regSucess = driver.findElement(By.xpath("//div/div/div/div[2]/p")).getText();
		Assert.assertTrue(regSucess.contains("confirmed"));
		driver.findElement(By.linkText("Home")).click();
		Assert.assertTrue(driver.getTitle().contains("Home"));

		//		Actions act2 = new Actions(driver);
		//		act2.moveToElement(driver.findElement(By.partialLinkText("AboutUs"))).perform();
		//		act2.moveToElement(driver.findElement(By.partialLinkText("Our Offices"))).perform();
		//		act2.moveToElement(driver.findElement(By.partialLinkText("Chennai"))).click().perform();
		//		String home=driver.getWindowHandle();
		//		Set<String>set =driver.getWindowHandles();
		//		Assert.assertEquals(set.size(), 2);
		//		System.out.println(set);
		//		Object[] windows=set.toArray();
		//
		//		driver.switchTo().window(windows[1].toString());
		//		System.out.println("the title :"+ driver.getTitle());
		//		System.out.println("the title :"+ driver.getCurrentUrl());
		//		Assert.assertEquals(driver.getTitle(), "Contact Us");
		//		driver.switchTo().window(home);




	}

}
