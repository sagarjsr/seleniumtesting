package testmavenwebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDragnDrop {
	WebDriver driver;
	@BeforeClass
	public void beforeclass() {
		driver =DriverUtility.getDriver("ie");
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	@AfterClass
	public void afterclass(){
		driver.close();
	}
	@Test
	public void dragDrop() {
		WebElement from=driver.findElement(By.xpath("//div[@id=\'ctl00_ContentPlaceholder1_RadTreeView1\']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to=driver.findElement(By.xpath("//div[@id=\'ctl00_ContentPlaceholder1_priceChecker\']/div[1]"));
		Actions act2 = new Actions(driver);	
		//act2.clickAndHold(from).release(to).perform();
		act2.dragAndDrop(from, to).perform();
		WebDriverWait wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		String result=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println("The Result" +result);
		Assert.assertTrue(result.contains("$3999"));

	}

}
