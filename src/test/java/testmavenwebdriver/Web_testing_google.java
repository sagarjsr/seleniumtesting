package testmavenwebdriver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Web_testing_google {
	@Test
	public void testGoogle() {
		//		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		//		System.setProperty("webdriver.ie.driver", "C:\\driver\\IEDriverServer.exe");
		//		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver =DriverUtility.getDriver("chrome");
		//		WebDriver driver = new InternetExplorerDriver();
		//		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		driver.close(); 
	}

}
